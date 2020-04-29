package io.github.mkutz.workshop.pact

import io.github.mkutz.workshop.pact.task.DocumentV1Controller
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.http.client.MultipartBodyBuilder
import org.springframework.mock.web.MockMultipartFile
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.ResultActions
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder
import org.springframework.test.web.servlet.request.MockMultipartHttpServletRequestBuilder
import org.springframework.web.multipart.MultipartFile
import spock.lang.Specification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest(DocumentV1Controller)
class DocumentV1ControllerSpec extends Specification {

    @Autowired
    MockMvc mvc

    def "test file upload"() {
        given:
        MultipartFile multipartFile = new MockMultipartFile("file",
                this.class.classLoader.getResourceAsStream("application.yml"))

        MockHttpServletRequestBuilder requestBuilder = put("/v1/document")
        MockMultipartHttpServletRequestBuilder multipartRequestBuilder = multipart()

        expect:
        mvc.perform(multipartRequestBuilder)
                .andExpect(status().isCreated())
    }
}
