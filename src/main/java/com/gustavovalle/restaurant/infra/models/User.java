package com.gustavovalle.restaurant.infra.models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.gustavovalle.restaurant.infra.dtos.UserDto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Entity(name = "users")
public class User implements UserDetails {

	public User(String name, String email, String password, LocalDate birthDate) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.birthDate = birthDate;
	}

	public User() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "Name is required!")
	private String name;

	@NotNull(message = "Email is required!")
	private String email;

	@NotNull(message = "Password is required!")
	private String password;

	@NotNull(message = "Birth date is required!")
	@Column(name = "birth_date")
	private LocalDate birthDate;

	@NotNull
	@ManyToMany
	private List<Profile> profiles;

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return profiles;
	}

	@Override
	public String getPassword() {
		return password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getUsername() {
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Profile> getProfiles() {
		return profiles;
	}

	public void setProfiles(List<Profile> profiles) {
		this.profiles = profiles;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", birthDate=" + birthDate + ", profiles="
				+ profiles + "]";
	}

	public UserDto toDto() {
		return new UserDto(this.id, this.name, this.email, this.password, this.birthDate);
	}

}
