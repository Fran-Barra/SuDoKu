package com.company;
import javasolver.Javasolver;
import javasolver.PrintSudoku;



public class Main {

    public static void main(String[] args) {
	// write your code here
        byte[][] sudoku = {
                {0,2,1,5,6,3,9,4,7},
                {3,9,7,2,1,4,5,6,8},
                {6,4,5,7,8,9,1,3,2},
                {1,7,9,4,3,2,6,8,5},
                {2,6,4,8,9,5,3,7,1},
                {5,8,3,1,7,6,2,9,4},
                {7,3,2,9,4,1,8,5,6},
                {4,5,6,3,2,8,7,1,9},
                {9,1,8,6,5,7,4,2,3}
        };
        byte[][] sudoku2 = {
            {0,0,0,5,6,0,0,0,7},
            {0,0,0,0,0,0,0,0,8},
            {0,4,0,0,8,0,0,3,0},
            {0,7,9,4,3,0,0,8,5},
            {0,0,0,0,9,0,0,0,0},
            {0,8,3,0,7,6,2,0,0},
            {7,3,2,0,4,0,0,0,6},
            {4,5,6,0,2,0,7,0,9},
            {0,0,0,0,5,7,4,0,0}
        };
        byte[][] sudoku3 = {
                {0,0,0,0,7,1,3,0,0},
                {1,0,8,0,0,0,0,2,6},
                {0,7,0,2,0,6,0,9,0},
                {5,8,6,1,0,2,4,0,0},
                {4,3,0,0,0,0,1,0,0},
                {0,0,0,7,6,0,5,0,0},
                {0,9,1,0,0,0,0,5,0},
                {0,4,0,0,0,0,0,0,0},
                {8,0,0,0,2,0,0,0,3}
        };
        byte[][] sudoku4 = {
                {0,0,0,0,0,1,0,0,4},
                {0,0,3,0,0,6,0,1,0},
                {0,5,0,0,0,0,0,0,0},
                {6,0,5,0,0,0,0,0,7},
                {0,0,4,0,9,8,0,0,6},
                {0,0,0,0,0,0,5,0,0},
                {0,0,0,4,0,7,9,0,0},
                {3,0,2,0,0,0,6,0,0},
                {1,0,0,0,8,0,0,0,0}
        };
        PrintSudoku.printSuDoKu(Javasolver.solver(sudoku4));
    }
}
