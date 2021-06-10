package com.example.covid19.util;

import java.text.NumberFormat;

/**
 * フォーマットユーティリティ
 */
public class FormatUtil {

    /**
     * カンマ編集
     *
     * @param number {@link T} 数値
     * @param <T>    数値型
     * @return カンマ編集済数値
     */
    public static <T> String toComma(T number) {
        NumberFormat nf = NumberFormat.getNumberInstance();
        return nf.format(number);
    }
}
