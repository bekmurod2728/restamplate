package com.example.service;

import com.example.dto.respondDto.ValyutaResponseDto;
import com.example.entity.ValyutaKursi;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ValyutaServise {
    private final RestTemplate restTemplate;

    public ValyutaServise(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<List<ValyutaResponseDto>> getAll() {

        String url ="https://cbu.uz/uz/arkhiv-kursov-valyut/json/";
        ResponseEntity<ValyutaKursi[]> forEntity =  restTemplate.getForEntity(url, ValyutaKursi[].class);
        List<ValyutaResponseDto> collect = Arrays.stream(forEntity.getBody()).map(ValyutaResponseDto::change).collect(Collectors.toList());
        return ResponseEntity.ok(collect);
    }

    public ResponseEntity<ValyutaResponseDto> findByName(String ccy){
        String url ="https://cbu.uz/uz/arkhiv-kursov-valyut/json/";
        ResponseEntity<ValyutaKursi[]> forEntity =  restTemplate.getForEntity(url, ValyutaKursi[].class);
        ValyutaResponseDto dto = Arrays.stream(forEntity.getBody()).filter(e -> e.getCcy().equals(ccy)).map(ValyutaResponseDto::change).findFirst().orElse(null);
        return (dto!=null)? ResponseEntity.ok(dto):ResponseEntity.notFound().build();
    }
}
