package org.javaacademy.wedding_host.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReservationDto {
    private int monthNumber;
    private int dayNumber;
    private boolean booked;
}
