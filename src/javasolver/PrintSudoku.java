package javasolver;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class PrintSudoku {
    public static void printSuDoKu(ArrayList<Integer>[][] sudoku){
        for (int y = 0; y <= 8; y++){
            ArrayList<Integer> line = new ArrayList<>();
            for (int x = 0; x <= 8; x++){
                line.add(sudoku[x][y].size() == 1? sudoku[x][y].get(0) : 0);
            }
            System.out.println(line);
        }
    }
}
