package br.com.erik.notaFiscal.controller.form;

import br.com.erik.notaFiscal.modelo.Cliente;
import br.com.erik.notaFiscal.modelo.Nota;
import br.com.erik.notaFiscal.repository.ClienteRepository;

public class NotaForm {
		
	private String numero;
	private Cliente nome;
	
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public Cliente getNome() {
		return nome;
	}
	public void setNome(Cliente nome) {
		this.nome = nome;
	}
	public Nota converter(ClienteRepository clienteRepository) {
		Cliente cliente = clienteRepository.findByNome(nome);
		return new Nota(numero, cliente);
	}
	
}
