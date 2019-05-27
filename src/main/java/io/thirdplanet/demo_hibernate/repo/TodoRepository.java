package io.thirdplanet.demo_hibernate.repo;

import org.springframework.data.repository.CrudRepository;
import io.thirdplanet.demo_hibernate.domain.Todo ;
interface TodoRepository extends CrudRepository<Todo, Long> {
 
}