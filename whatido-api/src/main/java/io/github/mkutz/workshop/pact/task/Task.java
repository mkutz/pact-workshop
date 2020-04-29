package io.github.mkutz.workshop.pact.task;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.ZonedDateTime;

@Data
@AllArgsConstructor
public class Task {

    private String title;
    private String description;
    private ZonedDateTime created;

    public Task(TaskEntity taskEntity) {
        this.title = taskEntity.getTitle();
        this.description = taskEntity.getDescription();
    }

    public Task(TaskJson taskJson) {
        this.title = taskJson.getTitle();
        this.description = taskJson.getDescription();
    }

    public TaskJson toJson() {
        return new TaskJson(title, description, created.toString());
    }
}
