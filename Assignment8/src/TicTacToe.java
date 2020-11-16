import java.util.*;



/**
 * I put some codes I wrote in ticTacToe.java file which can give some tips I think.
 * You can just delete codes or functions I wrote if you come up with some other methods to finish the requirements.
 */

public class TicTacToe {

    private static List<Integer> playerPositions = new ArrayList<>();
    private static List<Integer> cpuPositions = new ArrayList<>();

    public static void main(String[] args) {
        char[][] gameBoard = {
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
        };

        printGameBoard(gameBoard);


        while (true) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter your placement (1-9): ");
            int playerPos = scan.nextInt();
            // write your code here
            if(checkPosValid(playerPos)){
                System.out.println("Your position: " + playerPos);
                placePiece(gameBoard, playerPos, "player");
                int cpuPos = cpuTurn();
                System.out.println("CPU's position: " + cpuPos);
                placePiece(gameBoard, cpuPos, "cpu");
                if(isGameOver())
                    break;
            }
            else{
                System.out.println("Please type another valid position.");
            }
        }
    }

    public static void printGameBoard(char[][] gameBoard) {
        // write your code here
        for(int i = 0; i < gameBoard.length; i++){
            for(int j = 0; j < gameBoard[0].length; j++){
                System.out.println(gameBoard[i][j]);
            }
        }
    }

    public static void placePiece(char[][] gameBoard, int pos, String user) {

        char symbol = ' ';
        if (user.equals("player")) {
            symbol = 'X';
            playerPositions.add(pos);
        } else if (user.equals("cpu")) {
            symbol = 'O';
            cpuPositions.add(pos);
        }

        // write your code here
        int row = (pos - 1) / 3 * 2;
        int col = (pos - 1) % 3 * 2;
        gameBoard[row][col] = symbol;

    }

    public static boolean checkPosValid(int pos){
        boolean isValid = (!playerPositions.contains(pos)) && (!cpuPositions.contains(pos));
        return isValid;
    }

    public static int cpuTurn(){
        int cpuPos;
        do{
            cpuPos = (int)(Math.random() * 9 + 1);
        }while(!checkPosValid(cpuPos));
        return cpuPos;

    }

    public static boolean isBoardFull(){
        if(playerPositions.size() + cpuPositions.size() == 9)
            return true;
        return false;
    }

    public static String checkWinner() {
        // write your code here
        String winner;
        if (playerPositions.size() >= 3 && cpuPositions.size() >= 3) {
            if ((cpuPositions.contains(1) && cpuPositions.contains(2) && cpuPositions.contains(3)) ||
                    (cpuPositions.contains(4) && cpuPositions.contains(5) && cpuPositions.contains(6)) ||
                    (cpuPositions.contains(7) && cpuPositions.contains(8) && cpuPositions.contains(9)) ||
                    (cpuPositions.contains(1) && cpuPositions.contains(4) && cpuPositions.contains(7)) ||
                    (cpuPositions.contains(2) && cpuPositions.contains(5) && cpuPositions.contains(8)) ||
                    (cpuPositions.contains(3) && cpuPositions.contains(6) && cpuPositions.contains(9)) ||
                    (cpuPositions.contains(1) && cpuPositions.contains(5) && cpuPositions.contains(9)) ||
                    (cpuPositions.contains(3) && cpuPositions.contains(5) && cpuPositions.contains(7)))
                return "cpu";
            else if ((playerPositions.contains(1) && playerPositions.contains(2) && playerPositions.contains(3)) ||
                    (playerPositions.contains(4) && playerPositions.contains(5) && playerPositions.contains(6)) ||
                    (playerPositions.contains(7) && playerPositions.contains(8) && playerPositions.contains(9)) ||
                    (playerPositions.contains(1) && playerPositions.contains(4) && playerPositions.contains(7)) ||
                    (playerPositions.contains(2) && playerPositions.contains(5) && playerPositions.contains(8)) ||
                    (playerPositions.contains(3) && playerPositions.contains(6) && playerPositions.contains(9)) ||
                    (playerPositions.contains(1) && playerPositions.contains(5) && playerPositions.contains(9)) ||
                    (playerPositions.contains(3) && playerPositions.contains(5) && playerPositions.contains(7)))
                return "player";

        }
        return "no winner";
    }

    public static boolean isGameOver(){
        String winner = checkWinner();
        if(winner.equals("cpu")){
            System.out.println("CPU wins! Sorry:(");
            return true;
        }
        else if(winner.equals("player")){
            System.out.println("Congratulations you won!");
            return true;
        }
        else if(isBoardFull()){
            System.out.println("CAT!");
            return true;
        }
        return false;
    }
}
