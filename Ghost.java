public class Ghost {
    private int row;
    private int col;

    public Ghost(int row, int col) {
        this.row = row;
        this.col = col;
    }

    //Distance Formula
    public double calculateDistance(int fromRow, int fromCol,
                                    int toRow,   int toCol) {
        int dr = toRow - fromRow;
        int dc = toCol - fromCol;
        return Math.sqrt(dr * dr + dc * dc);
    }
    public void move(GameBoard board, Pacman pacman) {
        int[] dRow = {-1, 1,  0, 0};   // up, down, left, right
        int[] dCol = { 0, 0, -1, 1};

        int    bestRow  = row;
        int    bestCol  = col;
        double bestDist = Double.MAX_VALUE;

        for (int i = 0; i < 4; i++) {
            int nr = row + dRow[i];
            int nc = col + dCol[i];


            if (nr < 0 || nr >= board.getRows()) continue;
            if (nc < 0 || nc >= board.getCols()) continue;

            // wall check
            if (board.isWall(nr, nc)) continue;

            double dist = calculateDistance(nr, nc,
                                            pacman.getRow(),
                                            pacman.getCol());

            // Primary sort: smaller distance wins
            // Tie-break: prefer row movement over column movement
            if (dist < bestDist ||
               (dist == bestDist && dRow[i] != 0)) {
                bestDist = dist;
                bestRow  = nr;
                bestCol  = nc;
            }
        }

        row = bestRow;
        col = bestCol;
    }

    public int getRow() { return row; }
    public int getCol() { return col; }
}
