using nicos_signup.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Mail;
using System.Web;
using System.Web.Mvc;

namespace nicos_signup.Controllers
{
    public class UserController : Controller
    {
        // GET: User
        public ActionResult Index()
        {
            return View();
        }

        //get reg form

        [HttpGet]
        public ActionResult Registration()
        {
            return View();
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Registration([Bind(Exclude = "IsEmailVerified,ActivationCode")] admin userM)
        {
            bool Status = false;
            string message = "";
            //
            // Model Validation 
            if (ModelState.IsValid)
            {

                #region //Email is already Exist 
                var isExist = IsEmailExist(userM.EmailID);
                if (isExist)
                {
                    ModelState.AddModelError("EmailExist", "Email already exist");
                    return View(userM);
                }
                #endregion

                #region Generate Activation Code 
                userM.ActivationCode = Guid.NewGuid();
                #endregion

                #region  Password Hashing 
                userM.Password = Crypto.Hash(userM.Password);
                //userM.ConfirmPassword = Crypto.Hash(userM.ConfirmPassword); //
                #endregion
                userM.IsEmailVerified = false;

                #region Save to Database
                using (nicosEntities dc = new nicosEntities())
                {
                    dc.admins.Add(userM);
                    dc.SaveChanges();

                    //Send Email to User
                    SendVerificationLinkEmail(userM.EmailID, userM.ActivationCode.ToString());
                    message = "Registration successfully done. Account activation link " +
                        " has been sent to your email id:" + userM.EmailID;
                    Status = true;
                }
                #endregion
            }
            else
            {
                message = "Invalid Request";
            }

            ViewBag.Message = message;
            ViewBag.Status = Status;
            return View(userM);
        }

        [NonAction]
        public bool IsEmailExist(string emailID)
        {
            using (nicosEntities dc = new nicosEntities())
            {
                var v = dc.admins.Where(a => a.EmailID == emailID).FirstOrDefault();
                return v != null;
            }
        }


        [NonAction]
        public void SendVerificationLinkEmail(string emailID, string activationCode)
        {
            var verifyUrl = "/User/VerifyAccount/" + activationCode;
            var link = Request.Url.AbsoluteUri.Replace(Request.Url.PathAndQuery, verifyUrl);

            var fromEmail = new MailAddress("nicoswaves.mn@gmail.com", "nicos waves");
            var toEmail = new MailAddress(emailID);
            var fromEmailPassword = "armitage3432!!*"; // Replace with actual password
            string subject = "Your account is successfully created!";

            string body = "<br/><br/>We are excited to tell you that your Dotnet Awesome account is" +
                " successfully created. Please click on the below link to verify your account" +
                " <br/><br/><a href='" + link + "'>" + link + "</a> ";

            var smtp = new SmtpClient
            {
                Host = "smtp.gmail.com",
                Port = 587,
                EnableSsl = true,
                DeliveryMethod = SmtpDeliveryMethod.Network,
                UseDefaultCredentials = false,
                Credentials = new NetworkCredential(fromEmail.Address, fromEmailPassword)
            };

            using (var message = new MailMessage(fromEmail, toEmail)
            {
                Subject = subject,
                Body = body,
                IsBodyHtml = true
            })
                smtp.Send(message);
        }
    }
}