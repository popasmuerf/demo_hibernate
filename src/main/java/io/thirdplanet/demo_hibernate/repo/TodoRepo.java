package io.thirdplanet.demo_hibernate.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import io.thirdplanet.demo_hibernate.domain.Todo;


//url :  https://www.petrikainulainen.net/programming/spring-framework/spring-data-jpa-tutorial-creating-database-queries-from-method-names/


//@NoRepositoryBean
@org.springframework.stereotype.Repository
public interface TodoRepo extends CrudRepository<Todo,Long> {

    
    //named quieries....

    //@Query("SELECT * from Todo todo WHERE todo.id = :id")
    Optional<Todo> findById(Long id);

    
    @Query(value="SELECT * from Todo todo WHERE todo.title=:title",nativeQuery=true)
    Optional<List<Todo>> findByTitle(@Param("title")String title);
    
    @Query("SELECT todo.title FROM Todo todo where todo.id = :id") 
    String findTitleById(@Param("id") Long id);

    
    @Query("SELECT todo.title FROM Todo todo WHERE todo.title= :title")
    List<String> findTitleByTitle(@Param("title")String title);


    //Method Queries
    Optional<List<Todo>> findByTitleOrDescription(String title,String description);
    Optional<List<Long>> countByTitle(String title);

    
}