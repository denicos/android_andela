using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Covid.Models
{
   public class Appointment
    {
        public int Appointment_id { get; set; }
        public System.DateTime Appointment_date { get; set; }
        public string ScheduledBy { get; set; }
        public string Reason { get; set; }
    }
}
