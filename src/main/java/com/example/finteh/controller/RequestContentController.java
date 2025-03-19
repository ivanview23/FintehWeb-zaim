package com.example.finteh.controller;

import com.example.finteh.dto.RequestContentDTO;
import com.example.finteh.entity.RequestContentEntity;
import com.example.finteh.services.RequestContentService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.net.URI;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/request-content")
public class RequestContentController {
    private final RequestContentService service;

    @Autowired
    public RequestContentController(RequestContentService service) {
        this.service = service;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<RequestContentEntity> create(@RequestBody String jsonContent) throws JsonProcessingException {
        // Приходит JSON преобразованный в строку
        log.warn("JsonContent -> {}", jsonContent);


        RequestContentDTO dto = RequestContentDTO.fromJson(jsonContent);
        RequestContentEntity saved = service.saveRequest(dto);

        URI location = URI.create("/api/request-content/" + saved.getId());
        return ResponseEntity.created(location).body(saved);
    }
}
//@RestController
//@RequestMapping("/api/request-content")
//public class RequestContentController {
//    private final RequestContentService service;
//
//    @Autowired
//    public RequestContentController(RequestContentService service) {
//        this.service = service;
//    }
//
//    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseStatus(HttpStatus.CREATED)
//    public ResponseEntity<RequestContentEntity> create(@RequestBody Map<String, Object> jsonContent) throws JsonProcessingException {
//        // Преобразование всего JSON объекта в строку
//        ObjectMapper mapper = new ObjectMapper();
//        String jsonString = mapper.writeValueAsString(jsonContent);
//
//        RequestContentDTO dto = RequestContentDTO.fromJson(jsonString);
//        RequestContentEntity saved = service.saveRequest(dto);
//
//        URI location = URI.create("/api/request-content/" + saved.getId());
//        return ResponseEntity.created(location).body(saved);
//    }
//}
