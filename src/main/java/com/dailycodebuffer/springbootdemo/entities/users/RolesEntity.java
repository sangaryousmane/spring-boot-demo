package com.dailycodebuffer.springbootdemo.entities.users;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Entity(name = "RolesEntity")
@Table(name = "roles")
@NoArgsConstructor
@Getter
@Setter
public class RolesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false)
    private String name;

    @Column(length = 250, nullable = false)
    private String description;

    public RolesEntity(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public RolesEntity(Integer id) {
        this.id = id;
    }

    public RolesEntity(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "RolesEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RolesEntity entity)) return false;
        return Objects.equals(id, entity.id)
                && Objects.equals(name, entity.name) && Objects.equals(description, entity.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description);
    }
}
