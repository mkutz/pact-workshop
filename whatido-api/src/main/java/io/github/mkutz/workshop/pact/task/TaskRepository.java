package io.github.mkutz.workshop.pact.task;

import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNullApi;

import java.util.List;

public interface TaskRepository extends CrudRepository<TaskEntity, String> {

    @Override
    List<TaskEntity> findAll();
}