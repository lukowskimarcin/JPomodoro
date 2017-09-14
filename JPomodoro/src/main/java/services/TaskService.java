package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import models.Task;
import repositories.TaskRepository;


@Service
public class TaskService {
	
	@Autowired 	private TaskRepository taskRepository;
	
	
	public void save(Task task) {
		taskRepository.saveAndFlush(task);
	}
	
	public List<Task> findAll() {
		return taskRepository.findAll();
	}
	
}
