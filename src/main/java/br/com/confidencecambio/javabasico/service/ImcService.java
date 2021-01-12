package br.com.confidencecambio.javabasico.service;

import br.com.confidencecambio.javabasico.util.BigDecimalUtils;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class ImcService {
    public BigDecimal getImc(String peso, String altura) throws Exception {
        try {
            var pesoBigDecimal = BigDecimalUtils.toBigDecimal(peso);
            var alturaBigDecimal = BigDecimalUtils.toBigDecimal(altura);
            return pesoBigDecimal.divide(alturaBigDecimal.pow(2), 2, RoundingMode.CEILING);
        } catch (NumberFormatException e) {
            throw new Exception("Utilize somente valores numericos para peso/altura");
        }
    }
}
