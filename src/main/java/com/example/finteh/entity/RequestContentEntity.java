package com.example.finteh.entity;

import com.fasterxml.jackson.databind.JsonNode;
import jakarta.persistence.*;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Entity
@Table(name="request_content")
public class RequestContentEntity {

     @Id
     @Column(name = "id")
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private int id;

     @Setter
     @Column(name = "json_content", columnDefinition = "jsonb")
     @JdbcTypeCode(SqlTypes.JSON)
     private JsonNode jsonContent;

     public RequestContentEntity() {
     }

     public RequestContentEntity(JsonNode jsonContent) {
         this.jsonContent = jsonContent;
     }

    public int getId() {
        return id;
    }

    public JsonNode getJsonContent() {
        return jsonContent;
    }

    @Override
    public String toString() {
        return "RequestContentEntity{" +
                "id=" + id +
                ", jsonContent=" + jsonContent +
                '}';
    }
}
//@Entity
//@Table(name="request_content")
//public class RequestContentEntity {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    // Поле для хранения всего JSON объекта
//    @Column(name = "json_content", columnDefinition = "JSON")
//    private String jsonData;
//
//    // Геттеры и сеттеры
//    public Long getId() { return id; }
//    public void setId(Long id) { this.id = id; }
//    public String getJsonData() { return jsonData; }
//    public void setJsonData(String jsonData) { this.jsonData = jsonData; }
//}
