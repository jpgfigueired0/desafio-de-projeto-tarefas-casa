package br.com.manager.tasks.dto.user;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.manager.tasks.model.Pessoa;

public class PessoaDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	@NotNull
	private String nome;
	
	@NotBlank
	private long idComodo;

	public PessoaDTO(Pessoa pessoa) {
		super();
		this.nome = pessoa.getNome();
		this.idComodo = pessoa.getIdComodo().getId();
	}

	public PessoaDTO() {
		super();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public long getIdComodo() {
		return idComodo;
	}

	public void setIdComodo(long idComodo) {
		this.idComodo = idComodo;
	}

}
