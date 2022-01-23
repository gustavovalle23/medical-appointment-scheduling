package com.gustavovalle.customauthentication.controller.user;

import com.gustavovalle.customauthentication.service.security.AuthenticationService;
import com.gustavovalle.customauthentication.service.security.TokenService;
import com.gustavovalle.customauthentication.shared.JwtTokenDTO;
import com.gustavovalle.customauthentication.shared.LoginForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
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
    private final AuthenticationService authenticationService;

    Logger log = LoggerFactory.getLogger(UserController.class);

    public UserController(AuthenticationManager authenticationManager,
                          TokenService tokenService,
                          AuthenticationService authenticationService) {
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/user/authenticate")
    public ResponseEntity<JwtTokenDTO> authenticate(@RequestBody @Valid LoginForm loginForm) throws Exception {
        UsernamePasswordAuthenticationToken login = loginForm.convert();

        Authentication auth = authenticationService.authenticate(authenticationManager, login);
        String token = tokenService.generateToken(auth);
        return ResponseEntity.ok(new JwtTokenDTO(token));
    }
}
