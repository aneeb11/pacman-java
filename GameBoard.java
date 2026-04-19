public class GameBoard {


    private char[][] structure = {
        {'#','#','#','#','#','#','#','#','#'},
        {'#','.','.','.','#','.','.','.','#'},
        {'#','.','#','.','#','.','#','.','#'},
        {'#','.','#','.','.','.','#','.','#'},
        {'#','.','.','#',' ','#','.','.','#'},
        {'#','.','#','.','.','.','#','.','#'},
        {'#','.','#','.','#','.','#','.','#'},
        {'#','.','.','.','#','.','.','.','#'},
        {'#','#','#','#','#','#','#','#','#'}
    };


    public boolean isWall(int row, int col) {
        return structure[row][col] == '#';
    }

    public boolean isFood(int row, int col) {
        return structure[row][col] == '.';  
    }

    public boolean hasFood() {
        for (int i = 0; i < structure.length; i++) {
            for (int j = 0; j < structure[i].length; j++) {
                if (structure[i][j] == '.') return true;
            }
        }
        return false;
    }


    public void eatFood(int row, int col) {
        structure[row][col] = ' '; 
    }

    public void printBoard(Pacman p, Ghost g) {
        for (int i = 0; i < structure.length; i++) {
            for (int j = 0; j < structure[i].length; j++) {
                if (i == p.getRow() && j == p.getCol()) {
                    System.out.print('@');
                } else if (i == g.getRow() && j == g.getCol()) {
                    System.out.print('G');
                } else {
                    System.out.print(structure[i][j]);
                }
            }
            System.out.println();
        }
        System.out.println("Score: " + p.getScore());
    }

    public int getRows() {
        return structure.length;
    }

    public int getCols() {
        return structure[0].length;
    }
}