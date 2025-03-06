package org.example.greetingapp.service;
import org.example.greetingapp.Model.Greeting;

import java.util.List;

public interface GreetingService {
    String generateGreeting(Greeting greeting);
    Greeting getGreeting(Long id);
    List<Greeting> getAllGreetings();
    Greeting updateGreeting(Long id, Greeting updatedGreeting);
    String deleteGreeting(Long id);
}
