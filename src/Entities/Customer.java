/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

import java.util.Scanner;

/**
 *
 * @author brand
 */
public class Customer extends Admin{
    private final String[] reservedRoom;
    private int reserveRoomQty;
    Room room = new Room();

    public Customer() {
        this.reservedRoom = new String[100];
    }
    
    @Override
    // method for reserving room
    public void add(Room room){
        // reset reserved room qty 
        this.reserveRoomQty = 0;
        // if no room avalaible, give notification
        if (room.qty == 0){
            System.out.println("Sorry. No room left.");
        // if not, reserve room
        } else {
            Scanner input = new Scanner(System.in);
            System.out.print("How many room(s) do you want to reserve?: ");
            this.reserveRoomQty = input.nextInt();
            
            // reserve room from the latest room according to how many room the customer reserved
            int i = 0;
            while(i < this.reserveRoomQty){
                this.reservedRoom[i] = room.Number[room.qty-1];
                i++;
                room.qty--;
            }
            System.out.println("Reservation success.\nPlease check you reservation detail by choosing the 3rd option.");
        }
    }

//  method for checking room
    @Override
    public void checkRoom(Room room){
        System.out.println("Avalaible Room(s): ");
        for(int i = 0; i < room.qty; i++){
            System.out.print(room.Number[i] + " ");
            if(i >= 20 && i%20 == 0){
                System.out.println("");
            }
        }
        System.out.println("");
    }
    
    // method for checking reservation
    public void checkReservation(){
        // if customer haven't reserved any room, give notification
        if(this.reserveRoomQty == 0){
            System.out.println("You haven't reserved any room.");
        // if not, print the reservation details
        } else {
            System.out.println("You reserved: " + this.reserveRoomQty + " room(s).");
            System.out.println("The room you've reserved is/are:");
            int i = 0;
            while(i < this.reserveRoomQty){
                System.out.print(this.reservedRoom[i] + " ");
                i++;
            }
        }
        System.out.println("");
    }
    
    @Override
    // method for retracting
    public void delete(Room room){
        // if the customer have reserved any room, retract reservation
        if(this.reserveRoomQty != 0){
            Scanner input = new Scanner(System.in);

            System.out.print("Insert room's number you want to unreserve: ");
            String roomNum = input.nextLine();
            
            room.qty++;
            
            // checking reserved room number one by one using loop
            for(int i = 0; i < this.reserveRoomQty; i++){
                // if room found, retract
                if(roomNum.equals(this.reservedRoom[i])){
                    // add retracted room to room avalaible list
                    room.Number[room.qty-1] = roomNum;
                    
                    // update reservation list
                    for(int a = i; a < this.reserveRoomQty; a++){
                        this.reservedRoom[a] = this.reservedRoom[a+1];
                    }
                    this.reserveRoomQty--;
                    System.out.println("Reservation retracted");
                    i = this.reserveRoomQty;
                // if not, give notification
                } else {
                    System.out.println("You didn't reserve this room.");
                    i = this.reserveRoomQty;
                }
            }
        // if not, give notification
        } else {
            System.out.println("You have not reserved any room yet.");
        }
    }
}
