package com.spring.boot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "users")
public class User {
		
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
	@Column (name ="name")
    private String name ;
    
    
	public User() {	}

	public User(String name) {
		super();
		this.name = name;
	}
	
	   public long getId() {
	        return id;
	    }
	    public void setId(long id) {
	        this.id = id;
	    }
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
    
        
}
