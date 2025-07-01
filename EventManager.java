import java.util.*;

class Event {
    int id;
    String title;
    String date;
    String description;

    Event(int id, String title, String date, String description) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.description = description;
    }
}

class Registration {
    String name;
    int eventId;

    Registration(String name, int eventId) {
        this.name = name;
        this.eventId = eventId;
    }
}

public class EventManager {
    static Scanner sc = new Scanner(System.in);
    static List<Event> events = new ArrayList<>();
    static List<Registration> registrations = new ArrayList<>();
    static int eventIdCounter = 1;

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1. Add Event\n2. View Events\n3. Register for Event\n4. View Registrations\n5. Exit");
            System.out.print("Choose an option: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1: addEvent(); break;
                case 2: viewEvents(); break;
                case 3: register(); break;
                case 4: viewRegistrations(); break;
                case 5: System.exit(0);
                default: System.out.println("Invalid choice.");
            }
        }
    }

    static void addEvent() {
        System.out.print("Enter title: ");
        String title = sc.nextLine();
        System.out.print("Enter date (YYYY-MM-DD): ");
        String date = sc.nextLine();
        System.out.print("Enter description: ");
        String desc = sc.nextLine();

        Event e = new Event(eventIdCounter++, title, date, desc);
        events.add(e);
        System.out.println("Event added!");
    }

    static void viewEvents() {
        if (events.isEmpty()) {
            System.out.println("No events found.");
        } else {
            for (Event e : events) {
                System.out.println("ID: " + e.id + ", Title: " + e.title + ", Date: " + e.date);
                System.out.println("Description: " + e.description + "\n");
            }
        }
    }

    static void register() {
        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        System.out.print("Enter event ID to register: ");
        int eventId = Integer.parseInt(sc.nextLine());

        boolean found = false;
        for (Event e : events) {
            if (e.id == eventId) {
                registrations.add(new Registration(name, eventId));
                System.out.println("Registered successfully!");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Event ID not found.");
        }
    }

    static void viewRegistrations() {
        if (registrations.isEmpty()) {
            System.out.println("No registrations found.");
        } else {
            for (Registration r : registrations) {
                System.out.println(r.name + " registered for event ID " + r.eventId);
            }
        }
    }
}
