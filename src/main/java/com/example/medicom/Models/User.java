package com.example.medicom.Models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.Date;
import java.util.Set;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Поле не может быть пустым")
    @NotEmpty(message = "Поле не может быть пустым")
    private String username;

    @NotNull(message = "Поле не может быть пустым")
    @NotEmpty(message = "Поле не может быть пустым")
    private String password;

    private boolean active;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    private Date lastEnter;

    @OneToMany(mappedBy = "user_", fetch = FetchType.EAGER)
    private Collection<Log> logCollection;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String login) {
        this.username = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Date getLastEnter() {
        return lastEnter;
    }

    public void setLastEnter(Date lastEnter) {
        this.lastEnter = lastEnter;
    }

    public Collection<Log> getLogCollection() {
        return logCollection;
    }

    public void setLogCollection(Collection<Log> logCollection) {
        this.logCollection = logCollection;
    }

    public User(String username, String password, boolean active, Set<Role> roles, Date lastEnter) {
        this.username = username;
        this.password = password;
        this.active = active;
        this.roles = roles;
        this.lastEnter = lastEnter;
    }

    public User() {
    }
}
