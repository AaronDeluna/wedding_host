package org.javaacademy.wedding_host.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {
    private int monthNumber;
    private int dayNumber;
    private boolean booked;
}
