package robot;

import kareltherobot.*;

public class Roomba implements Directions {
    private static int st = 0;
    private static int av = 0;    

    public static void main(String[] args) {
        String worldName = "robot/finalTestWorld2024.wld";
        Roomba cleaner = new Roomba();
        int totalBeepers = cleaner.cleanRoom(worldName, 26, 149); // starting pos
        System.out.println("Roomba cleaned up a total of " + totalBeepers + " beepers.");
    }

    private Robot roomba;
    private int totalBeepers = 0;

    public int cleanRoom(String worldName, int startStreet, int startAvenue) {
        World.readWorld(worldName);
        World.setVisible(true);
        World.setDelay(0);

        roomba = new Robot(startStreet, startAvenue, West, 0);
        // initializes the variablese 

        /*added 1 becuase it does not calculate the very top last square.
         This is universal accross all testing worlds so adding 1 is a universal solution */

        double totalArea = 1;
        double largestPile = 0;
        double numberOfPiles = 0;

        //this while loop helps to check if the code is working
        while (true) {
            totalArea++;
            int currentPile = 0;

            if (roomba.nextToABeeper()) {
                numberOfPiles++;
                while (roomba.nextToABeeper()) {
                    roomba.pickBeeper();
                    totalBeepers++;
                    currentPile++;
                }
                if (currentPile > largestPile) {
                    largestPile = currentPile;
                    st = roomba.street();
                    av = roomba.avenue();
                }
            }

            // this prompts the roomba to move and pick up beeper using nested while loop + if statement 
            // the code prompts the robot in zig zag motion and picks up beeper along the way

            if (roomba.frontIsClear()) {
                roomba.move();
            } else {
                if (roomba.facingEast()) {
                    roomba.turnLeft();
                    if (!roomba.frontIsClear()) break;
                    roomba.move();
                    roomba.turnLeft();
                } else { 
                    roomba.turnLeft();
                    roomba.turnLeft();
                    roomba.turnLeft();
                    if (!roomba.frontIsClear()) break;
                    roomba.move();
                    roomba.turnLeft();
                    roomba.turnLeft();
                    roomba.turnLeft();
                    // this stops the robot before running into the wall.
                    
                }
            }
        }

        // this outputs the results of the code 
        System.out.println("the total area of the world is " + totalArea);
        System.out.println("the total number of piles is " + numberOfPiles);
        System.out.println("the percent dirty is " + (100 * numberOfPiles / totalArea) + "%");
        System.out.println("the average pile size is " + (totalBeepers / numberOfPiles));
        System.out.println("Location of Largest Pile: (" + "street " + st + ", avenue " + av + ")");
        System.out.println("the largest pile is " + largestPile);
        return totalBeepers;
    }
}
