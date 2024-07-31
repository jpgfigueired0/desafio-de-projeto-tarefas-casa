package br.com.manager.tasks.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.manager.tasks.model.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long>{
	
	public List<Room> findAllByTitulo(String titulo);
	
}
