import java.util.Random;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Random ran = new Random();
        char[][] gameBoard = {
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}
        };
        int player = 1;
        boolean win = false;
        int plays = 0;

        while(!win){

            printGameBoard(gameBoard);

            if(plays == 9){
                System.out.println("It's a Tie");
                break;
            }
            if(player == 1){

                Scanner scan = new Scanner(System.in);
                System.out.println("Enter your placement (1-9)");
                int position = scan.nextInt();

                if(isEmpty(gameBoard, position)){

                    yourTurn(gameBoard, player, position);

                    if(playStatus(gameBoard)){

                        printGameBoard(gameBoard);
                        System.out.println("Player 1 wins!!!!!");
                        win = true;

                    };

                    player = 2;
                    plays++;
                }else{
                    System.out.println("Spot is already taken, please try again.");
                    continue;
                }
            }else if(player == 2){

                int cpu = ran.nextInt(9) + 1;

                if(isEmpty(gameBoard,cpu)){

                    yourTurn(gameBoard, player, cpu);

                    if(playStatus(gameBoard)){
                        printGameBoard(gameBoard);
                        System.out.println("CPU wins...");
                        win = true;
                    };

                    player = 1;
                    plays++;
                }else{
                    continue;
                }
            }

        }
    }

    public static void printGameBoard(char[][] gameBoard){
        System.out.println("-------------------------");
        for(char[] row: gameBoard){
            for(char line: row){
                System.out.print(line);
            }
            System.out.println();
        }
    }

    public static void yourTurn(char[][] gameBoard, int player, int position){
        char marker = player%2 > 0 ? 'X' : 'O';
        switch (position){
            case 1:
                if(gameBoard[0][0] == ' '){
                    gameBoard[0][0] = marker;
                }
                break;
            case 2:
                if(gameBoard[0][2] == ' '){
                    gameBoard[0][2] = marker;
                }
                break;
            case 3:
                if(gameBoard[0][4] == ' '){
                    gameBoard[0][4] = marker;
                }
                break;
            case 4:
                if(gameBoard[2][0] == ' '){
                    gameBoard[2][0] = marker;
                }
                break;
            case 5:
                if(gameBoard[2][2] == ' '){
                    gameBoard[2][2] = marker;
                }
                break;
            case 6:
                if(gameBoard[2][4] == ' '){
                    gameBoard[2][4] = marker;
                }
                break;
            case 7:
                if(gameBoard[4][0] == ' '){
                    gameBoard[4][0] = marker;
                }
                break;
            case 8:
                if(gameBoard[4][2] == ' '){
                    gameBoard[4][2] = marker;
                }
                break;
            case 9:
                if(gameBoard[4][4] == ' '){
                    gameBoard[4][4] = marker;
                }
                break;
        }
    }

    public static boolean isEmpty(char[][] gameBoard, int position){
        boolean empty = false;
        switch (position){
            case 1:
                if(gameBoard[0][0] == ' '){
                    empty = true;
                }
                break;
            case 2:
                if(gameBoard[0][2] == ' '){
                    empty = true;
                }
                break;
            case 3:
                if(gameBoard[0][4] == ' '){
                    empty = true;
                }
                break;
            case 4:
                if(gameBoard[2][0] == ' '){
                    empty = true;
                }
                break;
            case 5:
                if(gameBoard[2][2] == ' '){
                    empty = true;
                }
                break;
            case 6:
                if(gameBoard[2][4] == ' '){
                    empty = true;
                }
                break;
            case 7:
                if(gameBoard[4][0] == ' '){
                    empty = true;
                }
                break;
            case 8:
                if(gameBoard[4][2] == ' '){
                    empty = true;
                }
                break;
            case 9:
                if(gameBoard[4][4] == ' '){
                    empty = true;
                }
                break;
        }
        return empty;
    }

    public static boolean playStatus(char[][] gameBoard){
        return
                (gameBoard[0][0] == gameBoard[0][2] && gameBoard[0][2] == gameBoard[0][4] && gameBoard[0][4] != ' ') ||
                (gameBoard[2][0] == gameBoard[2][2] && gameBoard[2][2] == gameBoard[2][4] && gameBoard[2][4] != ' ') ||
                (gameBoard[4][0] == gameBoard[4][2] && gameBoard[4][2] == gameBoard[4][4] && gameBoard[4][4] != ' ') ||
                (gameBoard[0][0] == gameBoard[2][2] && gameBoard[2][2] == gameBoard[4][4] && gameBoard[4][4] != ' ') ||
                (gameBoard[0][4] == gameBoard[2][2] && gameBoard[2][2] == gameBoard[4][0] && gameBoard[4][0] != ' ') ||
                (gameBoard[0][0] == gameBoard[2][0] && gameBoard[2][0] == gameBoard[4][0] && gameBoard[4][0] != ' ') ||
                (gameBoard[0][2] == gameBoard[2][2] && gameBoard[2][2] == gameBoard[4][2] && gameBoard[4][2] != ' ') ||
                (gameBoard[0][4] == gameBoard[2][4] && gameBoard[2][4] == gameBoard[4][4] && gameBoard[4][4] != ' ');

    }

}