package br.com.manager.tasks.service;

import java.util.List;
import java.util.Optional;

import br.com.manager.tasks.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import br.com.manager.tasks.dto.tarefa.TarefaDTO;
import br.com.manager.tasks.dto.tarefa.TarefaIdDTO;
import br.com.manager.tasks.model.Pessoa;
import br.com.manager.tasks.model.Tarefa;
import br.com.manager.tasks.repository.RoomRepository;
import br.com.manager.tasks.repository.PessoaRepository;
import br.com.manager.tasks.repository.TarefaRepository;

@Service
public class TarefaService {

	@Autowired
	private TarefaRepository tarefaRepository;

	@Autowired
	RoomRepository roomRepository;

	@Autowired
	PessoaRepository pessoaRepository;

	// Cadastrar nova tarefa
	public Optional<TarefaDTO> postTarefa(@RequestBody TarefaDTO dto) {
		if (tarefaRepository.findAllByTitulo(dto.getTitulo()).isEmpty()
				&& roomRepository.findById(dto.getIdComodo()).isPresent()) {
			Room room = new Room();
			room.setId(dto.getIdComodo());
			Tarefa tarefa = new Tarefa(dto.getTitulo(), dto.getDescricao(), dto.getPrazo(), dto.getDuracao(),
					room);
                        tarefaRepository.save(tarefa);
			return Optional.of(dto);
		} else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"Possiveis erros: Nome da Tarefa já existente ou Cômodo não localizado!!!!", null);
		}
	}

	// Editar tarefa
	public Optional<Tarefa> putTarefa(@RequestBody TarefaDTO dto, long id) {
		if (tarefaRepository.findById(id).isPresent()
				&& roomRepository.findById(dto.getIdComodo()).isPresent()) {
			Tarefa tarefa = tarefaRepository.getById(id);
			Room room = new Room();
			tarefa.setTitulo(dto.getTitulo());
			tarefa.setDescricao(dto.getDescricao());
			tarefa.setPrazo(dto.getPrazo());
			tarefa.setDuracao(dto.getDuracao());
			room.setId(dto.getIdComodo());
			tarefa.setIdComodo(room);
			return Optional.of(tarefaRepository.save(tarefa));
		} else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"Possiveis erros: Nome da Tarefa já existente ou Cômodo não localizado!!!!", null);
		}
	}

	// Alocar uma pessoa na tarefa que tenha o mesmo comodo
	public Optional<TarefaIdDTO> alocarPessoaTarefa(@RequestBody TarefaIdDTO alocarDTO, long id) {
		Tarefa tarefa = tarefaRepository.getById(alocarDTO.getIdTarefa());
		Pessoa pessoa = pessoaRepository.getById(id);
		if (tarefaRepository.findById(id).isPresent() && pessoaRepository.findById(id).isPresent()
				&& tarefa.getIdComodo() == pessoa.getIdComodo()) {
			tarefa.setPessoa(pessoa);
			tarefaRepository.save(tarefa);
			return Optional.of(alocarDTO);
		} else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"Possiveis erros: Cômodos diferentes ou não encontrado pessoa/tarefa!!!!", null);
		}
	}

	// Finalizar a tarefa
	public Optional<Long> finalizarTarefa(long finalizarTarefa) {
		if (tarefaRepository.findById(finalizarTarefa).isPresent()) {
			Tarefa tarefa = tarefaRepository.getById(finalizarTarefa);
			tarefa.setFinalizado(true);
			tarefaRepository.save(tarefa);
			return Optional.of(finalizarTarefa);
		} else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID não localizado!!!!", null);
		}
	}

	// Buscar todas tarefas
	public List<Tarefa> findAll() {
		return tarefaRepository.findAll();
	}

}
