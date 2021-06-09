package com.example.covid19.controller;

import com.example.covid19.model.dto.Covid19Dto;
import com.example.covid19.model.dto.PrefecturesDto;
import com.example.covid19.model.service.Covid19Service;
import com.example.covid19.model.service.PrefecturesService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
class ListControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private Covid19Service covid19Service;

    @MockBean
    private PrefecturesService prefecturesService;

    @Test
    @Transactional
    void execute_初期表示() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.post("/list"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("list"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("prefecturesDtoList"))
        ;
    }

    @Test
    @Transactional
    void execute_検索() throws Exception {

        final String PREFECTURES_CODE = "99";
        final String PREFECTURES_NAME = "国国国国国国国国国国";

        Mockito.when(covid19Service.search("99"))
                .thenReturn(List.of(new Covid19Dto() {
                    {
                        setYyyyMmDd(LocalDate.MIN);
                        setPrefecturesCode(PREFECTURES_CODE);
                        setPrefecturesName(PREFECTURES_NAME);
                        setInfectionPersonCountOneDay("1,111");
                        setInfectionPersonCountTotal("2,222");
                        setDeadCountOneDay("3,333");
                        setDeadCountTotal("4,444");
                    }
                }));

        Mockito.when(prefecturesService.list())
                .thenReturn(List.of(new PrefecturesDto() {
                    {
                        setPrefecturesCode(PREFECTURES_CODE);
                        setPrefecturesName(PREFECTURES_NAME);
                    }
                }));

        mockMvc.perform(MockMvcRequestBuilders.post("/list")
                .param("action", "検索")
                .param("prefecturesCode", "99"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("list"))
                .andExpect(MockMvcResultMatchers.model().attribute("prefecturesDtoList", List.of(new PrefecturesDto() {
                    {
                        setPrefecturesCode(PREFECTURES_CODE);
                        setPrefecturesName(PREFECTURES_NAME);
                    }
                })))
                .andExpect(MockMvcResultMatchers.model().attribute("covid19DtoList", List.of(new Covid19Dto() {
                    {
                        setYyyyMmDd(LocalDate.MIN);
                        setPrefecturesCode(PREFECTURES_CODE);
                        setPrefecturesName(PREFECTURES_NAME);
                        setInfectionPersonCountOneDay("1,111");
                        setInfectionPersonCountTotal("2,222");
                        setDeadCountOneDay("3,333");
                        setDeadCountTotal("4,444");
                    }
                })));
    }

}