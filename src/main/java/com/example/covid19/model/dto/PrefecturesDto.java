package com.example.covid19.model.dto;

import lombok.Data;

@Data
public class PrefecturesDto {
    /**
     * 都道府県コード
     */
    private String prefecturesCode;
    /**
     * 都道府県名
     */
    private String prefecturesName;
}
