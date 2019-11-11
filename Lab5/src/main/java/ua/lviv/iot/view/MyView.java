package ua.lviv.iot.view;

import ua.lviv.iot.controller.Controller;
import ua.lviv.iot.controller.ControllerImpl;

import java.sql.SQLException;
import java.sql.Date;
import java.sql.Time;
import java.util.Scanner;

public class MyView {
    private static Controller controller;
    private static String submenu =
            "\t1 - Find all\n\t2 - Find by id\n\t3 - Create\n\t4 - Update\n\t5 - Delete\n\tQ - Go back\n";

    public MyView() {
        controller = new ControllerImpl();
    }

    public void show() throws SQLException {
        String menuPoint;
        do {
            System.out.println("Press ENTER key to continue...");
            new Scanner(System.in).nextLine();

            outputMenu();
            System.out.print("\nPlease, select menu point: ");
            menuPoint = new Scanner(System.in).nextLine().toUpperCase();

            switch (menuPoint) {
                case "1":
                    workWithHousehold();
                    break;
                case "2":
                    workWithOutput();
                    break;
                case "3":
                    workWithOwner();
                    break;
                case "4":
                    workWithPanel();
                    break;
                case "5":
                    workWithPanelData();
                    break;
                case "6":
                    workWithPrice();
                    break;
                case "7":
                    workWithStation();
                    break;
                case "8":
                    workWithOwnerHasStation();
                    break;
                case "9":
                    workWithStationHasHousehold();
                    break;
                case "Q":
                    System.out.println("\n\nDone!");
                    break;
                default:
                    System.out.println("Menu point does not exist!");
            }
        } while (!menuPoint.equals("Q"));
    }

    private void outputMenu() {
        System.out.println("\t\tMenu");
        System.out.println("(Choose Table to work with:)");
        System.out.print("\t1 - Household\n" + "\t2 - Output\n" + "\t3 - Owner\n" + "\t4 - Panel\n" + "\t5 - PanelData\n" +
                "\t6 - Price\n" + "\t7 - Station\n" + "\t8 - OwnerHasStation\n" + "\t9 - StationHasHousehold\n" + "\tQ - Exit\n");
    }

    private void workWithHousehold() throws SQLException {
        System.out.println("\tTable 'household'");
        System.out.println(submenu);
        System.out.print("Select point: ");
        switch (new Scanner(System.in).nextLine().toUpperCase()) {
            case "1":
                controller.findAllHousehold();
                break;
            case "2":
                System.out.print("Enter id: ");
                controller.findHouseholdById(new Scanner(System.in).nextInt());
                break;
            case "3":
                System.out.print("Enter name: ");
                String name = new Scanner(System.in).nextLine();
                controller.createHousehold(name);
                break;
            case "4":
                System.out.print("Enter id: ");
                Integer id = new Scanner(System.in).nextInt();
                System.out.print("Enter name: ");
                name = new Scanner(System.in).nextLine();
                controller.updateHousehold(id, name);
                break;
            case "5":
                System.out.print("Enter id: ");
                controller.deleteHousehold(new Scanner(System.in).nextInt());
                break;
            case "Q":
                break;
            default:
                System.out.println("Try again!");
        }
    }

