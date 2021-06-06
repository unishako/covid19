package com.example.covid19.model.dao;

import com.example.covid19.model.dto.Prefectures;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.jdbc.JdbcTestUtils;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
class PrefecturesDaoTest {

    @Autowired
    PrefecturesDao prefecturesDao;

    @Autowired
    JdbcTemplate jdbcTemplate;

    /**
     * 取得内容テスト
     */
    @Test
    @Transactional
    void findAll_取得内容() {
        List<Prefectures> list = prefecturesDao.findAll();
        Assertions.assertEquals("北海道", list.stream().findFirst().map(Prefectures::getPrefecturesName).orElseThrow());
    }

    /**
     * 取得件数テスト
     */
    @Test
    void findAll_取得件数() {
        Assertions.assertEquals(
                JdbcTestUtils.countRowsInTable(jdbcTemplate, "prefectures"),
                prefecturesDao.findAll().size());
    }
}