package org.anudip.rrs.model;

public class Train {

    private int trainId;
    private String trainName;
    private String source;
    private String destination;
    private double fare;
    private int availableSeats;

    public Train() {

    }

    public Train(int trainId, String trainName, String source,
            String destination, double fare, int availableSeats) {

        this.trainId = trainId;
        this.trainName = trainName;
        this.source = source;
        this.destination = destination;
        this.fare = fare;
        this.availableSeats = availableSeats;
    }

    public int getTrainId() {
        return trainId;
    }

    public void setTrainId(int trainId) {
        this.trainId = trainId;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public double getFare() {
        return fare;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    @Override
    public String toString() {

        return trainId + "\t" + trainName + "\t" + source + "\t"
                + destination + "\t" + fare + "\t" + availableSeats;
    }

}