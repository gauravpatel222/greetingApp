package org.example.greetingapp.service;

import org.example.greetingapp.Model.Greeting;
import org.example.greetingapp.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GreetingServiceImpl implements GreetingService {

    @Autowired
    private GreetingRepository greetingRepository;

    @Override
    public String generateGreeting(Greeting greeting) {
        String message;

        if (greeting.getFirstName() != null && greeting.getLastName() != null) {
            message = "Hello, " + greeting.getFirstName() + " " + greeting.getLastName() + "!";
        } else if (greeting.getFirstName() != null) {
            message = "Hello, " + greeting.getFirstName() + "!";
        } else if (greeting.getLastName() != null) {
            message = "Hello, " + greeting.getLastName() + "!";
        } else {
            message = "Hello, World!";
        }

        greeting.setMessage(message);
        greetingRepository.save(greeting);
        return message;
    }

    @Override
    public Greeting getGreeting(Long id) {
        return greetingRepository.findById(id).orElse(null);
    }

    @Override
    public List<Greeting> getAllGreetings() {
        return greetingRepository.findAll();
    }

    @Override
    public Greeting updateGreeting(Long id, Greeting updatedGreeting) {
        return greetingRepository.findById(id)
                .map(greeting -> {
                    greeting.setMessage(updatedGreeting.getMessage());
                    return greetingRepository.save(greeting);
                })
                .orElseThrow(() -> new RuntimeException("Greeting not found with id " + id));
    }

    @Override
    public String deleteGreeting(Long id) {
        if (greetingRepository.existsById(id)) {
            greetingRepository.deleteById(id);
            return "Greeting with ID " + id + " has been deleted.";
        } else {
            return "Greeting not found with ID " + id;
        }
    }
}
