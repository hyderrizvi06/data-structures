public class Grid
{
    private static final int SIZE = 10;
    int[][] pixels = new int[SIZE][SIZE];

    public Grid(){
        for (int i = 0; i < 10 ; i++){
            for (int j = 0; j < 10 ; j++){
                pixels[i][j] = 0;
            }
        }
    }

    /**
     * Flood fill, starting with the given row and column.
    */
    public void floodfill(int row, int column)
    {
        int n = 1;
        if(row >= 0 && row < 10 && column < 10 && column >= 0){
            pixels[row][column] = n;
            floodfill(row + 1, column + 1, n + 1);
            floodfill(row + 1, column - 1, n + 1);
            floodfill(row - 1, column + 1, n + 1);
            floodfill(row - 1, column - 1, n + 1);
        }
    }

    public void floodfill(int row, int column, int n)
    {
        if(row >= 0 && row < 10 && column < 10 && column >= 0 && pixels[row][column] == 0){
            pixels[row][column] = n;
            floodfill(row + 1, column + 1, n + 1);
            floodfill(row + 1, column - 1, n + 1);
            floodfill(row - 1, column + 1, n + 1);
            floodfill(row - 1, column - 1, n + 1);
        }
    }

    @Override
    public String toString()
    {
        String r = "";
        for (int i = 0; i < SIZE; i++)
        {
            for (int j = 0; j < SIZE; j++)
                r = r + String.format("%4d", pixels[i][j]);
            r = r + "\n";
        }
        return r;
    }
}
