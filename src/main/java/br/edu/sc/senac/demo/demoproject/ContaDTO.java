package br.edu.sc.senac.demo.demoproject;

public class ContaDTO {

	private String titular;
	private double saldo;
	private String numeroConta;

	public ContaDTO(String numeroConta) {
		this.numeroConta = numeroConta;
	}

	public String getNumeroConta() {
		return numeroConta;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public double getSaldo() {
		return saldo;
	}

}
