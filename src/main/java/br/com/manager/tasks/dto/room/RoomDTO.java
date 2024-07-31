package br.com.manager.tasks.dto.room;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import br.com.manager.tasks.model.Room;

public class RoomDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@NotNull
	private String titulo;
	
	public RoomDTO(Room room) {
		super();
		this.titulo = room.getTitulo();
	}

	public RoomDTO() {
		super();
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	
}
