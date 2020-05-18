using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Covid.Models
{
   public class Patient_diagnostics
    {
        public int Diagnostic_id { get; set; }
        public string Patient_id { get; set; }
        public string Diagnosis { get; set; }
        public string Doctor_id { get; set; }
        public Nullable<System.DateTime> date { get; set; }

        public virtual AspNetUser AspNetUser { get; set; }
        public virtual AspNetUser AspNetUser1 { get; set; }
    }
}
