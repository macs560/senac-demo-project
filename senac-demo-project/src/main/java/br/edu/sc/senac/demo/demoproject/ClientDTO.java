package br.edu.sc.senac.demo.demoproject;

public final class ClientDTO {

	public static final ProductDTO NULL_VALUE = new ProductDTO(Long.valueOf(0), "", "", Double.valueOf(0.0));

	private final String email;
	private final String name;
	private final String date;
	
	public ClientDTO(final String email, final String name, final String date) {
		this.email = email;
		this.name = name;
		this.date = date;
	}

	public String getEmail() {
		return this.email;
	}

	public String getName() {
		return this.name;
	}

	public String getDate() {
		return this.date;
	}

}