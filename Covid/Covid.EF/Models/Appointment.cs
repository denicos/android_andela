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
    
    public partial class Appointment
    {
        public int Appointment_id { get; set; }
        public System.DateTime Appointment_date { get; set; }
        public string ScheduledBy { get; set; }
        public string Reason { get; set; }
    }
}