package br.com.manager.tasks.dto.room;

import java.io.Serializable;
import java.util.stream.Collectors;

import br.com.manager.tasks.model.Room;

public class RoomCountDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String titulo;

	private Long pessoas;

	private Long tarefas;

	public RoomCountDTO(Room room) {
		super();
		this.titulo = room.getTitulo();
		this.pessoas = room.getPessoa().stream().collect(Collectors.counting());
		this.tarefas = room.getTarefa().stream().collect(Collectors.counting());
	}

	public RoomCountDTO() {
		super();
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Long getPessoas() {
		return pessoas;
	}

	public void setPessoas(Long pessoas) {
		this.pessoas = pessoas;
	}

	public Long getTarefas() {
		return tarefas;
	}

	public void setTarefas(Long tarefas) {
		this.tarefas = tarefas;
	}

}
