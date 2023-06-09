package com.meta.ale.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnpDocDto {
    private Long docId;
    private Integer totalAnv;
    private Integer usedAnv;
    private Integer remainAnv;
    @DateTimeFormat(pattern = "yyyy-MM-dd" )
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date occurDate; // 문서생성시점
    @DateTimeFormat(pattern = "yyyy-MM-dd" )
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date anvOccurDate; // 연차생성시점
    private EmpDto empDto;

    // 연차사용계획서 존재여부 판단용
    private Integer plan;

    public void setAll(EmpDto empDto, int totalAnv, Date occurDate, int remainAnv, int usedAnv, Date anvOccurDate) {
        this.totalAnv =totalAnv;
        this.usedAnv =usedAnv;
        this.remainAnv = remainAnv;
        this.empDto =empDto;
        this.occurDate =occurDate;
        this.anvOccurDate = anvOccurDate;
    }
}
