package org.anudip.rrs.main;

import java.util.Scanner;

import org.anudip.rrs.controller.RailwayController;

public class RailwayApp {

    public static void main(String[] args) {

        System.out.println("Starting Railway Reservation System...");

        Scanner sc = new Scanner(System.in);

        RailwayController controller = new RailwayController();

        int choice = 0;

        do {

            System.out.println();
            System.out.println("================================================");
            System.out.println("       RAILWAY RESERVATION SYSTEM");
            System.out.println("================================================");
            System.out.println("1.  Add Train");
            System.out.println("2.  View Trains");
            System.out.println("3.  Search Train");
            System.out.println("4.  Update Train");
            System.out.println("5.  Delete Train");
            System.out.println("6.  Add Passenger");
            System.out.println("7.  View Passengers");
            System.out.println("8.  Search Passenger");
            System.out.println("9.  Update Passenger");
            System.out.println("10. Book Ticket");
            System.out.println("11. View Bookings");
            System.out.println("12. Search Booking");
            System.out.println("13. Cancel Ticket");
            System.out.println("14. Exit");
            System.out.println("================================================");

            System.out.print("Enter Your Choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    controller.addTrain();
                    break;

                case 2:
                    controller.viewTrains();
                    break;

                case 3:
                    controller.searchTrain();
                    break;

                case 4:
                    controller.updateTrain();
                    break;

                case 5:
                    controller.deleteTrain();
                    break;

                case 6:
                    controller.addPassenger();
                    break;

                case 7:
                    controller.viewPassengers();
                    break;

                case 8:
                    controller.searchPassenger();
                    break;

                case 9:
                    controller.updatePassenger();
                    break;

                case 10:
                    controller.bookTicket();
                    break;

                case 11:
                    controller.viewBookings();
                    break;

                case 12:
                    controller.searchBooking();
                    break;

                case 13:
                    controller.cancelTicket();
                    break;

                case 14:
                    System.out.println(
                            "Thank you for using Railway Reservation System.");
                    break;

                default:
                    System.out.println(
                            "Invalid choice. Please try again.");
            }

        } while (choice != 14);

        sc.close();
    }
}