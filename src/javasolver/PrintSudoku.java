package javasolver;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class PrintSudoku {
    public static void printSuDoKu(byte[][] sudoku){
        for (int y = 0; y <= 8; y++){
            ArrayList<Byte> line = new ArrayList<>();
            for (int x = 0; x <= 8; x++){
                line.add(sudoku[x][y]);
            }
            System.out.println(line);
        }
    }
}
