package com.gustavovalle.medicalappointment.api.rest;

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

import com.gustavovalle.medicalappointment.usecases.dtos.CreateUser;
import com.gustavovalle.medicalappointment.usecases.dtos.JwtToken;
import com.gustavovalle.medicalappointment.usecases.dtos.LoginUser;
import com.gustavovalle.medicalappointment.usecases.dtos.UserDto;
import com.gustavovalle.medicalappointment.infra.models.User;
import com.gustavovalle.medicalappointment.infra.service.security.AuthenticationService;
import com.gustavovalle.medicalappointment.infra.service.security.TokenService;
import com.gustavovalle.medicalappointment.infra.service.user.UserService;

import javax.validation.Valid;

import static com.gustavovalle.medicalappointment.infra.builders.UserBuilder.user;

@RestController
@RequestMapping("/api/v1")
public class UserController {

	private final AuthenticationManager authenticationManager;
	private final TokenService tokenService;
	private final UserService userService;
	private final AuthenticationService authenticationService;

	Logger log = LoggerFactory.getLogger(UserController.class);

	public UserController(AuthenticationManager authenticationManager,
			TokenService tokenService,
			UserService userService,
			AuthenticationService authenticationService) {
		this.authenticationManager = authenticationManager;
		this.tokenService = tokenService;
		this.userService = userService;
		this.authenticationService = authenticationService;
	}

	@PostMapping("/user/authenticate")
	public ResponseEntity<JwtToken> authenticate(@RequestBody @Valid LoginUser loginForm) throws Exception {
		UsernamePasswordAuthenticationToken login = loginForm.convert();

		Authentication auth = authenticationService.authenticate(authenticationManager, login);
		String token = tokenService.generateToken(auth);
		return ResponseEntity.ok(new JwtToken(token));
	}

	@PostMapping("/user/save")
	public ResponseEntity<UserDto> saveUser(@RequestBody @Valid CreateUser createUser) {
		log.info("Request to save {}", createUser);
		User user = user().build(createUser);
		UserDto savedUser = userService.saveUser(user);
		return ResponseEntity.ok(savedUser);
	}
}
