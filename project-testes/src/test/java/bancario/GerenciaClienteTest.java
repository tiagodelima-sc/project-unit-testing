package bancario;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GerenciaClienteTest {
	
	static int idCliente01, idCliente02;
	static Cliente cliente01, cliente02;
	static ContaCorrente conta1, conta2;
	static List<Cliente> listaClientesDoBanco;
	static List<ContaCorrente> listaContaDoBanco;
	static GerenciaCliente gerenciamentoClientes;
	static GerenciaConta gerenciamentoContas;
	
	//Pre Condicao
	@Before
	public void preCondicaoGeral() {
		
		//Clientes, Contas Correntes e IDS inicializados.
		idCliente01 = 1;
		idCliente02 = 2;
		cliente01 = new Cliente(idCliente01, 20, 1, "Tiago de lima", "tiago.l07@aluno.ifsc.edu", false);
		cliente02 = new Cliente(idCliente02, 21, 2, "Mateus Rodrigues", "mateus@gmail.com", true);
		conta1 = new ContaCorrente(idCliente01, 250, true);
		conta2 = new ContaCorrente(idCliente02, 0, true);
		
		//Lista de Clientes e Contas Correntes inicializadas.
		listaClientesDoBanco = new ArrayList<Cliente>();
		listaContaDoBanco = new ArrayList<ContaCorrente>();
		
		//Populando lista de clientes e contas
		listaClientesDoBanco.add(cliente01);
		listaClientesDoBanco.add(cliente02);
		listaContaDoBanco.add(conta1);
		listaContaDoBanco.add(conta2);
		
		//Gerenciamento de Clientes e Contas
		gerenciamentoClientes = new GerenciaCliente(listaClientesDoBanco);
		gerenciamentoContas = new GerenciaConta(listaContaDoBanco);
		
	}
	
	//Pos Condicao
	@After
	public void limpaListaClientes() {
		gerenciamentoClientes.limpa();
	}
	
	/*
	 * Teste para verificar se a pesquisa est� 
	 * retornando o cliente pela ID.
	 * */
	
	@Test
	public void testPesquisaCliente() {
				
		Cliente cliente = gerenciamentoClientes.pesquisaCliente(idCliente01);
		
		assertEquals(cliente.getId(), idCliente01);
		assertEquals(cliente.getIdade(), 20);
		assertEquals(cliente.getNome(), "Tiago de lima");
	}
	
	/*
	 * Teste para verificar se a pesquisa 
	 * retornando um cliente nulo, que não existe.
	 * */
	
	@Test
	public void testPesquisaCliente_Inexistente() {
		
		Cliente cliente = gerenciamentoClientes.pesquisaCliente(4);
		
		assertNull(cliente);
		
	}
	
	/*
	 * Teste para verificar se o cliente est� sendo 
	 * removido da lista do banco.
	 * */
	
	@Test
	public void testRemoveCliente() {
		
		boolean clienteRemovido = gerenciamentoClientes.removeCliente(idCliente02);
		
		assertEquals(clienteRemovido, true);
		assertEquals(gerenciamentoClientes.getClientesDoBanco().size(), 1);
		assertNull(gerenciamentoClientes.pesquisaCliente(idCliente02));
		
	}
	
	/*
	 * Teste para remover cliente que nao 
	 * existe na da lista do banco.
	 * */
	
	@Test
	public void testRemoveCliente_Inexistente() {
		
		boolean clienteRemovido = gerenciamentoClientes.removeCliente(4);
		
		assertEquals(clienteRemovido, false);
		assertEquals(gerenciamentoClientes.getClientesDoBanco().size(), 2);
		
	}
	
	/*
	 * Teste para verificar se a transferencia est� 
	 * saindo da origem e chegando no destino, 
	 * descontando o valor e acrescentando em outro .
	 * */
	
	@Test
	public void testTransfereValor() {
		
		gerenciamentoContas.transfereValor(idCliente01, 120, idCliente02);
		assertEquals(conta2.getSaldo(), 120, 0);
		assertEquals(conta1.getSaldo(), 130, 0);
		
	}
	
	/* Teste para verificar o retorno que acontece
	 * quando o usuario vai fazer uma transferencia
	 * sem o saldo na conta
	 * */
	
	@Test
	public void testTransfereValor_QuandoNaoTemSaldo() {
		
		boolean sucesso = gerenciamentoContas.transfereValor(idCliente01, 350, idCliente02);
		
		assertFalse(sucesso);
		assertEquals(conta1.getSaldo(), 250, 0);
		assertEquals(conta2.getSaldo(), 0, 0);
	}
	
	/* Teste para verificar se o cliente tem idade
	 * aceitavel para ter uma conta no banco
	 * */
	
	@Test
	public void testClienteTemIdadeAceitavel() throws IdadeNaoPermitidaException {
		
		boolean idadeValida = gerenciamentoClientes.validaIdade(cliente01.getIdade());
		boolean idadeValida2 = gerenciamentoClientes.validaIdade(cliente02.getIdade());
		
		assertTrue(idadeValida);
		assertTrue(idadeValida2);

	}
	
	/* Teste para verificar quando o cliente 
	 * tem idade menor que o limite para ter uma conta no banco
	 * */
	
	@Test
	public void testClienteNaoTemIdadeAceitavel_MenorIdadeLimite() throws IdadeNaoPermitidaException {
		Cliente clienteMenorLimite = new Cliente(idCliente01, 17, 1, "Tiago de lima", "tiago.l07@aluno.ifsc.edu", false);
		
		try {
			gerenciamentoClientes.validaIdade(clienteMenorLimite.getIdade());
			fail();
		} catch (Exception e) {
			assertEquals(e.getMessage(), IdadeNaoPermitidaException.MSG_IDADE_INVALIDA);
		}

	}
	
	/* Teste para verificar quando o cliente 
	 * tem idade maior que o limite para ter uma conta no banco
	 * */
	
	@Test
	public void testClienteNaoTemIdadeAceitavel_MaiorIdadeLimite() throws IdadeNaoPermitidaException {
		Cliente clienteMaiorLimite = new Cliente(idCliente02, 66, 2, "Mateus Rodrigues", "mateus@gmail.com", true);
		
		try {
			gerenciamentoClientes.validaIdade(clienteMaiorLimite.getIdade());
			fail();
		} catch (Exception e) {
			assertEquals(e.getMessage(), IdadeNaoPermitidaException.MSG_IDADE_INVALIDA);
		}

	}
	
	
	

}
