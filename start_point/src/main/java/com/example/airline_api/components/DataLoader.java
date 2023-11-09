package com.example.airline_api.components;

import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.FlightRepository;
import com.example.airline_api.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader  implements ApplicationRunner {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    PassengerRepository passengerRepository;

    public void run(ApplicationArguments args) {

//      Barcelona flight

        Flight barcelonaFlight = new Flight("Barcelona", 500, "Monday","Noon");
        flightRepository.save(barcelonaFlight);

        Passenger passenger1 = new Passenger("Sarah", "sarah@hotmail.com");
        passenger1.getFlights().add(barcelonaFlight);
        barcelonaFlight.getPassengers().add(passenger1);
        passengerRepository.save(passenger1);

        Passenger passenger2 = new Passenger("Melody", "melody@hotmail.com");
        passenger2.getFlights().add(barcelonaFlight);
        barcelonaFlight.getPassengers().add(passenger2);
        passengerRepository.save(passenger2);

        Passenger passenger3 = new Passenger("Sophie", "sophie@hotmail.com");
        passenger3.getFlights().add(barcelonaFlight);
        barcelonaFlight.getPassengers().add(passenger3);
        passengerRepository.save(passenger3);

//        London flight

        Flight londonFlight = new Flight("London", 100, "Tuesday","Morning");
        flightRepository.save(londonFlight);

        Passenger passenger4 = new Passenger("Zoe", "zoe@hotmail.com");
        passenger4.getFlights().add(londonFlight);
        londonFlight.getPassengers().add(passenger4);
        passengerRepository.save(passenger4);

        Passenger passenger5 = new Passenger("lee", "lee@hotmail.com");
        passenger5.getFlights().add(londonFlight);
        londonFlight.getPassengers().add(passenger5);
        passengerRepository.save(passenger5);

        Passenger passenger6 = new Passenger("cleo", "cleo@hotmail.com");
        passenger6.getFlights().add(londonFlight);
        londonFlight.getPassengers().add(passenger6);
        passengerRepository.save(passenger6);


//        Both flights

        passenger1.getFlights().add(londonFlight);
        londonFlight.getPassengers().add(passenger1);
        passengerRepository.save(passenger1);

        passenger4.getFlights().add(barcelonaFlight);
        barcelonaFlight.getPassengers().add(passenger4);
        passengerRepository.save(passenger4);

        passenger2.getFlights().add(londonFlight);
        londonFlight.getPassengers().add(passenger2);
        passengerRepository.save(passenger2);


    }

}
