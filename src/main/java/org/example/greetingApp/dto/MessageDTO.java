package org.example.greetingApp.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MessageDTO {

    String message;

    Long id;

    public MessageDTO(String message) {
        this.message = message;
        this.id = null;
    }

}
