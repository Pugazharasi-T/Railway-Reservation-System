package org.anudip.rrs.service;

import java.util.List;

import org.anudip.rrs.model.Booking;
import org.anudip.rrs.model.Passenger;
import org.anudip.rrs.model.Train;
import org.anudip.rrs.repository.RailwayRepository;
import org.anudip.rrs.repository.RailwayRepositoryImpl;

public class RailwayServiceImpl implements RailwayService {

    private RailwayRepository repository;

    public RailwayServiceImpl() {

        repository = new RailwayRepositoryImpl();
    }

    // ================= TRAIN =================

    @Override
    public void addTrain(Train train) {
        repository.addTrain(train);
    }

    @Override
    public List<Train> getAllTrains() {
        return repository.getAllTrains();
    }

    @Override
    public Train searchTrain(int trainId) {
        return repository.searchTrain(trainId);
    }

    @Override
    public void updateTrain(Train train) {
        repository.updateTrain(train);
    }

    @Override
    public void deleteTrain(int trainId) {
        repository.deleteTrain(trainId);
    }

    // ================= PASSENGER =================

    @Override
    public void addPassenger(Passenger passenger) {
        repository.addPassenger(passenger);
    }

    @Override
    public List<Passenger> getAllPassengers() {
        return repository.getAllPassengers();
    }

    @Override
    public Passenger searchPassenger(int passengerId) {
        return repository.searchPassenger(passengerId);
    }

    @Override
    public void updatePassenger(Passenger passenger) {
        repository.updatePassenger(passenger);
    }

    // ================= BOOKING =================

    @Override
    public void bookTicket(Booking booking) {
        repository.bookTicket(booking);
    }

    @Override
    public List<Booking> getAllBookings() {
        return repository.getAllBookings();
    }

    @Override
    public Booking searchBooking(int pnrNumber) {
        return repository.searchBooking(pnrNumber);
    }

    @Override
    public void cancelTicket(int pnrNumber) {
        repository.cancelTicket(pnrNumber);
    }
}