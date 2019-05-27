Introduction to Spring Data Repoistories
=====================================================
The power of Spring Data JPA lies in the repository abstraction
that is provided by the Spring Data Commons project and
extended by the datastore specfic sub projects.


We can use Spring Data JPA without paying any attention to the actual implementation of the
repository abstraction, but we can be familiar with the
Spring Data repository interfaces.  These interfaces
are described in the following:
========================================================

First, the Spring Data Commons project provides the following
interfaces:
---------------------------------------------------------------
    *   Repository<T,ID extends Serializable>:
            -   interface is a marker interface that has two
                purposes:
                    1. It captures the type ofthe managed entity and the type of the entity's id

                    2. It helps the Spring containter to discover the concrete repository interfaces during classpath scanning.

    *   CrudRepository<T,ID extends Serializable> interface
        provides CRUD operations for the managed entity.

    *   PagingAndSortingRepository<T,ID extends Serializable>
        delcares the methods that are used to sort and 
        paginate entities that are retrieved fromt eh the database

    *   QueryDslPredicateExecutor<T> interface is not a
        "repository interface".  It delcares the methods
        that are used to retrieve entities from the atabase by using  QueryDsl Predicate objects.


   *    The JpaRepository<T, ID extends Serializable> interface is a JPA specific repository interface that combines the methods declared by the common repository interfaces behind a single interface.

    *    The JpaSpecificationExecutor<T> interface is not a “repository interface”. It declares the methods that are used to retrieve entities from the database by using Specification<T> objects that use the JPA criteria API.
        
    
        
