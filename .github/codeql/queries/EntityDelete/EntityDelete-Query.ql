/**
 * This is an automatically generated file
 * @id java/orion/entity-deleted-query
 * @kind problem
 * @name Deleted Entity 
 * @description Detects when an jpql query uses a deleted entity.
 * @problem.severity error
 */

import java
import utils
import utilsDelete


from Class entity, Annotation q, Method m
where 

    entity.hasName("Post") 
    
    and
      // Search queries
      (isQuery(q) and usesEntity(q.getValue("value"), entity)
      and m = q.getTarget())

        
select m,  "Usage of deleted entity " + entity.getName() + " detected in JPQL queries. The entity no longer exists, which may cause runtime errors."

