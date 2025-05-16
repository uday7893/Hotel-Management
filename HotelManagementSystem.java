import java.util.Scanner;

public class HotelManagementSystem {

    // Array to store hotel rooms: [Room Number, Guest Info]
    private static String[][] rooms = new String[10][2];
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Initialize hotel rooms
        for (int i = 0; i < rooms.length; i++) {
            rooms[i][0] = String.valueOf(i + 1); // Room number
            rooms[i][1] = "Empty"; // Guest info
        }

        // Display hotel menu
        while (true) {
            System.out.println("\nWelcome to the Hotel Management System\n");
            System.out.println("1. Check-In");
            System.out.println("2. Check-Out");
            System.out.println("3. View Occupancy");
            System.out.println("4. Exit");
            System.out.print("\nEnter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkIn();
                    break;
                case 2:
                    checkOut();
                    break;
                case 3:
                    viewOccupancy();
                    break;
                case 4:
                    System.out.println("Exiting... Thank you!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("\nInvalid choice. Please try again.");
                    break;
            }
        }
    }

    // Method to check-in guests
    private static void checkIn() {
        System.out.print("\nEnter room number (1-10): ");
        int roomNumber = scanner.nextInt() - 1;
        scanner.nextLine(); // Clear the buffer

        if (roomNumber >= 0 && roomNumber < rooms.length) {
            if (rooms[roomNumber][1].equals("Empty")) {
                System.out.print("Enter guest name: ");
                String name = scanner.nextLine();

                System.out.print("Enter age: ");
                int age = scanner.nextInt();
                scanner.nextLine(); // Clear the buffer

                System.out.print("Enter sex (Male/Female): ");
                String sex = scanner.nextLine();

                System.out.print("Enter ID number (Govt issued): ");
                String id = scanner.nextLine();

                String guestInfo = "Name: " + name + ", Age: " + age + ", Sex: " + sex + ", ID: " + id;
                rooms[roomNumber][1] = guestInfo;

                System.out.println("\nCheck-in successful.");
            } else {
                System.out.println("\nSorry, this room is already occupied.");
            }
        } else {
            System.out.println("\nInvalid room number. Please try again.");
        }
    }

    // Method to check-out guests
    private static void checkOut() {
        System.out.print("\nEnter room number (1-10): ");
        int roomNumber = scanner.nextInt() - 1;

        if (roomNumber >= 0 && roomNumber < rooms.length) {
            if (!rooms[roomNumber][1].equals("Empty")) {
                System.out.println("\nGuest from room " + rooms[roomNumber][0] + " has checked out.");
                rooms[roomNumber][1] = "Empty";
            } else {
                System.out.println("\nSorry, this room is already vacant.");
            }
        } else {
            System.out.println("\nInvalid room number. Please try again.");
        }
    }

    // Method to view occupancy status
    private static void viewOccupancy() {
        System.out.println("\nRoom\tGuest Info");
        for (int i = 0; i < rooms.length; i++) {
            System.out.println(rooms[i][0] + "\t" + rooms[i][1]);
        }
    }
}
