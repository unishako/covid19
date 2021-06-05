package com.example.covid19.model.dao;

import com.example.covid19.model.dto.Covid19;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.jdbc.JdbcTestUtils;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Sql(scripts = "classpath:/data/covid19.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
class Covid19DaoTest {

    @Autowired
    Covid19Dao covid19Dao;

    @Autowired
    JdbcTemplate jdbcTemplate;

    /**
     * 取得内容テスト
     */
    @Test
    @Transactional
    void findByPrefecturesCode_取得内容() {
        List<Covid19> list = covid19Dao.findByPrefecturesCode("99");
        Assertions.assertEquals("国国国国国国国国国１", list.stream().findFirst().map(Covid19::getPrefecturesName).orElseThrow());
    }

    /**
     * 取得件数テスト
     */
    @Test
    @Transactional
    void findByPrefecturesCode_取得件数() {
        int count = JdbcTestUtils.countRowsInTableWhere(jdbcTemplate, "covid19", "prefectures_code = '99'");
        Assertions.assertEquals(2, count);
    }
}