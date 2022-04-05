package javasolver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Javasolver {

    private static ArrayList<Integer>[][] matrixOfOptionsCreator(Integer[][] sudoku) {
        ArrayList<Integer>[][] matrixOfOptions = new ArrayList[9][9];
        for (int x = 0; x <= 8; x++) {
            for (int y = 0; y <= 8; y++) {
                // si en el sudoku hay un cero, reemplazo por la lista de opciones del 1 l 9
                if (sudoku[x][y] == 0)
                    matrixOfOptions[x][y] = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
                // sino reemplazo por una lista de una sola posicion con el numero que esta en esa posicion del sudoku
                else
                    matrixOfOptions[x][y] = new ArrayList<>(List.of(sudoku[x][y]));
            }
        }
        return matrixOfOptions;
    }

    public static ArrayList<Integer>[][] solver(Integer[][] sudoku) {
        //the sudoku is multydimensional array of 9 columns of lenght 9
        ArrayList<Integer>[][] matrixOfOptions = matrixOfOptionsCreator(sudoku);
        int repetition = 1;
        boolean completed = false;
        while (repetition <= 82 && !completed) {
            completed = true;
            // recorro cada casilla del sudoku, de arriba para abajo, de izq a der
            for (int x = 0; x <= 8; x++) {
                for (int y = 0; y <= 8; y++) {
                    // si no hay una sola opcion, o sea el numero esta fijo, evaluo que opciones puedo descartar
                    if (matrixOfOptions[x][y].size() > 1) {
                        completed = false;
                        checkColumAndRow(matrixOfOptions, x, y);
                        checkSquare3x3(matrixOfOptions, x, y);
                    }
                }
            }
            repetition++;
        }
        return matrixOfOptions;
    }

    private static void checkColumAndRow(ArrayList<Integer>[][] matrixOfOptions, int x, int y){
        ArrayList<Integer> options = matrixOfOptions[x][y];
        ArrayList<Integer> totalOptions = new ArrayList<>();
        for (int j = 0; j <= matrixOfOptions.length - 1 && options.size() > 1; j++){
            // itero las posiciones de x e y para ir comparando con la opcion en el index i
            // funciona siempre y cuando la matriz es cuadrada
            if (x!=j && matrixOfOptions[j][y].size() == 1)
                options.remove(matrixOfOptions[j][y].get(0));
            else if (x!=j)
                addWithoutRepetition(totalOptions, matrixOfOptions[j][y]);
            if (y!=j && matrixOfOptions[x][j].size() == 1)
                options.remove(matrixOfOptions[x][j].get(0));
            else if (y!=j)
                addWithoutRepetition(totalOptions, matrixOfOptions[x][j]);
        }
        for (Integer option: options){
            if (!totalOptions.contains(option)){
                options.clear();
                options.add(option);
                break;
            }
        }
    }

    private static void checkSquare3x3(ArrayList<Integer>[][] matrixOfOptions, int x, int y){
        ArrayList<Integer> options = matrixOfOptions[x][y];
        ArrayList<Integer> totalOptions = new ArrayList<>();
        int auxX = (x/3)*3;
        int auxY = (y/3)*3;
        int maxX = auxX + 2;
        int maxY = auxY + 2;

        //recorro el sub cuadrante donde se encuentra la casilla que estoy analizando, de izq a der y de up to down
        while (auxY <= maxY) {
            while (auxX <= maxX){
                if (!((auxX == x) && (auxY == y)) && matrixOfOptions[auxX][auxY].size() == 1)
                    options.remove(matrixOfOptions[auxX][auxY].get(0));
                else if (!((auxX == x) && (auxY == y)))
                    addWithoutRepetition(totalOptions, matrixOfOptions[auxX][auxY]);
                auxX++;
            }
            auxX = maxX-2;
            auxY++;
        }
        for (Integer option: options){
            if (!totalOptions.contains(option)){
                options.clear();
                options.add(option);
                break;
            }
        }
    }

    private static void addWithoutRepetition(ArrayList<Integer> original, ArrayList<Integer> extension){
        for (Integer element: extension){
            if (!original.contains(element))
                original.add(element);
        }
    }
}
