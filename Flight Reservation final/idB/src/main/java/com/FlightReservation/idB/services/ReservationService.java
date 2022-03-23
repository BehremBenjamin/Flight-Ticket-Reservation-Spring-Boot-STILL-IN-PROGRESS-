package com.FlightReservation.idB.services;

import com.FlightReservation.idB.dto.ReservationRequest;
import com.FlightReservation.idB.entities.Reservation;

public interface ReservationService {
    public Reservation bookFlight(ReservationRequest request);
}
