import java.util.*;
public class sudoku {
    public static boolean isSafe(int sudoku[][],int row,int col,int digit){
        //column
        for(int i=0;i<=8;i++){
            if(sudoku[i][col]==digit){
                return false;
            }
        }
        //row
        for(int i=0;i<=8;i++){
            if(sudoku[row][i]==digit){
                return false;
            }
        }
        //same 3x3 grid
        int sr = (row/3)*3;
        int sc= (col/3)*3;
        for(int i=sr;i<sr+3;i++){
            for(int j=sc;j<sc+3;j++){
                if (sudoku[i][j]==digit) {
                    return false;
                }
            }
        }
        return true;

    }
    public static boolean sudoku_solver(int sudoku[][],int row,int col){
        //base case
        if(row==9){
            return true;
        }
        
        
        //work
        int nextrow = row; int nextcol=col+1;
        if(col+1 ==9){
            nextrow = row+1;
            nextcol=0;
        }
        if(sudoku[row][col] != 0){
            return sudoku_solver(sudoku, nextrow, nextcol);//for not changing the default values in the soduku
        }
        for(int digit=1;digit<=9;digit++){
            if(isSafe(sudoku,row,col,digit)){
                sudoku[row][col] = digit;
                if(sudoku_solver(sudoku, nextrow, nextcol)){
                    return true;
                }else{
                    sudoku[row][col]=0;
                }
            }
        }
        return false;
    }
    public static void printSudoku(int sudoku[][]){
        for(int i=0;i<=8;i++){
            for(int j=0;j<=8;j++){
                System.out.print(sudoku[i][j]+"   ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int sudoku[][] = {                       // sample puzzle (0 = blank)
            {5, 3, 0, 0, 7, 0, 0, 0, 0},
            {6, 0, 0, 1, 9, 5, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 0, 6, 0},
            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},
            {7, 0, 0, 0, 2, 0, 0, 0, 6},
            {0, 6, 0, 0, 0, 0, 2, 8, 0},
            {0, 0, 0, 4, 1, 9, 0, 0, 5},
            {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };
        if(sudoku_solver(sudoku, 0, 0)){
            System.out.println("solution exist");
            printSudoku(sudoku);
        }else{
            System.out.println("Solution does not exist");
        }
        
    }
}
