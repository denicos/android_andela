//------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated from a template.
//
//     Manual changes to this file may cause unexpected behavior in your application.
//     Manual changes to this file will be overwritten if the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

namespace Covid.EF.Models
{
    using System;
    using System.Collections.Generic;
    
    public partial class Account_Transactions
    {
        public int Transaction_id { get; set; }
        public string action { get; set; }
        public string Account_id { get; set; }
        public string Notes { get; set; }
    
        public virtual AspNetUser AspNetUser { get; set; }
    }
}
