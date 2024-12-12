package org.javaacademy.wedding_host.mapper;

import org.javaacademy.wedding_host.dto.ReservationDto;
import org.javaacademy.wedding_host.entity.Reservation;
import org.javaacademy.wedding_host.entity.ReservationRequest;
import org.springframework.stereotype.Component;

@Component
public class ReservationMapper {

    public Reservation convertToEntity(ReservationDto reservationDto) {
        return new Reservation(
                reservationDto.getMonthNumber(),
                reservationDto.getDayNumber(),
                reservationDto.isBooked()
        );
    }

    public ReservationDto convertToDto(Reservation reservation) {
        return new ReservationDto(
                reservation.getMonthNumber(),
                reservation.getDayNumber(),
                reservation.isBooked()
        );
    }

    public ReservationDto convertToDtoFromRequest(ReservationRequest request) {
        return new ReservationDto(
                request.getMonth(),
                request.getDay(),
                true
        );
    }

}
