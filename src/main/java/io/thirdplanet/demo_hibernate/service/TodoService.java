package io.thirdplanet.demo_hibernate.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import io.thirdplanet.demo_hibernate.domain.Todo;
import io.thirdplanet.demo_hibernate.repo.TodoRepo;

import io.thirdplanet.demo_hibernate.domain.Todo;

@Service
public class TodoService {
    private final TodoRepo brepo;

    @Autowired
    public TodoService(TodoRepo  brepo){
        this.brepo = brepo ;
    }

    public Optional<Todo> findById(Long id){
        return brepo.findById(id);
    }
    public  List<Todo> findAll() {
        return (List<Todo>) brepo.findAll();
    }

    public Optional<List<Todo>> findByTitle(String title){
        return brepo.findByTitle(title);
    }

}