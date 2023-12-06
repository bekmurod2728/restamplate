package com.example.controller;

import com.example.dto.respondDto.ValyutaResponseDto;
import com.example.service.ValyutaServise;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/kurs")
public class ValyutaController {
    private final ValyutaServise servise;

    public ValyutaController(ValyutaServise servise) {
        this.servise = servise;
    }

    @GetMapping("/all")
    public ResponseEntity<List<ValyutaResponseDto>> getAll(){
        return servise.getAll();
    }

    @GetMapping("/find/{ccy}")
    public ResponseEntity<ValyutaResponseDto> findByName(@PathVariable String ccy){
        return servise.findByName(ccy);
    }
}
