import java.util.ArrayList;
import java.util.Scanner;

public class App {
    // 6 sided cube, with 3 x 3 faces
    static String[][] cube =    { 
                                // Red Face (0)
                                {"r", "r", "r",  // 0 1 2
                                 "r", "r", "r",  // 3 4 5
                                 "r", "r", "r"}, // 6 7 8  

                                // Blue Face (1)
                                {"b", "b", "b",  // 0 1 2
                                 "b", "b", "b",  // 3 4 5
                                 "b", "b", "b"}, // 6 7 8 

                                // Orange Face (2)
                                {"o", "o", "o",  // 0 1 2
                                 "o", "o", "o",  // 3 4 5
                                 "o", "o", "o"}, // 6 7 8  
                                
                                // Green Face (3)
                                {"g", "g", "g",  // 0 1 2                           
                                 "g", "g", "g",  // 3 4 5                             
                                 "g", "g", "g"}, // 6 7 8
                                          
                                // Yellow Face (4)
                                {"y", "y", "y",  // 0 1 2                            
                                 "y", "y", "y",  // 3 4 5                            
                                 "y", "y", "y"}, // 6 7 8  

                                // White Face (5)
                                {"w", "w", "w",  // 0 1 2                              
                                 "w", "w", "w",  // 3 4 5                             
                                 "w", "w", "w"}  // 6 7 8                             
                                };
    // The following arrays contain moves, there are 12 moves
    //                    2    2    2    3    3    3    0    0    0    1    1    1
    static String[] U = {"o", "o", "o", "g", "g", "g", "r", "r", "r", "b", "b", "b"}; // top
    //                    2    2    2    1    1    1    0    0    0    3    3    3
    static String[] D = {"o", "o", "o", "b", "b", "b", "r", "r", "r", "g", "g", "g"}; // bottom
    //                    2    2    2    4    4    4    0    0    0    5    5    5
    static String[] R = {"o", "o", "o", "y", "y", "y", "r", "r", "r", "w", "w", "w"}; // right
    //                    2    2    2    5    5    5    0    0    0    4    4    4
    static String[] L = {"o", "o", "o", "w", "w", "w", "r", "r", "r", "y", "y", "y"}; // left
    //                    4    4    4    1    1    1    5    5    5    3    3    3 
    static String[] F = {"y", "y", "y", "b", "b", "b", "w", "w", "w", "g", "g", "g"}; // front
    //                    4    4    4    3    3    3    5    5    5    1    1    1 
    static String[] B = {"y", "y", "y", "g", "g", "g", "w", "w", "w", "b", "b", "b"}; // back   
    
    static void solveinreverse(ArrayList<String> stack) {
        for (int i = stack.size() - 1; i >= 0; i--) {
            System.out.println(stack.get(i));
        }
    }

    static void print_cube() {
        for (int i = 0; i < cube.length; i++) {
            for (int j = 0; j < cube[i].length; j++) {
                System.out.print(cube[i][j] + " ");
                if ((j + 1) % 3 == 0) {
                    System.out.println();
                }
            }
            System.out.println();
        }
    }

    static void printMoves() {
        System.out.println("U: " + String.join(" ", U));
        System.out.println("D: " + String.join(" ", D));
        System.out.println("R: " + String.join(" ", R));
        System.out.println("L: " + String.join(" ", L));
        System.out.println("F: " + String.join(" ", F));
        System.out.println("B: " + String.join(" ", B));
    }

    static void rotateFaceCounterClockwise(int face) {
        String Temp = cube[face][1];
        cube[face][1] = cube[face][5];
        cube[face][5] = cube[face][7];
        cube[face][7] = cube[face][3];
        cube[face][3] = Temp;

        Temp = cube[face][0];
        cube[face][0] = cube[face][2];
        cube[face][2] = cube[face][8];
        cube[face][8] = cube[face][6];
        cube[face][6] = Temp;
    }

    static void rotateFaceClockwise(int face) {
        String Temp = cube[face][0];
        cube[face][0] = cube[face][6];
        cube[face][6] = cube[face][8];
        cube[face][8] = cube[face][2];
        cube[face][2] = Temp;

        Temp = cube[face][1];
        cube[face][1] = cube[face][3];
        cube[face][3] = cube[face][7];
        cube[face][7] = cube[face][5];
        cube[face][5] = Temp;
    }

