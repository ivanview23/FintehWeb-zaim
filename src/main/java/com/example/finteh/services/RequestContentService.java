package com.example.finteh.services;

import com.example.finteh.dto.RequestContentDTO;
import com.example.finteh.entity.RequestContentEntity;
import com.example.finteh.repository.RequestContentRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RequestContentService {
    private final RequestContentRepository repository;
    private final ObjectMapper objectMapper;

    @Autowired
    public RequestContentService(RequestContentRepository repository, ObjectMapper objectMapper) {
        this.repository = repository;
        this.objectMapper = objectMapper;
    }

    public RequestContentEntity saveRequest(RequestContentDTO dto) throws JsonProcessingException {

        RequestContentEntity entity = new RequestContentEntity();
//        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(String.valueOf(dto.getJsonContent()));

// Получение значений
        String loanRequestId = jsonNode.get("loanRequestID").asText();
        JsonNode regPerson = jsonNode.get("regPerson");
        String firstName = regPerson.get("firstName").asText();
        log.info("Parsing loanRequestID -> {}\n         regPerson -> {}\n           firstName -> {}", loanRequestId, regPerson, firstName);

// Работа с массивами
        ArrayNode accountInfo = (ArrayNode) jsonNode.get("creditBureau").get("account_info");
        for (JsonNode account : accountInfo) {

            String accountNumber = account.get("account_number").asText();

//        entity.setJsonContent(objectMapper.readTree(String.valueOf(dto.getJsonContent())));

        }
            return repository.save(entity);
    }
}

//@Service
//public class RequestContentService {
//    @Autowired
//    private RequestContentRepository repository;
//
//    public RequestContentEntity saveRequest(RequestContentDTO dto) {
//        RequestContentEntity entity = new RequestContentEntity();
//        entity.setJsonData(dto.getJsonString());
//        return repository.save(entity);
//    }
//}
