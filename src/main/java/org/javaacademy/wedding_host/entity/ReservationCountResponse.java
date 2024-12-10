package org.javaacademy.wedding_host.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ReservationCountResponse {
    @JsonProperty("count")
    private Integer count;
}
