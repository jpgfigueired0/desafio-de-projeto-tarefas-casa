package br.com.manager.tasks.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "TB_PESSOAS")
public class Pessoa implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String nome;
	
	@OneToMany(mappedBy = "pessoa", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties({"pessoa", "idRoom"})
	private List<Tarefa> tarefa;
	
	@ManyToOne
	@JsonIgnoreProperties({"pessoa", "tarefa"})
	@JoinColumn(name = "idRoom")
	private Room idRoom;
	
	public Pessoa(String nome, Room room) {
		super();
		this.nome = nome;
		this.idRoom = room;
	}

	public Pessoa() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Tarefa> getTarefa() {
		return tarefa;
	}

	public void setTarefa(List<Tarefa> tarefa) {
		this.tarefa = tarefa;
	}

	public Room getIdComodo() {
		return idRoom;
	}

	public void setIdComodo(Room idRoom) {
		this.idRoom = idRoom;
	}

}
