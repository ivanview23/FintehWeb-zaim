package com.example.finteh.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import lombok.Data;

@Data
public class RequestContentDTO {

    private JsonNode jsonContent;


    @JsonProperty(required = true)
    private JsonNode loanRequest;

    @PostConstruct
    private void validate() {
        if (loanRequest == null) {
            throw new IllegalArgumentException("jsonContent не может быть null");
        }
    }
    public static RequestContentDTO fromJson(String json) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, RequestContentDTO.class);
    }
}

//public class RequestContentDTO {
//    private String jsonString;
//
//    public static RequestContentDTO fromJson(String json) {
//        RequestContentDTO dto = new RequestContentDTO();
//        dto.setJsonString(json);
//        return dto;
//    }
//
//    public String getJsonString() { return jsonString; }
//    public void setJsonString(String jsonString) { this.jsonString = jsonString; }
//}
