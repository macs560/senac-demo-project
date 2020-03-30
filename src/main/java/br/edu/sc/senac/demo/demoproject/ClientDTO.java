package br.edu.sc.senac.demo.demoproject;

public class ClientDTO {

	private String nome;
	private String dataNascimento;
	private int id;

	
	
	public ClientDTO(String nome, String dataNascimento, int id) {
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public int getId() {
		return id;
	}

}
