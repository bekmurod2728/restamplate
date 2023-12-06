package com.example.entity;


import lombok.AccessLevel;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    Integer age;
    @ManyToMany
    @JoinTable(
            name = "fan_person",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "fan_id")
    )
    Set<FanlarEntity> fanlars;

    public StudentEntity(String name, Integer age) {
        if (fanlars == null) {
            fanlars = new HashSet<>();
        }
        this.name = name;
        this.age = age;
    }

    public StudentEntity() {
        if (fanlars == null) {
            fanlars = new HashSet<>();
        }
    }

    public void addPerson(FanlarEntity fanlar) {
        if (fanlars == null) {
            fanlars = new HashSet<>();
        }
        fanlars.add(fanlar);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentEntity person = (StudentEntity) o;
        return Objects.equals(id, person.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
