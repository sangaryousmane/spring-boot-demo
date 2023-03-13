package com.dailycodebuffer.springbootdemo.entities.users;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity(name = "UserEntity")
@Table(name = "users")
@NoArgsConstructor
@Getter
@Setter
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String email;

    @Column(nullable = false, name = "first_name")
    private String firstname;

    @Column(nullable = false, name = "last_name")
    private String lastName;
    private String password;
    private boolean enabled;

    @Column(length = 64)
    private String photos;

    // TODO: This is a Unidirectional relationship
    @ManyToMany
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(
                    name = "user_id",
                    foreignKey = @ForeignKey(name = "user_FK")),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id",
                    foreignKey = @ForeignKey(name = "role_FK"))
    )
    private Set<RolesEntity> roles = new HashSet<>();

    public UserEntity(String email, String firstname,
                      String lastName, String password) {
        this.email = email;
        this.firstname = firstname;
        this.lastName = lastName;
        this.password = password;
    }

    public void addRole(RolesEntity roleId) {
        this.roles.add(roleId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UserEntity that = (UserEntity) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }


    @Override
    public String toString() {
        return "UserEntity{" +
                "email='" + email + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastName='" + lastName + '\'' +
                ", roles=" + roles +
                '}';
    }
}
