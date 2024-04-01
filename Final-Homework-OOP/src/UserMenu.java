import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UserMenu {
    private Scanner scanner;

    public UserMenu() {
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("Welcome! You have an amazing opportunity to create a new human!");
        System.out.println("Please select the type of human you want to create:");
        System.out.println("1. Just a human (gender unknown)");
        System.out.println("2. Man");
        System.out.println("3. Woman");

        int choice = 0;
        boolean validChoice = false;

        while (!validChoice) {
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
                if (choice >= 1 && choice <= 3) {
                    validChoice = true;
                } else {
                    System.out.println("Invalid choice. Please enter a number between 1 and 3:");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 3:");
                scanner.nextLine();
            }
        }

        Human human = createHuman(choice);

        saveHumanToFile(human);

        Human loadedHuman = loadHumanFromFile();
        if (loadedHuman != null) {
            System.out.println("\nCreated human:");
            System.out.println("Name: " + loadedHuman.getName());
            System.out.println("Surname: " + loadedHuman.getSurname());
            System.out.println("Weight: " + loadedHuman.getWeight());
            System.out.println("Height: " + loadedHuman.getHeight());
            System.out.println("Gender: " + loadedHuman.getGender());
        } else {
            System.out.println("\nNo Human data found in file.");
        }

        if (human != null) {
            human.presentYourself();
            human.describeYourself();
        } else {
            System.out.println("\nNo Human data found in file.");
        }
    }

    private Human createHuman(int choice) {
        String name = "";
        String surname = "";
        String weight = "";
        String height = "";
        String gender = "N/A";

        boolean validName = false;
        boolean validSurname = false;
        boolean validWeight = false;
        boolean validHeight = false;

        while (!validName) {
            System.out.println("Enter the name:");
            name = scanner.nextLine();
            if (name.matches("[A-Za-z\\-\\. ]+")) {
                validName = true;
            } else {
                System.out.println("Invalid input. Please enter a name using only letters, dashes, dots, or spaces.");
            }
        }

        while (!validSurname) {
            System.out.println("Enter the surname:");
            surname = scanner.nextLine();
            if (surname.matches("[A-Za-z\\-\\. ]+")) {
                validSurname = true;
            } else {
                System.out.println("Invalid input. Please enter a surname using only letters, dashes, dots, or spaces.");
            }
        }

        while (!validWeight) {
            System.out.println("Enter the weight:");
            weight = scanner.nextLine();
            if (weight.matches("[0-9\\.]+")) {
                validWeight = true;
            } else {
                System.out.println("Invalid input. Please enter weight using only numbers and dots.");
            }
        }

        while (!validHeight) {
            System.out.println("Enter the height:");
            height = scanner.nextLine();
            if (height.matches("[0-9\\.]+")) {
                validHeight = true;
            } else {
                System.out.println("Invalid input. Please enter height using only numbers and dots.");
            }
        }

        switch (choice) {
            case 1:
                return new Human(name, surname, weight, height, gender);
            case 2:
                return new Men(name, surname, weight, height, gender);
            case 3:
                return new Women(name, surname, weight, height, gender);
            default:
                System.out.println("Invalid choice. Creating a default Human.");
                return new Human(name, surname, weight, height, gender);
        }
    }

    public void saveHumanToFile(Human human) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("createdObjects.txt", true))) {
            writer.println(human.getName());
            writer.println(human.getSurname());
            writer.println(human.getWeight());
            writer.println(human.getHeight());
            writer.println(human.getGender());
            System.out.println("Human data saved to file.");
        } catch (IOException e) {
            System.out.println("Error occurred while saving human data to file.");
            e.printStackTrace();
        }
    }

    public Human loadHumanFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("createdObjects.txt"))) {
            String name = null;
            String surname = null;
            String weight = null;
            String height = null;
            String gender = null;
            String line;
            while ((line = reader.readLine()) != null) {
                name = line;
                surname = reader.readLine();
                weight = reader.readLine();
                height = reader.readLine();
                gender = reader.readLine();
            }
            System.out.println("Loaded from file.");
            if (gender != null) {
                switch (gender) {
                    case "Man":
                        return new Men(name, surname, weight, height, gender);
                    case "Woman":
                        return new Women(name, surname, weight, height, gender);
                    case "N/A":
                        return new Human(name, surname, weight, height, gender);
                    default:
                        System.out.println("Not found in file.");;
                }
            }
        } catch (IOException e) {
            System.out.println("Error occurred while loading human data from file.");
            e.printStackTrace();
        }
        return null;
    }
}
