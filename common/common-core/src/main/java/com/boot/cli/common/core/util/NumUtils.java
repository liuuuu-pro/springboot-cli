package com.boot.cli.common.core.util;

import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.StrUtil;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;
import java.util.Optional;

public class NumUtils {

    public static int getInt(String num) {
        if (StrUtil.isEmpty(num) || !NumberUtil.isNumber(num)) {
            return 0;
        }
        return Integer.parseInt(num);
    }

    public static int getInt(Integer num) {
        return Objects.nonNull(num) ? num : 0;
    }

    public static int getInt(Optional<Integer> num) {
        return num.isPresent() ? num.orElse(0) : 0;
    }

    public static long getLong(Long num) {
        return Objects.nonNull(num) ? num : 0;
    }

    public static long getLong(Optional<Long> num) {
        return num.orElse(0L);
    }

    public static long getLong2(Optional<Integer> num) {
        return num.orElse(0);
    }

    public static BigDecimal getBig(Integer num) {
        return Objects.isNull(num) ? BigDecimal.ZERO : new BigDecimal(num);
    }

    public static BigDecimal getBig(BigDecimal num) {
        return Objects.isNull(num) ? BigDecimal.ZERO : num;
    }

    public static String getBigDecimal(BigDecimal big) {
        if (Objects.isNull(big)) {
            return null;
        }
        return big.stripTrailingZeros().toPlainString();
    }

    public static BigDecimal m2k(BigDecimal million) {
        million = getBig(million);
        return million.divide(new BigDecimal("1000"), 6, RoundingMode.DOWN);
    }

    public static String getStr(Optional<String> str) {
        return str.orElse(null);
    }

}
