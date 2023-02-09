package com.gustavovalle.restaurant.api.rest;

import com.gustavovalle.restaurant.usecases.create.CreateUserCommand;
import com.gustavovalle.restaurant.usecases.create.CreateUserOutput;
import com.gustavovalle.restaurant.usecases.create.CreateUserUseCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gustavovalle.restaurant.infra.dtos.JwtToken;
import com.gustavovalle.restaurant.infra.dtos.LoginUser;
import com.gustavovalle.restaurant.infra.gateways.services.security.AuthenticationService;
import com.gustavovalle.restaurant.infra.gateways.services.security.TokenService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class UserController {

	private final AuthenticationManager authenticationManager;
	private final TokenService tokenService;
	private final CreateUserUseCase createUserUseCase;
	private final AuthenticationService authenticationService;

	Logger log = LoggerFactory.getLogger(UserController.class);

	public UserController(AuthenticationManager authenticationManager,
						  TokenService tokenService,
						  CreateUserUseCase createUserUseCase, AuthenticationService authenticationService) {
		this.authenticationManager = authenticationManager;
		this.tokenService = tokenService;
		this.createUserUseCase = createUserUseCase;
		this.authenticationService = authenticationService;
	}

	@PostMapping("/user/authenticate")
	public ResponseEntity<JwtToken> authenticate(@RequestBody @Valid LoginUser loginForm) throws Exception {
		log.info("Request to /user/authenticate -> {}", loginForm);
		UsernamePasswordAuthenticationToken login = loginForm.convert();

		Authentication auth = authenticationService.authenticate(authenticationManager, login);
		String token = tokenService.generateToken(auth);
		return ResponseEntity.ok(new JwtToken(token));
	}

	@PostMapping("/user/save")
	public ResponseEntity<CreateUserOutput> saveUser(@RequestBody @Valid CreateUserCommand input) throws Exception {
		log.info("Request to save user with input -> {}", input);
		CreateUserOutput output = createUserUseCase.execute(input);
		return ResponseEntity.ok(output);
	}
}
