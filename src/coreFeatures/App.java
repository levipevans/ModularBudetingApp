package coreFeatures;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class App {
    static boolean shouldRun = false;
    static Scanner scanner = new Scanner(System.in);
    static User user = null;
    static String input;

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {

        loadUser();
        initUser();
        mainLoop();
    }

    private static void mainLoop() {
        while (shouldRun) {
            // relying on switch/case
        }
    }

    private static void initUser() {
        while (user == null) {
            System.out.println("Hello and welcome to Modular Budgeting App!");
            System.out.println(
                    "What would you like to do?\n (1) create a new user\n (2) provide the path to a previously saved user\n (3) exit");
            input = Integer.toString(scanner.nextInt());
            scanner.nextLine();
            switch (Integer.parseInt(input)) {
                case 1:
                    user = createNewUser();
                    saveUser();
                    break;
                case 2:
                    System.out.print("provide path to saved user: ");
                    input = scanner.nextLine();
                    loadUser(input);
                    break;
                case 3:
                    shouldRun = false;
                    break;
                default:
                    System.out.printf("Sorry %s is not a valid input try entering 1, 2, or 3\n", input);

            }
        }
        
    }

    private static User createNewUser() {
        User user = new User();
        System.out.println("To begin creating a new user enter your name: ");
        input = scanner.nextLine();
        user.setName(input);
        return user;
    }
    
    private static void saveUser() {
        try (
        ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream("./user.ser"))) {
            stream.writeObject(user);
            stream.close();
        } catch (IOException e) {
            System.out.println("error on App.saveUser(): ");
            e.printStackTrace();
        }
    }

    private static void loadUser() {
        try (
        ObjectInputStream stream = new ObjectInputStream(new FileInputStream("./user.ser"))) {
            user = (User) stream.readObject();
            stream.close();
        } catch (ClassNotFoundException | IOException e) {
            System.out.println("error on App.loadUser(): ");
            e.printStackTrace();
        }
    }

    private static void loadUser(String path) {
        try (
        ObjectInputStream stream = new ObjectInputStream(new FileInputStream(path))) {
            user = (User) stream.readObject();
            stream.close();
        } catch (ClassNotFoundException | IOException e) {
            System.out.println("error on App.loadUser(String path): ");
            e.printStackTrace();
        }
    }
}
