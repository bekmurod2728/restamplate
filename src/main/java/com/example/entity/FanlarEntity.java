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
public class FanlarEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    Double duration;

    public FanlarEntity() {
        people=new HashSet<>();
    }

    public FanlarEntity(String name, Double duration) {
        if (people==null){
            people=new HashSet<>();
        }
        this.name = name;
        this.duration = duration;
    }

    @ManyToMany
    @JoinTable(
            name = "fan_person",
            joinColumns = @JoinColumn(name = "fan_id"),
            inverseJoinColumns = @JoinColumn(name = "person_id")
    )
    Set<StudentEntity> people;
    public void addPerson(StudentEntity studentEntity) {
        if (people==null){
            people=new HashSet<>();
        }
        people.add(studentEntity);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FanlarEntity fanlar = (FanlarEntity) o;
        return Objects.equals(id, fanlar.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
