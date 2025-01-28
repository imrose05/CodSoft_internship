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
      int numToGuess=random.nextInt(100)+1;
      int attempts=0;
      int maximumAttempts=10;
      boolean guessedCorrectly=false;
      System.out.println("I have selected a number btw 1-100.you have "+ maximumAttemts +" attempts to guess the correct number. All the best!"):
      while(attempts<maximumAttempts){
        System.out.print("Enter your Guess: ");
        int userGuess=sc.nextInt();
        attempts++;
        if(userGuess==numToGuess{
           System.out.println("Congratulations you have Guessed the correct number in "+attempts+"attempts.");
           guessedCorrectly=true;
           score+=(maximumAttempts-attempts+1);
           break;
        }
        
