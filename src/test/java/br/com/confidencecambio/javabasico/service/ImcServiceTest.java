package br.com.confidencecambio.javabasico.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class ImcServiceTest {
    private ImcService service;

    @Before
    public void init() {
        service = new ImcService();
    }


    @Test
    public void deveriaCalcularImc() throws Exception {
        BigDecimal imc = service.getImc("45", "1,70");
        assertEquals("15.58", String.valueOf(imc));
        imc = service.getImc("45,0", "1.70");
        assertEquals("15.58", String.valueOf(imc));
        imc = service.getImc("45.0", "1.70");
        assertEquals("15.58", String.valueOf(imc));
    }

    @Test
    public void naoDeveriaCalcularImc() {
        try {
            BigDecimal imc = service.getImc("45a", "1,70s");
            Assert.fail("Deveria retornar uma Exception");
        } catch (Exception e) {
        }
    }
}