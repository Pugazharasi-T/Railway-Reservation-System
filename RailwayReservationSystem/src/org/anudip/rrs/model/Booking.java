package org.anudip.rrs.model;

public class Booking {

    private int pnrNumber;
    private int passengerId;
    private int trainId;
    private String coach;
    private int seatNumber;
    private String status;

    public Booking() {

    }

    public Booking(int pnrNumber,
            int passengerId,
            int trainId,
            String coach,
            int seatNumber,
            String status) {

        this.pnrNumber = pnrNumber;
        this.passengerId = passengerId;
        this.trainId = trainId;
        this.coach = coach;
        this.seatNumber = seatNumber;
        this.status = status;
    }

    public int getPnrNumber() {
        return pnrNumber;
    }

    public void setPnrNumber(int pnrNumber) {
        this.pnrNumber = pnrNumber;
    }

    public int getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(int passengerId) {
        this.passengerId = passengerId;
    }

    public int getTrainId() {
        return trainId;
    }

    public void setTrainId(int trainId) {
        this.trainId = trainId;
    }

    public String getCoach() {
        return coach;
    }

    public void setCoach(String coach) {
        this.coach = coach;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {

        return pnrNumber + "\t"
                + passengerId + "\t"
                + trainId + "\t"
                + coach + "\t"
                + seatNumber + "\t"
                + status;
    }

}