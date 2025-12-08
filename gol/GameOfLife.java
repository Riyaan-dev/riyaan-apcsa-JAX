package gol;

public class GameOfLife implements Board {

    private int[][] board;

    public GameOfLife(int x, int y)
    {
        board = new int[x][y];
    }

    public void set(int x, int y, int[][] data) {


        for (int i = 0; i < data.length; i++) {


            for (int j = 0; j < data[0].length; j++) {


                board[x + i][y + j] = data[i][j];
            }
        }
    }

    public void run(int turns) {


        int t = 0;




        while (t < turns) {


            step();


            t++;
        }
    }

    public void step()
    {
        print();

        int rows = board.length;


        int cols = board[0].length;



        int[][] next = new int[rows][cols];

        for (int r = 0; r < rows; r++) {


            for (int c = 0; c < cols; c++) {

                int neighbors = countNeighbors(r, c);


                int current = board[r][c];

                if (current == 1) {


                    if (neighbors < 2) {


                        next[r][c] = 0;


                    } else if (neighbors == 2 || neighbors == 3) {


                        next[r][c] = 1;
                    } else {
                        next[r][c] = 0;
                    }
                } else {
                    if (neighbors == 3) {
                        next[r][c] = 1;


                    } else {
                        next[r][c] = 0;
                    }
                }
            }
        }

        board = next;
    }

    public int countNeighbors(int x, int y) {
        int count = 0;



        for (int r = -1; r <= 1; r++) {
            for (int c = -1; c <= 1; c++) {

                if (r == 0 && c == 0) {
                    continue;
                }

                int value = get(x + r, y + c);


                count = count + value;
            }
        }

        return count;
    }

    public int get(int x, int y) {


        int rows = board.length;


        int cols = board[0].length;

        while (x < 0) {


            x = x + rows;
        }
        while (x >= rows) {


            x = x - rows;
        }

        while (y < 0) {
            y = y + cols;
        }
        while (y >= cols) {

            y = y - cols;
        }

        return board[x][y];
    }

    public int[][] get()
    {
        return board;
    }

    public void print(){
        System.out.print("\n ");

        for (int y = 0; y < board[0].length; y++) {


            System.out.print(y % 10 + " ");
        }

        for (int x = 0; x < board.length; x++) {


            System.out.print("\n" + x % 10);

            for (int y = 0; y < board[x].length; y++) {

                
                if (board[x][y] == 1) {
                    
                    System.out.print("⬛");
                } else {
                    System.out.print("⬜");
                }
            }
        }

        System.out.println();
    }
}
