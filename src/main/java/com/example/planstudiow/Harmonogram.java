package com.example.planstudiow;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

@JsonSerialize
@Data
public class Harmonogram {
    @JsonProperty("Id")
    private Integer id;
    @JsonProperty("Nazwa")
    private String subject;
    @JsonProperty("ECTS")
    private Integer score;
    @JsonProperty("Sala")
    private String room;
    @JsonProperty("Egzamin")
    private Boolean exam;
}
