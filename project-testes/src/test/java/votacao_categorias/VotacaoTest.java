package votacao_categorias;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import votacao.Votacao;

public class VotacaoTest {

	@Test
	public void verificarIdadeIgual15Anos_NaoPodeVotar() {
		assertEquals("Jose voce nao pode votar", Votacao.podeVotar("Jose", 2007));;
	}
	
	@Test
	public void verificar16Anos_votoFacultativo() {
		assertEquals("Gabriel seu voto e facultativo", Votacao.podeVotar("Gabriel", 2006));
	}
	

	@Test
	@Ignore
	public void verificaIdadeIgual17Anos_votoFacultativo() {
		assertEquals("Matheus seu voto e facultativo",Votacao.podeVotar("Matheus", 2005));
	}
	
	@Test
	public void verificaIdadeIgual18Anos() {
		assertEquals("Carla seu voto e obrigatorio", Votacao.podeVotar("Carla", 2004));
	}
	
	@Test
	public void verificaIdadeIgual30Anos() {
		assertEquals("Paulo seu voto e obrigatorio", Votacao.podeVotar("Paulo", 1992));
	}
	
	@Test
	public void verificaIdadeIgual70Anos() {
		assertEquals("Roger seu voto e obrigatorio", Votacao.podeVotar("Roger", 1952));
	}
	
	@Test
	public void verificaIdadeIgual71Anos_votoFacultativo() {
		assertEquals("Kayk seu voto e facultativo", Votacao.podeVotar("Kayk", 1951));
	}

}
