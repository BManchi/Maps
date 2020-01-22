package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static Map<Integer, Location> locations = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Locations 1,2,3,4 == N,E,S,W

        locations.put(1, new Location(1, "You are standing in front of a door"));
        locations.get(1).addExits("N", 11);
        locations.get(1).addExits("E", 2);
        locations.get(1).addExits("S", 3);
        locations.get(1).addExits("W", 4);

        locations.put(11, new Location(11, "You turn the knob. Nothing happens."));
        locations.get(11).addExits("N", 11);
        locations.get(11).addExits("E", 2);
        locations.get(11).addExits("S", 3);
        locations.get(11).addExits("W", 4);

        locations.put(2, new Location(2, "There is a wall with stock family pictures"));
        locations.get(2).addExits("N", 1);
        locations.get(2).addExits("S", 3);
        locations.get(2).addExits("W", 4);

        locations.put(3, new Location(3, "A wooden desk is full with papers and boxes"));
        locations.get(3).addExits("w", 4);
        locations.get(3).addExits("N", 1);
        locations.get(3).addExits("E", 2);
        locations.get(3).addExits("S", 33);

        locations.put(4, new Location(4, "The window is open. The fall does not seem to be dangerous but there is no way to climb back up"));
        locations.get(4).addExits("N", 1);
        locations.get(4).addExits("S", 3);
        locations.get(4).addExits("E", 2);
        locations.get(4).addExits("W", 0);

        int loc = 1;
        while(true) {
            System.out.println(locations.get(loc).getDescription());
            if (loc == 0) {
                System.out.println("Congratulations, you got out!");
                break;
            }

            Map<String, Integer> exits = locations.get(loc).getExits();
            System.out.print("You can go ");
            for ( String exit: exits.keySet()){
                System.out.print(exit + ", ");
            }

            System.out.println();

            String direction = scanner.nextLine().toUpperCase();

            if (exits.containsKey(direction)){
                loc = exits.get(direction);

            } else{
                System.out.println("You cannot go in that direction");

            }


        }
    }


}
