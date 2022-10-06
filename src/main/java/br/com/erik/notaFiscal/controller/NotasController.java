package br.com.erik.notaFiscal.controller;


import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.erik.notaFiscal.controller.dto.NotaDto;
import br.com.erik.notaFiscal.controller.form.NotaForm;
import br.com.erik.notaFiscal.modelo.Nota;
import br.com.erik.notaFiscal.repository.ClienteRepository;
import br.com.erik.notaFiscal.repository.NotaRepository;

@RestController
@RequestMapping("/Notas")
public class NotasController {
	
	@Autowired
	private NotaRepository notaRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping
	public List<NotaDto> lista(){
		List<Nota> notas = notaRepository.findAll();
		return NotaDto.converter(notas);
	}
	
	@PostMapping
	public ResponseEntity<NotaDto> cadastrar(@RequestBody NotaForm form, UriComponentsBuilder uriBuilder){
		Nota nota = form.converter(clienteRepository);
		notaRepository.save(nota);
		URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(nota.getId()).toUri();
		return ResponseEntity.created(uri).body(new NotaDto(nota));
	}
}
