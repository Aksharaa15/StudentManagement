import java.util.*;

class Question {
    String question;
    String[] options;
    int correctAns;

    Question(String q, String[] opt, int ans) {
        this.question = q;
        this.options = opt;
        this.correctAns = ans;
    }
}

public class ExamPortal {

    static Scanner sc = new Scanner(System.in);
    static int score = 0;

    static ArrayList<Question> questions = new ArrayList<>();

    static void loadQuestions() {
        questions.add(new Question(
                "Java is a ____ language?",
                new String[]{"1. Low level", "2. High level", "3. Machine", "4. Assembly"},
                2
        ));

        questions.add(new Question(
                "Which is not a data structure?",
                new String[]{"1. Array", "2. Stack", "3. Compiler", "4. Queue"},
                3
        ));

        questions.add(new Question(
                "Which keyword is used for inheritance?",
                new String[]{"1. this", "2. super", "3. extends", "4. implements"},
                3
        ));
    }

    static void takeExam() {
        score = 0;

        for (int i = 0; i < questions.size(); i++) {
            Question q = questions.get(i);

            System.out.println("\nQ" + (i + 1) + ": " + q.question);

            for (String opt : q.options) {
                System.out.println(opt);
            }

            System.out.print("Enter answer: ");
            int ans = sc.nextInt();

            if (ans == q.correctAns) {
                score++;
            }
        }

        System.out.println("\nExam Finished!");
    }

    static void showResult() {
        System.out.println("\nYour Score: " + score + "/" + questions.size());

        if (score >= 2) {
            System.out.println("Result: PASS");
        } else {
            System.out.println("Result: FAIL");
        }
    }

    public static void main(String[] args) {

        loadQuestions();

        while (true) {
            System.out.println("\n--- EXAM PORTAL ---");
            System.out.println("1. Take Exam");
            System.out.println("2. View Result");
            System.out.println("3. Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1: takeExam(); break;
                case 2: showResult(); break;
                case 3: return;
                default: System.out.println("Invalid choice");
            }
        }
    }
}
