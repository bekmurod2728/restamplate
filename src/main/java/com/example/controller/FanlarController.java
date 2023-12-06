package com.example.controller;

import com.example.dto.requestDto.FanlarRequestDto;
import com.example.dto.requestDto.PersonRequestDto;
import com.example.dto.respondDto.FanlarRespondDto;
import com.example.dto.respondDto.StudentRespondDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("fan")
public class FanlarController {
    @Autowired
    private RestTemplate restTemplate;
@GetMapping("get")
    public ResponseEntity<List<StudentRespondDto>> getAll() {
    String url="http://localhost:8080/person/show";
        List<?> dto=restTemplate.getForObject(url,List.class);

    return ResponseEntity.ok(null);
}

    @PostMapping("/add")
    public ResponseEntity<FanlarRespondDto> addFan(@RequestBody FanlarRequestDto dto){
    String url="http://localhost:8080/person/add";
        ResponseEntity<FanlarRespondDto> response = restTemplate
                .postForEntity(url,dto
                        , FanlarRespondDto.class);
        return response;
    }
    @DeleteMapping("/del/{id}")
    public ResponseEntity<FanlarRespondDto> deleteById(@PathVariable Long id){
    String url="http://localhost:8080/person/del/{id}";
    ResponseEntity<FanlarRespondDto> response = restTemplate.exchange(
                url,
                HttpMethod.DELETE,
                null,
                FanlarRespondDto.class,
                id
        );

    return response;
    }

}
