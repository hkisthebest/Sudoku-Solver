
import java.util.Scanner;

public class Main {
    public static void main(String[] argv) {
        final int COL = 9;
        final int ROW = 9;
        Integer[][] board = new Integer[ROW][COL];
        Scanner scan = new Scanner(System.in);

        for(int i = 0; i< board.length; i++){
            for(int a = 0; a< board[i].length; a++){
                board[i][a]= scan.nextInt();
            }
            scan.nextLine();
        }
        
        Solver solver = new Solver();
        solver.solve(board, 0, 0);
        printBoard(board);
    }

    public static void printBoard(Integer[][] board){
        for(int i = 0; i< board.length; i++){
            for(int a = 0; a< board[i].length; a++){
                System.out.print(board[i][a]+" ");
            }
            System.out.println("\n");
        }
    }

}
