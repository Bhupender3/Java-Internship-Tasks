import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class User {
    String loginId;
    String password;

    public User(String loginId, String password) {
        this.loginId = loginId;
        this.password = password;
    }
}

class Reservation {
    String pnr;
    String trainNumber;
    String trainName;
    String classType;
    String dateOfJourney;
    String from;
    String to;

    public Reservation(String pnr, String trainNumber, String trainName, String classType, String dateOfJourney, String from, String to) {
        this.pnr = pnr;
        this.trainNumber = trainNumber;
        this.trainName = trainName;
        this.classType = classType;
        this.dateOfJourney = dateOfJourney;
        this.from = from;
        this.to = to;
    }

    @Override
    public String toString() {
        return "PNR: " + pnr + "\n" +
               "Train Number: " + trainNumber + "\n" +
               "Train Name: " + trainName + "\n" +
               "Class Type: " + classType + "\n" +
               "Date of Journey: " + dateOfJourney + "\n" +
               "From: " + from + "\n" +
               "To: " + to;
    }
}

public class OnlineReservationSystem {
    private static Map<String, User> users = new HashMap<>();
    private static Map<String, Reservation> reservations = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        users.put("user1", new User("user1", "password1"));
        users.put("user2", new User("user2", "password2"));

        System.out.println("Welcome to the Online Reservation System");

        if (login()) {
            int option;
            do {
                System.out.println("\nMain Menu:");
                System.out.println("1. Make a Reservation");
                System.out.println("2. Cancel a Reservation");
                System.out.println("3. Exit");
                System.out.print("Choose an option: ");
                option = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (option) {
                    case 1:
                        makeReservation();
                        break;
                    case 2:
                        cancelReservation();
                        break;
                    case 3:
                        System.out.println("Thank you for using the Online Reservation System. Have a great day!");
                        break;
                    default:
                        System.out.println("Invalid option. Please choose again.");
                }
            } while (option != 3);
        } else {
            System.out.println("Invalid login. Exiting the system.");
        }
    }

    private static boolean login() {
        System.out.print("Enter login ID: ");
        String loginId = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        User user = users.get(loginId);
        if (user != null && user.password.equals(password)) {
            System.out.println("Login successful!");
            return true;
        } else {
            System.out.println("Login failed. Invalid login ID or password.");
            return false;
        }
    }

    private static void makeReservation() {
        System.out.print("Enter PNR number: ");
        String pnr = scanner.nextLine();
        System.out.print("Enter train number: ");
        String trainNumber = scanner.nextLine();
        System.out.print("Enter train name: ");
        String trainName = scanner.nextLine();
        System.out.print("Enter class type: ");
        String classType = scanner.nextLine();
        System.out.print("Enter date of journey: ");
        String dateOfJourney = scanner.nextLine();
        System.out.print("Enter departure location: ");
        String from = scanner.nextLine();
        System.out.print("Enter destination: ");
        String to = scanner.nextLine();

        reservations.put(pnr, new Reservation(pnr, trainNumber, trainName, classType, dateOfJourney, from, to));
        System.out.println("Reservation made successfully!");
    }

    private static void cancelReservation() {
        System.out.print("Enter PNR number: ");
        String pnr = scanner.nextLine();

        Reservation reservation = reservations.get(pnr);
        if (reservation != null) {
            System.out.println("Reservation found:");
            System.out.println(reservation);
            System.out.print("Do you want to cancel this reservation? (yes/no): ");
            String confirmation = scanner.nextLine();

            if (confirmation.equalsIgnoreCase("yes")) {
                reservations.remove(pnr);
                System.out.println("Reservation cancelled successfully!");
            } else {
                System.out.println("Cancellation aborted.");
            }
        } else {
            System.out.println("No reservation found with the given PNR number.");
        }
    }
}
