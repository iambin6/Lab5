package model;

import java.util.ArrayList;
import java.util.List;

public class Bi_Store {
    private List<Bicycle> bicycles;

    // Constructor to initialize the list and add 5 bicycles
    public Bi_Store() {
        bicycles = new ArrayList<>();
        bicycles.add(new Bicycle("B001", 25, 150, true, "15/03/2022"));
        bicycles.add(new Bicycle("B002", 30, 20, false, "20/06/2021"));
        bicycles.add(new Bicycle("B003", 22, 100, false, "05/05/2023"));
        bicycles.add(new Bicycle("B004", 28, 80, true, "10/01/2020"));
        bicycles.add(new Bicycle("B005", 24, 120, false, "17/11/2022"));
    }

    // Method to add a new bicycle
    public void addBicycle(Bicycle bicycle) {
        bicycles.add(bicycle);
    }

    // Method to delete a bicycle by ID
    public boolean deleteBicycle(String bicycleId) {
        return bicycles.removeIf(b -> b.getBicycleId().equals(bicycleId));
    }

    // Method to find the bicycle with the least time to move
    public Bicycle searchForLeastTimeToMove() {
        return bicycles.stream()
                .min((b1, b2) -> Double.compare(b1.getDistance() / b1.getSpeed(), b2.getDistance() / b2.getSpeed()))
                .orElse(null);
    }

    // Method to print the list of bicycles
    public List<Bicycle> getBicycles() {
        return bicycles;
    }

    // Method to get the bicycles produced in a certain year
    public List<Bicycle> getBicyclesByYear(int year) {
        List<Bicycle> result = new ArrayList<>();
        for (Bicycle b : bicycles) {
            if (b.getProductionDate().getYear() == year) {
                result.add(b);
            }
        }
        return result;
    }
}