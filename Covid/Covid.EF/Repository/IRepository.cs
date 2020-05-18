using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Covid.EF.Repository
{
    
        public interface IRepository<TEntity> where TEntity : class
        {
            IQueryable<TEntity> AsQueryable();
            TEntity AddNew(TEntity entity);
            void Delete(TEntity entity);
            void Update(TEntity entity);
            void Detach(TEntity entity);
        }
    
}