    static void rotateArray(String[] arr) {
        for (int i = 0; i < 3; i++) {
            String temp = arr[arr.length - 1];
            for (int j = arr.length - 1; j > 0; j--) {
            arr[j] = arr[j - 1];
            }
            arr[0] = temp;
        }
    } 

    static void rotateArrayPrime(String[] arr) {
        for (int i = 0; i < 3; i++) {
            String temp = arr[0];
            for (int j = 0; j < arr.length - 1; j++) {
                arr[j] = arr[j + 1];
            }
            arr[arr.length - 1] = temp;
        }
    }


    static void UpdateMoves() {
        // The indices of the "U" array correspond to the following faces of the cube:
        // (2, 2, 2, 3, 3, 3, 0, 0, 0, 1, 1, 1)
        U[0] = cube[2][2];
        U[1] = cube[2][1];
        U[2] = cube[2][0];
        U[3] = cube[3][2];
        U[4] = cube[3][1];
        U[5] = cube[3][0];
        U[6] = cube[0][0];
        U[7] = cube[0][1];
        U[8] = cube[0][2];
        U[9] = cube[1][2];
        U[10] = cube[1][1];
        U[11] = cube[1][0];

        // The indices of the "D" array correspond to the following faces of the cube:
        // (2, 2, 2, 1, 1, 1, 0, 0, 0, 3, 3, 3)
        D[0] = cube[2][6];
        D[1] = cube[2][7];
        D[2] = cube[2][8];
        D[3] = cube[1][6];
        D[4] = cube[1][7];
        D[5] = cube[1][8];
        D[6] = cube[0][8];
        D[7] = cube[0][7];
        D[8] = cube[0][6];
        D[9] = cube[3][6];
        D[10] = cube[3][7];
        D[11] = cube[3][8];

        // The indices of the "R" array correspond to the following faces of the cube:
        // (2, 2, 2, 4, 4, 4, 0, 0, 0, 5, 5, 5)
        R[0] = cube[2][8];
        R[1] = cube[2][5];
        R[2] = cube[2][2];
        R[3] = cube[4][2];
        R[4] = cube[4][5];
        R[5] = cube[4][8];
        R[6] = cube[0][8];
        R[7] = cube[0][5];
        R[8] = cube[0][2];
        R[9] = cube[5][8];
        R[10] = cube[5][5];
        R[11] = cube[5][2];

        // The indices of the "L" array correspond to the following faces of the cube:
        // (2, 2, 2, 5, 5, 5, 0, 0, 0, 4, 4, 4)
        L[0] = cube[2][0];
        L[1] = cube[2][3];
        L[2] = cube[2][6];
        L[3] = cube[5][0];
        L[4] = cube[5][3];
        L[5] = cube[5][6];
        L[6] = cube[0][0];
        L[7] = cube[0][3];
        L[8] = cube[0][6];
        L[9] = cube[4][6];
        L[10] = cube[4][3];
        L[11] = cube[4][0];

        // The indices of the "F" array correspond to the following faces of the cube:
        // (4, 4, 4, 1, 1, 1, 5, 5, 5, 3, 3, 3)
        F[0] = cube[4][0];
        F[1] = cube[4][1];
        F[2] = cube[4][2];
        F[3] = cube[1][0];
        F[4] = cube[1][3];
        F[5] = cube[1][6];
        F[6] = cube[5][0];
        F[7] = cube[5][1];
        F[8] = cube[5][2];
        F[9] = cube[3][2];
        F[10] = cube[3][5];
        F[11] = cube[3][8];

        // The indices of the "B" array correspond to the following faces of the cube:
        // (4, 4, 4, 3, 3, 3, 5, 5, 5, 1, 1, 1)
        B[0] = cube[4][8];
        B[1] = cube[4][7];
        B[2] = cube[4][6];
        B[3] = cube[3][0];
        B[4] = cube[3][3];
        B[5] = cube[3][6];
        B[6] = cube[5][8];
        B[7] = cube[5][7];
        B[8] = cube[5][6];
        B[9] = cube[1][8];
        B[10] = cube[1][5];
        B[11] = cube[1][2];
    }

    static void U() {
        // When the U is executed, the yellow(4) face is rotated clockwise
        rotateFaceClockwise(4);
        rotateArray(U);
        // The indices of the "U" array correspond to the following faces of the cube:
        // (2, 2, 2, 3, 3, 3, 0, 0, 0, 1, 1, 1)
        cube[2][2] = U[0];
        cube[2][1] = U[1];
        cube[2][0] = U[2];
        cube[3][2] = U[3];
        cube[3][1] = U[4];
        cube[3][0] = U[5];
        cube[0][0] = U[6];
        cube[0][1] = U[7];
        cube[0][2] = U[8];
        cube[1][2] = U[9];
        cube[1][1] = U[10];
        cube[1][0] = U[11];

        UpdateMoves();
    }
    

