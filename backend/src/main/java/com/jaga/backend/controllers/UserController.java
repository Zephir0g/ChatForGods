package com.jaga.backend.controllers;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import com.jaga.backend.data.dto.ErrorDto;
import com.jaga.backend.data.service.JwtService;
import com.jaga.backend.data.service.MessageSendingService;
import com.jaga.backend.data.dto.MessageDto;

@Controller
@AllArgsConstructor
@RestController
@MessageMapping("/user")
public class UserController {

    private final JwtService jwtService;
    private final MessageSendingService messageSendingService;

    @MessageMapping("/getUsername")
    @SendTo("/topic/user")
    @Transactional
    public void registerUser(@Payload String userToken) throws Exception {

        // TODO check user token and return username if valid else return error

        
        if (isValidUserToken(userToken)) {
            String username = getUsername(userToken);

            messageSendingService.sendMessage(new MessageDto("Username: " + username, "/topic/user", 200));

        } else { 
            messageSendingService.sendError(new ErrorDto("Invalid user token", "/topic/user", 400));
        }
    }

    private boolean isValidUserToken(String userToken) {
        // implement logic to check if user token is valid
        return true;
    }

    private String getUsername(String userToken) {
        // implement logic to get username from user token
        return "username";
    }

}
