using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Covid.Models
{
   public class Account_Transactions
    {
        public int Transaction_id { get; set; }
        public string action { get; set; }
        public string Account_id { get; set; }
        public string Notes { get; set; }

        public virtual AspNetUser AspNetUser { get; set; }
    }
}
