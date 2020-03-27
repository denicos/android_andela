using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using System.ComponentModel.DataAnnotations;

namespace nicoshool.Models
{
    public class StudentEntities
    {
        [Required]
        public string FirstName { get; set; }

        [Required]
        public string LastName { get; set; }

        [Required]
        public string DoB { get; set; }

        [Required]
        public string Gender { get; set; }

        [Required]
        public string Email { get; set; }

        [Required]
        public string Username { get; set; }

        [Required]
        public string password { get; set; }

        [Required]
        public string MainGuardian { get; set; }

        [Required]
        public string PhoneNumber { get; set; }

        [Required]
        public string  Address { get; set; }

    }
}
