/**
 * Week 1 Practice - Problem 3: BMI Calculator for a Team
 */
public class P3_BMICalculator {

    static String getBmiStatus(double bmi) {
        if (bmi < 18.5) return "Underweight";
        if (bmi < 25.0) return "Normal";
        if (bmi < 30.0) return "Overweight";
        return "Obese";
    }

    static void printWellnessReport(double[] heights, double[] weights) {
        System.out.println("Person | Height (m) | Weight (kg) | BMI    | Status");
        System.out.println("-------------------------------------------------------");

        for (int i = 0; i < heights.length; i++) {
            double bmi = weights[i] / (heights[i] * heights[i]);
            String status = getBmiStatus(bmi);
            System.out.printf("  %2d   |   %.2f     |   %5.1f     | %5.2f  | %s%n",
                    i + 1, heights[i], weights[i], bmi, status);
        }
    }

    public static void main(String[] args) {
        // Sample data (2 people matching the example + a few more)
        double[] heights = {1.75, 1.60, 1.80, 1.65, 1.70};
        double[] weights = {70, 90, 75, 55, 85};

        printWellnessReport(heights, weights);
    }
}
