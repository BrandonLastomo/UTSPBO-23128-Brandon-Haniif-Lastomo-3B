/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mainProgram;
import java.util.Scanner;
import Entities.*;
import Methods.Login;

/**
 *
 * @author brand
 */
public class Hotel {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Room room = new Room();
        Admin admin1 = new Admin();
        Customer cust1 = new Customer();
        String option;
        
        // menu will be keep showing until user chooses 2 (exit)
        do {
            // Main menu
            System.out.println("=== Tripe ===");
            System.out.print("1. Login\n2. Exit\n> ");
            // take menu input from user
            option = input.nextLine();
            switch(option){
                // if user chooses 1, login form will be displayed
                case "1":
                    // login
                    System.out.println("\nLogin");
                    System.out.print("Username: ");
                    // take username input
                    String username = input.nextLine();
                    System.out.print("Password: ");
                    // take password input
                    String password = input.nextLine();
                    // pass username and password to Login class constructor
                    Login login = new Login(username, password);
                    // check username and password
                    String isAdmin = login.credentialCheck();     
                    
                    switch(isAdmin){
                        // if the user is admin, display menu for admin
                        case "admin":
                            do {                    
                                System.out.println("\nAdmin Menu\n");
                                System.out.print("1. Add Room\n2. Check Room(s)\n3. Delete Room\n4. Exit\n> ");
                                option = input.nextLine();
                                switch(option){
                                    case "1":
                                        admin1.add(room);
                                    break;
                                    case "2":
                                        admin1.checkRoom(room);
                                    break;
                                    case "3":
                                        admin1.delete(room);
                                    break;
                                    case "4":
                                        System.out.println("Bye.\n");
                                    break;
                                    default:
                                        System.out.println("Invalid option.\n");
                                }
                            } while (!"4".equals(option));
                            break;
                        // if the user is customer, display menu for customer
                        case "customer":
                            do {                    
                            System.out.println("\nCustomer Menu\n");
                            System.out.print("1. Reserve Room(s)\n2. Check Room\n3. Check Reservation Details\n4. Retract Reservation\n5. Exit\n> ");
                                option = input.nextLine();
                                switch(option){
                                    case "1":
                                        cust1.add(room);
                                    break;
                                    case "2":
                                        cust1.checkRoom(room);
                                    break;
                                    case "3":
                                        cust1.checkReservation();
                                    break;
                                    case "4":
                                        cust1.delete(room);
                                    break;
                                    case "5":
                                        System.out.println("Bye.\n");
                                    break;
                                    default:
                                        System.out.println("Invalid option.\n");
                                }
                            } while (!"5".equals(option));
                            break;
                        // if somehow the user is neither, give notification
                        default:
                            System.out.println("Invalid User Type.\n");
                    }
                    break;
                // if user chooses 2, the program will exit
                case "2":
                    System.out.println("Thanks for using!");
                    break;
                // if user chooses neither, give notification
                default:
                    System.out.println("Invalid option.\n");
                    break;
            }
        } while (!"2".equals(option));
     
    }
    
}
