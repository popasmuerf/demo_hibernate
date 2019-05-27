package io.thirdplanet.demo_hibernate.controller;

import java.util.List;
import java.util.Optional;

import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.thirdplanet.demo_hibernate.domain.Todo;
import io.thirdplanet.demo_hibernate.service.TodoService;

@RestController
@RequestMapping(value = "/api")
public class TestController {
    private TodoService todoService;

    @Autowired
    public void TestController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<Todo>> allTodo() {
        List<Todo> todoList = todoService.findAll();
        return new ResponseEntity<List<Todo>>(todoList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Todo> findById(@PathVariable("id")Long id){
        Optional<Todo> todo = todoService.findById(id);
        Todo _todo = todo.get();
        if(todo.isPresent()){
            return new ResponseEntity<Todo>(_todo,HttpStatus.OK) ;
        }else{
            return new ResponseEntity<Todo>(_todo,HttpStatus.NOT_FOUND) ;
        }
    }

    @GetMapping("/todo/{title}")
    public ResponseEntity<List<Todo>> findByTitle(@PathVariable("title") String title){
        Optional<List<Todo>> todoList = todoService.findByTitle(title);
        if(todoList.isPresent()){
            List<Todo> _todoList = todoList.get();
            return new ResponseEntity<List<Todo>>(_todoList,HttpStatus.OK) ;
        }else{
            List<Todo> _todoList = todoList.get();
            return new ResponseEntity<List<Todo>>(_todoList,HttpStatus.NOT_FOUND) ;
        }
    }
    
    
}