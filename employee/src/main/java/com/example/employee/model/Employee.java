package com.example.employee.model;

import java.util.Collection;
import jakarta.persistence.*;
import com.example.employee.model.Role; // ✅ CORRECT!

@Entity
@Table(name =  "user", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Employee {
//..............................................................
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
    @Column(name = "first_name")
    private String firstName;
//...........................................................
    @Column(name = "last_name")
    private String lastName;
//............................................................
    private String email;
//...........................................................
    private String password;
//............................................................
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"))
    private Collection<Role> roles;

    // Getters and Setters
    // id ........................................................
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    // first name..............................................
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    // last name..................................................

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // email..............................................

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    // password..................................................

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    // roles................................................
    public Collection<Role> getRoles() {
        return roles;
    }
    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }
}