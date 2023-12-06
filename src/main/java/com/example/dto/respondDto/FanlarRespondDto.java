package com.example.dto.respondDto;


import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class FanlarRespondDto {
    Long id;
    String name;
    Double duration;
    List<String> people;

    public FanlarRespondDto() {
        people=new ArrayList<>();
    }

//    public static FanlarRespondDto of(Fanlar fanlar){
//        FanlarRespondDto dto=new FanlarRespondDto();
//        dto.setId(fanlar.getId());
//        dto.setName(fanlar.getName());
//        dto.setDuration(fanlar.getDuration());
//        dto.setPeople(fanlar.getPeople().stream()
//                .filter(Objects::nonNull).map(Person::getName)
//                .collect(Collectors.toList()));
//        return dto;
//    }
}
