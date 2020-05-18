using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using System.Data.SqlClient;
using nicoshool.Models;

namespace nicoshool.Models
{
    public class StudentDBAccessLayer
    {
        SqlConnection con = new SqlConnection("Data Source=NICKLAUS\\SQL2019;Initial Catalog=nicoschool;User ID=sa;Password=niecshenz2020");
        public string AddStudent (StudentEntities studentEntities)
        {
            try
            {
                SqlCommand cmd = new SqlCommand("sp_students_add", con);
                cmd.CommandType = System.Data.CommandType.StoredProcedure;
                cmd.Parameters.AddWithValue("@firstName", studentEntities.FirstName);
                cmd.Parameters.AddWithValue("@lastName", studentEntities.LastName);
                cmd.Parameters.AddWithValue("@DoB", studentEntities.DoB);
                cmd.Parameters.AddWithValue("@gender", studentEntities.Gender);
                cmd.Parameters.AddWithValue("@email", studentEntities.Email);
                cmd.Parameters.AddWithValue("@username", studentEntities.Username);
                cmd.Parameters.AddWithValue("@password", studentEntities.password);
                cmd.Parameters.AddWithValue("@mainGuardian", studentEntities.MainGuardian);
                cmd.Parameters.AddWithValue("@phoneNumber", studentEntities.PhoneNumber);
                cmd.Parameters.AddWithValue("@address", studentEntities.Address);
                con.Open();
                cmd.ExecuteNonQuery();
                con.Close();

                return ("Student successfully saved.");
            }
            catch(Exception ex)
            {
                if (con.State == System.Data.ConnectionState.Open)
                {
                    con.Close();
                }

                return (ex.Message.ToString());
            }
        }
    }
}
