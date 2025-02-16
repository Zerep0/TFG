import java

/** 
 *Check if two expressions are equal 
 */
predicate isEqual(Expr a, Expr b) {
    a.toString() = b.toString()
}

/**
 * Check if an annotation is a Query annotation
 */
predicate isQuery(Annotation a) {
    a.getType().hasQualifiedName("org.springframework.data.jpa.repository", "Query")
}

/**
 * Check if an annotation is a NamedQuery annotation
 */
predicate isNamedQuery(Annotation a) {
    a.getType().hasQualifiedName("jakarta.persistence", "NamedQuery")
}
  