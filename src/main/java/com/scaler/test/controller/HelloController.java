package com.scaler.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//This class is serving a REST(HTTP)APIS
//local host 8080
@RestController
@RequestMapping("/Hello")
public class HelloController {
    @GetMapping("/say/{name}/{times}")
    public String sayHello(@PathVariable("name") String name,
                                @PathVariable("times") int times){
       String ans="";
       for(int i=1;i<=times;i++){
           ans +="Hello " +name;
           ans += "<br>";
       }
        return ans;
    }
}
