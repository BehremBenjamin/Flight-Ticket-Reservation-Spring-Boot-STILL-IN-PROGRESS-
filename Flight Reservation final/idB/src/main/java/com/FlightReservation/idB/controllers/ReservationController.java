package com.FlightReservation.idB.controllers;

import com.FlightReservation.idB.entities.Flight;
import com.FlightReservation.idB.entities.Reservation;
import com.FlightReservation.idB.repositories.FlightRepository;
import com.FlightReservation.idB.dto.ReservationRequest;
import com.FlightReservation.idB.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class ReservationController {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    ReservationService reservationService;

    @RequestMapping("showCompleteReservation")
    public String showCompleteReservation(@RequestParam("flightId") Long flightId, ModelMap modelMap){
        final Optional<Flight> flightOptional = flightRepository.findById(flightId);
        Flight flight = flightOptional.get();
        modelMap.addAttribute("flight", flight);
        return "completeReservation";
    }

    @RequestMapping(value = "completeReservation", method = RequestMethod.POST)
    public String completeReservation(ReservationRequest request, ModelMap modelMap) {
        Reservation reservation = reservationService.bookFlight(request);
        modelMap.addAttribute("msg", "Reservation with flight" + " " + request.getFlightId() + " for  " +
                "" + request.getPassengerFirstName() + " " + request.getPassengerLastName() +  " " + "confirmed !");
        return "reservationConfirmation";

    }
}