    private void workWithOutput() throws SQLException {
        System.out.println("\tTable 'output'");
        System.out.println(submenu);
        System.out.print("Select point: ");
        switch (new Scanner(System.in).nextLine().toUpperCase()) {
            case "1":
                controller.findAllOutput();
                break;
            case "2":
                System.out.print("Enter id: ");
                controller.findOutputById(new Scanner(System.in).nextInt());
                break;
            case "3":
                System.out.print("Enter powerPerHour: ");
                Integer powerPerHour = new Scanner(System.in).nextInt();
                System.out.print("Enter timeStart: ");
                Date timeStart = new Date(System.currentTimeMillis()).valueOf(new Scanner(System.in).nextLine());
                System.out.print("Enter timeEnd: ");
                Date timeEnd = new Date(System.currentTimeMillis()).valueOf(new Scanner(System.in).nextLine());
                System.out.print("Enter stationId: ");
                Integer stationId = new Scanner(System.in).nextInt();
                System.out.print("Enter priceId: ");
                Integer priceId = new Scanner(System.in).nextInt();
                controller.createOutput(powerPerHour, timeStart, timeEnd, stationId, priceId);
                break;
            case "4":
                System.out.println("Enter id: ");
                Integer id = new Scanner(System.in).nextInt();
                System.out.print("Enter powerPerHour: ");
                powerPerHour = new Scanner(System.in).nextInt();
                System.out.print("Enter timeStart: ");
                timeStart = new Date(System.currentTimeMillis()).valueOf(new Scanner(System.in).nextLine());
                System.out.print("Enter timeEnd: ");
                timeEnd = new Date(System.currentTimeMillis()).valueOf(new Scanner(System.in).nextLine());
                System.out.print("Enter stationId: ");
                stationId = new Scanner(System.in).nextInt();
                System.out.print("Enter priceId: ");
                priceId = new Scanner(System.in).nextInt();
                controller.updateOutput(id, powerPerHour, timeStart, timeEnd, stationId, priceId);
                break;
            case "5":
                System.out.print("Enter id: ");
                controller.deleteOutput(new Scanner(System.in).nextInt());
                break;
            case "Q":
                break;
            default:
                System.out.println("Try again!");
        }
    }

    private void workWithOwner() throws SQLException {
        System.out.println("\tTable 'owner'");
        System.out.println(submenu);
        System.out.print("Select point: ");
        switch (new Scanner(System.in).nextLine().toUpperCase()) {
            case "1":
                controller.findAllOwner();
                break;
            case "2":
                System.out.print("Enter id: ");
                controller.findOwnerById(new Scanner(System.in).nextInt());
                break;
            case "3":
                System.out.print("Enter firstName: ");
                String firstName = new Scanner(System.in).nextLine();
                System.out.print("Enter LastName: ");
                String lastName = new Scanner(System.in).nextLine();
                controller.createOwner(firstName, lastName);
                break;
            case "4":
                System.out.println("Enter id: ");
                Integer id = new Scanner(System.in).nextInt();
                System.out.print("Enter firstName: ");
                firstName = new Scanner(System.in).nextLine();
                System.out.print("Enter LastName: ");
                lastName = new Scanner(System.in).nextLine();
                controller.updateOwner(id, firstName, lastName);
                break;
            case "5":
                System.out.print("Enter id: ");
                controller.deleteOwner(new Scanner(System.in).nextInt());
                break;
            case "Q":
                break;
            default:
                System.out.println("Try again!");
        }
    }

    private void workWithPanel() throws SQLException {
        System.out.println("\tTable 'panel'");
        System.out.println(submenu);
        System.out.print("Select point: ");
        switch (new Scanner(System.in).nextLine().toUpperCase()) {
            case "1":
                controller.findAllPanel();
                break;
            case "2":
                System.out.print("Enter id: ");
                controller.findPanelById(new Scanner(System.in).nextInt());
                break;
            case "3":
                System.out.print("Enter type: ");
                String type = new Scanner(System.in).nextLine();
                System.out.print("Enter capacity: ");
                Integer capacity = new Scanner(System.in).nextInt();
                System.out.println("Enter stationId");
                Integer stationId = new Scanner(System.in).nextInt();
                controller.createPanel(type, capacity, stationId);
                break;
            case "4":
                System.out.println("Enter id: ");
                Integer id = new Scanner(System.in).nextInt();
                System.out.print("Enter type: ");
                type = new Scanner(System.in).nextLine();
                System.out.print("Enter capacity: ");
                capacity = new Scanner(System.in).nextInt();
                System.out.println("Enter stationId: ");
                stationId = new Scanner(System.in).nextInt();
                controller.updatePanel(id, type, capacity, stationId);
                break;
            case "5":
                System.out.print("Enter id: ");
                controller.deletePanel(new Scanner(System.in).nextInt());
                break;
            case "Q":
                break;
            default:
                System.out.println("Try again!");
        }
    }

