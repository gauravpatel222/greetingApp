package org.example.greetingapp.controller;
import org.example.greetingapp.Model.Greeting;
import org.example.greetingapp.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HelloController {

    // Injecting Service Layer
    @Autowired
    private GreetingService greetingService;

    // UC1: Say "Hello World"
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello World!";
    }

    // UC2: Say Hello with Name as Query Parameter
    @GetMapping("/hello/query")
    public String sayHelloQuery(@RequestParam String name) {
        return "Hello, " + name + "!";
    }

    // UC3: Say Hello with Name in Path Variable
    @GetMapping("/hello/param/{name}")
    public String sayHelloPath(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    // UC4: Generate and Save Greeting
    @PostMapping("/greeting")
    public String generateGreeting(@RequestBody Greeting greeting) {
        return greetingService.generateGreeting(greeting);
    }

    // UC5: Get a Greeting by ID
    @GetMapping("/greeting/{id}")
    public Greeting getGreeting(@PathVariable Long id) {
        return greetingService.getGreeting(id);
    }

    // UC6: Get All Greetings
    @GetMapping("/greeting")
    public List<Greeting> getAllGreetings() {
        return greetingService.getAllGreetings();
    }

    // UC7: Update an existing Greeting message
    @PutMapping("/greeting/{id}")
    public Greeting updateGreeting(@PathVariable Long id, @RequestBody Greeting updatedGreeting) {
        return greetingService.updateGreeting(id, updatedGreeting);
    }

    // UC8: Delete a Greeting Message
    @DeleteMapping("/greeting/{id}")
    public String deleteGreeting(@PathVariable Long id) {
        return greetingService.deleteGreeting(id);
    }
}
