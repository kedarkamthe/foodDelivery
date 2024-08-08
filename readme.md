

# Spring Modulith Implementation


### Learnings

-------
1. For each listener annotated with  `@ApplicationModuleListener`/`@TransactionalEventListener` it created one entry in `event_publication` table
2. When we use simple `@EventListener` it doesn't create entry in `event_publication` table