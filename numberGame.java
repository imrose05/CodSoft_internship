import java.util.Scanner;
import java.util.Random;
public class numberGame{
  public static void main(String args[]){
    Scanner sc=new Scanner(System.in);
    Random ra=new Random();
    int score=0;
    int numOfRounds=0;
    System.out.println("Lets Start the number guessing game!!");
    while(true){
      int numToGuess=ra.nextInt(100)+1;
      int attempts=0;
      int maximumAttempts=10;
      boolean guessedCorrectly=false;
      System.out.println("I have selected a number btw 1-100.you have "+ maximumAttempts +" attempts to guess the correct number. All the best!");
      while(attempts<maximumAttempts){
        System.out.print("Enter your Guess: ");
        int userGuess=sc.nextInt();
        attempts++;
        if(userGuess==numToGuess){
           System.out.println("Congratulations you have Guessed the correct number in "+ attempts +"attempts.");
           guessedCorrectly=true;
           score+=(maximumAttempts-attempts+1);
           break;
        }
        if(userGuess==numToGuess){
          System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
          guessedCorrectly=true;
          score=score+maximumAttempts-attempts+1;
          break;
        }
        else if(userGuess<numToGuess){
           System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
        }
        if(!guessedCorrectly){
          System.out.println("You've used all your attempts! The correct number was: " + numToGuess);
        }
          numOfRounds++;
        System.out.println("Your current Score is :"+score);
        System.out.print("Do you want to play another round? (yes/no): ");
        String playAgain = sc.next();
        if(!playAgain.equalsIgnoreCase("yes")) {
                break;
            }
        }
      System.out.println("\nGame Over! You played " + numOfRounds+ " rounds and scored " + score + " points.");
        sc.close();
    }
}
        
