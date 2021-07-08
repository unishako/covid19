package com.example.covid19.util;

import java.text.NumberFormat;

public class FormatUtil {
    /**
     * カンマ編集
     *
     * @param number {@link N} 数値
     * @param <N>    数値型
     * @return カンマ編集済数値
     */
    public static <N extends Number> String toComma(N number) {
        NumberFormat nf = NumberFormat.getNumberInstance();
        return nf.format(number);
    }
}
