package com.example.dto.respondDto;


import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class StudentRespondDto {
    Long id;
    String name;
    Integer age;
    List<String> fanlars=new ArrayList<>();


//    public static PersonRespondDto of(Person person){
//        PersonRespondDto dto=new PersonRespondDto();
//        dto.setId(person.getId());
//        dto.setName(person.getName());
//        dto.setAge(person.getAge());
//        dto.setFanlars(person.getFanlars().stream().map(Fanlar::getName).collect(Collectors.toList()));
//        return dto;
//    }
}
