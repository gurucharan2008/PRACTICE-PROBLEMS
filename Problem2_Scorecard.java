public class Scorecard {
    private final boolean[] results;
    private int recorded = 0;
    private final int totalQuestions;

    public Scorecard(int totalQuestions) {
        this.totalQuestions = totalQuestions;
        this.results = new boolean[totalQuestions];
    }

    public void recordAnswer(boolean correct) {
        if (recorded < totalQuestions) {
            results[recorded] = correct;
            recorded++;
        }
        // else ignore
    }

    public int getScore() {
        int score = 0;
        for (int i = 0; i < recorded; i++) {
            if (results[i]) score++;
        }
        return score;
    }

    public static void main(String[] args) {
        Scorecard sc = new Scorecard(4);
        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);
        System.out.println("Score: " + sc.getScore());
    }
}
