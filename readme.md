

# Spring Modulith Implementation

### Data Setup 
--------
1. Navigate to datasetup directory
2. Run `./setupData.sh` file
3. After successful execution of step-2 it adds sample data



### Learnings

-------
1. For each listener annotated with  `@ApplicationModuleListener`/`@TransactionalEventListener` it created one entry in `event_publication` table
2. When we use simple `@EventListener` it doesn't create entry in `event_publication` table