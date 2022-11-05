package br.ce.wcaquino.taskbackend.repo;

import br.ce.wcaquino.taskbackend.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TaskRepo extends JpaRepository<Task, Long>{

}
