import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class SudokuSolver {
    private final int M = 3;
    private final int N = M * M;
    private int[][] grid;
    private ArrayList<Set<Integer>> rows;
    private ArrayList<Set<Integer>> cols;
    private ArrayList<Set<Integer>> squares;
    private Set<Integer> nums;

    public SudokuSolver(String fileName) {
        // read the puzzle file
        try (Scanner in = new Scanner(new File(fileName))) {

            this.grid = new int[N][N];

            for (int row = 0; row < N; row++) {
                String line = in.next();

                for (int col = 0; col < N; col++) {
                    String strVal = line.substring(col, col + 1);
                    int number;
                    if (strVal.equals("x")) {
                        number = 0;
                    } else {
                        number = Integer.parseInt(strVal);
                    }
                    this.grid[row][col] = number;
                }

                
            }
            //System.out.println(grid);
        } catch (FileNotFoundException e) {
            System.out.println("Cannot open: " + fileName);
        }

        // create the list of sets for each row (this.rows)

        this.rows = new ArrayList<>();
        for(int i = 0; i < 9; i++){
            Set<Integer> row = new HashSet<>();
            for(int j = 0; j < 9; j++){
                row.add(grid[i][j]);
            }
            

            this.rows.add(row);
            //System.out.println(row + "DUPE:");
            
            //row.clear();
            System.out.println(this.rows.get(i));
        }
        System.out.println("///////");

        //System.out.println(this.rows);
            

        // create the list of sets for each col (this.cols)
        
        
        this.cols = new ArrayList<>();
        for(int i = 0; i < 9; i++){
            Set<Integer> col = new HashSet<>();
            for(int j = 0; j < 9; j++){
                col.add(grid[j][i]);
            }
            this.cols.add(col);
            System.out.println(col);
            //col.clear();
        }
        System.out.println("///////");
        // create the list of sets for each square (this.squares)
        /* the squares are added to the list row-by-row:
            0 1 2
            3 4 5
            6 7 8
         */
        //

        this.squares = new ArrayList<>();
        for(int l = 0; l < 7; l+=3){
            for(int k = 0; k < 7; k+=3){
                Set<Integer> square = new HashSet<>();
                for(int i = 0+k; i < 3+k; i++){
                    
                    for(int j = 0+l; j < 3+l; j++){
                        square.add(grid[i][j]);
                        //System.out.println(""+i+", "+j);
                    }
                    
                }
                this.squares.add(square);
                System.out.println(square);
                //squares.clear();
                System.out.println("NEW\n");
            }
        }
        // create a hash set for [1..9] (this.nums)
        this.nums = new HashSet<>();
        for(int i = 1; i < 10; i++){
            nums.add(i);
        }

        //visually inspect that all the sets are correct
        
        for (int row = 0; row < N; row++) {
            System.out.println("row " + row + ": " + this.rows.get(row));
        }
        for (int col = 0; col < N; col++) {
            System.out.println("col " + col + ": " + this.cols.get(col));
        }
        for (int square = 0; square < N; square++) {
            System.out.println("square " + square + ": " + this.squares.get(square));
        }
        System.out.println(this.nums);
    }

    public boolean solve() {
        // find an empty location, if any
        boolean finished = true;
        int nextRow = -1;
        int nextCol = -1;
        for (int row = 0; row < N && finished; row++) {
            for (int col = 0; col < N && finished; col++) {
                if (this.grid[row][col] == 0) {
                    finished = false;
                    nextRow = row;
                    nextCol = col;
                }
            }
        }

        // the board is complete; we solved it
        if (finished) {
            return true;
        }

        // get all possible numbers for the row and column we are trying to populate
        /*
            Create a new set based on the this.nums and remove all elements in the sets
            corresponding to nextRow, nextCol, and the corresponding square (use the
            removeAll method).

            Properly indexing the squares list of sets is tricky. Verify that your
            algorithm is correct.
         */
        Set<Integer> possibleNums = new HashSet<Integer>();
        possibleNums.addAll(this.nums);
        
        for(int i = 1; i < 10; i++){
            int sqr = (3*((int)(nextCol/3))) + (int)(nextRow/3);
            if(this.rows.get(nextRow).contains(i) || this.cols.get(nextCol).contains(i) || this.squares.get(sqr).contains(i))
                possibleNums.remove(i);
        }

        // if there are no possible numbers, we cannot solve the board in its current state
        if (possibleNums.isEmpty()) {
            return false;
        }
        //if(this.grid[0][0] == 3 && this.grid[0][1] == 1 && this.grid[0][2] == 9 && this.grid[0][3] == 6)
            //System.out.println(possibleNums);
        // try each possible number
        for (Integer possibleNum : possibleNums) {
            // update the grid and all three corresponding sets with possibleNum
            for (int row = nextRow; row < nextRow + 3 && row >= 0; row++) {
                for (int col = nextCol; col < nextCol + 3 && col >= 0; col++) {
                    if (this.grid[row][col] == 0) {
                        //if(row == 0 && col == 3){
                            //System.out.println("\nWHERE SIX: " + possibleNums + "\n"+ this.rows.get(0) +"\n");
                        //}
                        this.grid[row][col] = possibleNum;
                        int sqr = (3*((int)(nextCol/3))) + (int)(nextRow/3);
                        int num = possibleNum.intValue();
                        this.rows.get(row).add(num);
                        this.cols.get(col).add(num);
                        this.squares.get(sqr).add(num);
                        col = -100;
                        row = -100;

                        //quickp();
                    }
                }
            }

            // recursively solve the board
            if (this.solve()) {
                // the board is solved!
                return true;
            } else {
                //if(this.grid[0][0] == 3 && this.grid[0][1] == 1 && this.grid[0][2] == 9 && this.grid[0][3] == 6)
                    //System.out.println("WRONG: "+possibleNum.intValue());
                for (int row = nextRow; row < nextRow + 3 && row >= 0; row++) {
                    for (int col = nextCol; col < nextCol + 3 && col >= 0; col++) {
                        if (this.grid[row][col] == possibleNum) {
                            int sqr = (3*((int)(nextCol/3))) + (int)(nextRow/3);
                            int num = possibleNum.intValue();
                            this.grid[row][col] = 0;
                            this.rows.get(row).remove(num);
                            this.cols.get(col).remove(num);
                            this.squares.get(sqr).remove(num);
                            col = -100;
                            row = -100;
                        }
                    }
                }
            }
        }

        return false;
    }

    public String toString() {
        String str = "";

        for (int[] row : grid) {
            for (int val : row) {
                str += val + "\t";
            }

            str += "\n";
        }

        return str;
    }

    public void quickp() {
        if (this.grid[0][0] == 3 && this.grid[0][1] == 1 && this.grid[0][2] == 9 && this.grid[0][3] == 6){
            String str = "";

            for (int[] row : grid) {
                for (int val : row) {
                 str += val + "\t";
                }

                str += "\n";
            }

            System.out.println(str);
        }
    }

    public static void main(String[] args) {
        String fileName = "Chapter 15 Activities/Sudoku/src/puzzle1.txt";
        
        SudokuSolver solver = new SudokuSolver(fileName);
        System.out.println(solver);
        if (solver.solve()) {
            System.out.println("Solved!");
            System.out.println(solver);
        } else {
            System.out.println("Unsolveable...");
        }
    }
}