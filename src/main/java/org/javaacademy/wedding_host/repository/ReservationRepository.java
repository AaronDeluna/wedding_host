package org.javaacademy.wedding_host.repository;

import lombok.RequiredArgsConstructor;
import org.javaacademy.wedding_host.entity.Reservation;
import org.javaacademy.wedding_host.storage.ReservationStorage;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ReservationRepository {
    private final ReservationStorage reservationStorage;

    public void save(Reservation reservation) {
        List<Reservation> reservations = reservationStorage.getReservationData().get(reservation.getMonthNumber());
        if (reservations == null) {
            reservations = new ArrayList<>();
        }
        reservations.add(reservation);
        reservationStorage.getReservationData().put(reservation.getMonthNumber(), reservations);
    }

    public List<Reservation> getAllReservationByMonth(Integer month) {
        return Optional.ofNullable(reservationStorage.getReservationData())
                .map(data -> data.get(month))
                .orElse(Collections.emptyList());
    }

    public Integer getCountByMonth(Integer month) {
        return Optional.ofNullable(reservationStorage.getReservationData())
                .map(data -> data.get(month))
                .orElse(Collections.emptyList()).size();
    }
}
