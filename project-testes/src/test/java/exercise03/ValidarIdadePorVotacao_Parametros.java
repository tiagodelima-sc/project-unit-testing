package exercise03;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import votacao.Votacao;

@RunWith(Parameterized.class)
public class ValidarIdadePorVotacao_Parametros {
	
	//Definindo os atributos com parametros e eliminando o construtor.
	//Atributos publicos para o Data Driven poder enxergar e fazer a injecao dos dados.
	
	@Parameter(0) public String nome;
	@Parameter(1) public int anoDeNascimento;
	@Parameter(2) public String resultado;	
	
	@Test
	public void validarObrigatoriedadeDeVoto() {
		assertEquals(resultado, Votacao.podeVotar(nome, anoDeNascimento));
	}
	
	@Parameters(name = "{0} | {1} | {2}")
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
			
			{"Jose", 2007, "Jose voce nao pode votar"},
			{"Gabriel", 2006, "Gabriel seu voto e facultativo"},
			{"Matheus", 2005, "Matheus seu voto e facultativo"},
			{"Carla", 2004, "Carla seu voto e obrigatorio"},
			{"Paulo", 1992, "Paulo seu voto e obrigatorio"},
			{"Roger", 1952, "Roger seu voto e obrigatorio"},
			{"Kayk", 1951, "Kayk seu voto e facultativo"}

		});
	}
	
	
	
	
}
