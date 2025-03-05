import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Cube {
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

    static String[][] solved_cube = {
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

    static void solve(ArrayList<String> stack) {
        ArrayList<String> solve = new ArrayList<>();
        String temp = stack.get(stack.size() - 1);
        int count = 0;
        // Check if the cube is solved already
        int not_solved = 0;
        for (int j = 0; j < 5; j++) {
            for (int k = 0; k < whole_cube[j].length; k++) {
                // If the current element is not the same as the solved cube, set not_solved to 1
                if (!whole_cube[j][k].equals(solved_cube[j][k])) {
                    not_solved = 1;
                }
            }
        }
        // If the cube is solved, print the solve array
        if (not_solved == 0) {
            System.out.println("Cube is solved");
            return;
        }
        // For loop starts with the last element of the stack
        for (int i = stack.size() - 1; i >= 0; i--) {
            // If the current element is the same as the previous element, increment count
            solve.add(stack.get(i));
            int solve_length = solve.size();
            // If the last two moves are opposites, remove them from the solve array
            if (solve_length >= 2) {
                String lastMove = solve.get(solve_length - 1);
                String secondLastMove = solve.get(solve_length - 2);
                if ((lastMove.equals("U") && secondLastMove.equals("U'")) ||
                    (lastMove.equals("U'") && secondLastMove.equals("U")) ||
                    (lastMove.equals("D") && secondLastMove.equals("D'")) ||
                    (lastMove.equals("D'") && secondLastMove.equals("D")) ||
                    (lastMove.equals("R") && secondLastMove.equals("R'")) ||
                    (lastMove.equals("R'") && secondLastMove.equals("R")) ||
                    (lastMove.equals("L") && secondLastMove.equals("L'")) ||
                    (lastMove.equals("L'") && secondLastMove.equals("L")) ||
                    (lastMove.equals("F") && secondLastMove.equals("F'")) ||
                    (lastMove.equals("F'") && secondLastMove.equals("F")) ||
                    (lastMove.equals("B") && secondLastMove.equals("B'")) ||
                    (lastMove.equals("B'") && secondLastMove.equals("B"))) {
                    solve.remove(solve_length - 1);
                    solve.remove(solve_length - 2);
                    solve_length -= 2;
                }
            }
            if (stack.get(i).equals(temp)) {
                count++;
                // If there are 4 instances of the same move in a row, add nothing to the solve array
                // If there are 3 instances of the same move in a row, add the opposite move to the solve array
                if (count == 3) {
                    // checking if the move is a prime move
                    solve.remove(solve_length - 1);
                    solve.remove(solve_length - 2);
                    solve.remove(solve_length - 3);
                    solve_length -= 3;
                    if (stack.get(i).contains("'")) {
                        // adding the non-prime move to the solve array
                        solve.add(temp.substring(0, temp.length()));
                        solve_length++;
                    }   
                    // checking if the move is a non-prime move
                    else {
                        // adding the prime move to the solve array
                        solve.add(stack.get(i));
                        solve_length++;
                    }  
                }
                // If there are 4 instances of the same move in a row, add nothing to the solve array
                else if (count == 4) {
                    solve.remove(solve_length - 1);
                    solve_length--;
                    solve.remove(solve_length - 1);
                    solve_length--;
                }
            } 
            else {
                count = 1; // Reset count if the current move is different
            }
            temp = stack.get(i);
        }     
        System.out.println("Total number of moves to solve: ");
        System.out.println(solve.size());
        System.out.println("Moves to solve: ");
            for (int i = 0; i < solve.size(); i++) {
                System.out.print(solve.get(i) + " ");
        }
        for (String move : solve) {
            switch (move) {
            case "U":
                Cube.U();
                break;
            case "U'":
                Cube.U_prime();
                break;
            case "D":
                Cube.D();
                break;
            case "D'":
                Cube.D_prime();
                break;
            case "R":
                Cube.R();
                break;
            case "R'":
                Cube.R_prime();
                break;
            case "L":
                Cube.L();
                break;
            case "L'":
                Cube.L_prime();
                break;
            case "F":
                Cube.F();
                break;
            case "F'":
                Cube.F_prime();
                break;
            case "B":
                Cube.B();
                break;
            case "B'":
                Cube.B_prime();
                break;
            default:
                break;
            }
        }
        System.out.println("\nCube after solving:");
        Cube.print_format();
    }

    static void cube_randomizer(int moves, ArrayList<String> Stack) {
        // Randomize the cube  
        Random rand = new Random(); 
        // 0 = U, 1 = U', 2 = D, 3 = D', 4 = R, 5 = R', 6 = L, 7 = L', 8 = F, 9 = F', 10 = B, 11 = B'
        System.out.println("Random moves: ");

        int i = 0;
        while (i < moves) {
            switch (rand.nextInt(12)) {
                case 0:
                    Cube.U();
                    Stack.add("U'");
                    System.out.print("U" + " ");
                    break;
                case 1:
                    Cube.U_prime();
                    Stack.add("U");
                    System.out.print("U'" + " ");
                    break;
                case 2:
                    Cube.D();
                    Stack.add("D'");
                    System.out.print("D" + " ");
                    break;
                case 3:
                    Cube.D_prime();
                    Stack.add("D");
                    System.out.print("D'" + " ");
                    break;
                case 4:
                    Cube.R();
                    Stack.add("R'");
                    System.out.print("R" + " ");
                    break;
                case 5:
                    Cube.R_prime();
                    Stack.add("R");
                    System.out.print("R'" + " ");
                    break;
                case 6:
                    Cube.L();
                    Stack.add("L'");
                    System.out.print("L" + " ");
                    break;
                case 7:
                    Cube.L_prime();
                    Stack.add("L");
                    System.out.print("L'" + " ");
                    break;
                case 8:
                    Cube.F();
                    Stack.add("F'");
                    System.out.print("F" + " ");
                    break;
                case 9:
                    Cube.F_prime();
                    Stack.add("F");
                    System.out.print("F'" + " ");
                    break;
                case 10:
                    Cube.B();
                    Stack.add("B'");
                    System.out.print("B" + " ");
                    break;
                case 11:
                    Cube.B_prime();
                    Stack.add("B");
                    System.out.print("B'" + " ");
                    break;
                default:
                    break;
            }
            i++;
        }
        System.out.println();
    }
    
    static void print_whole_cube() {
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
        System.out.println();
    }
    
    static void print_format() {
        System.out.println();
        // Prints the red face
        for (int i = 1; i <= 3; i++) {
            for (int j = 6; j < 9; j++) {
                System.out.print(whole_cube[i][j]);
                if (j == 8) {
                    System.out.println();
                }
                else {
                    System.out.print("|");
                }
            }
        }
        System.out.println();
        // Prints the blue face
        for (int i = 1; i <= 3; i++) {
            for (int j = 3; j < 6; j++) {
                System.out.print(whole_cube[i][j]);
                if (j == 5) {
                    System.out.println();
                }
                else {
                    System.out.print("|");
                }
            }
        }
        System.out.println();
        // Prints the orange face
        for (int i = 1; i <= 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(whole_cube[i][j]);
                if (j == 2) {
                    System.out.println();
                }
                else {
                    System.out.print("|");
                }
            }
        }
        System.out.println();
        // Prints the green face
        for (int i = 1; i <= 3; i++) {
            for (int j = 9; j < 12; j++) {
                System.out.print(whole_cube[i][j]);
                if (j == 11) {
                    System.out.println();
                }
                else {
                    System.out.print("|");
                }
            }
        }
        System.out.println();
        // Prints the yellow face
        for (int i = 0; i < whole_cube[0].length; i++) {
                System.out.print(whole_cube[0][i]);
                if (i == 2 || i == 5 || i == 8) {
                    System.out.println();
                }
                else {
                    System.out.print("|");
                }
            }
        System.out.println();
        // Prints the white face
        for (int i = 0; i < whole_cube[4].length; i++) {
            System.out.print(whole_cube[4][i]);
            if (i == 2 || i == 5 || i == 8) {
                System.out.println();
            }
            else {
                System.out.print("|");
            }
        }
        System.out.println();
    }
} 
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);

        ArrayList<String> stack = new ArrayList<>();
        boolean solving = true; 

        System.out.println("Welcome to the Rubik's Cube Solver");
        System.out.println();
        System.out.println("Orientation of the cube:");
        System.out.println("The yellow face is on top, the white face is on the bottom");
        System.out.println("The orange face is on the front, the red face is on the back");
        System.out.println("The blue face is on the right, the green face is on the left");
        System.out.println();
        while(solving) {
            System.out.println("Choose an option: ");
            System.out.println("1. Play with the Cube");
            System.out.println("2. Randomize the cube");
            System.out.println("3. Solve the cube");
            System.out.println("4. Print the cube in whole format");
            System.out.println("5. Quit");

            int option = scn.nextInt();
            scn.nextLine(); // consume the newline character

            switch (option) {
                case 1:
                    Boolean moving = true;
                    System.out.println("Enter move: ");
                    System.out.println("U, U', D, D', R, R', L, L', F, F', B, B', Q = Quit");
                    while (moving) {
                        Cube.print_format();
                        String move = scn.nextLine();

                    switch (move.toUpperCase()) {
                        case "U":
                            stack.add("U'");
                            Cube.U();
                            break;
                        case "U'":
                            stack.add("U");
                            Cube.U_prime();
                            break;
                        case "D":
                            stack.add("D'");
                            Cube.D();
                            break;
                        case "D'":
                            stack.add("D");
                            Cube.D_prime();
                            break;
                        case "R":
                            stack.add("R'");
                            Cube.R();
                            break;
                        case "R'":
                            stack.add("R");
                            Cube.R_prime();
                            break;
                        case "L":
                            stack.add("L'");
                            Cube.L();
                            break;
                        case "L'":
                            stack.add("L");
                            Cube.L_prime();
                            break;
                        case "F":
                            stack.add("F'");
                            Cube.F();
                            break;
                        case "F'":
                            stack.add("F");
                            Cube.F_prime();
                            break;
                        case "B":
                            stack.add("B'");
                            Cube.B();
                            break;
                        case "B'":
                            stack.add("B");
                            Cube.B_prime();
                            break;
                        case "Q":
                            moving = false;
                            break;
                        default:
                            System.out.println("Invalid move");
                            break;
                    
                        }
                    }
                    Cube.print_format();
                    break;
                case 2:
                    Cube.cube_randomizer(40, stack);
                    Cube.print_format();
                    break;
                case 3:
                    Cube.solve(stack);
                    break;
                case 4:
                    Cube.print_format();
                    break;
                case 5:
                    solving = false;
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
    } 
    scn.close();
}