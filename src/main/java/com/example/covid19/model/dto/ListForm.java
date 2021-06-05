package com.example.covid19.model.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ListForm {

    /**
     * アクション
     */
    private String action;
    /**
     * 日付
     */
    private LocalDate yyyyMmDd;
    /**
     * 都道府県コード
     */
    private String prefecturesCode;
}
