package com.jaga.backend.error;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@RequiredArgsConstructor
@ControllerAdvice
public class WebsocketExceptionHandler {

    private final SimpMessagingTemplate messagingTemplate;
    ObjectMapper mapper = new ObjectMapper();


    @ExceptionHandler(ErrorException.class)
    public void handleWebSocketException(ErrorException e) {

        messagingTemplate.convertAndSend(
                e.getDestination(),
                e.getMessage()
        );


        /*messagingTemplate.convertAndSendToUser(
                Objects.requireNonNull(headerAccessor.getUser()).getName(),
                e.getDestination(),
                e.getMessage()
               );*/

    }

}