import java.util.*;

public class GuessGame {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int number = rand.nextInt(100) + 1; // 1 to 100
        int guess;

        System.out.println("Guess the number (1-100)");

        do {
            System.out.print("Enter guess: ");
            guess = sc.nextInt();

            if (guess > number) {
                System.out.println("Too High!");
            } else if (guess < number) {
                System.out.println("Too Low!");
            } else {
                System.out.println("Correct! You guessed it 🎉");
            }

        } while (guess != number);
    }
}
