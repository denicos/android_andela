using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Covid.EF.Context;
using Covid.EF.Repository;

namespace Covid.EF.UnitOfWork
{
    public interface IUnitOfWork<TContext> : IDisposable where TContext : IDbContext
    {
        IRepository<TEntity> Get<TEntity>() where TEntity : class;
        int SaveChanges();
    }
}
