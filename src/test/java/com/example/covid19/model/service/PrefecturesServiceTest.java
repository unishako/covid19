package com.example.covid19.model.service;

import com.example.covid19.model.dao.PrefecturesDao;
import com.example.covid19.model.dto.Prefectures;
import com.example.covid19.model.dto.PrefecturesDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

@SpringBootTest
class PrefecturesServiceTest {

    @Autowired
    PrefecturesService prefecturesService;

    @MockBean
    PrefecturesDao prefecturesDao;

    @Test
    void list_取得内容() {
        final String PREFECTURES_CODE = "99";
        final String PREFECTURES_NAME = "国国国国国国国国国国";

        Mockito.when(prefecturesDao.findAll())
                .thenReturn(List.of(new Prefectures() {
                    {
                        setPrefecturesCode(PREFECTURES_CODE);
                        setPrefecturesName(PREFECTURES_NAME);
                    }
                }));
        Assertions.assertEquals(PREFECTURES_NAME, prefecturesService.list().stream().findFirst().map(PrefecturesDto::getPrefecturesName).orElseThrow());
    }
}