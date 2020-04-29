package io.github.mkutz.workshop.pact.task;

import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
class TaskService {

    private final TaskRepository taskRepository;

    TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Stream<Task> getAllTasks() {
        return taskRepository.findAll().stream().map(Task::new);
    }
}
