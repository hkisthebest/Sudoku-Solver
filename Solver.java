import java.util.ArrayList;
import java.util.List;

public class Solver {
    public static boolean solve(Integer[][] board, Integer row, Integer col){
//      swaping line.
        if(col == board[row].length){
            col = 0;
            row++;
            if(row == board.length){
                return true;
            }
        }
        if(board[row][col] != 0){
            if(solve(board, row, col+1)){
                return true;
            }
            return false;
        }
        for(int i = 1; i< board.length+1;i++){
            if(checkAll(board, row, col, i)) {
                board[row][col] = i;
                if(solve(board, row, col+1)) {
                    return true;
                }
            }
            board[row][col] = 0;
        }
        return false;
    }
//  check whether the row, column or box is legal.
    public static boolean checkAll(Integer[][] board, Integer row, Integer col, Integer value){
        Integer[][] temp = board;
        temp[row][col] = value;
        if(check(temp[row], value) && check(getBox(temp,row, col), value) && check(getCol(temp, col), value)){
            return true;
        }
        return false;
    }
//  get the box of the current cell.
    private static Integer[] getBox(Integer[][] board, Integer row, Integer col){
        int boxes = (int)Math.sqrt(board.length);
        int hBox = row/boxes;
        int vBox = col/boxes;
        int startingHPoint = boxes* hBox;
        int startingVPoint = boxes* vBox;

        Integer[] arr = new Integer[board.length];
        List<Integer> list = new ArrayList<>(board.length);
        for(int i = startingHPoint; i< startingHPoint+boxes; i++){
            for(int a = startingVPoint; a< startingVPoint+boxes; a++){
                list.add(board[i][a]);
            }
        }
        return list.toArray(arr);
    }
//  get the column of the current cell.
    private static Integer[] getCol(Integer[][] board, Integer col){
        Integer[] arr = new Integer[board.length];
        for(int i = 0; i< board.length; i++){
            arr[i] = board[i][col];
        }
        return arr;
    }
//  check if an array has duplicates.
    private static boolean check(Integer[] arrToBeChecked, Integer value) {
        int count = 0;
        for (int i = 0; i < arrToBeChecked.length; i++) {
            if (arrToBeChecked[i] == value) {
                count++;
            }
        }
        return count == 1;
    }

}
