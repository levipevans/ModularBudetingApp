package coreFeatures;

import java.util.Scanner;

public class App {
        static boolean shouldRun = true;
        static Scanner scanner = new Scanner(System.in);
        static User user = null;
        static String input;
    public static void main(String[] args){

        
        loadUser();
        while(user == null){
            System.out.println("Hello and welcome to Modular Budgeting App!");
            System.out.print("What would you like to do?\n (1) create a new user\n (2) provide the path to a previously saved user\n (3) exit");
            input = Integer.toString(scanner.nextInt());
            switch(Integer.parseInt(input)){
                case 1: user = createNewUser();
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

    
    private static User createNewUser() {
        //TODO: implement createNewUser(). This should guide the user through initializing their User.java object.
        User user = new User();
        System.out.println("To begin creating a new user enter your name: ");
        user.setName(scanner.nextLine());
        
        return user;
    }
    
    private static void loadUser() {
        //TODO: implement loadUser() this should be the default logic for loading a user from a program-defined location.
    }
    private static void loadUser(String input) {
        //TODO: This overload of loadUser is responsible for loading the user from a user-defined path.
    }
}
