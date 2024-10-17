package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Bicycle {
    private String bicycleId;
    private int speed;
    private double distance;
    private boolean isElectricBicycle;
    private LocalDate productionDate;

    // Constructor
    public Bicycle(String bicycleId, int speed, double distance, boolean isElectricBicycle, String productionDate) {
        this.bicycleId = bicycleId;
        this.speed = speed;
        this.distance = distance;
        this.isElectricBicycle = isElectricBicycle;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.productionDate = LocalDate.parse(productionDate, formatter);
    }

    // Getters and Setters
    public String getBicycleId() {
        return bicycleId;
    }

    public void setBicycleId(String bicycleId) {
        this.bicycleId = bicycleId;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public boolean isElectricBicycle() {
        return isElectricBicycle;
    }

    public void setElectricBicycle(boolean electricBicycle) {
        isElectricBicycle = electricBicycle;
    }

    public LocalDate getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(LocalDate productionDate) {
        this.productionDate = productionDate;
    }

    // Method to check if the bicycle needs recharging
    public String needToRecharge() {
        if (isElectricBicycle && distance > 60) {
            return "Need to recharge batteries";
        } else {
            return "Don’t need to recharge";
        }
    }

    // Override toString method
    @Override
    public String toString() {
        String bikeType = isElectricBicycle ? "E-Bicycle" : "Bicycle";
        return bikeType + " |" + bicycleId + " |" + speed + " |" + distance + " |" + needToRecharge() + " |" + productionDate;
    }
}