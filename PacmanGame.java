import java.util.Scanner;

public class PacmanGame {

    private static final int PACMAN_START_ROW = 4;
    private static final int PACMAN_START_COL = 4;
    private static final int GHOST_START_ROW  = 1;
    private static final int GHOST_START_COL  = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GameBoard board  = new GameBoard();
        Pacman    pacman = new Pacman(PACMAN_START_ROW, PACMAN_START_COL);
        Ghost     ghost  = new Ghost(GHOST_START_ROW,  GHOST_START_COL);

        while (true) {
            board.printBoard(pacman, ghost);

            System.out.print("Move (W/A/S/D): ");
            char move = Character.toLowerCase(scanner.next().charAt(0));
            pacman.move(move, board);

            // Ghost now chases Pacman using distance formula
            ghost.move(board, pacman);

            if (pacman.getRow() == ghost.getRow() &&
                pacman.getCol() == ghost.getCol()) {
                board.printBoard(pacman, ghost);
                System.out.println("Game Over! Final score: " + pacman.getScore());
                break;
            }

            if (!board.hasFood()) {
                board.printBoard(pacman, ghost);
                System.out.println("You Win! Final score: " + pacman.getScore());
                break;
            }
        }
        scanner.close();
    }
}
