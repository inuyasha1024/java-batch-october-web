package com.siliconspectra.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

public class MainApp {


    public static void main(String[] args) {
//        xml bean creation
//        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
//        Employee employee = (Employee) ac.getBean("employee1");
//        Salary salary = (Salary) ac.getBean("salary");
//        Salary salary1 = ac.getBean(Salary.class);
//        System.out.println(salary == salary1);

        //annotation bean creation
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(Config.class);
//        Employee employee = (Employee)ac.getBean("employee2");
//        Employee employee1 = ac.getBean(Employee.class);
        Salary salary = ac.getBean(Salary.class);
        Environment env = ac.getEnvironment();
        System.out.println(salary);
        ac.close();
    }
}
