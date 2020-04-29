package io.github.mkutz.workshop.pact.task;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.stream.Stream;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TaskController.class)
class TaskControllerMockMvcTest {

    @Autowired
    MockMvc httpMock;

    @MockBean
    TaskService taskServiceMock;

    @Test
    @DisplayName("GET /tasks/")
    void testGetTasks() throws Exception {
        Mockito.when(taskServiceMock.getAllTasks())
                .thenReturn(Stream.of(
                        new Task("My first Task", "Just a task to do",
                                LocalDateTime.of(2020, 3, 30, 8, 46).atZone(ZoneId.of("Europe/Berlin"))),
                        new Task("My second Task", "Another task to do",
                                LocalDateTime.of(2020, 2, 19, 11, 9).atZone(ZoneId.of("Europe/Berlin")))
                ));

        httpMock.perform(get("/tasks"))
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"title\":\"My first Task\",\"description\":\"Just a task to do\"},{\"title\":\"My second Task\",\"description\":\"Another task to do\"}]"));
    }
}