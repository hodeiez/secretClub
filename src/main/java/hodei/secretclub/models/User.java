package hodei.secretclub.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;



import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

/**
 * Created by Hodei Eceiza
 * Date: 4/17/2021
 * Time: 22:03
 * Project: secretClub
 * Copyright: MIT
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="users")

public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="user_id")
    private int id;
    @Column(name="user_name")
    @Length(min=4,message="user name must have at least 4 characters")
    @NotEmpty(message="write something!")
    private String userName;
    @Column(name="email")
    @Email(message="a valid email please")
    @NotEmpty(message="write an email please!")
    private String email;
    @Column(name="password")
    @Length(min=5,message="has to be at least 5 characters")
    @NotEmpty(message="write a password, please")
    private String password;
    @Column(name="name")
    @NotEmpty(message="write your name")
    private String name;
    @Column(name="active")
    private Boolean active;
    @ManyToMany(cascade=CascadeType.MERGE)
    @JoinTable(name="user_role",joinColumns=@JoinColumn(name="user_id"),inverseJoinColumns=@JoinColumn(name="role_id"))
    private Set<Role> roles;



}
