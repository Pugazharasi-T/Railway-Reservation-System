package org.anudip.rrs.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.anudip.rrs.model.Booking;
import org.anudip.rrs.model.Passenger;
import org.anudip.rrs.model.Train;
import org.anudip.rrs.util.DBConnection;

public class RailwayRepositoryImpl implements RailwayRepository {

    // =========================================================
    // TRAIN OPERATIONS
    // =========================================================

    @Override
    public void addTrain(Train train) {

        String sql = "INSERT INTO train "
                + "(train_id, train_name, source, destination, fare, available_seats) "
                + "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, train.getTrainId());
            ps.setString(2, train.getTrainName());
            ps.setString(3, train.getSource());
            ps.setString(4, train.getDestination());
            ps.setDouble(5, train.getFare());
            ps.setInt(6, train.getAvailableSeats());

            ps.executeUpdate();

            System.out.println("Train Added Successfully.");

        } catch (SQLException e) {

            System.out.println("Error while adding train.");
            e.printStackTrace();
        }
    }

    @Override
    public List<Train> getAllTrains() {

        List<Train> trainList = new ArrayList<>();

        String sql = "SELECT * FROM train";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Train train = new Train();

                train.setTrainId(rs.getInt("train_id"));
                train.setTrainName(rs.getString("train_name"));
                train.setSource(rs.getString("source"));
                train.setDestination(rs.getString("destination"));
                train.setFare(rs.getDouble("fare"));
                train.setAvailableSeats(rs.getInt("available_seats"));

                trainList.add(train);
            }

        } catch (SQLException e) {

            System.out.println("Error while fetching trains.");
            e.printStackTrace();
        }

        return trainList;
    }

    @Override
    public Train searchTrain(int trainId) {

        Train train = null;

        String sql = "SELECT * FROM train WHERE train_id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, trainId);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {

                    train = new Train();

                    train.setTrainId(rs.getInt("train_id"));
                    train.setTrainName(rs.getString("train_name"));
                    train.setSource(rs.getString("source"));
                    train.setDestination(rs.getString("destination"));
                    train.setFare(rs.getDouble("fare"));
                    train.setAvailableSeats(
                            rs.getInt("available_seats"));
                }
            }

        } catch (SQLException e) {

            System.out.println("Error while searching train.");
            e.printStackTrace();
        }

        return train;
    }

    @Override
    public void updateTrain(Train train) {

        String sql = "UPDATE train SET "
                + "train_name = ?, "
                + "source = ?, "
                + "destination = ?, "
                + "fare = ?, "
                + "available_seats = ? "
                + "WHERE train_id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, train.getTrainName());
            ps.setString(2, train.getSource());
            ps.setString(3, train.getDestination());
            ps.setDouble(4, train.getFare());
            ps.setInt(5, train.getAvailableSeats());
            ps.setInt(6, train.getTrainId());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Train Updated Successfully.");
            } else {
                System.out.println("Train Not Found.");
            }

        } catch (SQLException e) {

            System.out.println("Error while updating train.");
            e.printStackTrace();
        }
    }

    @Override
    public void deleteTrain(int trainId) {

        String sql = "DELETE FROM train WHERE train_id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, trainId);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Train Deleted Successfully.");
            } else {
                System.out.println("Train Not Found.");
            }

        } catch (SQLException e) {

            System.out.println("Cannot delete train.");
            System.out.println(
                    "Train may have existing bookings.");
        }
    }

    // =========================================================
    // PASSENGER OPERATIONS
    // =========================================================

    @Override
    public void addPassenger(Passenger passenger) {

        String sql = "INSERT INTO passenger "
                + "(passenger_id, passenger_name, age, gender, mobile) "
                + "VALUES (?, ?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, passenger.getPassengerId());
            ps.setString(2, passenger.getPassengerName());
            ps.setInt(3, passenger.getAge());
            ps.setString(4, passenger.getGender());
            ps.setString(5, passenger.getMobile());

            ps.executeUpdate();

            System.out.println("Passenger Added Successfully.");

        } catch (SQLException e) {

            System.out.println("Error while adding passenger.");
            e.printStackTrace();
        }
    }

    @Override
    public List<Passenger> getAllPassengers() {

        List<Passenger> passengerList = new ArrayList<>();

        String sql = "SELECT * FROM passenger";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Passenger passenger = new Passenger();

                passenger.setPassengerId(
                        rs.getInt("passenger_id"));

                passenger.setPassengerName(
                        rs.getString("passenger_name"));

                passenger.setAge(
                        rs.getInt("age"));

                passenger.setGender(
                        rs.getString("gender"));

                passenger.setMobile(
                        rs.getString("mobile"));

                passengerList.add(passenger);
            }

        } catch (SQLException e) {

            System.out.println(
                    "Error while fetching passengers.");

            e.printStackTrace();
        }

        return passengerList;
    }

    @Override
    public Passenger searchPassenger(int passengerId) {

        Passenger passenger = null;

        String sql =
                "SELECT * FROM passenger WHERE passenger_id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, passengerId);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {

                    passenger = new Passenger();

                    passenger.setPassengerId(
                            rs.getInt("passenger_id"));

                    passenger.setPassengerName(
                            rs.getString("passenger_name"));

                    passenger.setAge(
                            rs.getInt("age"));

                    passenger.setGender(
                            rs.getString("gender"));

                    passenger.setMobile(
                            rs.getString("mobile"));
                }
            }

        } catch (SQLException e) {

            System.out.println(
                    "Error while searching passenger.");

            e.printStackTrace();
        }

        return passenger;
    }

    @Override
    public void updatePassenger(Passenger passenger) {

        String sql = "UPDATE passenger SET "
                + "passenger_name = ?, "
                + "age = ?, "
                + "gender = ?, "
                + "mobile = ? "
                + "WHERE passenger_id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, passenger.getPassengerName());
            ps.setInt(2, passenger.getAge());
            ps.setString(3, passenger.getGender());
            ps.setString(4, passenger.getMobile());
            ps.setInt(5, passenger.getPassengerId());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println(
                        "Passenger Updated Successfully.");
            } else {
                System.out.println("Passenger Not Found.");
            }

        } catch (SQLException e) {

            System.out.println(
                    "Error while updating passenger.");

            e.printStackTrace();
        }
    }

    // =========================================================
    // BOOKING OPERATIONS
    // =========================================================

    @Override
    public void bookTicket(Booking booking) {

        String checkPassenger =
                "SELECT passenger_id FROM passenger "
                + "WHERE passenger_id = ?";

        String checkTrain =
                "SELECT available_seats FROM train "
                + "WHERE train_id = ?";

        String insertBooking =
                "INSERT INTO booking "
                + "(pnr_number, passenger_id, train_id, coach, "
                + "seat_number, status) "
                + "VALUES (?, ?, ?, ?, ?, ?)";

        String updateSeats =
                "UPDATE train "
                + "SET available_seats = available_seats - 1 "
                + "WHERE train_id = ? "
                + "AND available_seats > 0";

        Connection con = null;

        try {

            con = DBConnection.getConnection();

            // Start transaction
            con.setAutoCommit(false);

            // ---------------------------------------------
            // Check Passenger
            // ---------------------------------------------

            try (PreparedStatement ps =
                    con.prepareStatement(checkPassenger)) {

                ps.setInt(1, booking.getPassengerId());

                try (ResultSet rs = ps.executeQuery()) {

                    if (!rs.next()) {

                        System.out.println(
                                "Passenger Not Found.");

                        con.rollback();
                        return;
                    }
                }
            }

            // ---------------------------------------------
            // Check Train
            // ---------------------------------------------

            try (PreparedStatement ps =
                    con.prepareStatement(checkTrain)) {

                ps.setInt(1, booking.getTrainId());

                try (ResultSet rs = ps.executeQuery()) {

                    if (!rs.next()) {

                        System.out.println(
                                "Train Not Found.");

                        con.rollback();
                        return;
                    }

                    int seats =
                            rs.getInt("available_seats");

                    if (seats <= 0) {

                        System.out.println(
                                "No Seats Available.");

                        con.rollback();
                        return;
                    }
                }
            }

            // ---------------------------------------------
            // Insert Booking
            // ---------------------------------------------

            try (PreparedStatement ps =
                    con.prepareStatement(insertBooking)) {

                ps.setInt(1, booking.getPnrNumber());
                ps.setInt(2, booking.getPassengerId());
                ps.setInt(3, booking.getTrainId());
                ps.setString(4, booking.getCoach());
                ps.setInt(5, booking.getSeatNumber());
                ps.setString(6, booking.getStatus());

                ps.executeUpdate();
            }

            // ---------------------------------------------
            // Reduce Available Seat
            // ---------------------------------------------

            try (PreparedStatement ps =
                    con.prepareStatement(updateSeats)) {

                ps.setInt(1, booking.getTrainId());

                ps.executeUpdate();
            }

            // Commit transaction
            con.commit();

            System.out.println(
                    "Ticket Booked Successfully.");

        } catch (SQLException e) {

            try {

                if (con != null) {
                    con.rollback();
                }

            } catch (SQLException rollbackException) {
                rollbackException.printStackTrace();
            }

            System.out.println(
                    "Booking Failed.");

            e.printStackTrace();

        } finally {

            try {

                if (con != null) {
                    con.setAutoCommit(true);
                    con.close();
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Booking> getAllBookings() {

        List<Booking> bookingList = new ArrayList<>();

        String sql = "SELECT * FROM booking";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Booking booking = new Booking();

                booking.setPnrNumber(
                        rs.getInt("pnr_number"));

                booking.setPassengerId(
                        rs.getInt("passenger_id"));

                booking.setTrainId(
                        rs.getInt("train_id"));

                booking.setCoach(
                        rs.getString("coach"));

                booking.setSeatNumber(
                        rs.getInt("seat_number"));

                booking.setStatus(
                        rs.getString("status"));

                bookingList.add(booking);
            }

        } catch (SQLException e) {

            System.out.println(
                    "Error while fetching bookings.");

            e.printStackTrace();
        }

        return bookingList;
    }

    @Override
    public Booking searchBooking(int pnrNumber) {

        Booking booking = null;

        String sql =
                "SELECT * FROM booking WHERE pnr_number = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, pnrNumber);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {

                    booking = new Booking();

                    booking.setPnrNumber(
                            rs.getInt("pnr_number"));

                    booking.setPassengerId(
                            rs.getInt("passenger_id"));

                    booking.setTrainId(
                            rs.getInt("train_id"));

                    booking.setCoach(
                            rs.getString("coach"));

                    booking.setSeatNumber(
                            rs.getInt("seat_number"));

                    booking.setStatus(
                            rs.getString("status"));
                }
            }

        } catch (SQLException e) {

            System.out.println(
                    "Error while searching booking.");

            e.printStackTrace();
        }

        return booking;
    }

    @Override
    public void cancelTicket(int pnrNumber) {

        String findBooking =
                "SELECT train_id, status FROM booking "
                + "WHERE pnr_number = ?";

        String updateBooking =
                "UPDATE booking "
                + "SET status = 'Cancelled' "
                + "WHERE pnr_number = ?";

        String increaseSeat =
                "UPDATE train "
                + "SET available_seats = available_seats + 1 "
                + "WHERE train_id = ?";

        Connection con = null;

        try {

            con = DBConnection.getConnection();

            con.setAutoCommit(false);

            int trainId;
            String status;

            // ---------------------------------------------
            // Find Booking
            // ---------------------------------------------

            try (PreparedStatement ps =
                    con.prepareStatement(findBooking)) {

                ps.setInt(1, pnrNumber);

                try (ResultSet rs = ps.executeQuery()) {

                    if (!rs.next()) {

                        System.out.println(
                                "Booking Not Found.");

                        con.rollback();
                        return;
                    }

                    trainId = rs.getInt("train_id");
                    status = rs.getString("status");
                }
            }

            // ---------------------------------------------
            // Check Status
            // ---------------------------------------------

            if ("Cancelled".equalsIgnoreCase(status)) {

                System.out.println(
                        "Ticket is already cancelled.");

                con.rollback();
                return;
            }

            // ---------------------------------------------
            // Cancel Booking
            // ---------------------------------------------

            try (PreparedStatement ps =
                    con.prepareStatement(updateBooking)) {

                ps.setInt(1, pnrNumber);

                ps.executeUpdate();
            }

            // ---------------------------------------------
            // Increase Available Seat
            // ---------------------------------------------

            try (PreparedStatement ps =
                    con.prepareStatement(increaseSeat)) {

                ps.setInt(1, trainId);

                ps.executeUpdate();
            }

            con.commit();

            System.out.println(
                    "Ticket Cancelled Successfully.");

        } catch (SQLException e) {

            try {

                if (con != null) {
                    con.rollback();
                }

            } catch (SQLException rollbackException) {
                rollbackException.printStackTrace();
            }

            System.out.println(
                    "Error while cancelling ticket.");

            e.printStackTrace();

        } finally {

            try {

                if (con != null) {
                    con.setAutoCommit(true);
                    con.close();
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}