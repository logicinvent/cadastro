package com.logical.experience.controller;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cadastro")
public class CadastroController {

	public static List<DadosPessoais> dados() {

		Endereco enderecoMae = new Endereco("Rua Sao Florencio", 1464, "São Paulo", "SP", "Brasil");
		Endereco enderecoPai = new Endereco("Rua Alexandre Calame", 80, "São Paulo", "SP", "Brasil");
		Endereco enderecoVo = new Endereco("Rua Professor Geraldo Passareli", 46, "São Paulo", "SP", "Brasil");

		List<DadosPessoais> listaDeDados = Arrays.asList(
				new DadosPessoais("Lucca", 19, enderecoVo),
				new DadosPessoais("Nicolle", 13, enderecoMae), 
				new DadosPessoais("Millena", 23, enderecoPai),
				new DadosPessoais("Jean", 43, enderecoPai));

		return listaDeDados;

	}

	@GetMapping("/lista")
	public ResponseEntity<List<DadosPessoais>> obter() {

		return ResponseEntity.status(HttpStatus.OK).body(dados());
	}

	@GetMapping("/buscar/{nome}")
	public ResponseEntity<DadosPessoais> obterPorNome(@PathVariable(value = "nome") String nome) {

		Optional<DadosPessoais> dado = dados().stream().filter(e -> e.getNome().equalsIgnoreCase(nome)).findFirst();

		if (dado.isPresent())
			return ResponseEntity.status(HttpStatus.OK).body(dado.get());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

	}

	@GetMapping("/buscar/nome/{nome}/idade/{idade}")
	public ResponseEntity<DadosPessoais> obterPorNomeEIdade(@PathVariable(value = "nome") String nome,
			@PathVariable(value = "idade") Integer idade) {

		Optional<DadosPessoais> dado = dados().stream().filter(e -> e.getNome().equalsIgnoreCase(nome))
				.filter(e -> e.getIdade().equals(idade)).findFirst();

		if (dado.isPresent())
			return ResponseEntity.status(HttpStatus.OK).body(dado.get());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

	}

	@GetMapping("/ordenar")
	public ResponseEntity<List<DadosPessoais>> ordenar() {

		List<DadosPessoais> result = dados().stream().sorted(Comparator.comparing(DadosPessoais::getNome).reversed())
				.collect(Collectors.toList());
		
		return ResponseEntity.status(HttpStatus.OK).body(result);

	}

}
