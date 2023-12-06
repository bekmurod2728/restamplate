package com.example.controller;

import com.example.dto.requestDto.PersonRequestDto;
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
@RequestMapping("student")
public class StudentController {
    @Autowired
    private RestTemplate restTemplate;
@GetMapping("get")
    public ResponseEntity<List<StudentRespondDto>> getAll() {
    String url="http://localhost:8080/person/show";
        ResponseEntity<List<StudentRespondDto>> dto=restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<StudentRespondDto>>() {}
        );

        return dto;
    }


    @PostMapping("/add")
    public ResponseEntity<StudentRespondDto> addFan(@RequestBody PersonRequestDto dto){
    String url="http://localhost:8080/person/add";
    HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<PersonRequestDto> requestEntity = new HttpEntity<>(dto, headers);

        ResponseEntity<StudentRespondDto> response = restTemplate
                .postForEntity(url, requestEntity
                        , StudentRespondDto.class);
        return response;
    }
    @DeleteMapping("/del/{id}")
    public ResponseEntity<StudentRespondDto> deleteById(@PathVariable Long id){
    String url="http://localhost:8080/person/del/{id}";
    ResponseEntity<StudentRespondDto> response = restTemplate.exchange(
                url,
                HttpMethod.DELETE,
                null,
                StudentRespondDto.class,
                id
        );

    return response;
    }

}
