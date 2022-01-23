package com.gustavovalle.customauthentication.controller.user;

import com.gustavovalle.customauthentication.service.security.TokenService;
import com.gustavovalle.customauthentication.shared.LoginForm;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    public UserController(AuthenticationManager authenticationManager, TokenService tokenService) {
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }

    @PostMapping("/user/authenticate")
    public ResponseEntity<String> authenticate(@RequestBody @Valid LoginForm loginForm) {
        UsernamePasswordAuthenticationToken login = loginForm.convert();

        try {
            Authentication auth = authenticationManager.authenticate(login);
            String token = tokenService.generateToken(auth);
            return ResponseEntity.ok().body(token);
        } catch (AuthenticationException err) {
            return ResponseEntity.badRequest().body("User not found with provided credentials");
        }

    }

}
