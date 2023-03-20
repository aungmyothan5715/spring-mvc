package com.example.uritemplate.controller;

import jakarta.annotation.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    //curl http://localhost:8080/percurl http://localhost:8080/pereson/John/city/Mandalay/hobby/Reading/age/23son/John/city/Mandalay/hobby/Reading/age/23
    @GetMapping("/person/{name}/city/{city}/hobby/{hobby}/age/{age}")
    public String personInfoV1(
        @PathVariable("name")String name,
        @PathVariable String city,
        @PathVariable("hobby")String myHobby,
        @PathVariable int age){

        return String.format(
                "Name ::[%s]\nCity ::[%s]\nHobby ::[%s]\nAge ::[%d]",
                name,city,myHobby,age
        );
    }

    //curl http://localhost:8080/personinfo/Khaing/Swimming
    @GetMapping({"/personinfo/{name}/{hobby}","/personinfo/{name}"})  // you can insert two link or more
    public String personInfoV2(
            @PathVariable String name,
            @PathVariable @Nullable String hobby){ // @Nullable , (required=false)
        return String.format("Name ::[%s] :: Hobby[%s]",name, hobby);
    }
}
