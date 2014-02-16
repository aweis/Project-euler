import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;

/**
 * Created by adam on 2/16/14.
 */
public class Problem18 implements Euler {
    int[][] table;
    public Problem18() throws Exception {
        LinkedList<String> l = new LinkedList<String>();
        BufferedReader in = new BufferedReader(new FileReader("text/Problem18b.txt"));
        String currentLine;
        while((currentLine = in.readLine()) != null) {
            l.addLast(currentLine);
        }
        table = new int[l.size()][l.getLast().split(" ").length];
        int row = 0;
        for(String s : l) {
            int col = 0;
            for(String elem : s.split(" ")) {
                table[row][col] = Integer.parseInt(elem);
                col++;
            }
            row++;
        }
    }

    private void printTable() {
        for (int i = 0; i < table[0].length; i++) {
            for (int j = 0; j < table.length; j++) {
                System.out.print(table[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
    @Override
    public String answer() throws Exception {
        for(int row = 1; row < table[0].length; row++) {
            for(int col = 0; col < table.length; col++) {
                if (col == 0) {
                    table[row][col]+= table[row-1][col];
                } else if (col == table.length-1) {
                    table[row][col]+= table[row-1][col-1];
                } else {
                    table[row][col] += Math.max(table[row-1][col-1], table[row-1][col]);
                }
            }
        }
        int max = 0;
        for(int i = 0; i < table[0].length; i++) {
            int temp = table[table.length-1][i];
            if (temp > max) {
                max = temp;
            }
        }
        return Integer.toString(max);
    }
}
