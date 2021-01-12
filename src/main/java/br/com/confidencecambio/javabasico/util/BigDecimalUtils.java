package br.com.confidencecambio.javabasico.util;

import java.math.BigDecimal;

public class BigDecimalUtils {
    public static BigDecimal toBigDecimal(String string) {
        return new BigDecimal(string.replace(",", "."));
    }
}
