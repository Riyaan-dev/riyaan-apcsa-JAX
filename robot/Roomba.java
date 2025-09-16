package robot;

import kareltherobot.*;

public class Roomba implements Directions {
	private static int st = 0;
	private static int av = 0;	

	// Main method to make this self-contained
	public static void main(String[] args) {
		// LEAVE THIS ALONE!!!!!!
		//String worldName = "robot/basicRoom.wld";
		String worldName = "robot/finalTestWorld2024.wld";
		//String worldName = "robot/finalTestworld.wld";
		
		Roomba cleaner = new Roomba();
		int totalBeepers = cleaner.cleanRoom(worldName, 25, 11);
		System.out.println("Roomba cleaned up a total of " + totalBeepers + " beepers.");

	}

	// declared here so it is visible in all the methods!
	private Robot roomba;

	int totalBeepers = 99;
	
	// You will need to add many variables!!


	public int cleanRoom(String worldName, int startX, int startY) {

		// A new Robot should be constructed and assigned to the global (instance) variable named roomba that is declared above.
        // Make sure it starts at startX and startY location.
		roomba = new Robot(26, 149, West, 0);

		World.readWorld(worldName);
		World.setVisible(true);
		World.setDelay(0);
	


		/** This section will have all the logic that takes the Robot to every location
		 * and cleans up all piles of beepers. Think about ways you can break this
		 * large, complex task into smaller, easier to solve problems.
		 */

		// the line below causes a null pointer exception
		// what is that and why are we getting it

		double totalArea = 2;

		double largestPile = 0;
		
		double previousPile = 0;

		double numberOfPiles = 1;

		



while (true) {
    while (roomba.frontIsClear()) {
        roomba.move();
        totalArea++;

        if (roomba.nextToABeeper()) {
            previousPile = 0;
            numberOfPiles++;

            while (roomba.nextToABeeper()) {
                totalBeepers++;
                roomba.pickBeeper();
                previousPile++;

                if (previousPile > largestPile) {
                    largestPile = previousPile;
                    st = roomba.street();
                    av = roomba.avenue();
                }
            }
        }
    }

    // Reached the end of a row
    if (roomba.facingEast()) {
        roomba.turnLeft();
        if (!roomba.frontIsClear()) {
            roomba.turnOff();  
            break;
        }
        roomba.move();
        totalArea++;
        roomba.turnLeft();
    } else { // facing west
        roomba.turnLeft();
        roomba.turnLeft();
        roomba.turnLeft();
        if (!roomba.frontIsClear()) {
            roomba.turnOff();  
            break;
        }
        roomba.move();
        totalArea++;
        roomba.turnLeft();
        roomba.turnLeft();
        roomba.turnLeft();
    }
}



	System.out.println("the total area of the world is " + totalArea);
	System.out.println("the total number of piles is " + numberOfPiles);
	System.out.println("the percent dirty is " + (100* numberOfPiles/totalArea)+ "%");
	System.out.println("the average pile size is " + (totalBeepers/numberOfPiles));
	System.out.println("Location of Largest Pile: (" + "street " + st + ", avenue " + av + ")" );
	System.out.println("the largest pile is " + largestPile);
	return totalBeepers;


	

}
}