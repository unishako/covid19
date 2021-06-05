package com.example.covid19.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@AutoConfigureMockMvc
@Sql(scripts = "classpath:/data/covid19.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
class ListControllerTest {

    @Autowired
    MockMvc mockMvc;

    /**
     * 初期(GET /list)
     * 一覧(POST /list)
     * JSON(GET /list/json)
     */

    @Test
    @Transactional
    void execute() {

    }
}