    static void U_prime() {
        // U' rotates yellow(4) counterclockwise
        rotateFaceCounterClockwise(4);
        rotateArrayPrime(U);
        // The indices of the "U" array correspond to the following:
        // (2, 2, 2, 3, 3, 3, 0, 0, 0, 1, 1, 1)
        cube[2][2] = U[0];
        cube[2][1] = U[1];
        cube[2][0] = U[2];
        cube[3][2] = U[3];
        cube[3][1] = U[4];
        cube[3][0] = U[5];
        cube[0][0] = U[6];
        cube[0][1] = U[7];
        cube[0][2] = U[8];
        cube[1][2] = U[9];
        cube[1][1] = U[10];
        cube[1][0] = U[11];

        UpdateMoves();
    }

    static void D() {
        // When the D is executed, the white(5) face is rotated clockwise
        rotateFaceClockwise(5);
        rotateArray(D);
        // The indices of the "D" array correspond to the following faces of the cube:
        // (2, 2, 2, 1, 1, 1, 0, 0, 0, 3, 3, 3)
        cube[2][8] = D[0];
        cube[2][7] = D[1];
        cube[2][6] = D[2];
        cube[1][8] = D[3];
        cube[1][7] = D[4];
        cube[1][6] = D[5];
        cube[0][6] = D[6];
        cube[0][7] = D[7];
        cube[0][8] = D[8];
        cube[3][8] = D[9];
        cube[3][7] = D[10];
        cube[3][6] = D[11];     
        
        UpdateMoves();
    }

    static void D_prime() {
        // When the D is executed, the white(5) face is rotated counterclockwise
        rotateFaceCounterClockwise(5);
        rotateArrayPrime(D);
        // The indices of the "D" array correspond to the following faces of the cube:
        // (2, 2, 2, 1, 1, 1, 0, 0, 0, 3, 3, 3)
        cube[2][6] = D[0];
        cube[2][7] = D[1];
        cube[2][8] = D[2];
        cube[1][6] = D[3];
        cube[1][7] = D[4];
        cube[1][8] = D[5];
        cube[0][6] = D[6];
        cube[0][7] = D[7];
        cube[0][8] = D[8];
        cube[3][6] = D[9];
        cube[3][7] = D[10];
        cube[3][8] = D[11];   

        UpdateMoves();
    }

    static void R() {
        // When the R is executed, the blue(1) face is rotated clockwise
        rotateFaceClockwise(1);
        rotateArray(R);
        // The indices of the "R" array correspond to the following faces of the cube:
        // (2, 2, 2, 4, 4, 4, 0, 0, 0, 5, 5, 5)
        cube[2][2] = R[0];
        cube[2][5] = R[1];
        cube[2][8] = R[2];
        cube[4][8] = R[3];
        cube[4][5] = R[4];
        cube[4][2] = R[5];
        cube[0][2] = R[6];
        cube[0][5] = R[7];
        cube[0][8] = R[8];
        cube[5][2] = R[9];
        cube[5][5] = R[10];
        cube[5][8] = R[11];

        UpdateMoves();
    }

    static void R_prime() {
        // When the R' is executed, the blue(1) face is rotated counterclockwise
        rotateFaceCounterClockwise(1);
        rotateArrayPrime(R);
        // The indices of the "R" array correspond to the following faces of the cube:
        // (2, 2, 2, 4, 4, 4, 0, 0, 0, 5, 5, 5)
        cube[2][8] = R[0];
        cube[2][5] = R[1];
        cube[2][2] = R[2];
        cube[4][8] = R[3];
        cube[4][5] = R[4];
        cube[4][2] = R[5];
        cube[0][8] = R[6];
        cube[0][5] = R[7];
        cube[0][2] = R[8];
        cube[5][8] = R[9];
        cube[5][5] = R[10];
        cube[5][2] = R[11];

        UpdateMoves();
    }

