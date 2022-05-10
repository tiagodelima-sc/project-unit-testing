package exercise02;

import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import votacao.Votacao;

@RunWith(Parameterized.class)
public class ValidarIdadePorVotacao_DDT {
	
	public String nome;
	public int anoDeNascimento;
	public String resultado;
	
	
	public ValidarIdadePorVotacao_DDT(String nome, int anoDeNascimento, String resultado) {
		this.nome = nome;
		this.anoDeNascimento = anoDeNascimento;
		this.resultado = resultado;
	}

	@Test
	public void validarObrigatoriedaDeDeVoto() {
		assertEquals(resultado, Votacao.podeVotar(nome, anoDeNascimento));
	}
	
	@Parameters(name = "{0} | {1} | {2}")
	public static Collection<Object[]> data(){
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
