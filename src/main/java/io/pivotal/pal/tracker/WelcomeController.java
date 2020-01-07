package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    private String Msg;

    @GetMapping("/")
    public String sayHello() {
        return this.Msg;
    }
    public WelcomeController(
            @Value("${welcome.message}") String Message
    ){
        this.Msg = Message;
    }
}