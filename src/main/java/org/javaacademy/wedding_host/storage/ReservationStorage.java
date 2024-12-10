package org.javaacademy.wedding_host.storage;

import lombok.Getter;
import org.javaacademy.wedding_host.entity.Reservation;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Component
public class ReservationStorage {
    private final Map<Integer, List<Reservation>> reservationData = new HashMap<>();
}
