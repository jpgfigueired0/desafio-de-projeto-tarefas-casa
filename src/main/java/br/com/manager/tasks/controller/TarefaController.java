package br.com.manager.tasks.controller;

import java.util.List;

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

import br.com.manager.tasks.dto.tarefa.TarefaDTO;
import br.com.manager.tasks.dto.tarefa.TarefaIdDTO;
import br.com.manager.tasks.model.Tarefa;
import br.com.manager.tasks.repository.TarefaRepository;
import br.com.manager.tasks.service.TarefaService;

@RestController
@RequestMapping
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TarefaController {

	@Autowired
	private TarefaService tarefaService;

	@Autowired
	private TarefaRepository tarefaRepository;

	// Buscar todas tarefas
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER', 'ROLE_MANAGER')")
	@GetMapping("/get/tarefas/all")
	public ResponseEntity<List<Tarefa>> getAll() {
		return ResponseEntity.ok(tarefaService.findAll());
	}

	// Cadastrar tarefa
	@PostMapping("/post/tarefas")
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER', 'ROLE_MANAGER')")
	public ResponseEntity<TarefaDTO> postTarefa(@RequestBody TarefaDTO dto) {
		return tarefaService.postTarefa(dto).map(resp -> ResponseEntity.status(HttpStatus.CREATED).body(resp))
				.orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
	}

	// Editar tarefa
	@PutMapping("/put/tarefas/{id}")
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER', 'ROLE_MANAGER')")
	public ResponseEntity<Tarefa> putTarefa(@RequestBody TarefaDTO dto, @PathVariable("id") long id) {
		return tarefaService.putTarefa(dto, id).map(resp -> ResponseEntity.status(HttpStatus.OK).body(resp))
				.orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
	}
	
	// Alocar uma pessoa na tarefa que tenha o mesmo cômodo
	@PutMapping("/put/tarefas/alocar/{id}")
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER', 'ROLE_MANAGER')")
	public ResponseEntity<TarefaIdDTO> alocarPessoaTarefa(@RequestBody TarefaIdDTO alocarDTO, @PathVariable("id") long id) {
		return tarefaService.alocarPessoaTarefa(alocarDTO, id).map(resp -> ResponseEntity.status(HttpStatus.OK).body(resp))
				.orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
	}
	
	// Finalizar a tarefa
	@PutMapping("/put/tarefas/finalizar/{id}")
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER', 'ROLE_MANAGER')")
	public ResponseEntity<Long> finalizarTarefa(@PathVariable("id") long finalizarTarefa) {
		return tarefaService.finalizarTarefa(finalizarTarefa).map(resp -> ResponseEntity.status(HttpStatus.OK).body(resp))
				.orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
	}
	
	// Deletar tarefa
	@DeleteMapping("/delete/tarefa/{id}")
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER', 'ROLE_MANAGER')")
	public void deleteTarefa(@PathVariable("id") long id) {
		tarefaRepository.deleteById(id);
	}

}
