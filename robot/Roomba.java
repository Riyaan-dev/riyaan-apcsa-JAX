package robot;

import kareltherobot.*;

public class Roomba implements Directions {

	// Main method to make this self-contained
	public static void main(String[] args) {
		// LEAVE THIS ALONE!!!!!!
		String worldName = "robot/basicRoom.wld";
		
		Roomba cleaner = new Roomba();
		int totalBeepers = cleaner.cleanRoom(worldName, 7, 6);
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
		// what is that and why are we getting it?



		int i = 0;
		while (true){

			if (!roomba.nextToABeeper()){

				roomba.move();
			}

			while(roomba.nextToABeeper()){

				roomba.pickBeeper();

				totalBeepers ++;
			
			}

			if(!roomba.frontIsClear()){

				i++;

				if (i%2 == 1){

					roomba.turnLeft();

					if (!roomba.frontIsClear()){

						break;

					
					}
				
					roomba.move();
					roomba.turnLeft();


				}
				else {

					roomba.turnLeft();
					roomba.turnLeft();
					roomba.turnLeft();


					if (!roomba.frontIsClear()){

						break;

					}

					roomba.move();
					roomba.turnLeft();
					roomba.turnLeft();
					roomba.turnLeft();

					}

				


				}

			
				}

				roomba.move();
				roomba.turnLeft();


				

				
return totalBeepers;
				
			}

			

		}

	/*int i = 0;

	


	while (roomba.frontIsClear()){

		while(roomba.nextToABeeper()){

			if(!roomba.frontIsClear()){

				i++;

				if(i%2 == 1){

					roomba.turnLeft();
					if(!roomba.frontIsClear()){

						break;

					}

					else{ 

						roomba.turnLeft();
						roomba.turnLeft();
						roomba.turnLeft();

					}
					if (!roomba.frontIsClear()){


						break;


					}

					roomba.move();
					roomba.turnLeft();
					roomba.turnLeft();
					roomba.turnLeft();

	


				}

			}

			roomba.pickBeeper();
		}

		roomba.move();
	}
	int totalBeepers = 0; 
		//this code picks up the 7 beepers to start 
		roomba.move();
		roomba.move();
		for (int x = 1; x <=7; x +=1){

			roomba.pickBeeper();

			totalBeepers ++;


		}

		// this code moves over 1 and picks up 6 beepers 

		roomba.move();
		
		for (int x = 1; x <= 6; x +=1){
		roomba.pickBeeper();

		totalBeepers ++;
		}

		roomba.move();
		roomba.move();

		roomba.turnLeft();
		roomba.move();

		for (int x = 1; x<=3; x+=1){

			roomba.pickBeeper();
			totalBeepers ++;
		}



		// while loop for picking up big number of beepers 
		
		roomba.move();

		while (roomba.nextToABeeper()){


			roomba.pickBeeper();
			totalBeepers ++;
 


		}


		// code for picking up next set of beepers on the left (6 beepers)

		while (roomba.nextToABeeper()) {

			roomba.pickBeeper();
			totalBeepers ++;






		}


		roomba.turnLeft();
		roomba.move();
		roomba.move();
		roomba.move();
		roomba.move();

	 while (roomba.nextToABeeper()) {

		roomba.pickBeeper();
		totalBeepers ++;

	 }

// roomba will turn right and move forward twice 

roomba.turnLeft();
roomba.turnLeft();
roomba.turnLeft();
roomba.move();
roomba.move();

roomba.turnLeft();
roomba.turnLeft();
roomba.turnLeft();
roomba.move();

while (roomba.nextToABeeper())
{

	roomba.pickBeeper();
	totalBeepers ++;

}		

roomba.move();
roomba.move();

while (roomba.nextToABeeper()){

	roomba.pickBeeper();	
	totalBeepers ++;

}

roomba.move();
roomba.move();	
roomba.move();	

while (roomba.nextToABeeper()){

	roomba.pickBeeper();
	totalBeepers ++;

}

roomba.turnLeft();
roomba.turnLeft();
roomba.turnLeft();
roomba.move();


roomba.turnLeft();
roomba.turnLeft();
roomba.turnLeft();
for (int x =1; x<=4; x+=1){

	roomba.move();
	totalBeepers ++;
}


while (roomba.nextToABeeper()){

	roomba.pickBeeper();
	totalBeepers ++;
}

roomba.move();





		



		 // Need to move this somewhere else.
        // This method should return the total number of beepers cleaned up.
		return totalBeepers;
	}*/