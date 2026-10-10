import java.util.Random;

/**
 * Week 1 Practice - Problem 1: Rock-Paper-Scissors Game
 */
public class P1_RockPaperScissors {

    static String playRound(String playerMove, String computerMove) {
        if (playerMove.equals(computerMove)) {
            return "Draw";
        }
        if ((playerMove.equals("Rock") && computerMove.equals("Scissors"))
                || (playerMove.equals("Paper") && computerMove.equals("Rock"))
                || (playerMove.equals("Scissors") && computerMove.equals("Paper"))) {
            return "Player Wins";
        }
        return "Computer Wins";
    }

    public static void main(String[] args) {
        String[] moves = {"Rock", "Paper", "Scissors"};
        // Predefined player moves for demo (5 rounds)
        String[] playerMoves = {"Rock", "Paper", "Scissors", "Rock", "Paper"};

        Random rand = new Random();
        int wins = 0, losses = 0, draws = 0;

        System.out.println("Round | Player Move | Computer Move | Result");
        System.out.println("----------------------------------------------");

        for (int i = 0; i < 5; i++) {
            String player = playerMoves[i];
            String computer = moves[rand.nextInt(3)];
            String result = playRound(player, computer);

            System.out.printf("%5d | %-11s | %-13s | %s%n", i + 1, player, computer, result);

            if (result.equals("Player Wins")) wins++;
            else if (result.equals("Computer Wins")) losses++;
            else draws++;
        }

        double winPct = (wins * 100.0) / 5;
        System.out.printf("%nWins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%%n",
                wins, losses, draws, winPct);
    }
}
