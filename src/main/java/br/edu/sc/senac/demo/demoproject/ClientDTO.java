package br.edu.sc.senac.demo.demoproject;

public class ClientDTO {
	public static final ClientDTO NULL_VALUE = new ClientDTO("", "", "");

	private final String name;
	private final String cargo;
	private final String data;
	
	public ClientDTO(final String name, final String cargo, final String data) {
		this.name = name;
		this.cargo = cargo;
		this.data = data;
	}

	public String getName() {
		return this.name;
	}

	public String getCargo() {
		return this.cargo;
	}

	public String getData() {
		return this.data;
	}

}

