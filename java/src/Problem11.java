import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Created by adam on 2/1/14.
 */
public class Problem11 implements Euler {
    final String file = "text/Problem11.txt";
    final int height = 20;
    final int width = 20;
    BufferedReader in;
    int[][] grid = new int[20][20];

    public Problem11() throws Exception {
        String currentLine;
        in = new BufferedReader(new FileReader(file));
        int row = 0;
        while((currentLine = in.readLine()) != null) {
            String[] row_arr = currentLine.split(" ");
            for(int col = 0; col < row_arr.length; col++) {
                grid[row][col] = Integer.parseInt(row_arr[col]);
            }
            row++;
        }
    }

        /*
            (-1,-1) | (-1,0) | (-1, 1)
            (0, -1) | (0, 0) | (0, 1)
            (1, -1) | (1, 0) | (1, 1)
         */

    private int up(int row, int col, int depthRemaining, int valueSoFar) {
        if(depthRemaining == 0) {
            return valueSoFar;
        }

        //Bounds check
        if (row < 0 || col < 0 || row >= height || col >= width) {
            return 0;
        }

        int current = grid[row][col];
        int newValue = valueSoFar * current;
        int newDepth = depthRemaining-1;

        return up(row-1, col, newDepth, newValue);
    }

    private int down(int row, int col, int depthRemaining, int valueSoFar) {
        if(depthRemaining == 0) {
            return valueSoFar;
        }

        //Bounds check
        if (row < 0 || col < 0 || row >= height || col >= width) {
            return 0;
        }

        int current = grid[row][col];
        int newValue = valueSoFar * current;
        int newDepth = depthRemaining-1;

        return down(row + 1, col, newDepth, newValue);
    }

    private int left(int row, int col, int depthRemaining, int valueSoFar) {
        if(depthRemaining == 0) {
            return valueSoFar;
        }

        //Bounds check
        if (row < 0 || col < 0 || row >= height || col >= width) {
            return 0;
        }

        int current = grid[row][col];
        int newValue = valueSoFar * current;
        int newDepth = depthRemaining-1;

        return left(row, col - 1, newDepth, newValue);
    }

    private int right(int row, int col, int depthRemaining, int valueSoFar) {
        if(depthRemaining == 0) {
            return valueSoFar;
        }

        //Bounds check
        if (row < 0 || col < 0 || row >= height || col >= width) {
            return 0;
        }

        int current = grid[row][col];
        int newValue = valueSoFar * current;
        int newDepth = depthRemaining-1;

        return right(row, col + 1, newDepth, newValue);
    }

    private int backSlash(int row, int col, int depthRemaining, int valueSoFar) {
        if(depthRemaining == 0) {
            return valueSoFar;
        }

        //Bounds check
        if (row < 0 || col < 0 || row >= height || col >= width) {
            return 0;
        }

        int current = grid[row][col];
        int newValue = valueSoFar * current;
        int newDepth = depthRemaining-1;

        return backSlash(row + 1, col + 1, newDepth, newValue);
    }

    private int slash(int row, int col, int depthRemaining, int valueSoFar) {
        if(depthRemaining == 0) {
            return valueSoFar;
        }

        //Bounds check
        if (row < 0 || col < 0 || row >= height || col >= width) {
            return 0;
        }

        int current = grid[row][col];
        int newValue = valueSoFar * current;
        int newDepth = depthRemaining-1;

        return slash(row + 1, col - 1, newDepth, newValue);
    }

    @Override
    public String answer() {
        long max = 0;
        for(int col = 0; col < width; col++) {
            for(int row = 0; row < height; row++) {
                int right = right(row, col, 4, 1);
                int left = left(row, col, 4, 1);
                int up = up(row, col, 4, 1);
                int down = down(row, col, 4, 1);
                int slash = slash(row, col, 4, 1);
                int backSlash = backSlash(row, col, 4, 1);
                int curr = Math.max(right, Math.max(left, Math.max(up, Math.max(down, Math.max(slash, backSlash)))));
                if (curr > max) {
                    max = curr;
                }
            }
        }
        return Long.toString(max);
    }
}