    private void workWithPanelData() throws SQLException {
        System.out.println("\tTable 'panel_data'");
        System.out.println(submenu);
        System.out.print("Select point: ");
        switch (new Scanner(System.in).nextLine().toUpperCase()) {
            case "1":
                controller.findAllPanelData();
                break;
            case "2":
                System.out.print("Enter id: ");
                controller.findPanelDataById(new Scanner(System.in).nextInt());
                break;
            case "3":
                System.out.print("Enter date: ");
                Date date = new Date(System.currentTimeMillis()).valueOf(new Scanner(System.in).nextLine());
                System.out.print("Enter angle: ");
                Integer angle = new Scanner(System.in).nextInt();
                System.out.println("Enter power");
                Integer power = new Scanner(System.in).nextInt();
                System.out.println("Enter chargeLevel");
                Integer chargeLevel = new Scanner(System.in).nextInt();
                System.out.println("Enter panelId");
                Integer panelId = new Scanner(System.in).nextInt();
                controller.createPanelData(date, angle, power, chargeLevel, panelId);
                break;
            case "4":
                System.out.println("Enter Id: ");
                Integer id = new Scanner(System.in).nextInt();
                System.out.print("Enter date: ");
                date = new Date(System.currentTimeMillis()).valueOf(new Scanner(System.in).nextLine());
                System.out.print("Enter angle: ");
                angle = new Scanner(System.in).nextInt();
                System.out.println("Enter power");
                power = new Scanner(System.in).nextInt();
                System.out.println("Enter chargeLevel");
                chargeLevel = new Scanner(System.in).nextInt();
                System.out.println("Enter panelId");
                panelId = new Scanner(System.in).nextInt();
                controller.updatePanelData(id, date, angle, power, chargeLevel, panelId);
                break;
            case "5":
                System.out.print("Enter id: ");
                controller.deletePanelData(new Scanner(System.in).nextInt());
                break;
            case "Q":
                break;
            default:
                System.out.println("Try again!");
        }
    }

    private void workWithPrice() throws SQLException {
        System.out.println("\tTable 'price'");
        System.out.println(submenu);
        System.out.print("Select point: ");
        switch (new Scanner(System.in).nextLine().toUpperCase()) {
            case "1":
                controller.findAllPrice();
                break;
            case "2":
                System.out.print("Enter id: ");
                controller.findPriceById(new Scanner(System.in).nextInt());
                break;
            case "3":
                System.out.print("Enter value: ");
                Integer value = new Scanner(System.in).nextInt();
                System.out.println("Enter timeOfPriceBegin: ");
                Time timeOfPriceBegin = new Time(System.currentTimeMillis()).valueOf(new Scanner(System.in).nextLine());
                System.out.println("Enter timeOfPriceEnd: ");
                Time timeOfPriceEnd = new Time(System.currentTimeMillis()).valueOf(new Scanner(System.in).nextLine());
                controller.createPrice(value, timeOfPriceBegin, timeOfPriceEnd);
                break;
            case "4":
                System.out.println("Enter Id: ");
                Integer id = new Scanner(System.in).nextInt();
                System.out.print("Enter value: ");
                value = new Scanner(System.in).nextInt();
                System.out.println("Enter timeOfPriceBegin: ");
                timeOfPriceBegin = new Time(System.currentTimeMillis()).valueOf(new Scanner(System.in).nextLine());
                System.out.println("Enter timeOfPriceEnd: ");
                timeOfPriceEnd = new Time(System.currentTimeMillis()).valueOf(new Scanner(System.in).nextLine());
                controller.updatePrice(id, value, timeOfPriceBegin, timeOfPriceEnd);
                break;
            case "5":
                System.out.print("Enter id: ");
                controller.deletePrice(new Scanner(System.in).nextInt());
                break;
            case "Q":
                break;
            default:
                System.out.println("Try again!");
        }
    }

