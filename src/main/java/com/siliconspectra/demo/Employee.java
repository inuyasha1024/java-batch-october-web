package com.siliconspectra.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Configuration("employee1")
public class Employee {

    public String id;

    public String name;

    @PostConstruct
    public void init() {
        System.out.println("bean init");
    }
    @PreDestroy
    public void destroy() {
        System.out.println("bean destroy");
    }

    @Bean("employee2")
    public Employee createEmployee() {
        return new Employee("1", "Jim");
    }

    public Employee(String id, String name) {
        System.out.println("this is employee");
        this.id = id;
        this.name = name;
    }

    public Employee() {
        System.out.println("this is employee");
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
