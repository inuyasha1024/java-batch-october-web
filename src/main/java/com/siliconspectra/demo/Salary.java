package com.siliconspectra.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Salary {
    @Value("${salary.id}")
    public String id;

    @Autowired
    @Qualifier("employee2")
    public Employee employee;


    public Salary(String id, @Autowired @Qualifier("employee2") Employee e){
        this.id = id;
        this.employee = e;
    }

    public Salary() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Salary{" +
                "id='" + id + '\'' +
                ", employee=" + employee +
                '}';
    }
}
