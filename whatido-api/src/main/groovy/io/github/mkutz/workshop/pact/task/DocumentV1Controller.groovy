package io.github.mkutz.workshop.pact.task

import org.springframework.http.HttpEntity
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile
import org.springframework.web.util.UriBuilder
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("v1/document")
class DocumentV1Controller {

    @PutMapping
    ResponseEntity<Void> newdoc(@RequestHeader Map<String, String> headers,
            @RequestParam("file") MultipartFile multipartFile,
            UriComponentsBuilder uriBuilder) {
        return ResponseEntity.created(uriBuilder.build().toUri()).build();
    }
}
