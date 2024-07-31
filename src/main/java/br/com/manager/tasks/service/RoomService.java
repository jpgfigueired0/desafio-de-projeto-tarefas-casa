package br.com.manager.tasks.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import br.com.manager.tasks.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import br.com.manager.tasks.dto.room.RoomCountDTO;
import br.com.manager.tasks.dto.room.RoomDTO;
import br.com.manager.tasks.repository.RoomRepository;

@Service
public class RoomService {
	
	@Autowired
	private RoomRepository roomRepository;

	// Cadastrar novo cômodo
	public Optional<Room> postRoom(@RequestBody RoomDTO dto) {
		if(roomRepository.findAllByTitulo(dto.getTitulo()).isEmpty()) {
			Room room = new Room(dto.getTitulo());
			return Optional.of(roomRepository.save(room));
		} else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Dados incorretos ou cômodo já existente!!!!", null);
		}
	}

	// Editar pessoa
	public Optional<Room> putRoom(@RequestBody RoomDTO dto, long id) {
		if(roomRepository.findById(id).isPresent()) {
			Room room = roomRepository.getById(id);
			room.setTitulo(dto.getTitulo());
			return Optional.of(roomRepository.save(room));
		} else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Dados incorretos!!!!", null);
		}
	}
	
	// Listar cômodos e quantidade de pessoas e tarefas
	public List<RoomCountDTO> listarComodos() {
		List<RoomCountDTO> RoomCountDTO = roomRepository.findAll().stream().map(x -> new RoomCountDTO(x))
				.collect(Collectors.toList());
		return RoomCountDTO;
	}
	
	// Buscar todas pessoas
	public List<Room> findAll() {
		return roomRepository.findAll();
	}

}
