package com.FlightReservation.idB.controllers;

import com.FlightReservation.idB.entities.Flight;
import com.FlightReservation.idB.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class FlightController  {

    @Autowired
    FlightRepository flightRepository;

    @RequestMapping("findFlights")
    public String findFlights(@RequestParam("from") String from, @RequestParam("to") String to,
                              @RequestParam("dateOfDeparture") @DateTimeFormat(pattern = "yyyy-mm-dd") String dateOfDeparture, ModelMap modelMap) {

        List<Flight> flights = flightRepository.findFlights(from, to, dateOfDeparture);
        modelMap.addAttribute("flights", flights);
        return "displayFlights";
    }
}
