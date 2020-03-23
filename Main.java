
import java.util.Scanner;

public class Main {
    public static void main(String[] argv) {
        final int COL = 9;
        final int ROW = 9;
        Integer[][] board = new Integer[ROW][COL];
        Scanner scan = new Scanner(System.in);
        long start = System.nanoTime();
        for(int i = 0; i< board.length; i++){
            for(int a = 0; a< board[i].length; a++){
                board[i][a]= scan.nextInt();
            }
            scan.nextLine();
        }
        Solver solver = new Solver();
        solver.solve(board, 0, 0);
        printBoard(board);
        long end = System.nanoTime();
        long duration = (end - start)/10000000;
        System.out.println("Took: "+ (float)duration/1000 +" seconds.");
    }

    public static void printBoard(Integer[][] board){
        for(int i = 0; i< board.length; i++){
            if(i %3  == 0) {
                printline(board.length);

            }
            for(int a = 0; a< board[i].length; a++){
                if(a == 0){
                    System.out.print("|");
                    System.out.printf("%d%s", board[i][a]," ");
                }else {
                    if (a % 3 == 2) {
                        System.out.printf("%d%s", board[i][a], "|");
                    } else {
                        System.out.printf("%d%s", board[i][a], " ");
                    }
                }
            }
            System.out.println("");
        }
        printline(board.length);
    }
    public static void printline(int col){
        for(int i = 0; i< col; i++){
            System.out.print("--");
        }
        System.out.print("-");
        System.out.println();
    }
}
