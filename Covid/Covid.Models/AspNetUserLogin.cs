using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Covid.Models
{
  public  class AspNetUserLogin
    {
        public string LoginProvider { get; set; }
        public string ProviderKey { get; set; }
        public string UserId { get; set; }
        public string IdentityUser_Id { get; set; }

        public virtual AspNetUser AspNetUser { get; set; }
    }
}
