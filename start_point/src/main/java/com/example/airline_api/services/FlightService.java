package com.example.airline_api.services;

import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.FlightRepository;
import com.example.airline_api.repositories.PassengerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightService {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    PassengerRepository passengerRepository;

    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    public Optional<Flight> getFlightById(Long id) {
        return flightRepository.findById(id);
    }

    public Flight addNewFlight(Flight flight) {
        return flightRepository.save(flight);
    }

//    found this part tricky and was not quite sure how to throw the exception
//    @Transactional
//    public void addPassengerToFlight(Long flightId, Passenger passenger) {
//        Optional<Flight> flight1 = flightRepository.findById(flightId);
//        if (flight1.isPresent()) {
//            Flight flight = flight1.get();
//            List<Passenger> passengers = flight.getPassengers();
//            passengers.add(passenger);
//
//            List<Flight> passengerFlights = passenger.getFlights();
//            passengerFlights.add(flight);
//
//            flightRepository.save(flight);
//            passengerRepository.save(passenger);
//
//        }
//    }
    public void cancelFlight(long id){
        flightRepository.deleteById(id);
    }

}


