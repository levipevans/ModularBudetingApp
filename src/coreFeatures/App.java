package coreFeatures;

import java.io.File;
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
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException{

        
        loadUser();
        while(user == null){
            System.out.println("Hello and welcome to Modular Budgeting App!");
            System.out.println("What would you like to do?\n (1) create a new user\n (2) provide the path to a previously saved user\n (3) exit");
            input = Integer.toString(scanner.nextInt());
            scanner.nextLine();
            switch(Integer.parseInt(input)){
                case 1: user = createNewUser();
                        saveUser();
                        break;
                case 2: System.out.print("provide path to saved user: ");
                        input = scanner.nextLine();
                        loadUser(input);
                        break;
                case 3: shouldRun = false;
                        break;

            }
        }
        while(shouldRun){
            
        }
    }

    
    private static void saveUser() throws FileNotFoundException, IOException {
        ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream("./user.ser"));

        stream.writeObject(user);
        stream.close();
    }


    private static User createNewUser() {
        //TODO: implement createNewUser(). This should guide the user through initializing their User.java object.
        User user = new User();
        System.out.println("To begin creating a new user enter your name: ");
        input = scanner.nextLine();
        user.setName(input);
        return user;
    }
    
    private static void loadUser() throws FileNotFoundException, IOException, ClassNotFoundException {
        //TODO: implement loadUser() this should be the default logic for loading a user from a program-defined location.
        ObjectInputStream stream = new ObjectInputStream(new FileInputStream("./user.ser"));
        user = (User)stream.readObject();
        stream.close();
    }
    private static void loadUser(String input) {
        //TODO: This overload of loadUser is responsible for loading the user from a user-defined path.
    }
}
