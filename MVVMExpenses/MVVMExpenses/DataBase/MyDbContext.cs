using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data.Entity;
using MVVMExpenses.Model;

namespace MVVMExpenses.DataBase
{
    
   public  class MyDbContext :System.Data.Entity.DbContext
    {
        static MyDbContext()
        {
            System.Data.Entity.Database.SetInitializer<MyDbContext>(null);
        }

        public DbSet<Account> Accounts { get; set; }
        public DbSet<Category> Categories { get; set; }
        public DbSet<Transaction> Transcations { get; set; }
    }
}
