package bancario;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class GerenciaClienteTest {
	
	static Cliente cliente01, cliente02;
	static List<Cliente> listaClientesDoBanco;
	static GerenciaCliente gerenciamentoClientes;
	
	//Pre Condicao
	@BeforeClass
	public static void preCondicaoFeral() {
		
		//Clientes Criado
		cliente01 = new Cliente(1, 20, 1, "Tiago de lima", "tiago.l07@aluno.ifsc.edu", false);
		cliente02 = new Cliente(2, 21, 2, "Mateus Rodrigues", "mateus@gmail.com", true);
		
		//Lista de Clientes Criado
		listaClientesDoBanco = new ArrayList<Cliente>();
		
		//Populando lista de clientes do banco
		listaClientesDoBanco.add(cliente01);
		listaClientesDoBanco.add(cliente02);
		
		gerenciamentoClientes = new GerenciaCliente(listaClientesDoBanco);
	}
	

	@Test
	public void testPesquisaCliente() {
				
		Cliente cliente = gerenciamentoClientes.pesquisaCliente(1);
		
		assertEquals(cliente.getId(), 1);
		assertEquals(cliente.getIdade(), 20);
		assertEquals(cliente.getNome(), "Tiago de lima");
	}
	
	@Test
	public void testRemoveCliente() {
		
		boolean clienteRemovido = gerenciamentoClientes.removeCliente(2);
		
		assertEquals(clienteRemovido, true);
		assertEquals(gerenciamentoClientes.getClientesDoBanco().size(), 1);
		assertNull(gerenciamentoClientes.pesquisaCliente(2));
		
	}
	
	

}
