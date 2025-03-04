import java.util.ArrayList;
import java.util.Scanner;

public class App {
    static String[][] whole_cube = {
        //0    1    2    3    4    5    6    7    8    9    10   11  
        {"y", "y", "y",  // 0 1 2                                   
         "y", "y", "y",  // 3 4 5   // 0
         "y", "y", "y"}, // 6 7 8   
        {"o", "o", "o", "b", "b", "b", "r", "r", "r", "g", "g", "g"}, // 1
        {"o", "o", "o", "b", "b", "b", "r", "r", "r", "g", "g", "g"}, // 2
        {"o", "o", "o", "b", "b", "b", "r", "r", "r", "g", "g", "g"}, // 3
        {"w", "w", "w",  // 0 1 2   
         "w", "w", "w",  // 3 4 5   // 4
         "w", "w", "w"}  // 6 7 8   
    };
    
    static void solveinreverse(ArrayList<String> stack) {
        for (int i = stack.size() - 1; i >= 0; i--) {
            System.out.println(stack.get(i));
        }
    }

    static void print_cube() {
        // Print the first array of whole_cube as a 3x3 square
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
            System.out.print(whole_cube[0][i * 3 + j] + " ");
            }
            System.out.println();
        }
        // Print the second, third, and fourth arrays of whole_cube as 3x12 rectangles
        for (int i = 1; i <= 3; i++) {
            for (int j = 0; j < 12; j++) {
                System.out.print(whole_cube[i][j] + " ");
            }
            System.out.println();
        }
        // Print the fourth array of whole_cube as a 3x3 square
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
            System.out.print(whole_cube[4][i * 3 + j] + " ");
            }
            System.out.println();
        }
    }

    static void rotateClockwise(String face) {
        String Temp = "";
        switch (face) {
            case "y":
                Temp = whole_cube[0][1];
                whole_cube[0][1] = whole_cube[0][3];
                whole_cube[0][3] = whole_cube[0][7];
                whole_cube[0][7] = whole_cube[0][5];
                whole_cube[0][5] = Temp;

                Temp = whole_cube[0][0];
                whole_cube[0][0] = whole_cube[0][6];
                whole_cube[0][6] = whole_cube[0][8];
                whole_cube[0][8] = whole_cube[0][2];
                whole_cube[0][2] = Temp;
                break;
            case "w":
                Temp = whole_cube[4][1];
                whole_cube[4][1] = whole_cube[4][3];
                whole_cube[4][3] = whole_cube[4][7];
                whole_cube[4][7] = whole_cube[4][5];
                whole_cube[4][5] = Temp;

                Temp = whole_cube[4][0];
                whole_cube[4][0] = whole_cube[4][6];
                whole_cube[4][6] = whole_cube[4][8];
                whole_cube[4][8] = whole_cube[4][2];
                whole_cube[4][2] = Temp;
                break;
            case "o":
                Temp = whole_cube[1][1];
                whole_cube[1][1] = whole_cube[2][0];
                whole_cube[2][0] = whole_cube[3][1];
                whole_cube[3][1] = whole_cube[2][2];
                whole_cube[2][2] = Temp;

                Temp = whole_cube[1][0];
                whole_cube[1][0] = whole_cube[3][0];
                whole_cube[3][0] = whole_cube[3][2];
                whole_cube[3][2] = whole_cube[1][2];
                whole_cube[1][2] = Temp;
                break;
            case "b":
                Temp = whole_cube[1][4];
                whole_cube[1][4] = whole_cube[2][3];
                whole_cube[2][3] = whole_cube[3][4];
                whole_cube[3][4] = whole_cube[2][5];
                whole_cube[2][5] = Temp;

                Temp = whole_cube[1][3];
                whole_cube[1][3] = whole_cube[3][3];
                whole_cube[3][3] = whole_cube[3][5];
                whole_cube[3][5] = whole_cube[1][5];
                whole_cube[1][5] = Temp;
                break;
            case "r":
                Temp = whole_cube[1][7];
                whole_cube[1][7] = whole_cube[2][6];
                whole_cube[2][6] = whole_cube[3][7];
                whole_cube[3][7] = whole_cube[2][8];
                whole_cube[2][8] = Temp;

                Temp = whole_cube[1][6];
                whole_cube[1][6] = whole_cube[3][6];
                whole_cube[3][6] = whole_cube[3][8];
                whole_cube[3][8] = whole_cube[1][8];
                whole_cube[1][8] = Temp;
                break;
            case "g":
                Temp = whole_cube[1][10];
                whole_cube[1][10] = whole_cube[2][9];
                whole_cube[2][9] = whole_cube[3][10];
                whole_cube[3][10] = whole_cube[2][11];
                whole_cube[2][11] = Temp;

                Temp = whole_cube[1][9];
                whole_cube[1][9] = whole_cube[3][9];
                whole_cube[3][9] = whole_cube[3][11];
                whole_cube[3][11] = whole_cube[1][11];
                whole_cube[1][11] = Temp;
                break;
            default:
                break;
        }
    }

    static void rotateCounterClockWise(String face) {
        String Temp = "";
        switch (face) {
            case "y":
                Temp = whole_cube[0][1];
                whole_cube[0][1] = whole_cube[0][5];
                whole_cube[0][5] = whole_cube[0][7];
                whole_cube[0][7] = whole_cube[0][3];
                whole_cube[0][3] = Temp;
    
                Temp = whole_cube[0][0];
                whole_cube[0][0] = whole_cube[0][2];
                whole_cube[0][2] = whole_cube[0][8];
                whole_cube[0][8] = whole_cube[0][6];
                whole_cube[0][6] = Temp;
                break;
            case "w":
                Temp = whole_cube[4][1];
                whole_cube[4][1] = whole_cube[4][5];
                whole_cube[4][5] = whole_cube[4][7];
                whole_cube[4][7] = whole_cube[4][3];
                whole_cube[4][3] = Temp;

                Temp = whole_cube[4][0];
                whole_cube[4][0] = whole_cube[4][2];
                whole_cube[4][2] = whole_cube[4][8];
                whole_cube[4][8] = whole_cube[4][6];
                whole_cube[4][6] = Temp;
                break;
            case "o":
                Temp = whole_cube[1][1];
                whole_cube[1][1] = whole_cube[2][2];
                whole_cube[2][2] = whole_cube[3][1];
                whole_cube[3][1] = whole_cube[2][0];
                whole_cube[2][0] = Temp;

                Temp = whole_cube[1][0];
                whole_cube[1][0] = whole_cube[1][2];
                whole_cube[1][2] = whole_cube[3][2];
                whole_cube[3][2] = whole_cube[3][0];
                whole_cube[3][0] = Temp;
                break;
            case "b":
                Temp = whole_cube[1][4];
                whole_cube[1][4] = whole_cube[2][5];
                whole_cube[2][5] = whole_cube[3][4];
                whole_cube[3][4] = whole_cube[2][3];
                whole_cube[2][3] = Temp;

                Temp = whole_cube[1][3];
                whole_cube[1][3] = whole_cube[1][5];
                whole_cube[1][5] = whole_cube[3][5];
                whole_cube[3][5] = whole_cube[3][3];
                whole_cube[3][3] = Temp;
                break;
            case "r":
                Temp = whole_cube[1][7];
                whole_cube[1][7] = whole_cube[2][8];
                whole_cube[2][8] = whole_cube[3][7];
                whole_cube[3][7] = whole_cube[2][6];
                whole_cube[2][6] = Temp;

                Temp = whole_cube[1][6];
                whole_cube[1][6] = whole_cube[1][8];
                whole_cube[1][8] = whole_cube[3][8];
                whole_cube[3][8] = whole_cube[3][6];
                whole_cube[3][6] = Temp;
                break;
            case "g":
                Temp = whole_cube[1][10];
                whole_cube[1][10] = whole_cube[2][11];
                whole_cube[2][11] = whole_cube[3][10];
                whole_cube[3][10] = whole_cube[2][9];
                whole_cube[2][9] = Temp;

                Temp = whole_cube[1][9];
                whole_cube[1][9] = whole_cube[1][11];
                whole_cube[1][11] = whole_cube[3][11];
                whole_cube[3][11] = whole_cube[3][9];
                whole_cube[3][9] = Temp;
                break;
            default:
                break;
        }
    }

    static void rotateArrayLeft(int a) {
        for (int i = 0; i < 3; i++) {
            String temp = whole_cube[a][0];
            for (int j = 0; j < 11; j++) {
                whole_cube[a][j] = whole_cube[a][j + 1];
            }
            whole_cube[a][11] = temp;
        }
    } 

    static void rotateArrayRight(int a) {
        for (int i = 0; i < 3; i++) {
            String temp = whole_cube[a][11];
            for (int j = 11; j > 0; j--) {
                whole_cube[a][j] = whole_cube[a][j - 1];
            }
            whole_cube[a][0] = temp;
        } 
    }

    static void U() {
        // When the U is executed, the yellow(4) face is rotated clockwise
        rotateClockwise("y");
        rotateArrayLeft(1);
    }
    
    static void U_prime() {
        // U' rotates yellow(4) counterclockwise
        rotateCounterClockWise("y");
        rotateArrayRight(1);
    }

    static void D() {
        // When the D is executed, the white(5) face is rotated clockwise
        rotateClockwise("w");
        rotateArrayRight(3);
    }

    static void D_prime() {
        // When the D is executed, the white(5) face is rotated counterclockwise
        rotateCounterClockWise("w");
        rotateArrayLeft(3);
    }

    static void R() {
        // When the R is executed, the blue(1) face is rotated clockwise
        rotateClockwise("b");

        String Temp = whole_cube[3][2];
        String Temp2 = whole_cube[2][2];
        String Temp3 = whole_cube[1][2];
        whole_cube[3][2] = whole_cube[4][8];
        whole_cube[2][2] = whole_cube[4][5];
        whole_cube[1][2] = whole_cube[4][2];
        whole_cube[4][8] = whole_cube[1][6];
        whole_cube[4][5] = whole_cube[2][6];
        whole_cube[4][2] = whole_cube[3][6];
        whole_cube[1][6] = whole_cube[0][8];
        whole_cube[2][6] = whole_cube[0][5];
        whole_cube[3][6] = whole_cube[0][2];
        whole_cube[0][8] = Temp;
        whole_cube[0][5] = Temp2;
        whole_cube[0][2] = Temp3;
    }

    static void R_prime() {
        // When the R' is executed, the blue(1) face is rotated counterclockwise
        rotateCounterClockWise("b");
        String Temp = whole_cube[1][2];
        String Temp2 = whole_cube[2][2];
        String Temp3 = whole_cube[3][2];
        whole_cube[1][2] = whole_cube[0][2];
        whole_cube[2][2] = whole_cube[0][5];
        whole_cube[3][2] = whole_cube[0][8];
        whole_cube[0][8] = whole_cube[1][6];
        whole_cube[0][5] = whole_cube[2][6];
        whole_cube[0][2] = whole_cube[3][6];
        whole_cube[1][6] = whole_cube[4][8];
        whole_cube[2][6] = whole_cube[4][5];
        whole_cube[3][6] = whole_cube[4][2];
        whole_cube[4][2] = Temp; 
        whole_cube[4][5] = Temp2;
        whole_cube[4][8] = Temp3;
    }

    static void L() {
        // When the L is executed, the green(3) face is rotated clockwise
        rotateClockwise("g");
        String Temp1 = whole_cube[1][0];
        String Temp2 = whole_cube[2][0];
        String Temp3 = whole_cube[3][0];
        whole_cube[1][0] = whole_cube[0][0];
        whole_cube[2][0] = whole_cube[0][3];
        whole_cube[3][0] = whole_cube[0][6];
        whole_cube[0][0] = whole_cube[3][8];
        whole_cube[0][3] = whole_cube[2][8];
        whole_cube[0][6] = whole_cube[1][8];
        whole_cube[3][8] = whole_cube[4][0];
        whole_cube[2][8] = whole_cube[4][3];
        whole_cube[1][8] = whole_cube[4][6];
        whole_cube[4][0] = Temp1;
        whole_cube[4][3] = Temp2;
        whole_cube[4][6] = Temp3;
    }

    static void L_prime() {
        // When the L' is executed, the green(3) face is rotated counterclockwise
        rotateCounterClockWise("g");
        String Temp1 = whole_cube[3][0];
        String Temp2 = whole_cube[2][0];
        String Temp3 = whole_cube[1][0];
        whole_cube[3][0] = whole_cube[4][6];
        whole_cube[2][0] = whole_cube[4][3];
        whole_cube[1][0] = whole_cube[4][0];
        whole_cube[4][0] = whole_cube[3][8];
        whole_cube[4][3] = whole_cube[2][8];
        whole_cube[4][6] = whole_cube[1][8];
        whole_cube[3][8] = whole_cube[0][0];
        whole_cube[2][8] = whole_cube[0][3];
        whole_cube[1][8] = whole_cube[0][6];
        whole_cube[0][0] = Temp3;
        whole_cube[0][3] = Temp2;
        whole_cube[0][6] = Temp1;
    }

    static void F() {
        // When the F or is executed, the orange(2) face is rotated clockwise
        rotateClockwise("o");
        String Temp1 = whole_cube[0][6];
        String Temp2 = whole_cube[0][7];
        String Temp3 = whole_cube[0][8];
        whole_cube[0][6] = whole_cube[3][11];
        whole_cube[0][7] = whole_cube[2][11];
        whole_cube[0][8] = whole_cube[1][11];
        whole_cube[1][11] = whole_cube[4][0];
        whole_cube[2][11] = whole_cube[4][1];
        whole_cube[3][11] = whole_cube[4][2];
        whole_cube[4][2] = whole_cube[1][3];
        whole_cube[4][1] = whole_cube[2][3];
        whole_cube[4][0] = whole_cube[3][3];
        whole_cube[1][3] = Temp1;
        whole_cube[2][3] = Temp2;
        whole_cube[3][3] = Temp3;
    }

    static void F_prime() {
        // When the F' is executed, the orange(2) face is rotated counterclockwise
        rotateCounterClockWise("o");
        String Temp1 = whole_cube[0][6];
        String Temp2 = whole_cube[0][7];
        String Temp3 = whole_cube[0][8];
        whole_cube[0][6] = whole_cube[1][3];
        whole_cube[0][7] = whole_cube[2][3];
        whole_cube[0][8] = whole_cube[3][3];
        whole_cube[1][3] = whole_cube[4][2];
        whole_cube[2][3] = whole_cube[4][1];
        whole_cube[3][3] = whole_cube[4][0];
        whole_cube[4][2] = whole_cube[3][11];
        whole_cube[4][1] = whole_cube[2][11];
        whole_cube[4][0] = whole_cube[1][11];
        whole_cube[1][11] = Temp3;
        whole_cube[2][11] = Temp2;
        whole_cube[3][11] = Temp1;
    }

    static void B() {
        // When the B is executed, the red(0) face is rotated clockwise
        rotateClockwise("r");
        String Temp1 = whole_cube[0][2];
        String Temp2 = whole_cube[0][1];
        String Temp3 = whole_cube[0][0];
        whole_cube[0][2] = whole_cube[3][5];
        whole_cube[0][1] = whole_cube[2][5];
        whole_cube[0][0] = whole_cube[1][5];
        whole_cube[1][5] = whole_cube[4][8];
        whole_cube[2][5] = whole_cube[4][7];
        whole_cube[3][5] = whole_cube[4][6];
        whole_cube[4][8] = whole_cube[3][9];
        whole_cube[4][7] = whole_cube[2][9];
        whole_cube[4][6] = whole_cube[1][9];
        whole_cube[1][9] = Temp1;
        whole_cube[2][9] = Temp2;
        whole_cube[3][9] = Temp3;
    }

    static void B_prime() {
        // When the B' is executed, the red(0) face is rotated counterclockwise
        rotateCounterClockWise("r");
        String Temp1 = whole_cube[0][2];
        String Temp2 = whole_cube[0][1];
        String Temp3 = whole_cube[0][0];
        whole_cube[0][2] = whole_cube[1][9];
        whole_cube[0][1] = whole_cube[2][9];
        whole_cube[0][0] = whole_cube[3][9];
        whole_cube[1][9] = whole_cube[4][6];
        whole_cube[2][9] = whole_cube[4][7];
        whole_cube[3][9] = whole_cube[4][8];
        whole_cube[4][8] = whole_cube[1][5];
        whole_cube[4][7] = whole_cube[2][5];
        whole_cube[4][6] = whole_cube[3][5];
        whole_cube[1][5] = Temp3;
        whole_cube[2][5] = Temp2;
        whole_cube[3][5] = Temp1;
    }
}
    public static void main(String[] args) throws Exception {

        Scanner scn = new Scanner(System.in);

        ArrayList<String> stack = new ArrayList<>();

        boolean solving = true; 

        System.out.println("Enter move: ");
        System.out.println("Options: U, U', D, D', R, R', L, L', F, F', B, B', Q to Quit");

        while(solving) {

            String move = scn.nextLine();

            switch (move.toUpperCase()) {
                case "U":
                    stack.add("U'");
                    App.U();
                    break;
                case "U'":
                    stack.add("U");
                    App.U_prime();
                    break;
                case "D":
                    stack.add("D'");
                    App.D();
                    break;
                case "D'":
                    stack.add("D");
                    App.D_prime();
                    break;
                case "R":
                    stack.add("R'");
                    App.R();
                    break;
                case "R'":
                    stack.add("R");
                    App.R_prime();
                    break;
                case "L":
                    stack.add("L'");
                    App.L();
                    break;
                case "L'":
                    stack.add("L");
                    App.L_prime();
                    break;
                case "F":
                    stack.add("F'");
                    App.F();
                    break;
                case "F'":
                    stack.add("F");
                    App.F_prime();
                    break;
                case "B":
                    stack.add("B'");
                    App.B();
                    break;
                case "B'":
                    stack.add("B");
                    App.B_prime();
                    break;
                case "Q":
                    solving = false;
                    break;
                default:
                    System.out.println("Invalid move");
                    break;
        }
    } 
    App.print_cube();
    //App.solveinreverse(stack);
    scn.close();
}