package br.edu.sc.senac.demo.demoproject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/conta")
public class ContaService {
	private static Map<String, Conta> contas = new HashMap<String, Conta>();

	@PostMapping("/cadastrocliente")
	public Conta cadastrarConta(@PathVariable String titular, @PathVariable String numeroConta) {
		Conta conta = new Conta(titular, numeroConta, 1000);
		contas.put(numeroConta, conta);
		return conta;
		}

	@GetMapping("{id}/Saque")
	private static ResponseEntity<Conta> efetuarSaque(@RequestBody ContaDTO conta) {
		String buscaNumeroConta = conta.getNumeroConta();
		if (contas.containsKey(buscaNumeroConta)) {
			Conta contaAtual = contas.get(buscaNumeroConta);
			efetuarSaque(contaAtual);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	private static void efetuarSaque(Conta contaAtual) {
		double saque = Double.parseDouble(JOptionPane.showInputDialog(null, "Informe o valor do saque:"));
		boolean isConseguiuSacar = contaAtual.sacar(saque);
		if (isConseguiuSacar) {
			return;
		}
		String mensagemSaldo = "Saldo " + contaAtual.getSaldo() + " insuficiente! Não foi possível efetuar o saque.";
		JOptionPane.showMessageDialog(null, mensagemSaldo);
	}

}
