package exercise05;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import exercise01.VotacaoTest;
import exercise02.ValidarIdadePorVotacao_DDT;
import exercise03.ValidarIdadePorVotacao_Parametros;
import exercise04.ValidarIdadePorVotacao_CSV;

@RunWith(Suite.class)
@SuiteClasses({
	VotacaoTest.class,
	ValidarIdadePorVotacao_DDT.class,
	ValidarIdadePorVotacao_Parametros.class,
	ValidarIdadePorVotacao_CSV.class
})
public class SuiteDeTeste {

}
