package com.logical.experience.controller;

public class DadosPessoais {
	
	public DadosPessoais(String nome, Integer idade, Endereco endereco) {
		super();
		this.nome = nome;
		this.idade = idade;
		this.endereco = endereco;
	}
	
	private String nome;
	private Integer idade;
	private Endereco endereco;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getIdade() {
		return idade;
	}
	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	
	

}
