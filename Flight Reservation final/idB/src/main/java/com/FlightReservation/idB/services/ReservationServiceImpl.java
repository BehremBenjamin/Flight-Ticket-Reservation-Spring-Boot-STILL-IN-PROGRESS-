/*
       In this Class we should add request.getCardNumber();
       We will skip connection to 3rd party gateWay for payment
       in this demo project
*/
package com.FlightReservation.idB.services;

import com.FlightReservation.idB.dto.ReservationRequest;
import com.FlightReservation.idB.entities.Flight;
import com.FlightReservation.idB.entities.Passenger;
import com.FlightReservation.idB.entities.Reservation;
import com.FlightReservation.idB.repositories.FlightRepository;
import com.FlightReservation.idB.repositories.PassengerRepository;
import com.FlightReservation.idB.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService {

    public boolean flightFound;
    Flight flight;

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    PassengerRepository passengerRepository;

    @Autowired
    ReservationRepository reservationRepository;

    @Override
    public Reservation bookFlight(ReservationRequest request) {

        //make payment with 3rd party

        Long flightId = request.getFlightId();
        Optional<Flight> flightOptional = flightRepository.findById(flightId);
        flightFound = flightOptional.isPresent();
        if (flightFound) flight = flightOptional.get();

        Passenger passenger = new Passenger();
        passenger.setFirstName(request.getPassengerFirstName());
        passenger.setLastName(request.getPassengerLastName());
        passenger.setPhone(request.getPassengerPhone());
        passenger.setEmail(request.getPassengerEmail());
        Passenger savedPassenger = passengerRepository.save(passenger);

        Reservation reservation = new Reservation();
        reservation.setFlight(flight);
        reservation.setPassenger(savedPassenger);
        reservation.setCheckedIn(false);
        Reservation savedReservation = reservationRepository.save(reservation);
        return savedReservation;
    }
}
