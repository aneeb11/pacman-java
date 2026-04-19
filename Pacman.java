public class Pacman {

    private int row;
    private int col;
    private int score = 0;


    public Pacman(int row, int col) {
        this.row = row;
        this.col = col;
    }


    public void move(char direction, GameBoard board) {
        int newRow = row;
        int newCol = col;

    
        if (direction == 'w') {
            newRow--;
        } else if (direction == 's') {
            newRow++;
        } else if (direction == 'a') {
            newCol--;
        } else if (direction == 'd') {
            newCol++;
        }

    
        if (newRow >= 0 && newRow < board.getRows() &&
            newCol >= 0 && newCol < board.getCols() &&
            !board.isWall(newRow, newCol)) {

            
            if (board.isFood(newRow, newCol)) {
                score++;
                board.eatFood(newRow, newCol);
            }

            row = newRow;
            col = newCol;
        }
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public int getScore() {
        return score;
    }
}