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
public class Admin extends Room{
    Room room = new Room();
    
    // method for adding new room
    public void add(Room room){
        // if array is full, give notification
        if(room.qty == 100){
            System.out.println("There's no space for new room.");
        // if not, add new room
        } else {
            Scanner input = new Scanner(System.in);
            System.out.print("Insert new room's number: ");
            String newRoom = input.nextLine();

            room.qty += 1;
            room.Number[room.qty-1] = newRoom;
        }
    }
    
    //  method for checking room
    public void checkRoom(Room room){
        System.out.println("Quantity of Avalaible Room(s): " + room.qty);
        System.out.println("Avalaible Room(s): ");
        for(int i = 0; i < room.qty; i++){
            System.out.print(room.Number[i] + " ");
            if(i >= 20 && i%20 == 0){
                System.out.println("");
            }
        }
    }
    
    // method for deleting room
    public void delete(Room room){
        Scanner input = new Scanner(System.in);
        
        System.out.print("Insert room's number: ");     
        String roomNum = input.nextLine();
        
        // checking room number one by one using loop
        for(int i = 0; i < room.qty; i++){
            // if room found
            if(roomNum.equals(room.Number[i])){
                // delete room by replacing current room with the room after it and do it until the last room
                for(int j = i; j < room.qty-1; j++){
                    room.Number[j] = room.Number[j+1];
                }
                room.qty-=1;
                System.out.println("Room Deleted.");
                i = room.qty;
            // if not, give notification
            } else {
                System.out.println("Room not found.");
            }
        }
    }
}
