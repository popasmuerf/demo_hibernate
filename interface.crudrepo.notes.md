default methods signatures
==========================================
void delete(T entity)
Iterable<T> findAll()
T findOne(Long id)
T save(T entity)



Extending the Repository interface...
=============================================

1. Provide the two type parameters....
    1.1 the type of the entity.
    1.2 the type of the entity's ID

2. Add the required methods to the repository interface:
    1. void delete
    2. List<Todo> findAll()
    3. Optional<Todo> findOne(T id)
    4. T save(T pesisted)


import org.springframework.data.repository.Repository;
 
import java.util.List;
import java.util.Optional;
```
interface TodoRepository extends Repository<Todo, Long> {
 
    void delete(Todo deleted);
 
    List<Todo> findAll();
 
    Optional<Todo> findOne(Long id);
 
    Todo save(Todo persisted);
}
```



General Repository architecture plan...
==================================================
Two rules...

1.If we want to expose all repository methods that are declared
by the CrudRepository interface and we don't want to return Optional objects , or repo interfaces should extend the
CrudRepo interface.

2.If we don't want to expose all repo methods that are declared by the CrudRepository interface or we want to 
return Optional objects , our repo interfaces must extend the
Repository interface...



Case closed ?
Not exactly....
It could be argued that we should always use the second method...this opinion is based on two reasons:

1. When we create an interface, we should not add unnecessary methods to it.  We should keep the interface as small as possible because small interfaces are easier to use and they help us to create components that have only one job.

2. Optional helps us to create better APIs because it reveals that there might not be a return value.

We can avoid this by following these steps:

    Create a base interface that extends the Repository interface and add the common methods to that interface.
    Create the actual repository interface that extends our base interface.

Let’s move on and take a closer look at these steps.

First, we have to create a base interface that declares the methods shared by our repositories. We can do this by following these steps:

    Create the BaseRepository interface that extends the Repository interface. This interface has two type parameters:
        T describes the type of the managed entity.
        ID describes the type of the entity’s id field.
    Annotate the created interface with the @NoRepositoryBean annotation. This ensures that Spring Data JPA doesn’t try to create an implementation for our base repository interface.
    Add the common methods to the created interface.

The source code of the BaseRepository interface looks as follows:


@NoRepositoryBean
interface BaseRepository<T,ID extends Serializable> extends Repository<T,ID>{
    void delete(T deleted);
    List<T> findAll(); 
    Optional<T> findOne(ID id);
    T save(T persisted);
}