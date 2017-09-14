package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import models.Task;


  @Repository
public interface  TaskRepository extends JpaRepository<Task,Long>{

}
