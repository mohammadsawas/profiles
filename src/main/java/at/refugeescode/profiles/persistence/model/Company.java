package at.refugeescode.profiles.persistence.model;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;

@Entity
@Component
public class Company {

    @Id
    @GeneratedValue
    private Long id;

    @NotEmpty
    private String name;
    @Column(unique = true)
    private String username;

    private String password;

    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @ElementCollection(fetch = FetchType.EAGER)
    private Set<String> authorities = new HashSet();

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Profile> interested = new HashSet<>();

    public Set<Profile> getInterested() {
        return interested;
    }

    public void setInterested(Set<Profile> interested) {
        this.interested = interested;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<String> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<String> authorities) {
        this.authorities = authorities;
    }
}
