package exercise07;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

import categorias.Positivos;

/*Essa suite de testes funciona para 
 * executar baterias de testes com filtros de categorias.*/

//Indicando que a suite vai executar focando em categorias de testes
@RunWith(Categories.class)
//Incluindo categorias
@IncludeCategory(Positivos.class)
@SuiteClasses({
	TesteCategorizado.class
	
})
public class SuiteDeCategorias {

}
