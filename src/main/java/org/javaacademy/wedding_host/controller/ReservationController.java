package org.javaacademy.wedding_host.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.javaacademy.wedding_host.dto.ReservationDto;
import org.javaacademy.wedding_host.entity.ReservationCountResponse;
import org.javaacademy.wedding_host.entity.ReservationRequest;
import org.javaacademy.wedding_host.service.ReservationService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/booking")
@RequiredArgsConstructor
@CrossOrigin
@Slf4j
public class ReservationController {
    private final ReservationService reservationService;

    @GetMapping("/month/{month}")
    public List<ReservationDto> getAllReservationByMonth(@PathVariable Integer month) {
        return reservationService.getAllReservationByMonth(month);
    }

    @GetMapping("/month/{month}/free")
    public ReservationCountResponse getReservationCountByMonth(@PathVariable Integer month) {
        ReservationCountResponse countResponse = new ReservationCountResponse();
        countResponse.setCount(reservationService.getReservationCountByMonth(month));
        return countResponse;
    }

    @PostMapping
    public void createNewReservation(@RequestBody ReservationRequest reservationRequest) {
        reservationService.createReservation(new ReservationDto(
                reservationRequest.getMonth(),
                reservationRequest.getDay(),
                true)
        );
    }
}
