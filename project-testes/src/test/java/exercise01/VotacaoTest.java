package exercise01;

import static org.junit.Assert.*;

import org.junit.Test;

import votacao.Votacao;

public class VotacaoTest {

	@Test
	public void verificarIdadeIgual15Anos_NaoPodeVotar() {
		assertEquals("José você não pode votar", Votacao.podeVotar("José", 2003));;
	}
	
	@Test
	public void verificar16Anos_votoFacultativo() {
		assertEquals("Gabriel seu voto é facultativo", Votacao.podeVotar("Gabriel", 2002));
	}
	
	@Test
	public void verificaIdadeIgual17Anos_votoFacultativo() {
		assertEquals("Matheus seu voto é facultativo",Votacao.podeVotar("Matehus", 2001));
	}
	
	@Test
	public void verificaIdadeIgual18Anos() {
		assertEquals("Carla seu voto é obrigatorio", Votacao.podeVotar("Carla", 2000));
	}
	
	@Test
	public void verificaIdadeIgual30Anos() {
		assertEquals("Paulo seu voto é obrigatorio", Votacao.podeVotar("Paulo", 1993));
	}
	
	@Test
	public void verificaIdadeIgual70Anos() {
		assertEquals("Roger seu voto é obrigatorio", Votacao.podeVotar("Roger", 1948));
	}
	
	@Test
	public void verificaIdadeIgual71Anos_votoFacultativo() {
		assertEquals("Kayk seu voto é facultativo", Votacao.podeVotar("Kayk", 1947));
	}

}
