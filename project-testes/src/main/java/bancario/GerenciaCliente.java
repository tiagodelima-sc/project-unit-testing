package bancario;

import java.util.List;

public class GerenciaCliente {
	
	private List<Cliente> clientesDoBanco;

	public GerenciaCliente(List<Cliente> clientesDoBanco) {
		this.clientesDoBanco = clientesDoBanco;
	}
	
	public List<Cliente> getClientesDoBanco() {
		return clientesDoBanco;
	}
	
	//Pesquisa por um cliente a partir do seu ID.
	
	public Cliente pesquisaCliente (int idCliente) {

		for (Cliente cliente : clientesDoBanco) {
			if(cliente.getId() == idCliente)
				return cliente;
		}
		return null;
	}
	
	
	// Adiciona um novo cliente à lista de clientes do banco.
	 
	public void adicionaCliente (Cliente novoCliente) {
		clientesDoBanco.add(novoCliente);
	}

	
	 //Remove cliente da lista de clientes do banco.
	 
	public boolean removeCliente (int idCliente) {
		boolean clienteRemovido = false;
		
		for (int i = 0; i < clientesDoBanco.size(); i++) {
			Cliente cliente = clientesDoBanco.get(i);
			if(cliente.getId() == idCliente){
				clientesDoBanco.remove(i);
				clienteRemovido = true;
				break;
			}
		}
		
		return clienteRemovido;
	}


	 // Informa se um determinado cliente está ativo ou não.

	public boolean clienteAtivo (int idCliente) {
		boolean clienteAtivo = false;
		
		for (int i = 0; i < clientesDoBanco.size(); i++) {
			Cliente cliente = clientesDoBanco.get(i);
			if(cliente.getId() == idCliente)
				if(cliente.isAtivo()){
					clienteAtivo = true;
					break;
				}
		}
		
		return clienteAtivo;
	}

	
	 // Limpa a lista de clientes, ou seja, remove todos eles. 
	
	public void limpa() {
		this.clientesDoBanco.clear();
	}
	
	
	 // Valida se a idade do cliente está dentro do intervalo permitido (18 - 65).

	public boolean validaIdade(int idade) throws IdadeNaoPermitidaException {
	
		if(idade < 18 || idade > 65)
			throw new IdadeNaoPermitidaException(IdadeNaoPermitidaException.MSG_IDADE_INVALIDA);
		
		return true;
	}

}
