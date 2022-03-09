package com.databasepi.databasepi.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cliente {
	

	@Id
	private long cpf;
	
	private String nome;
	private String email;
	private String idade;
	private String avaliacao;
	private String recomenda;
	private String feedback;
	
	public long getCpf() {
		return cpf;
	}
	public void setCpf(long cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getIdade() {
		return idade;
	}
	public void setIdade(String idade) {
		this.idade = idade;
	}
	public String getAvaliacao() {
		return avaliacao;
	}
	public void setAvaliacao(String avaliacao) {
		this.avaliacao = avaliacao;
	}
	public String getRecomenda() {
		return recomenda;
	}
	public void setRecomenda(String recomenda) {
		this.recomenda = recomenda;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
