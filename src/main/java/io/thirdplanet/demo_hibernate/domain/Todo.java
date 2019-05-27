package io.thirdplanet.demo_hibernate.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter ;

import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

@Entity
@Table(name = "todo")
public class Todo {
 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter 
    @Setter 
    private Long id;
 
    @Column(name = "creation_time", nullable = false)
    @Getter 
    @Setter 
    private Date creationTime;
 
    @Column(name = "description", length = 500)
    @Getter 
    @Setter 
    private String description;
 
    @Column(name = "modification_time")
    @Getter 
    @Setter 
    private Date modificationTime;
 
    @Column(name = "title", nullable = false, length = 100)
    @Getter 
    @Setter 
    private String title;



    private  Todo(){  
        //private constructor
    }

    public Todo(Date creationTime ,String description,Date modificationTime ,String title){
        this() ;
        this.creationTime = creationTime;
        this.description = description ;
        this.modificationTime = modificationTime ;
        this.title = title ;
    }
 
    /*
    @Version
    @Getter 
    @Setter 
    private long version;
     */
    //The constructor, builder, and other methods are omitted
}