package model;

// Classe que representa um usuário no sistema
public class Usuario {
	
    // Atributos que correspondem às colunas da tabela usuario no banco
	private int id;
	private String nome;
    private String login;
    private String senha;

    // Construtor usado na criação de objetos Usuario
    public Usuario(String nome, String login, String senha) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }

    // Getters e Setters para acessar e modificar os atributos
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
