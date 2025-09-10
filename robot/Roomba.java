package robot;

import kareltherobot.*;

public class Roomba implements Directions {

	// Main method to make this self-contained
	public static void main(String[] args) {
		// LEAVE THIS ALONE!!!!!!
		//String worldName = "robot/basicRoom.wld";

		String worldName = "robot/testWorld.wld";
		
		Roomba cleaner = new Roomba();
		int totalBeepers = cleaner.cleanRoom(worldName, 25, 11);
		System.out.println("Roomba cleaned up a total of " + totalBeepers + " beepers.");

	}

	// declared here so it is visible in all the methods!
	private Robot roomba;

	int totalBeepers = 0;
	
	// You will need to add many variables!!


	public int cleanRoom(String worldName, int startX, int startY) {

		// A new Robot should be constructed and assigned to the global (instance) variable named roomba that is declared above.
        // Make sure it starts at startX and startY location.
		roomba = new Robot(startX, startY, East, 0);

		World.readWorld(worldName);
		World.setVisible(true);
		World.setDelay(1);
	


		/** This section will have all the logic that takes the Robot to every location
		 * and cleans up all piles of beepers. Think about ways you can break this
		 * large, complex task into smaller, easier to solve problems.
		 */

		// the line below causes a null pointer exception
		// what is that and why are we getting it

		int totalArea = 0;



		while(roomba.frontIsClear()){
			
			roomba.move();
			totalArea++;

			while(roomba.nextToABeeper()){

				totalBeepers++;

				roomba.pickBeeper();

			}

			if (!roomba.frontIsClear()){

			if(roomba.facingEast()){

				roomba.turnLeft();
				roomba.move();
				roomba.turnLeft();
			}

			else {

				roomba.turnLeft();
				roomba.turnLeft();
				roomba.turnLeft();
				roomba.move();
				roomba.turnLeft();
				roomba.turnLeft();
				roomba.turnLeft();

			}
		}

		
	}
System.out.println("the total area of the world is " + totalArea);
	return totalBeepers;

}
}