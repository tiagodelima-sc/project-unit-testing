package calculadora;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

public class CalculadorTest {
	
	static Calculadora calculadora;
	static int valor1, valor2;
	
	@Before
	public void preCondicao() {
		//Montando cenario de teste
		valor1 = 10;
		valor2 = 5;
	}
	
	@Test
	public void testSomarDoisValores() {
		
		Calculadora calculadora = new Calculadora();
		
		//Executando o teste
		int resultadoObtido = calculadora.soma(valor1, valor2);
		
		//Verificando resultado
		assertNotNull(resultadoObtido);
		assertEquals(resultadoObtido, 15);
		
	}
	
	@Test
	public void testSubtrairDoisValores() {
		
		 Calculadora calculadora = new Calculadora();

		 int resultadoObtido = calculadora.subtrair(valor1, valor2);
		 
		 assertEquals(resultadoObtido, 5);
	}
	
	@Test
	public void testMultiplicarDoisValores() {

		Calculadora calculadora = new Calculadora();
		
		int resultadoObtido = calculadora.multiplicacao(valor1, valor2);
		
		assertEquals(resultadoObtido, 50);
		
	}
	
	@Test
	public void testDividirDoisValores() {

		Calculadora calculadora = new Calculadora();
		
		int resultadoObtido = calculadora.divisao(valor1, valor2);
		
		assertEquals(resultadoObtido, 2);
	}
	
	@Test(expected = ArithmeticException.class) 
	public void testDivisaoPorZero_LancarExcessao() {
		
		Calculadora calculadora = new Calculadora();
		
		int resultadoObtido = calculadora.divisao(valor1, 0);
		
		assertEquals(resultadoObtido, 0);
		
	}

}
