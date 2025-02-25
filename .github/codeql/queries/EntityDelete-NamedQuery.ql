/**
 * This is an automatically generated file
 * @id java/orion/entity-deleted-named-query
 * @kind problem
 * @name Deleted Entity 
 * @description Detects when an jpql query uses a deleted entity.
 * @problem.severity warning
 */

 import java
 import utilsDelete
 import utils
 
 
 
 from Class entity, Annotation nq, Annotation q, Method m
 where 
 
     entity.hasName("Post") 
     
     and
        (isQuery(q) and isNamedQuery(nq) and isEqual(nq.getValue("name"), q.getValue("name"))
        and usesEntity(nq.getValue("query"), entity)
        and m = q.getTarget()) 
 
 select m,  "Usage of deleted entity " + entity.getName() + " detected in JPQL queries. The entity no longer exists, which may cause runtime errors."
 
 