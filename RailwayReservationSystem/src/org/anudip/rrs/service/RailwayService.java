package org.anudip.rrs.service;

import java.util.List;

import org.anudip.rrs.model.Booking;
import org.anudip.rrs.model.Passenger;
import org.anudip.rrs.model.Train;

public interface RailwayService {

    // Train
    void addTrain(Train train);
    List<Train> getAllTrains();
    Train searchTrain(int trainId);
    void updateTrain(Train train);
    void deleteTrain(int trainId);

    // Passenger
    void addPassenger(Passenger passenger);
    List<Passenger> getAllPassengers();
    Passenger searchPassenger(int passengerId);
    void updatePassenger(Passenger passenger);

    // Booking
    void bookTicket(Booking booking);
    List<Booking> getAllBookings();
    Booking searchBooking(int pnrNumber);
    void cancelTicket(int pnrNumber);

}