    static void L() {
        // When the L is executed, the green(3) face is rotated clockwise
        rotateFaceClockwise(3);
        rotateArray(L);
        // The indices of the "L" array correspond to the following faces of the cube:
        // (2, 2, 2, 5, 5, 5, 0, 0, 0, 4, 4, 4)
        cube[2][6] = L[0];
        cube[2][3] = L[1];
        cube[2][0] = L[2];
        cube[5][6] = L[3];
        cube[5][3] = L[4];
        cube[5][0] = L[5];
        cube[0][0] = L[6];
        cube[0][3] = L[7];
        cube[0][6] = L[8];
        cube[4][0] = L[9];
        cube[4][3] = L[10];
        cube[4][6] = L[11];

        UpdateMoves();
    }

    static void L_prime() {
        // When the L' is executed, the green(3) face is rotated counterclockwise
        rotateFaceCounterClockwise(3);
        rotateArrayPrime(L);
        // The indices of the "L" array correspond to the following faces of the cube:
        // (2, 2, 2, 5, 5, 5, 0, 0, 0, 4, 4, 4)
        cube[2][0] = L[0];
        cube[2][3] = L[1];
        cube[2][6] = L[2];
        cube[5][8] = L[3];
        cube[5][5] = L[4];
        cube[5][2] = L[5];
        cube[0][8] = L[6];
        cube[0][5] = L[7];
        cube[0][2] = L[8];
        cube[4][0] = L[9];
        cube[4][3] = L[10];
        cube[4][6] = L[11];

        UpdateMoves();
    }

    static void F() {
        // When the F or is executed, the orange(2) face is rotated clockwise
        rotateFaceClockwise(2);
        rotateArray(F);
        // The indices of the "F" array correspond to the following faces of the cube:
        // (4, 4, 4, 1, 1, 1, 5, 5, 5, 3, 3, 3)
        cube[4][0] = F[0];
        cube[4][1] = F[1];
        cube[4][2] = F[2];
        cube[1][0] = F[3];
        cube[1][3] = F[4];
        cube[1][6] = F[5];
        cube[5][0] = F[6];
        cube[5][1] = F[7];
        cube[5][2] = F[8];
        cube[3][8] = F[9];
        cube[3][5] = F[10];
        cube[3][2] = F[11];

        UpdateMoves();
    }

    static void F_prime() {
        // When the F' is executed, the orange(2) face is rotated counterclockwise
        rotateFaceCounterClockwise(2);
        rotateArrayPrime(F);
        // The indices of the "F" array correspond to the following faces of the cube:
        // (4, 4, 4, 1, 1, 1, 5, 5, 5, 3, 3, 3)
        cube[4][6] = F[0];
        cube[4][7] = F[1];
        cube[4][8] = F[2];
        cube[1][0] = F[3];
        cube[1][3] = F[4];
        cube[1][6] = F[5];
        cube[5][6] = F[6];
        cube[5][7] = F[7];
        cube[5][8] = F[8];
        cube[3][8] = F[9];
        cube[3][5] = F[10];
        cube[3][2] = F[11];

        UpdateMoves();
    }

    static void B() {
        // When the B is executed, the red(0) face is rotated clockwise
        rotateFaceClockwise(0);
        rotateArray(B);
        // The indices of the "B" array correspond to the following faces of the cube:
        // (4, 4, 4, 3, 3, 3, 5, 5, 5, 1, 1, 1)

        cube[4][8] = B[0];
        cube[4][7] = B[1];
        cube[4][6] = B[2];
        cube[3][6] = B[3];
        cube[3][3] = B[4];
        cube[3][0] = B[5];
        cube[5][6] = B[6];
        cube[5][7] = B[7];
        cube[5][8] = B[8];
        cube[1][2] = B[9];
        cube[1][5] = B[10];
        cube[1][8] = B[11];

        UpdateMoves();
    }

    static void B_prime() {
        // When the B' is executed, the red(0) face is rotated counterclockwise
        rotateFaceCounterClockwise(0);
        rotateArrayPrime(B);
        // The indices of the "B" array correspond to the following faces of the cube:
        // (4, 4, 4, 3, 3, 3, 5, 5, 5, 1, 1, 1)
        cube[4][2] = B[0];
        cube[4][1] = B[1];
        cube[4][0] = B[2];
        cube[3][0] = B[3];
        cube[3][3] = B[4];
        cube[3][6] = B[5];
        cube[5][2] = B[6];
        cube[5][1] = B[7];
        cube[5][0] = B[8];
        cube[1][8] = B[9];
        cube[1][5] = B[10];
        cube[1][2] = B[11];
        UpdateMoves();
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
    App.printMoves();
    App.print_cube();
    //App.solveinreverse(stack);
}

