package bancario;

import java.util.List;

public class GerenciaConta {
	
	private List<ContaCorrente> contasDoBanco;

	public GerenciaConta(List<ContaCorrente> contasDoBanco) {
		this.contasDoBanco = contasDoBanco;
	}

	
	//Retorna uma lista com todas as contas do banco.
	
	public List<ContaCorrente> getContasDoBanco() {
		return contasDoBanco;
	}

	// Pesquisa por uma conta a partir do seu ID.
	 
	public ContaCorrente pesquisaConta (int idConta) {

		for (ContaCorrente contaCorrente : contasDoBanco) {
			if(contaCorrente.getId() == idConta)
				return contaCorrente;
		}
		return null;
	}
	
	
	 // Adiciona uma nova conta � lista de contas do banco.

	public void adicionaConta (ContaCorrente novaConta) {
		this.contasDoBanco.add(novaConta);
	}

	
	 // Remove conta da lista de contas do banco.

	public boolean removeConta (int idConta) {
		
		boolean contaRemovida = false;
		
		for (int i = 0; i < contasDoBanco.size(); i++) {
			ContaCorrente conta = contasDoBanco.get(i);
			if(conta.getId() == idConta){
				contasDoBanco.remove(i);
				break;
			}
		}
		
		return contaRemovida;
	}

	
	 // Informa se uma determinada conta est� ativa ou n�o.

	public boolean contaAtiva (int idConta) {
		
		boolean contaAtiva = false;
		
		for (int i = 0; i < contasDoBanco.size(); i++) {
			ContaCorrente conta = contasDoBanco.get(i);
			if(conta.getId() == idConta)
				if(conta.isAtiva()){
					contaAtiva = true;
					break;
				}
		}
		
		return contaAtiva;
	}
	
	/**
	 * Transfere um determinado valor de uma conta Origem para uma conta Destino.
	 * Caso n�o haja saldo suficiente, o valor n�o ser� transferido.
	 */
	
	public boolean transfereValor (int idContaOrigem, double valor, int idContaDestino) {
		
		boolean sucesso = false;
		
		ContaCorrente contaOrigem = pesquisaConta(idContaOrigem);
		ContaCorrente contaDestino = pesquisaConta(idContaDestino);
		
		if(contaOrigem.getSaldo() >= valor){
			contaDestino.setSaldo(contaDestino.getSaldo() + valor);
			contaOrigem.setSaldo(contaOrigem.getSaldo() - valor);
			sucesso = true;
	}
	
		return sucesso;
	}

}
