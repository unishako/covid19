package com.example.covid19.model.dto;

import lombok.Data;
import org.seasar.doma.Entity;
import org.seasar.doma.Metamodel;

import java.time.LocalDate;

/**
 * covid19
 */
@Entity(metamodel = @Metamodel)
@Data
public class Covid19 {

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
    private Integer infectionPersonCountOneDay;
    /**
     * 各地の感染者数_累計
     */
    private Integer infectionPersonCountTotal;
    /**
     * 各地の死者数_1日ごとの発表数
     */
    private Integer deadCountOneDay;
    /**
     * 各地の死者数_累計
     */
    private Integer deadCountTotal;
}
