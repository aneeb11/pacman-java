public class Ghost {


    private int row;
    private int col;


    public Ghost(int row, int col) {
        this.row = row;
        this.col = col;
    }


    public void move(GameBoard board) {
        int direction = (int) (Math.random() * 4);
        int jump    = (int) (Math.random() * 6);

        int newRow = row;
        int newCol = col;

        if (direction == 0) {
            newRow -= jump;
        } else if (direction == 1) {
            newRow += jump;
        } else if (direction == 2) {
            newCol -= jump;
        } else if (direction == 3) {
            newCol += jump;
        }

        if (newRow >= 0 && newRow < board.getRows() &&
            newCol >= 0 && newCol < board.getCols() &&
            !board.isWall(newRow, newCol)) {
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
}