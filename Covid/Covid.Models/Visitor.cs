using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Covid.Models
{
  public  class Visitor
    {
        public int Visitors_id { get; set; }
        public string Visitor_name { get; set; }
        public string Reason { get; set; }
        public Nullable<System.DateTime> TimeIn { get; set; }
        public Nullable<System.DateTime> TimeOut { get; set; }
    }
}
