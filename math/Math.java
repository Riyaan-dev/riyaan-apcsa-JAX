package math;

class Math {

    public static void main(String[] args) {

    //Use the // to create single line comments to either add info or to take out code for debugging

    System.out.println("Hello world!");

    //We will be using System.out.println and System.out.print throughout the year. Try using both below to see what the difference is!






    //ANSWER:

    System.out.print("Hello World");
    System.out.println("hello World");
    // the answer is that the print ln will go to the next line for the print statement 



    //Throughout the year this year we will need to store information. For that we will be using VARIABLES!

    //Java is an Object-Oriented programming language. All variables we use this year will either be OBJECTS or PRIMITIVES

    //There are 8 primitives in Java: int, byte, short, long, float, double, boolean, char

    //For AP we need to know: int, double, boolean

    //List examples of the types below and give definition
    //int (integer):

    int sumedh = 5;

    double ryan = 5.0;

    boolean cool = true; 

    System.out.print(sumedh + ryan);

    System.out.print(cool);

    //double:
    //boolean:

    //For now we are just going to work with primitive

    //Create 3 variables of each of the above types (USE GOOD CODING PRACTICE WHEN CREATING THE VARIABLES

    int Temperature = 60;

    double GPA = 4.17;

    boolean hotOutside = true;
    
    
    System.out.print(Temperature + GPA);

    System.out.print(hotOutside);

    





    //MATH TIME!

    //What are the math operators that we can use?
    //+ - * / %

    //Try doing some math operations with numbers. How can we check to see if the math worked?

    System.out.println(5 * 5);


    // we can out put it in the terminal

    

  

    //Create codes that will print the following:
    //Odd integers from 1 to 100, inclusive of both

    for (int i = 1; i <= 100; i +=2 ) {

      System.out.println(i);




    }



    //All multiples of 3 from 1 to 100

    System.out.println("PRINTING ALL MULTIPLES OF 3 FROM 1 TO 100"); 


    for (int x = 3; x <=100; x +=3 ) {

      System.out.println(x);


    }




    //Starting at 1000, print on the same line (with a - [hypthen] between each) all of the numbers that end in 0 going down to 0

    //All done!
  }
}
