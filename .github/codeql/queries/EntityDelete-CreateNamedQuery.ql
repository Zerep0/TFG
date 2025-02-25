/**
 * This is an automatically generated file
 * @id java/orion/entity-deleted-create-named-query
 * @kind problem
 * @name Deleted Entity 
 * @description Detects when an jpql query uses a deleted entity.
 * @problem.severity recommendation
 */

 import java
 import utils
 import utilsDelete
 import semmle.code.java.dataflow.TaintTracking
 
 module JPQLFlowConfiguration implements DataFlow::ConfigSig {
   
   predicate isSource(DataFlow::Node source) {
    exists(StringLiteral str |
      source.asExpr() = str 
    )
  }
 
  predicate isSink(DataFlow::Node sink) {
    exists(MethodCall mc |
      mc.getMethod().getDeclaringType().hasQualifiedName("jakarta.persistence", "EntityManager")
      and mc.getMethod().getName() = "createNamedQuery" and
      sink.asExpr() = mc.getArgument(0)
    )
  }
 }
 
 module JPQLFlow = TaintTracking::Global<JPQLFlowConfiguration>;
 
 from Class entity, Annotation q, Method m, MethodCall mc, DataFlow::Node source, DataFlow::Node sink
 where 
    // Verify the entity name
    entity.hasName("Post") 
     
    // Search createNamedQuery
    and mc.getMethod() = m
    and mc.getMethod().getName() = "createNamedQuery"
    and mc.getMethod().getDeclaringType().hasQualifiedName("jakarta.persistence", "EntityManager")
    and
      (JPQLFlow::flow(source, sink) and sink.asExpr() = mc.getArgument(0)
      and isEqual(source.asExpr(), q.getValue("name"))
      and usesEntity(q.getValue("query"), entity))

 select mc, "Usage of deleted entity " + entity.getName() + " detected in JPQL queries. The entity no longer exists, which may cause runtime errors."
 