package com.example.covid19.util;

import java.text.NumberFormat;

public class FormatUtil {

    public static String toComma(Integer number) {
        NumberFormat nf = NumberFormat.getNumberInstance();
        return nf.format(number);
    }
}
