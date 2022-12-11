package com.example.covid19.util;

import java.text.NumberFormat;

public class FormatUtil {
    /**
     * カンマ編集
     *
     * @param number {@link Number} 数値
     * @return カンマ編集済数値
     */
    public static String toComma(Number number) {
        NumberFormat nf = NumberFormat.getNumberInstance();
        return nf.format(number);
    }
}
