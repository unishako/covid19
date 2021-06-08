package com.example.covid19.model.service;

import com.example.covid19.model.dao.Covid19Dao;
import com.example.covid19.model.dto.Covid19;
import com.example.covid19.model.dto.Covid19Dto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
class Covid19ServiceTest {

    @Autowired
    Covid19Service covid19Service;

    @MockBean
    Covid19Dao covid19Dao;

    /**
     * 取得内容テスト
     */
    @Test
    void search_取得内容() {

        final String PREFECTURES_CODE = "99";
        final String PREFECTURES_NAME = "国国国国国国国国国国";

        Mockito.when(covid19Dao.findByPrefecturesCode("99"))
                .thenReturn(List.of(new Covid19() {
                    {
                        setYyyyMmDd(LocalDate.now());
                        setPrefecturesCode(PREFECTURES_CODE);
                        setPrefecturesName(PREFECTURES_NAME);
                        setInfectionPersonCountOneDay(1111);
                        setInfectionPersonCountTotal(2222);
                        setDeadCountOneDay(3333);
                        setDeadCountTotal(4444);
                    }
                }));
        Assertions.assertEquals(PREFECTURES_NAME, covid19Service.search(PREFECTURES_CODE).stream().findFirst().map(Covid19Dto::getPrefecturesName).orElseThrow());
        Assertions.assertEquals("1,111", covid19Service.search(PREFECTURES_CODE).stream().findFirst().map(Covid19Dto::getInfectionPersonCountOneDay).orElseThrow());
        Assertions.assertEquals("2,222", covid19Service.search(PREFECTURES_CODE).stream().findFirst().map(Covid19Dto::getInfectionPersonCountTotal).orElseThrow());
        Assertions.assertEquals("3,333", covid19Service.search(PREFECTURES_CODE).stream().findFirst().map(Covid19Dto::getDeadCountOneDay).orElseThrow());
        Assertions.assertEquals("4,444", covid19Service.search(PREFECTURES_CODE).stream().findFirst().map(Covid19Dto::getDeadCountTotal).orElseThrow());
    }
}
