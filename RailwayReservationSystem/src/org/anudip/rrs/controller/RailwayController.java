package org.anudip.rrs.controller;

import java.util.List;

import org.anudip.rrs.model.Booking;
import org.anudip.rrs.model.Passenger;
import org.anudip.rrs.model.Train;
import org.anudip.rrs.service.RailwayService;
import org.anudip.rrs.service.RailwayServiceImpl;
import org.anudip.rrs.util.InputUtil;

public class RailwayController {

    private RailwayService service = new RailwayServiceImpl();

    // =====================================================
    // TRAIN
    // =====================================================

    public void addTrain() {

        int id = InputUtil.getInt("Enter Train ID: ");

        if (service.searchTrain(id) != null) {
            System.out.println("Train ID already exists.");
            return;
        }

        String name = InputUtil.getString("Enter Train Name: ");
        String source = InputUtil.getString("Enter Source: ");
        String destination = InputUtil.getString("Enter Destination: ");
        double fare = InputUtil.getDouble("Enter Fare: ");
        int seats = InputUtil.getInt("Enter Available Seats: ");

        if (fare < 0 || seats < 0) {
            System.out.println("Fare and seats cannot be negative.");
            return;
        }

        Train train = new Train(
                id,
                name,
                source,
                destination,
                fare,
                seats
        );

        service.addTrain(train);
    }

    public void viewTrains() {

        List<Train> trains = service.getAllTrains();

        if (trains.isEmpty()) {
            System.out.println("No Train Records Found.");
            return;
        }

        System.out.println();
        System.out.println("==============================================================");
        System.out.println("                     TRAIN DETAILS");
        System.out.println("==============================================================");

        System.out.printf(
                "%-8s %-20s %-15s %-15s %-10s %-10s%n",
                "ID",
                "Name",
                "Source",
                "Destination",
                "Fare",
                "Seats"
        );

        System.out.println("--------------------------------------------------------------");

        for (Train train : trains) {
            System.out.printf(
                    "%-8d %-20s %-15s %-15s %-10.2f %-10d%n",
                    train.getTrainId(),
                    train.getTrainName(),
                    train.getSource(),
                    train.getDestination(),
                    train.getFare(),
                    train.getAvailableSeats()
            );
        }
    }

    public void searchTrain() {

        int id = InputUtil.getInt("Enter Train ID: ");

        Train train = service.searchTrain(id);

        if (train == null) {
            System.out.println("Train Not Found.");
            return;
        }

        System.out.println();
        System.out.println("Train Details");
        System.out.println("-----------------------------");
        System.out.println("Train ID        : " + train.getTrainId());
        System.out.println("Train Name      : " + train.getTrainName());
        System.out.println("Source          : " + train.getSource());
        System.out.println("Destination     : " + train.getDestination());
        System.out.println("Fare            : " + train.getFare());
        System.out.println("Available Seats : " + train.getAvailableSeats());
    }

    public void updateTrain() {

        int id = InputUtil.getInt("Enter Train ID to Update: ");

        Train train = service.searchTrain(id);

        if (train == null) {
            System.out.println("Train Not Found.");
            return;
        }

        String name = InputUtil.getString("Enter New Train Name: ");
        String source = InputUtil.getString("Enter New Source: ");
        String destination = InputUtil.getString("Enter New Destination: ");
        double fare = InputUtil.getDouble("Enter New Fare: ");
        int seats = InputUtil.getInt("Enter New Available Seats: ");

        train.setTrainName(name);
        train.setSource(source);
        train.setDestination(destination);
        train.setFare(fare);
        train.setAvailableSeats(seats);

        service.updateTrain(train);
    }

    public void deleteTrain() {

        int id = InputUtil.getInt("Enter Train ID to Delete: ");

        Train train = service.searchTrain(id);

        if (train == null) {
            System.out.println("Train Not Found.");
            return;
        }

        service.deleteTrain(id);
    }

    // =====================================================
    // PASSENGER
    // =====================================================

    public void addPassenger() {

        int id = InputUtil.getInt("Enter Passenger ID: ");

        if (service.searchPassenger(id) != null) {
            System.out.println("Passenger ID already exists.");
            return;
        }

        String name = InputUtil.getString("Enter Passenger Name: ");
        int age = InputUtil.getInt("Enter Age: ");
        String gender = InputUtil.getString("Enter Gender: ");
        String mobile = InputUtil.getString("Enter Mobile Number: ");

        if (age <= 0) {
            System.out.println("Age must be greater than zero.");
            return;
        }

        Passenger passenger = new Passenger(
                id,
                name,
                age,
                gender,
                mobile
        );

        service.addPassenger(passenger);
    }

