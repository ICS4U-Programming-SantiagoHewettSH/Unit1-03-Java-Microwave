import java.util.Scanner;




/**.
* This program will calculate the amount of time it takes to microwave certain
* types and amounts of food
*
* @author  Santiago Hewett
* @version 1.0
* @since   2025/02/25
*/




final class Microwave {
   /**.
   * SUB_TIME as double constant
   **/
   private static final double SUB_TIME = 1.0;
   /**.
   * PIZZA_TIME as double constant
   **/
   private static final double PIZZA_TIME = 0.75;
   /**.
   * SOUP_TIME as double constant
   **/
   private static final double SOUP_TIME = 1.75;




   /**
   * This is a private constructor used to satisfy the style checker.
   *
   * @exception IllegalStateException Utility class.
   * @see IllegalStateException
   */
   private Microwave() {
       throw new IllegalStateException("Utility class");
   }




   /**
   * This is the main method.
   *
   * @param args Unused.
   */
   public static void main(final String[] args) {
       // Welcome message
       System.out.println("This program will calculate"
               + " the amount of time it takes to microwave certain"
               + " types and amounts of food.");


       // Use a scanner to get the food and quantity from the user
       Scanner scanner = new Scanner(System.in);


       // Declare timeInMinutes double variable
       double timeInMinutes = 0;


       // Declare foodAsString String variable
       String foodAsString;


       // Declare minCookTime double variable
       double minCookTime = 0;


       // Declare numberOfItemString String variable
       String numberOfItemString;


       // Declare numberOfItemInt int variable
       int numberOfItemInt;


       // Do while loop to run until valid food and quantity is entered
       do {
           // Message to ask user for food
           System.out.println("Please enter the"
                   + " food you will be heating, Sub, Pizza or Soup: ");
           // Get the food as a string
           foodAsString = scanner.nextLine();


           // If statement for valid input .equals is used to compare strings
           // And .toLowerCase is used to make all input lower case
           if (foodAsString.toLowerCase().equals("sub")
                   || foodAsString.toLowerCase().equals("pizza")
                   || foodAsString.toLowerCase().equals("soup")) {
               if (foodAsString.toLowerCase().equals("sub")) {
                   minCookTime = SUB_TIME;
               } else if (foodAsString.toLowerCase().equals("pizza")) {
                   minCookTime = PIZZA_TIME;
               } else {
                   minCookTime = SOUP_TIME;
               }
           } else {
               // Error message for invalid input
               System.out.println("Invalid input: " + foodAsString
                       + ". Please enter Sub, Pizza or Soup.");
               // Continue the loop if the input is invalid
               continue;
           }
           // message for number of items
           System.out.println("Please enter the number of the food"
                   + " item(s) you will be heating(max 3 items): ");
           // Get the number of items as a string
           numberOfItemString = scanner.nextLine();
           try {


               // Convert string to int
               numberOfItemInt = Integer.parseInt(numberOfItemString);


               // If statement for valid number of items
               if (numberOfItemInt == 1 || numberOfItemInt == 2
                       || numberOfItemInt == 3) {
                   // Break the loop if the input is valid
                   // And set time in minutes
                   if (numberOfItemInt == 1) {
                       timeInMinutes = minCookTime;
                       break;
                   } else if (numberOfItemInt == 2) {
                       timeInMinutes = minCookTime * 1.5;
                       break;
                   } else {
                       timeInMinutes = minCookTime * 2;
                       break;
                   }
               } else {
                   // Error message for invalid input
                   System.out.println("Invalid input: " + numberOfItemString
                           + ". Please enter 1, 2 or 3.");
                   // Continue the loop if the input is invalid
                   continue;
               }
           } catch (NumberFormatException error) {
               // Error message for invalid input
               System.out.println("Invalid input: " + numberOfItemString
                       + ". Please enter 1, 2 or 3.");
               // Continue the loop if the input is invalid
               continue;
          }
       // While True for infinite loop until break
       } while (true);


       // Calculate number of minutes it takes to microwave
       int totalMinutesInt = (int) timeInMinutes;


       // Calculate number of seconds it takes to microwave
       int totalSecondsInt = (int) ((timeInMinutes - totalMinutesInt) * 60);


       // Display the time it takes to microwave in mins and secs
       System.out.print("The total time it takes to microwave ");
       System.out.print(numberOfItemInt + " ");
       System.out.print(foodAsString + "(s) is: ");
       System.out.print(totalMinutesInt + " minutes and ");
       System.out.println(totalSecondsInt + " seconds.");


   // Close scanner
   scanner.close();
   }
}
