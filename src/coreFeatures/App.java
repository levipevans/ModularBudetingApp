package coreFeatures;

import java.util.Scanner;

public class App {
    public static void main(String[] args){
        boolean shouldRun = true;
        Scanner scanner = new Scanner(System.in);
        User user = null;
        String input;
        
        loadUser();
        while(user == null){
            System.out.println("Hello and welcome to Modular Budgeting App!");
            System.out.print("What would you like to do?\n (1) create a new user\n (2) provide the path to a previously saved user\n (3) exit");
            input = Integer.toString(scanner.nextInt());
            switch(Integer.parseInt(input)){
                case 1: createNewUser();
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

    
    private static void createNewUser() {
        //TODO: implement createNewUser(). This should guide the user through initializing their User.java object.
    }
    
    private static void loadUser() {
        //TODO: implement loadUser() this should be the default logic for loading a user from a program-defined location.
    }
    private static void loadUser(String input) {
        //TODO: This overload of loadUser is responsible for loading the user from a user-defined path.
    }
}