    public void viewPassengers() {

        List<Passenger> passengers = service.getAllPassengers();

        if (passengers.isEmpty()) {
            System.out.println("No Passenger Records Found.");
            return;
        }

        System.out.println();
        System.out.println("==============================================================");
        System.out.println("                   PASSENGER DETAILS");
        System.out.println("==============================================================");

        System.out.printf(
                "%-8s %-20s %-8s %-10s %-15s%n",
                "ID",
                "Name",
                "Age",
                "Gender",
                "Mobile"
        );

        System.out.println("--------------------------------------------------------------");

        for (Passenger passenger : passengers) {

            System.out.printf(
                    "%-8d %-20s %-8d %-10s %-15s%n",
                    passenger.getPassengerId(),
                    passenger.getPassengerName(),
                    passenger.getAge(),
                    passenger.getGender(),
                    passenger.getMobile()
            );
        }
    }

    public void searchPassenger() {

        int id = InputUtil.getInt("Enter Passenger ID: ");

        Passenger passenger = service.searchPassenger(id);

        if (passenger == null) {
            System.out.println("Passenger Not Found.");
            return;
        }

        System.out.println();
        System.out.println("Passenger Details");
        System.out.println("-----------------------------");
        System.out.println("Passenger ID : " + passenger.getPassengerId());
        System.out.println("Name         : " + passenger.getPassengerName());
        System.out.println("Age          : " + passenger.getAge());
        System.out.println("Gender       : " + passenger.getGender());
        System.out.println("Mobile       : " + passenger.getMobile());
    }

    public void updatePassenger() {

        int id = InputUtil.getInt("Enter Passenger ID to Update: ");

        Passenger passenger = service.searchPassenger(id);

        if (passenger == null) {
            System.out.println("Passenger Not Found.");
            return;
        }

        String name = InputUtil.getString("Enter New Name: ");
        int age = InputUtil.getInt("Enter New Age: ");
        String gender = InputUtil.getString("Enter New Gender: ");
        String mobile = InputUtil.getString("Enter New Mobile: ");

        passenger.setPassengerName(name);
        passenger.setAge(age);
        passenger.setGender(gender);
        passenger.setMobile(mobile);

        service.updatePassenger(passenger);
    }

    // =====================================================
    // BOOKING
    // =====================================================

    public void bookTicket() {

        int pnr = InputUtil.getInt("Enter PNR Number: ");

        if (service.searchBooking(pnr) != null) {
            System.out.println("PNR Number already exists.");
            return;
        }

        int passengerId =
                InputUtil.getInt("Enter Passenger ID: ");

        Passenger passenger =
                service.searchPassenger(passengerId);

        if (passenger == null) {
            System.out.println("Passenger Not Found.");
            return;
        }

        int trainId =
                InputUtil.getInt("Enter Train ID: ");

        Train train =
                service.searchTrain(trainId);

        if (train == null) {
            System.out.println("Train Not Found.");
            return;
        }

        if (train.getAvailableSeats() <= 0) {
            System.out.println("No Seats Available.");
            return;
        }

        String coach =
                InputUtil.getString("Enter Coach: ");

        int seat =
                InputUtil.getInt("Enter Seat Number: ");

        Booking booking = new Booking(
                pnr,
                passengerId,
                trainId,
                coach,
                seat,
                "Confirmed"
        );

        service.bookTicket(booking);
    }

    public void viewBookings() {

        List<Booking> bookings =
                service.getAllBookings();

        if (bookings.isEmpty()) {
            System.out.println("No Booking Records Found.");
            return;
        }

        System.out.println();
        System.out.println("==============================================================");
        System.out.println("                    BOOKING DETAILS");
        System.out.println("==============================================================");

        System.out.printf(
                "%-10s %-12s %-10s %-10s %-10s %-12s%n",
                "PNR",
                "Passenger",
                "Train",
                "Coach",
                "Seat",
                "Status"
        );

        System.out.println("--------------------------------------------------------------");

        for (Booking booking : bookings) {

            System.out.printf(
                    "%-10d %-12d %-10d %-10s %-10d %-12s%n",
                    booking.getPnrNumber(),
                    booking.getPassengerId(),
                    booking.getTrainId(),
                    booking.getCoach(),
                    booking.getSeatNumber(),
                    booking.getStatus()
            );
        }
    }

    public void searchBooking() {

        int pnr =
                InputUtil.getInt("Enter PNR Number: ");

        Booking booking =
                service.searchBooking(pnr);

        if (booking == null) {
            System.out.println("Booking Not Found.");
            return;
        }

        System.out.println();
        System.out.println("Booking Details");
        System.out.println("-----------------------------");
        System.out.println("PNR Number   : " + booking.getPnrNumber());
        System.out.println("Passenger ID : " + booking.getPassengerId());
        System.out.println("Train ID     : " + booking.getTrainId());
        System.out.println("Coach        : " + booking.getCoach());
        System.out.println("Seat Number  : " + booking.getSeatNumber());
        System.out.println("Status       : " + booking.getStatus());
    }

    public void cancelTicket() {

        int pnr =
                InputUtil.getInt("Enter PNR Number: ");

        Booking booking =
                service.searchBooking(pnr);

        if (booking == null) {
            System.out.println("Booking Not Found.");
            return;
        }

        if (booking.getStatus().equalsIgnoreCase("Cancelled")) {
            System.out.println("Ticket is already cancelled.");
            return;
        }

        service.cancelTicket(pnr);
    }
}