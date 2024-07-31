package br.com.manager.tasks.controller;

import java.util.List;

import br.com.manager.tasks.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.manager.tasks.dto.room.RoomCountDTO;
import br.com.manager.tasks.dto.room.RoomDTO;
import br.com.manager.tasks.repository.RoomRepository;
import br.com.manager.tasks.service.RoomService;

@RestController
@RequestMapping
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class RoomController {

	@Autowired
	private RoomService roomService;

	@Autowired
	private RoomRepository roomRepository;

	// Listar cômodos e quantidade de pessoas e tarefas
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER', 'ROLE_MANAGER')")
	@GetMapping("/get/comodos")
	public ResponseEntity<List<RoomCountDTO>> getAll() {
		return ResponseEntity.ok(roomService.listarComodos());
	}

	// Cadastrar cômodo
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER', 'ROLE_MANAGER')")
	@PostMapping("/post/comodo")
	public ResponseEntity<Room> postComodo(@RequestBody RoomDTO dto) {
		return roomService.postRoom(dto)
				.map(resp -> ResponseEntity.status(HttpStatus.CREATED).body(resp))
				.orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
	}

	// Editar cômodo
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER', 'ROLE_MANAGER')")
	@PutMapping("/put/comodo/{id}")
	public ResponseEntity<Room> putComodo(@RequestBody RoomDTO dto, @PathVariable("id") long id) {
		return roomService.putRoom(dto, id).map(resp -> ResponseEntity.status(HttpStatus.OK).body(resp))
				.orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
	}

	// Deletar cômodo
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER', 'ROLE_MANAGER')")
	@DeleteMapping("/delete/comodo/{id}")
	public void deleteComodo(@PathVariable("id") long id) {
		roomRepository.deleteById(id);
	}

}
