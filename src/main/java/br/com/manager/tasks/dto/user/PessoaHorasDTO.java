package br.com.manager.tasks.dto.user;

import java.io.Serializable;
import java.util.stream.Collectors;

import br.com.manager.tasks.model.Pessoa;
import br.com.manager.tasks.model.Tarefa;

public class PessoaHorasDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String nome;

	private String comodo;

	private int horasTarefas;

	public PessoaHorasDTO(Pessoa pessoa) {
		super();
		this.nome = pessoa.getNome();
		this.comodo = pessoa.getIdComodo().getTitulo();
		this.horasTarefas = pessoa.getTarefa().stream().collect(Collectors.summingInt(Tarefa::getDuracao));
	}

	public PessoaHorasDTO() {
		super();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getComodo() {
		return comodo;
	}

	public void setComodo(String comodo) {
		this.comodo = comodo;
	}

	public int getHorasTarefas() {
		return horasTarefas;
	}

	public void setHorasTarefas(int horasTarefas) {
		this.horasTarefas = horasTarefas;
	}

}
