package com.gustavovalle.medicalappointment.infra.entities;

import com.gustavovalle.medicalappointment.domain.entities.user.UserDto;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Entity
public class User implements UserDetails {

    public User(String email, String password, LocalDateTime birthDate) {
        this.email = email;
        this.password = password;
        this.birthDate = birthDate;
    }

    public User() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Email is required!")
    private String email;

    @NotNull(message = "Password is required!")
    private String password;

    @NotNull(message = "Birth date is required!")
    @Column(name = "birth_date")
    private LocalDateTime birthDate;

    @NotNull
    @ManyToMany
    private List<Profile> profiles;

    public LocalDateTime getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDateTime birthDate) {
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
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", birthDate=" + birthDate +
                ", profiles=" + profiles +
                '}';
    }

    public UserDto toDto() {
        return new UserDto(this.id, this.email, this.password, this.birthDate);
    }
}
