package br.com.confidencecambio.javabasico.model;

import br.com.confidencecambio.javabasico.exception.ValitaionException;
import org.junit.Assert;
import org.junit.Test;

public class AbstractModelTest extends AbstractModel {

    @Test
    public void deveriaRetornarErro() {
        try {
            setName("");
            setName(" ");
            setName(null);
            Assert.fail("Nome nao poder ser nulo e nem estar vazio");
        } catch (ValitaionException e) {
        }
    }

    @Test
    public void naoDeveriaGravarComEspacosAdicionais() throws ValitaionException {
        setName("    Carlos da Silva  ");
        Assert.assertEquals("Carlos da Silva", getName());

    }

    @Test
    public void deveriaRetornarOPrimeiroNome() throws ValitaionException {
        setName("João Soares Silva");
        Assert.assertEquals("João", getFistName());
    }

    @Test
    public void deveriaRetornarONomeUpperCase() throws ValitaionException {
        setName("João Soares Silva");
        Assert.assertEquals("JOÃO SOARES SILVA", getNameUppercase());
    }

    @Test
    public void deveriaRetornarOUltimoNome() throws ValitaionException {
        setName("João Soares Silva");
        Assert.assertEquals("Soares Silva", getLastName());
        setName("João Silva");
        Assert.assertEquals("Silva", getLastName());
        setName("João");
        Assert.assertEquals("João", getLastName());

    }

    @Test
    public void deveriaRetornarONomeAbreviado() throws ValitaionException {
        setName("João Soares Silva");
        Assert.assertEquals("João S. Silva", getAbbreviatedName());
        setName("João Silva");
        Assert.assertEquals("João Silva", getAbbreviatedName());
        setName("Jose da Silva Ramos");
        Assert.assertEquals("Jose S. Ramos", getAbbreviatedName());
    }

}