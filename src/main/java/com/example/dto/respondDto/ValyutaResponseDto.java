package com.example.dto.respondDto;

import com.example.entity.ValyutaKursi;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ValyutaResponseDto {
    String Ccy;
    String CcyNm_UZ;
    String Rate;
    String Diff;
    String Date;

    public static ValyutaResponseDto change(ValyutaKursi kurs){
        ValyutaResponseDto dto=new ValyutaResponseDto();
        dto.setCcy(kurs.getCcy());
        dto.setCcyNm_UZ(kurs.getCcyNm_UZ());
        dto.setRate(kurs.getRate());
        dto.setDiff(kurs.getDiff());
        dto.setDate(kurs.getDate());
        return dto;
    }
}

