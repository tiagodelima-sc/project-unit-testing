package votacao_categorias;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import votacao_categorias.VotacaoTest;

@RunWith(Suite.class)
@SuiteClasses({
	VotacaoTest.class,
	ValidarIdadePorVotacao_DDT.class,
	ValidarIdadePorVotacao_Parametros.class,
	ValidarIdadePorVotacao_CSV.class
})
public class SuiteDeTeste {

}
