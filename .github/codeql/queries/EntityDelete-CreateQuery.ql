/**
 * This is an automatically generated file
 * @id java/orion/entity-deleted-create-query
 * @kind problem
 * @name Deleted Entity 
 * @description Detects when an jpql query uses a deleted entity.
 * @problem.severity warning
 */

 import java
 import utils
 import utilsDelete
 import semmle.code.java.dataflow.TaintTracking
 
 
// Taint tracking configuration
module JPQLFlowConfiguration implements DataFlow::ConfigSig {
  predicate isSource(DataFlow::Node source) {
    exists(StringLiteral str |
      source.asExpr() = str 
    )
  }

  predicate isSink(DataFlow::Node sink) {
    exists(MethodCall mc |
      mc.getMethod().getDeclaringType().hasQualifiedName("jakarta.persistence", "EntityManager") and
      mc.getMethod().getName() = "createQuery" and
      sink.asExpr() = mc.getArgument(0)
    )
  }
}

module JPQLFlow = TaintTracking::Global<JPQLFlowConfiguration>;


from Class entity, Method m, MethodCall mc, DataFlow::Node source, DataFlow::Node sink
where 
  // Verify the entity name
  entity.hasName("Post") 

  // Search createQuery
  and mc.getMethod() = m
  and mc.getMethod().getName() = "createQuery"
  and mc.getMethod().getDeclaringType().hasQualifiedName("jakarta.persistence", "EntityManager")

  // CreateQuery: One Parameter (jpql) and Two parameters (typed)
  and 
  (
    JPQLFlow::flow(source, sink)
    and usesEntity(source.asExpr(), entity)
    and sink.asExpr() = mc.getArgument(0)
  )

select mc, "Usage of deleted entity " + entity.getName() + " detected in JPQL queries. The entity no longer exists, which may cause runtime errors."
 
 