package com.example.airline_api.controllers;

import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.FlightRepository;
import com.example.airline_api.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    FlightService flightService;

    // Display all available flights
    @GetMapping
    public ResponseEntity<List<Flight>> getAllFlights(){
       List <Flight> flight = flightService.getAllFlights();
       return new ResponseEntity<>(flight, HttpStatus.CREATED);
    }

    // Display a specific flight
    @GetMapping(value = "/{id}")
    public ResponseEntity<Flight> getFlightById(@PathVariable Long id ){
        Optional <Flight> flight = flightService.getFlightById(id);
        if(flight.isPresent()) {
            return new ResponseEntity<>(flight.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>( HttpStatus.NOT_FOUND);
    }

    // Add details of a new flight
    @PostMapping
    public ResponseEntity<List<Flight>> addNewFlight(@RequestBody Flight flight){
        flightService.addNewFlight(flight);
        return new ResponseEntity<>(flightService.getAllFlights(), HttpStatus.OK);
    }

//    // Book passenger on a flight
//    @PatchMapping(value = "/{id}")
//    public ResponseEntity<Flight> addPassengerToFlight(@PathVariable Long id, @RequestBody Passenger passenger){
//       flightService.addPassengerToFlight(id, passenger);
//        return new ResponseEntity<>( HttpStatus.OK);
//
//    }

    // Cancel flight
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Long> cancelFlight(@PathVariable long id){
        flightService.cancelFlight(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

}
