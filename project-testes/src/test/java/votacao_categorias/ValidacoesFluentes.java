package votacao_categorias;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.core.Is;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;

public class ValidacoesFluentes {
	
	//Testando as validacoes mais usadas
	
	@Test
	public void validacaoEqualsTo() {
		String jogador = "Cristiano Ronaldo";
		String jogador2 = "Lionel Messi";
		
		assertThat(jogador, equalTo("Cristiano Ronaldo"));
		assertThat(jogador2, equalTo("Lionel Messi"));
	}
	
	@Test
	public void validacaoIs() {
		int codigo = 150;
		int codigo2 = 100;
		
		assertThat(codigo, is(150));
		assertThat(codigo2, is(100));
	}
	
	@Test
	public void validacaoAnyOf() {
		String resultadoObtido = "O tamanho selecionado foi G";
		assertThat(resultadoObtido, anyOf(containsString("G"), containsString("M")));
	}
	
	@Test
	public void validacaoHasItems() {
		List<String> listaProdutos = new ArrayList<String>();
		listaProdutos.add("Camiseta Estampada");
		listaProdutos.add("Bermuda");
		listaProdutos.add("Regata Lakers");
		
		assertThat(listaProdutos, hasItem("Bermuda"));
		assertThat(listaProdutos, hasItem("Regata Lakers"));
	}

}
