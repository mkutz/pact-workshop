package io.github.mkutz.workshop.pact;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@SpringBootTest
class WhatidoApiApplicationTests {

    @Container
    private static final WhatidoDatabaseContainer databaseContainer = WhatidoDatabaseContainer.getInstance()
            .withDatabaseName("whatido")
            .withUsername("postgres")
            .withPassword("password");

    @Test
    void contextLoads() {
    }
}
