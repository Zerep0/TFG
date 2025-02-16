import java
predicate usesEntity(Expr queryValue, Class parent) {
  queryValue.toString().regexpMatch(
    "(?i).*\\b(FROM|UPDATE|DELETE\\s+FROM)\\s+" + parent.getName() + "\\b.*"
  )
  or
  queryValue.toString().regexpMatch(
    "(?i).*\\bJOIN\\s+(?:FETCH\\s+)?" + parent.getName() + "\\b.*"
  )
}