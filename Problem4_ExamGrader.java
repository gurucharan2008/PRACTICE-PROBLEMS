import java.util.Scanner;

abstract class Question {
    protected String type;
    protected String questionText;
    protected String correctAnswer;
    protected String studentAnswer;
    protected int points;

    public Question(String type, String questionText, String correctAnswer, String studentAnswer, int points) {
        this.type = type;
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    public abstract double grade();

    public String getType() {
        return type;
    }
}

class MCQ extends Question {
    public MCQ(String questionText, String correctAnswer, String studentAnswer, int points) {
        super("MCQ", questionText, correctAnswer, studentAnswer, points);
    }

    @Override
    public double grade() {
        return studentAnswer.equalsIgnoreCase(correctAnswer) ? points : 0;
    }
}

class TF extends Question {
    public TF(String questionText, String correctAnswer, String studentAnswer, int points) {
        super("TF", questionText, correctAnswer, studentAnswer, points);
    }

    @Override
    public double grade() {
        return studentAnswer.equalsIgnoreCase(correctAnswer) ? points : 0;
    }
}

class Essay extends Question {
    public Essay(String questionText, String correctAnswer, String studentAnswer, int points) {
        super("ESSAY", questionText, correctAnswer, studentAnswer, points);
    }

    @Override
    public double grade() {
        String[] keywords = correctAnswer.split(",\\s*");
        String ansLower = studentAnswer.toLowerCase();
        int matches = 0;
        for (String kw : keywords) {
            if (ansLower.contains(kw.trim().toLowerCase())) {
                matches++;
            }
        }
        if (matches >= 2) return points * 0.75;
        if (matches == 1) return points * 0.50;
        return 0;
    }
}

public class Problem4_ExamGrader {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        Question[] questions = new Question[n];
        double total = 0;

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            // Simple parse: type then quoted strings and points
            String type = line.substring(0, line.indexOf(' '));
            String rest = line.substring(line.indexOf(' ') + 1);

            // Extract quoted parts
            java.util.List<String> quotes = new java.util.ArrayList<>();
            int start = 0;
            while (true) {
                int q1 = rest.indexOf('"', start);
                if (q1 == -1) break;
                int q2 = rest.indexOf('"', q1 + 1);
                quotes.add(rest.substring(q1 + 1, q2));
                start = q2 + 1;
            }
            int points = Integer.parseInt(rest.substring(rest.lastIndexOf(' ') + 1).trim());

            String qText = quotes.get(0);
            String correct = quotes.get(1);
            String student = quotes.get(2);

            if (type.equals("MCQ")) {
                questions[i] = new MCQ(qText, correct, student, points);
            } else if (type.equals("TF")) {
                questions[i] = new TF(qText, correct, student, points);
            } else {
                questions[i] = new Essay(qText, correct, student, points);
            }
        }

        for (Question q : questions) {
            double score = q.grade();
            System.out.printf("%s: %.2f%n", q.getType(), score);
            total += score;
        }
        System.out.printf("Total Score: %.2f%n", total);
        sc.close();
    }
}
