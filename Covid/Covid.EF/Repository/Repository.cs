using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data.Entity;
using Covid.EF.Context;

namespace Covid.EF.Repository
{
    public class Repository<TEntity> : IRepository<TEntity> where TEntity : class
    {
        internal IDbContext _context;
        internal IDbSet<TEntity> _dbSet;

        public Repository(IDbContext context)
        {
            _context = context;
            _dbSet = context.Set<TEntity>();
        }

        public virtual IQueryable<TEntity> AsQueryable()
        {
            return _dbSet;
        }

        public virtual TEntity AddNew(TEntity entity)
        {
            return _dbSet.Add(entity);
        }

        public virtual void Delete(TEntity entity)
        {
            _context.Entry(entity).State = System.Data.Entity.EntityState.Deleted;
            _dbSet.Remove(entity);
        }

        public virtual void Update(TEntity entity)
        {
            _context.Entry(entity).State = System.Data.Entity.EntityState.Modified;
        }

        public virtual void Detach(TEntity entity)
        {
            _context.Entry(entity).State = System.Data.Entity.EntityState.Detached;
        }
    }
}
