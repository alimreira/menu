package com.example.menuManagement.authModel;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name ="customers")
public class RegisterUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(unique = true)
    private String userName;
    @Column(unique = true)
    private String email;
    private String password;


    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(
            name = "users_roles", // Specify the name of the join table
            joinColumns = @JoinColumn(name = "user_id",referencedColumnName = "id"), // Name of the join column in the user_roles table
            inverseJoinColumns = @JoinColumn(name = "role_id",referencedColumnName = "id") // Name of the join column in the role table
    )
    private Set<Role> roleSet = new HashSet<>();

}
