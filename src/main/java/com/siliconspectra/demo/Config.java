package com.siliconspectra.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@ComponentScan(basePackages = "com.siliconspectra.demo")
@PropertySource("application.properties")
public class Config {

}
