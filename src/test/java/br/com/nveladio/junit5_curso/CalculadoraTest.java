package br.com.nveladio.junit5_curso;

import java.util.ArrayList;
import java.util.List;

import br.com.nveladio.junit5_curso.domain.exceptions.ValidationException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static br.com.nveladio.junit5_curso.domain.builders.UsuarioBuilder.umUsuario;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CalculadoraTest {
    private Calculadora calc = new Calculadora();
    private static int contador = 0;

    @BeforeEach
    public void setup() {
        System.out.println("^^^^^^^^^^");
    }

    @AfterEach
    public void teardown() {
        System.out.println("vvvvvvvv");
    }

    @BeforeAll
    public static void setupAll() {
        System.out.println("---------Before All--------");
    }

    @AfterAll
    public static void teardownAll() {
        System.out.println("----- After All -----");
    }

    @Test
    public void testSomar() {
        System.out.println(++contador);
        calc = new Calculadora();
        assertEquals(calc.soma(2, 1), 3);
    }

    @Test
    public void testSomar_retornando_sucesso() {
        System.out.println(++contador);
        Calculadora calc = new Calculadora();
        Assertions.assertTrue(calc.soma(2, 1) == 3);
    }

    @Test
    public void assertivas() {
        System.out.println(++contador);
        assertEquals("Casa", "Casa");
        Assertions.assertNotEquals("Casa", "casa");
        Assertions.assertTrue("casa".equalsIgnoreCase("CASA"));
        Assertions.assertTrue("casa".endsWith("sa"));
        Assertions.assertTrue("casa".startsWith("ca"));

        List<String> s1 = new ArrayList<>();
        // s1.add("a");
        List<String> s2 = new ArrayList<>();
        List<String> s3 = null;

        assertEquals(s1, s2);
        Assertions.assertSame(s1, s1);
        Assertions.assertNotEquals(s1, s3);
        Assertions.assertNull(s3);
        assertNotNull(s1);
        // Assertions.fail("Falhou pelo motivo A");
    }

    @Test
    public void DeveRetornarNumeroInteiroNaDivisao() {
        calc = new Calculadora();
        float resultado = calc.dividir(6, 2);
        assertEquals(3, resultado);
    }

    @Test
    public void DeveRetornarNumerosNegativosNaDivisao() {
        calc = new Calculadora();
        float resultado = calc.dividir(6, -2);
        assertEquals(-3, resultado);
    }

    @Test
    public void DeveRetornarNumerosDecimaisNaDivisao() {
        calc = new Calculadora();
        float resultado = calc.dividir(10, 3);
        assertEquals(3.33, resultado, 0.01);
    }

    @Test
    public void DeveRetornarZeroComNumeradordoZeroNaDivisao() {
        calc = new Calculadora();
        float resultado = calc.dividir(0, 2);
        assertEquals(0, resultado);
    }

    @Test
    public void DeveLancarUmaExcecaoQuandoDividirPorZero_Junit4() {
        System.out.println("Comecou");
        try {
            float resultado = 10 / 0;
            Assertions.fail("Deveria ter sido lancado uma divisão");
        } catch (ArithmeticException e) {
            assertEquals("/ by zero", e.getMessage());
        }
        System.out.println("terminou");
    }

    @Test
    public void DeveLancarUmaExcecaoQuandoDividirPorZero_Junit5() {
        ArithmeticException exception = Assertions.assertThrows(ArithmeticException.class, () -> {
            float resultado = 10 / 0;
        });
        assertEquals("/ by zero", exception.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"Teste1", "Teste2", "Teste3"})
    public void testStrings(String param) {
        System.out.println(param);
        assertNotNull(param);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "6, 2, 3",
            "6, -2, -3",
            "10, 3, 3.3333332538604736",
            "0, 2, 0"
    })
    public void deveDividirCorretamente(int num, int den, double res) {
        float resultado = calc.dividir(num, den);
        assertEquals(res, resultado);
    }

}