    private void workWithStation() throws SQLException {
        System.out.println("\tTable 'station'");
        System.out.println(submenu);
        System.out.print("Select point: ");
        switch (new Scanner(System.in).nextLine().toUpperCase()) {
            case "1":
                controller.findAllStation();
                break;
            case "2":
                System.out.print("Enter id: ");
                controller.findStationById(new Scanner(System.in).nextInt());
                break;
            case "3":
                System.out.print("Enter numberOfPanels: ");
                Integer numberOfPanels = new Scanner(System.in).nextInt();
                System.out.println("Enter address: ");
                String address = new Scanner(System.in).nextLine();
                System.out.println("Enter timeOfUsage: ");
                Integer timeOfUsage = new Scanner(System.in).nextInt();
                controller.createStation(numberOfPanels, address, timeOfUsage);
                break;
            case "4":
                System.out.println("Enter Id: ");
                Integer id = new Scanner(System.in).nextInt();
                System.out.print("Enter numberOfPanels: ");
                numberOfPanels = new Scanner(System.in).nextInt();
                System.out.println("Enter address: ");
                address = new Scanner(System.in).nextLine();
                System.out.println("Enter timeOfUsage: ");
                timeOfUsage = new Scanner(System.in).nextInt();
                controller.updateStation(id, numberOfPanels, address, timeOfUsage);
                break;
            case "5":
                System.out.print("Enter id: ");
                controller.deleteStation(new Scanner(System.in).nextInt());
                break;
            case "Q":
                break;
            default:
                System.out.println("Try again!");
        }
    }

    private void workWithOwnerHasStation() throws SQLException {
        System.out.println("\tTable 'owner_has_station'");
        System.out.println("\t1 - Find all\n\t2 - Find by id\n\t3 - Create\n\t4 - Delete\n\tQ - Go back\n");
        System.out.print("Select point: ");
        switch (new Scanner(System.in).nextLine().toUpperCase()) {
            case "1":
                controller.findAllOwnerHasStation();
                break;
            case "2":
                System.out.print("Enter owner_id: ");
                Integer ownerId = new Scanner(System.in).nextInt();
                System.out.println("Enter station_id: ");
                controller.findOwnerHasStationById(ownerId, new Scanner(System.in).nextInt());
                break;
            case "3":
                System.out.print("Enter owner_id: ");
                ownerId = new Scanner(System.in).nextInt();
                System.out.println("Enter station_id: ");
                controller.createOwnerHasStation(ownerId, new Scanner(System.in).nextInt());
                break;
            case "4":
                System.out.print("Enter owner_id: ");
                ownerId = new Scanner(System.in).nextInt();
                System.out.println("Enter station_id: ");
                controller.deleteOwnerHasStation(ownerId, new Scanner(System.in).nextInt());
                break;
            case "Q":
                break;
            default:
                System.out.println("Try again!");
        }
    }

    private void workWithStationHasHousehold() throws SQLException {
        System.out.println("\tTable 'owner_has_station'");
        System.out.println("\t1 - Find all\n\t2 - Find by id\n\t3 - Create\n\t4 - Delete\n\tQ - Go back\n");
        System.out.print("Select point: ");
        switch (new Scanner(System.in).nextLine().toUpperCase()) {
            case "1":
                controller.findAllStationHasHousehold();
                break;
            case "2":
                System.out.print("Enter station_id: ");
                Integer stationId = new Scanner(System.in).nextInt();
                System.out.println("Enter household_id: ");
                controller.findStationHasHouseholdById(stationId, new Scanner(System.in).nextInt());
                break;
            case "3":
                System.out.print("Enter station_id: ");
                stationId = new Scanner(System.in).nextInt();
                System.out.println("Enter household_id: ");
                controller.createStationHasHousehold(stationId, new Scanner(System.in).nextInt());
                break;
            case "4":
                System.out.print("Enter station_id: ");
                stationId = new Scanner(System.in).nextInt();
                System.out.println("Enter household_id: ");
                controller.deleteStationHasHousehold(stationId, new Scanner(System.in).nextInt());
                break;
            case "Q":
                break;
            default:
                System.out.println("Try again!");
        }
    }
}
