package med.voll.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HellController {

    @GetMapping
    public String olaMundo (){
        return   "Ola Mundo Spring MVC!";
    }
}
