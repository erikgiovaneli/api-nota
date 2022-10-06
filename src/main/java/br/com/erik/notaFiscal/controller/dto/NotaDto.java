package br.com.erik.notaFiscal.controller.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import br.com.erik.notaFiscal.modelo.Cliente;
import br.com.erik.notaFiscal.modelo.Nota;

public class NotaDto {
		
		private Long id;
		private Cliente nome;
		private String numero;
		private LocalDateTime dataCriacao;
		
		public NotaDto (Nota nota) {
			this.id = nota.getId();
			this.nome = nota.getNome();
			this.numero = nota.getNumero();
			this.dataCriacao = nota.getDataCriacao();
			
		}
		
		public Long getId() {
			return id;
		}
		public Cliente getNome() {
			return nome;
		}
		public String getNumero() {
			return numero;
		}
		public LocalDateTime getDataCriacao() {
			return dataCriacao;
		}

		public static List<NotaDto> converter(List<Nota> notas) {
			return notas.stream().map(NotaDto::new).collect(Collectors.toList());
		}
		
		
}
