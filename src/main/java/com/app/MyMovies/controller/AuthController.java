package com.app.MyMovies.controller;

import com.app.MyMovies.dto.AuthDto;
import com.app.MyMovies.dto.AuthResponseDto;
import com.app.MyMovies.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    AuthService service;

    @PostMapping("")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public AuthResponseDto check(@RequestBody AuthDto request) {
        return service.check(request);
    }

}
