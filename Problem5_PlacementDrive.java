import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Candidate implements Comparable<Candidate> {
    String name;
    double cgpa;
    int codingScore;

    public Candidate(String name, double cgpa, int codingScore) {
        this.name = name;
        this.cgpa = cgpa;
        this.codingScore = codingScore;
    }

    // Composite score: CGPA * 10 + codingScore (as implied by sample outputs)
    double getCompositeScore() {
        return cgpa * 10 + codingScore;
    }

    @Override
    public int compareTo(Candidate other) {
        // Descending order by composite score
        return Double.compare(other.getCompositeScore(), this.getCompositeScore());
    }

    @Override
    public String toString() {
        return name + " (" + String.format("%.1f", getCompositeScore()) + ")";
    }
}

public class Problem5_PlacementDrive {
    // CGPA-only filter: strong CGPA (>= 7.0) is eligible
    static boolean isEligible(double cgpa) {
        return cgpa >= 7.0;
    }

    // Combined filter: borderline CGPA (>= 6.5) + good coding score (>= 60)
    static boolean isEligible(double cgpa, int codingScore) {
        return cgpa >= 6.5 && codingScore >= 60;
    }

    static String shortlistAndRank(Candidate[] candidates) {
        List<Candidate> shortlisted = new ArrayList<>();

        for (Candidate c : candidates) {
            boolean eligible = isEligible(c.cgpa) || isEligible(c.cgpa, c.codingScore);
            if (eligible) {
                shortlisted.add(c);
            }
        }

        Candidate[] arr = shortlisted.toArray(new Candidate[0]);
        Arrays.sort(arr); // uses compareTo — descending composite

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (i > 0) sb.append(" | ");
            sb.append((i + 1)).append(". ").append(arr[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Candidate[] candidates = {
            new Candidate("Aisha", 8.2, 40),
            new Candidate("Rohit", 6.8, 65),
            new Candidate("Meena", 6.0, 90),
            new Candidate("Karan", 7.5, 20)
        };
        System.out.println(shortlistAndRank(candidates));
    }
}
