using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using nicoshool.Models;

namespace nicoshool.Controllers
{
    public class StudentController : Controller
    {
        StudentDBAccessLayer sdb = new StudentDBAccessLayer();

        [HttpGet]
        public IActionResult Create()
        {
            return View();
        }

        [HttpPost]
        public IActionResult Create([Bind] StudentEntities studentEntities)
        {
            try
            {
                if (ModelState.IsValid)
                {
                    String resp = sdb.AddStudent(studentEntities);
                    TempData["msg "] = resp;
                }
            }
            catch(Exception ex)
            {
                TempData["msg"] = ex.Message;
            }

            return View();
        }
    }
}