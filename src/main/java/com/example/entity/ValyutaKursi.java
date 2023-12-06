package com.example.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ValyutaKursi {
    public Long id;
    @JsonProperty("Code")
    public String code;
    @JsonProperty("Ccy")
    public String ccy;
    @JsonProperty("CcyNm_RU")
    public String ccyNm_RU;
    @JsonProperty("CcyNm_UZ")
    public String ccyNm_UZ;
    @JsonProperty("CcyNm_UZC")
    public String ccyNm_UZC;
    @JsonProperty("CcyNm_EN")
    public String ccyNm_EN;
    @JsonProperty("Nominal")
    public String nominal;
    @JsonProperty("Rate")
    public String rate;
    @JsonProperty("Diff")
    public String diff;
    @JsonProperty("Date")
    public String date;
//    Long id;
//    String Code;
//    String Ccy;
//    String CcyNm_RU;
//    String CcyNm_UZ;
//    String CcyNm_UZC;
//    String CcyNm_EN;
//    String Nominal;
//    String Rate;
//    String Diff;
//    String Date;
}
