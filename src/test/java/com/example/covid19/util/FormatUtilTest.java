package com.example.covid19.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FormatUtilTest {

    @Test
    void toComma() {
        Assertions.assertEquals("1,111", FormatUtil.toComma(1111));
        Assertions.assertEquals("1,111,111", FormatUtil.toComma(1111111));
    }
}