package com.example.covid19.model.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Covid19Dto {
    /**
     * 日付
     */
    private LocalDate yyyyMmDd;
    /**
     * 都道府県コード
     */
    private String prefecturesCode;
    /**
     * 都道府県名
     */
    private String prefecturesName;
    /**
     * 各地の感染者数_1日ごとの発表数
     */
    private String infectionPersonCountOneDay;
    /**
     * 各地の感染者数_累計
     */
    private String infectionPersonCountTotal;
    /**
     * 各地の死者数_1日ごとの発表数
     */
    private String deadCountOneDay;
    /**
     * 各地の死者数_累計
     */
    private String deadCountTotal;
}
