package io.github.mkutz.workshop.pact;

import org.testcontainers.containers.PostgreSQLContainer;

public class WhatidoDatabaseContainer extends PostgreSQLContainer<WhatidoDatabaseContainer> {

    private static final String IMAGE_VERSION = "postgres:11.1";
    private static WhatidoDatabaseContainer container;

    private WhatidoDatabaseContainer() {
        super(IMAGE_VERSION);
    }

    public static WhatidoDatabaseContainer getInstance() {
        if (container == null) {
            container = new WhatidoDatabaseContainer();
        }
        return container;
    }

    @Override
    public void start() {
        super.start();
        System.setProperty("SPRING_DATASOURCE_URL", container.getJdbcUrl());
        System.setProperty("SPRING_DATASOURCE_USERNAME", container.getUsername());
        System.setProperty("SPRING_DATASOURCE_PASSWORD", container.getPassword());
    }

    @Override
    public void stop() {
        super.stop();
    }
}
