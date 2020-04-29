package io.github.mkutz.workshop.pact.task;

import lombok.Data;

@Data
public class TaskJson {

    private final String title;
    private final String description;
    private final String created;
}
