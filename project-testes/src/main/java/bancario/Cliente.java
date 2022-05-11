package bancario;

public class Cliente {
	
	private int id, idade, idContaCorrente;
	private String nome;
	private boolean ativo;
	
	public Cliente(int id, int idade, int idContaCorrente, String nome, boolean ativo) {
		this.id = id;
		this.idade = idade;
		this.idContaCorrente = idContaCorrente;
		this.nome = nome;
		this.ativo = ativo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public int getIdContaCorrente() {
		return idContaCorrente;
	}

	public void setIdContaCorrente(int idContaCorrente) {
		this.idContaCorrente = idContaCorrente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	

}
