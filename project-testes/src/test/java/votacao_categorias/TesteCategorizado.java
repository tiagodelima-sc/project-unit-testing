package votacao_categorias;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import categorias.Positivos;
import categorias.Smoke;

public class TesteCategorizado {
	
	@Test
	@Category(Smoke.class)
	public void testeOne() {
		
	}
	
	@Test
	@Category(Positivos.class)
	public void testeTwo() {
		
	}
	
	@Test
	public void testeThree() {
		
	}

}
