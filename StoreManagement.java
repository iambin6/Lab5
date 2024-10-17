package controller;

import model.Bicycle;
import model.Bi_Store;

import java.util.List;
import java.util.Scanner;

public class StoreManagement {
    private Bi_Store store;
    private Scanner scanner;

    public StoreManagement() {
        store = new Bi_Store();
        scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Display all bicycles");
            System.out.println("2. Add new bicycle");
            System.out.println("3. Delete a bicycle");
            System.out.println("4. Search for the least time to move");
            System.out.println("5. Print bicycles by production year");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    displayAll();
                    break;
                case 2:
                    doAddBicycle();
                    break;
                case 3:
                    doDeleteBicycle();
                    break;
                case 4:
                    searchForLeastTimeToMove();
                    break;
                case 5:
                    printBicyclesByYear();
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    public void doAddBicycle() {
        System.out.print("Enter Bicycle ID: ");
        String bicycleId = scanner.next();
        System.out.print("Enter speed: ");
        int speed = scanner.nextInt();
        System.out.print("Enter distance: ");
        double distance = scanner.nextDouble();
        System.out.print("Is it an electric bicycle (true/false): ");
        boolean isElectric = scanner.nextBoolean();
        System.out.print("Enter production date (dd/MM/yyyy): ");
        String productionDate = scanner.next();

        Bicycle bicycle = new Bicycle(bicycleId, speed, distance, isElectric, productionDate);
        store.addBicycle(bicycle);
        System.out.println("Bicycle added successfully.");
    }

    public void doDeleteBicycle() {
        System.out.print("Enter Bicycle ID to delete: ");
        String bicycleId = scanner.next();
        if (store.deleteBicycle(bicycleId)) {
            System.out.println("Bicycle deleted successfully.");
        } else {
            System.out.println("Bicycle not found.");
        }
    }

    public void displayAll() {
        List<Bicycle> bicycles = store.getBicycles();
        bicycles.sort((b1, b2) -> Integer.compare(b1.getSpeed(), b2.getSpeed()));
        for (Bicycle bicycle : bicycles) {
            System.out.println(bicycle);
        }
    }

    public void searchForLeastTimeToMove() {
        Bicycle bicycle = store.searchForLeastTimeToMove();
        if (bicycle != null) {
            System.out.println("Bicycle with least time to move: " + bicycle);
        } else {
            System.out.println("No bicycles found.");
        }
    }

    public void printBicyclesByYear() {
        System.out.print("Enter production year: ");
        int year = scanner.nextInt();
        List<Bicycle> bicycles = store.getBicyclesByYear(year);
        if (!bicycles.isEmpty()) {
            for (Bicycle bicycle : bicycles) {
                System.out.println(bicycle);
            }
        } else {
            System.out.println("No bicycles found for the year " + year);
        }
    }

    public static void main(String[] args) {
        StoreManagement management = new StoreManagement();
        management.displayMenu();
    }
}