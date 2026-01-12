import java.util.Random;
import java.util.Scanner;

public class Main 
{
	public static void main(String[] args) {
	    Scanner input = new Scanner(System.in); 
	    
        while (true) {
            System.out.println("Guess The Number!");
		    System.out.println("by Emman Diamond");
            System.out.println("Start [Y/N]? ");
            String Start = input.nextLine();  

            if (Start.equalsIgnoreCase("y")) {
                ClearScreen();
                GameStart();
                break;
            } else if (Start.equalsIgnoreCase("n")) {
                ClearScreen();
                System.out.println("Thanks for playing!");
                break;
            } else {
                ClearScreen();
                System.out.println("Invalid Input");
                pause(2000);
                ClearScreen();
            }
        }
	}
	
	static void ClearScreen() {  // A clear terminal equivalent for java
	    System.out.print("\033[H\033[2J");
        System.out.flush();
	}
	
	static void pause(int ms) {  // A time.sleep equivalent for Java
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
	
	static void Objectives(int remaining, int RandomNumber) {
	    System.out.println("OBJECTIVE: Guess the number between 1 - 100");
	    if (remaining == 1) {
	        System.out.println("You have " + remaining + " attempt to guess the correct number");
	    } else {
	        System.out.println("You have " + remaining + " attempts to guess the correct number");
	    }
	    
	    if (remaining == 5) {
            if (RandomNumber % 2 == 0) {
                System.out.println("HINT: The number is even");
            } else {
                System.out.println("HINT: The number is odd");
            }
        }
	}
	
	static void GameStart() {
	    Scanner input = new Scanner(System.in);
	    Random random = new Random();
	    
	    int MaxAttempts = 10;
	    int UserAttempts = 0;
	    int RandomNumber = random.nextInt(100);
	    
        while (UserAttempts < MaxAttempts) {
            int remaining = MaxAttempts - UserAttempts;
            Objectives(remaining, RandomNumber);
            
            if (input.hasNextInt()) {
                int Guess = input.nextInt();
                input.nextLine();
                
                if (Guess < 1 || Guess > 100) {
                    ClearScreen();
                    System.out.println("The instruction said 1 - 100...");
                    pause(2000);
                    ClearScreen();
                } else {
                    UserAttempts += 1;
                    
                    
                    if (Guess == RandomNumber) {
                        ClearScreen();
                        System.out.println("Correct!! The number was " + RandomNumber + ". You got it in " + UserAttempts + " attempts");
                    } else if (Guess < RandomNumber && Guess < 100) {
                        ClearScreen();
                        System.out.println("Too Low, Maybe a higher number"); 
                        pause(2000);
                        ClearScreen();
                    } else if (Guess > RandomNumber && Guess < 100) {
                        ClearScreen();
                        System.out.println("Too High, Maybe a lower number");
                        pause(2000);
                        ClearScreen();
                    } 
                
                    if (Guess != RandomNumber && UserAttempts == MaxAttempts) {
                        System.out.println("Unfortunately.. You are out of attempts, The number was " + RandomNumber);
                        System.out.println("Would you like to play again?");
                        String PlayAgain = input.nextLine();
                    
                        if (PlayAgain.equalsIgnoreCase("y")) {
                            ClearScreen();
                            GameStart();
                            break;
                        } else if (PlayAgain.equalsIgnoreCase("n")) {
                            ClearScreen();
                            System.out.println("Thanks for playing!");
                            break;
                        } else {
                            ClearScreen();
                            System.out.println("Invalid Input");
                            pause(2000);
                            ClearScreen();
                        }
                    }
                }
                
            } else {
                ClearScreen();
                System.out.println("Invalid! That's not a number!");
                pause(2000);
                ClearScreen();
                input.next();
            }
        }
  }

}