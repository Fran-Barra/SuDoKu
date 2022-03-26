package javasolver;

import java.util.ArrayList;


public class Javasolver {
    public static byte[][] solver(byte[][] sudoku) {
        //the sudoku is multydimensional array of 9 columns of lenght 9
        int repetition = 1;
        boolean completed = false;
        while (repetition <= 82 && !completed) {
            completed = true;
            for (byte x = 0; x <= 8; x++) {
                for (byte y = 0; y <= 8; y++) {
                    if (sudoku[x][y] == 0) {
                        completed = false;
                        //selects the position of the scuare to check options
                        byte[] optionsFiller = {1, 2, 3, 4, 5, 6, 7, 8, 9};
                        ArrayList<Byte> options = new ArrayList<>();
                        for (byte number : optionsFiller) {
                            options.add(number);
                        }
                        for (int i = 0; i <= 8; i++)
                            //check "fila"
                            options = Javasolver.checkerColumOrRow(options, sudoku, x, i);


                        for (int j = 0; j <= 8; j++)
                            //check column
                            options = Javasolver.checkerColumOrRow(options, sudoku, j, y);

                        //check square 3x3
                        options = checkSquare3x3(options, sudoku, x, y);


                        if (options.size() == 1)
                            sudoku[x][y] = options.get(0);

                    }
                }
            }
            repetition++;
        }
        return sudoku;
    }

    private static byte[][] secondMedthod (byte[][] sudoku){
        //pos of 3x3 squares
        /* 0 1 2
           3 4 5
           6 7 8
         */
        //adquire square 3x3 options
        ArrayList<ArrayList<Byte>> multiSquare3x3Options = new ArrayList<>();
        for (byte y = 0; y<=8; y+=3){
            for (byte x = 0; x<=8; x+=3){
                byte[] optionsFiller = {1, 2, 3, 4, 5, 6, 7, 8, 9};
                ArrayList<Byte> options = new ArrayList<>();
                for (byte number : optionsFiller) {
                    options.add(number);
                }
                multiSquare3x3Options.add(Javasolver.checkSquare3x3(options,sudoku,x, y));
            }
        }

        int[] squares = {0,1,2,3,4,5,6,7,8,9};
        for (int square: squares){
            for (byte option: multiSquare3x3Options.get(square)){
                ArrayList<Byte> yValues;
                ArrayList<Byte> xValues;
                if (square == 0|| square == 1|| square == 2) {for (byte number:new byte[]{0,1,2}) {yValues.add(number);}}
                else if (square == 3|| square == 4|| square == 5) {yValues = new byte[]{3,4,5};}
                else {yValues = new byte[]{6,7,8};}

                if (square == 0|| square == 3|| square == 6) {xValues = new byte[]{0,1,2};}
                else if (square == 1|| square == 4|| square == 7) {xValues = new byte[]{3,4,5};}
                else {xValues = new byte[]{6,7,8};}

                int[] squaresToCheck;

                if (square == 0) {squaresToCheck = new int[]{1,2,3,6};}
                else if (square == 1) {squaresToCheck = new int[]{0,2,4,7};}
                else if (square == 2) {squaresToCheck = new int[]{0,1,5,8};}
                else if (square == 3) {squaresToCheck = new int[]{0,6,4,5};}
                else if (square == 4) {squaresToCheck = new int[]{1,7,3,5};}
                else if (square == 5) {squaresToCheck = new int[]{2,8,3,4};}
                else if (square == 6) {squaresToCheck = new int[]{0,3,7,8};}
                else if (square == 7) {squaresToCheck = new int[]{1,4,6,8};}
                else {squaresToCheck = new int[]{2,5,6,7};}

                for (int squareToCheck : squaresToCheck){
                    //if it not contains the option then it means that the square has the number
                    if (!multiSquare3x3Options.get(squareToCheck).contains(option)){
                        int column;
                        int line;

                        if (square == 0) {column = 0; line = 0;}
                        else if (square == 1) {column = 3; line = 0;}
                        else if (square == 2) {column = 6; line = 0;}
                        else if (square == 3) {column = 0; line = 3;}
                        else if (square == 4) {column = 3; line = 3;}
                        else if (square == 5) {column = 6; line = 3;}
                        else if (square == 6) {column = 0; line = 6;}
                        else if (square == 7) {column = 3; line = 6;}
                        else {column = 6; line = 6;}

                        int columnM = column + 2;
                        int lineM = line + 2;
                        while (column<columnM){
                            while (line<lineM){
                                if (option == sudoku[column][line]){
                                    if (yValues.)
                                }
                                line++;
                            }
                            line = line - lineM;
                            column++;
                        }

                    }
                }

            }
        }
    }

    private static ArrayList<Byte> checkerColumOrRow(ArrayList<Byte> options, byte[][] sudoku,int x, int y){
        int i = 0;
        while (i < options.size()) {
            if (options.get(i) == sudoku[x][y]){
                options.remove(i);
                break;
            }
            i++;
        }
        return options;
    }

    private static ArrayList<Byte> checkSquare3x3(ArrayList<Byte> options, byte[][] sudoku, byte x, byte y){
        byte maxX;
        byte maxY;

        x = (byte)((x/3)*3);
        maxX = (byte)(x + 2);

        y = (byte)((y/3)*3);
        maxY = (byte)(y + 2);

        while (y <= maxY) {
            while (x <= maxX){
                int i = 0;
                while (i < options.size()){
                    if (options.get(i) == sudoku[x][y]){
                        options.remove(i);
                        break;
                    }
                    i++;
                }
                x++;
            }
            x = (byte)(maxX-2);
            y++;
        }return options;
    }
}
