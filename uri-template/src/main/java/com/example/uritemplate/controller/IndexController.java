package com.example.uritemplate.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.Option;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class IndexController {
    //send data url
    //curl "http://localhost:8080/api/person?name=Thaw+Thaw+Htun+Zin&age=89"
    @GetMapping("/person")
    public String personV1(@RequestParam(value = "name",required = false,defaultValue = "Khaing") Optional<String> name,
                           @RequestParam("age")int age
                            ){
        return String.format("Name ::[%s] :: Age[%d]", name.get(), age); //you must -> Optional<String> name -> name.get()
    }
}
