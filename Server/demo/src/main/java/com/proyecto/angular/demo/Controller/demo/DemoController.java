package com.proyecto.angular.demo.Controller.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/demo")
public class DemoController {
    
    @GetMapping
    public String demo(){
        return "Hola mundo";
    }

}
