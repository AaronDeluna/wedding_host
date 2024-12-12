package org.javaacademy.wedding_host.service;

import lombok.RequiredArgsConstructor;
import org.javaacademy.wedding_host.dto.ReservationDto;
import org.javaacademy.wedding_host.entity.ReservationRequest;
import org.javaacademy.wedding_host.mapper.ReservationMapper;
import org.javaacademy.wedding_host.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final ReservationMapper reservationMapper;

    public void createReservation(ReservationRequest reservationRequest) {
        ReservationDto reservationDto = reservationMapper.convertToDtoFromRequest(reservationRequest);
        reservationRepository.save(reservationMapper.convertToEntity(reservationDto));
    }

    public List<ReservationDto> getAllReservationByMonth(Integer month) {
        return reservationRepository.getAllReservationByMonth(month).stream()
                .map(reservationMapper::convertToDto)
                .toList();
    }

    public Integer getReservationCountByMonth(Integer month) {
        return Optional.ofNullable(reservationRepository.getCountByMonth(month))
                .orElse(0);
    }
}
