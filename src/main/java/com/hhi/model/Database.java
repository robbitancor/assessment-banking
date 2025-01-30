package com.hhi.model;

import jakarta.persistence.*;
import org.springframework.scheduling.annotation.EnableScheduling;

@Entity
@Table(name = "Database")
public class Database {

    public Database(){}
    public Database(String name){
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private String name;
}
