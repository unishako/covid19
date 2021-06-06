package com.example.covid19.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@AutoConfigureMockMvc
@Sql(scripts = "classpath:/data/covid19.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
class ListControllerTest {

    @Autowired
    MockMvc mockMvc;

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

        mockMvc.perform(MockMvcRequestBuilders.post("/list")
                .param("action", "検索")
                .param("prefecturesCode", "99"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("list"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("prefecturesDtoList"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("covid19DtoList"))
        ;
    }

}