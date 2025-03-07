package org.example.greetingApp.repositories;

import org.example.greetingApp.entities.MessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GreetingRepository extends JpaRepository<MessageEntity, Long> {


}
