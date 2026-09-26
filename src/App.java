import java.util.Scanner;
import java.util.Random;

public class App {

    public static final int TOP = 0;
    public static final int BOTTOM = 1;
    public static final int NORTH = 2;
    public static final int SOUTH = 3;
    public static final int WEST = 4;
    public static final int EAST = 5;

    public static char[][][] cube = {
        {
            {'W','W','W'},
            {'W','W','W'},
            {'W','W','W'}
        },
        {
            {'Y','Y','Y'},
            {'Y','Y','Y'},
            {'Y','Y','Y'}
        },
        {
            {'B','B','B'},
            {'B','B','B'},
            {'B','B','B'}
        },
        {
            {'G','G','G'},
            {'G','G','G'},
            {'G','G','G'}
        },
        {
            {'O','O','O'},
            {'O','O','O'},
            {'O','O','O'}
        },
        {
            {'R','R','R'},
            {'R','R','R'},
            {'R','R','R'}
        }
    };
    
    public static void Rotate(char[][] cube){
        char[][] cubeTemp = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cubeTemp[i][j] = cube[i][j];
            }
        }

        for (int i = 0; i < 3; i++){
            for (int j = 2; j >= 0; j--) {
                cube[j][2 - i] = cubeTemp[i][j];
            }
        }
    }

    public static void RotateCounter(char[][] cube){
        char[][] cubeTemp = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cubeTemp[i][j] = cube[i][j];
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cube[3 - j - 1][i] = cubeTemp[i][j];
            }
        }
    }

    public static void Turn(char[][] Side1, char[][] Side2, char[][] Side3, char[][] Side4, int TurnLocation) {
        // TurnLocation: 1 is the top, 2 is the right side, 3 is the bottom, and 4 is left
        char[][] tempSide1 = new char[3][3];
        char[][] tempSide2 = new char[3][3];
        char[][] tempSide3 = new char[3][3];
        char[][] tempSide4 = new char[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tempSide1[i][j] = Side1[i][j];
                tempSide2[i][j] = Side2[i][j];
                tempSide3[i][j] = Side3[i][j];
                tempSide4[i][j] = Side4[i][j];
            }
        }

        switch (TurnLocation) {
            case 1:
                for (int i = 0; i < 3; i++) {
                    Side1[0][i] = tempSide2[0][i];
                    Side2[0][i] = tempSide3[0][i];
                    Side3[0][i] = tempSide4[0][i];
                    Side4[0][i] = tempSide1[0][i];
                }
                break;
            case 2:
                for (int i = 0; i < 3; i++) {
                    Side1[i][2] = tempSide2[i][2];
                    Side2[i][2] = tempSide3[i][2];
                    Side3[i][2] = tempSide4[i][2];
                    Side4[i][2] = tempSide1[i][2];
                }
                break;
            case 3:
                for (int i = 0; i < 3; i++) {
                    Side1[2][i] = tempSide2[2][i];
                    Side2[2][i] = tempSide3[2][i];
                    Side3[2][i] = tempSide4[2][i];
                    Side4[2][i] = tempSide1[2][i];
                }
                break;
            case 4:
                for (int i = 0; i < 3; i++) {
                    Side1[i][0] = tempSide2[i][0];
                    Side2[i][0] = tempSide3[i][0];
                    Side3[i][0] = tempSide4[i][0];
                    Side4[i][0] = tempSide1[i][0];
                }
                break;
        }
        
    }

    public static void TurnCounter(char[][] Side1, char[][] Side2, char[][] Side3, char[][] Side4, int TurnLocation) {
        char[][] tempSide1 = new char[3][3];
        char[][] tempSide2 = new char[3][3];
        char[][] tempSide3 = new char[3][3];
        char[][] tempSide4 = new char[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tempSide1[i][j] = Side1[i][j];
                tempSide2[i][j] = Side2[i][j];
                tempSide3[i][j] = Side3[i][j];
                tempSide4[i][j] = Side4[i][j];
            }
        }

        switch(TurnLocation){
            case 1:
                for (int i = 0; i < 3; i++) {
                    Side1[0][i] = tempSide4[0][i];
                    Side2[0][i] = tempSide1[0][i];
                    Side3[0][i] = tempSide2[0][i];
                    Side4[0][i] = tempSide3[0][i];
                }
                break;
            case 2:
                for (int i = 0; i < 3; i++) {
                    Side1[i][2] = tempSide4[i][2];
                    Side2[i][2] = tempSide1[i][2];
                    Side3[i][2] = tempSide2[i][2];
                    Side4[i][2] = tempSide3[i][2];
                }
                break;
            case 3:
                for (int i = 0; i < 3; i++) {
                    Side1[2][i] = tempSide4[2][i];
                    Side2[2][i] = tempSide1[2][i];
                    Side3[2][i] = tempSide2[2][i];
                    Side4[2][i] = tempSide3[2][i];
                }
                break;
            case 4:
                for (int i = 0; i < 3; i++) {
                    Side1[i][0] = tempSide4[i][0];
                    Side2[i][0] = tempSide1[i][0];
                    Side3[i][0] = tempSide2[i][0];
                    Side4[i][0] = tempSide3[i][0];
                }
                break;
        }
    }

    public static void applyMove(char[][][] cube, String move) {
        int face;
        switch (move) {
            case "U": case "U'": face = TOP; break;
            case "D": case "D'": face = BOTTOM; break;
            case "B": case "B'": face = NORTH; break;
            case "F": case "F'": face = SOUTH; break;
            case "L": case "L'": face = WEST; break;
            case "R": case "R'": face = EAST; break;
            default:
                return;
        }

        int layer = face == TOP || face == EAST || face == SOUTH ? 1 : -1;
        int turns = move.endsWith("'") ? layer : -layer;
        char[][][] turnedCube = new char[cube.length][3][3];

        for (int sourceFace = 0; sourceFace < cube.length; sourceFace++) {
            for (int row = 0; row < 3; row++) {
                for (int column = 0; column < 3; column++) {
                    int[] position = faceletPosition(sourceFace, row, column);
                    int[] normal = faceNormal(sourceFace);
                    if (position[faceAxis(face)] == layer) {
                        rotateClockwise(position, faceAxis(face), turns);
                        rotateClockwise(normal, faceAxis(face), turns);
                    }
                    int destinationFace = faceFromNormal(normal);
                    int[] destination = faceletIndex(destinationFace, position);
                    turnedCube[destinationFace][destination[0]][destination[1]] = cube[sourceFace][row][column];
                }
            }
        }

        for (int faceIndex = 0; faceIndex < cube.length; faceIndex++) {
            for (int row = 0; row < 3; row++) {
                System.arraycopy(turnedCube[faceIndex][row], 0, cube[faceIndex][row], 0, 3);
            }
        }
    }

    private static int faceAxis(int face) {
        return face == WEST || face == EAST ? 0 : face == TOP || face == BOTTOM ? 1 : 2;
    }

    private static int[] faceNormal(int face) {
        switch (face) {
            case TOP: return new int[] {0, 1, 0};
            case BOTTOM: return new int[] {0, -1, 0};
            case NORTH: return new int[] {0, 0, -1};
            case SOUTH: return new int[] {0, 0, 1};
            case WEST: return new int[] {-1, 0, 0};
            default: return new int[] {1, 0, 0};
        }
    }

    private static int[] faceletPosition(int face, int row, int column) {
        switch (face) {
            case TOP: return new int[] {row - 1, 1, 1 - column};
            case BOTTOM: return new int[] {row - 1, -1, column - 1};
            case NORTH: return new int[] {row - 1, column - 1, -1};
            case SOUTH: return new int[] {row - 1, column - 1, 1};
            case WEST: return new int[] {-1, row - 1, column - 1};
            default: return new int[] {1, row - 1, column - 1};
        }
    }

    private static int faceFromNormal(int[] normal) {
        if (normal[1] == 1) return TOP;
        if (normal[1] == -1) return BOTTOM;
        if (normal[2] == -1) return NORTH;
        if (normal[2] == 1) return SOUTH;
        if (normal[0] == -1) return WEST;
        return EAST;
    }

    private static int[] faceletIndex(int face, int[] position) {
        switch (face) {
            case TOP: return new int[] {position[0] + 1, 1 - position[2]};
            case BOTTOM: return new int[] {position[0] + 1, position[2] + 1};
            case NORTH: case SOUTH: return new int[] {position[0] + 1, position[1] + 1};
            case WEST: case EAST: return new int[] {position[1] + 1, position[2] + 1};
            default: throw new IllegalArgumentException("Unknown face: " + face);
        }
    }

    private static void rotateClockwise(int[] vector, int axis, int turns) {
        for (int turn = 0; turn < (turns + 4) % 4; turn++) {
            int x = vector[0];
            int y = vector[1];
            int z = vector[2];
            switch (axis) {
                case 0:
                    vector[1] = -z;
                    vector[2] = y;
                    break;
                case 1:
                    vector[0] = z;
                    vector[2] = -x;
                    break;
                default:
                    vector[0] = -y;
                    vector[1] = x;
                    break;
            }
        }
    }

    public static String[] RandomizeCube(char[][][] cube, int randomMoves) {
        String[] moves = {"U","U'","D","D'","R","R'","L","L'","F","F'","B","B'"};
        String[] moveList = new String[randomMoves];
        Random random = new Random();

        for (int i = 0; i < randomMoves; i++) {
            int randomIndex = random.nextInt(moves.length);
            String move = moves[randomIndex];
            moveList[i] = move;
            applyMove(cube, move);
        }
        return moveList; 
    }

    public static void PrintCube(char[][][] cube) {
        for (char[][] side : cube) {
            for (char[] row : side) {
                for (int column = 0; column < row.length; column++) {
                    System.out.print(row[column]);
                    if (column < row.length - 1) {
                        System.out.print("|");
                    }
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    public static String[] Solving(String[] Moves) {
        String[] TempList = new String[Moves.length];
        int index = 0;

        for (int i = Moves.length - 1; i >= 0; i--) {
            if (Moves[i] == null) {
                continue;
            }
            switch (Moves[i]) {
                case "U":
                    TempList[index++] = "U'";
                    break;
                case "U'":
                    TempList[index++] = "U";
                    break;
                case "D":
                    TempList[index++] = "D'";
                    break;
                case "D'":
                    TempList[index++] = "D";
                    break;
                case "R":
                    TempList[index++] = "R'";
                    break;
                case "R'":
                    TempList[index++] = "R";
                    break;
                case "L":
                    TempList[index++] = "L'";
                    break;
                case "L'":
                    TempList[index++] = "L";
                    break;
                case "F":
                    TempList[index++] = "F'";
                    break;
                case "F'":
                    TempList[index++] = "F";
                    break;
                case "B":
                    TempList[index++] = "B'";
                    break;
                case "B'":
                    TempList[index++] = "B";
                    break;
            }
        }

        boolean Simple = false;

        for (int i = 0; i < index - 2; i++) {
            if (TempList[i].equals("U") && TempList[i + 1].equals("U") && TempList[i + 2].equals("U")) {
                TempList[i] = "U'";
                Simple = true;
            } else if (TempList[i].equals("U'") && TempList[i + 1].equals("U'") && TempList[i + 2].equals("U'")) {
                TempList[i] = "U";
                Simple = true;
            } else if (TempList[i].equals("D") && TempList[i + 1].equals("D") && TempList[i + 2].equals("D")) {
                TempList[i] = "D'";
                Simple = true;
            } else if (TempList[i].equals("D'") && TempList[i + 1].equals("D'") && TempList[i + 2].equals("D'")) {
                TempList[i] = "D";
                Simple = true;
            } else if (TempList[i].equals("R") && TempList[i + 1].equals("R") && TempList[i + 2].equals("R")) {
                TempList[i] = "R'";
                Simple = true;
            } else if (TempList[i].equals("R'") && TempList[i + 1].equals("R'") && TempList[i + 2].equals("R'")) {
                TempList[i] = "R";
                Simple = true;
            } else if (TempList[i].equals("L") && TempList[i + 1].equals("L") && TempList[i + 2].equals("L")) {
                TempList[i] = "L'";
                Simple = true;
            } else if (TempList[i].equals("L'") && TempList[i + 1].equals("L'") && TempList[i + 2].equals("L'")) {
                TempList[i] = "L";
                Simple = true;
            } else if (TempList[i].equals("F") && TempList[i + 1].equals("F") && TempList[i + 2].equals("F")) {
                TempList[i] = "F'";
                Simple = true;
            } else if (TempList[i].equals("F'") && TempList[i + 1].equals("F'") && TempList[i + 2].equals("F'")) {
                TempList[i] = "F";
                Simple = true;
            } else if (TempList[i].equals("B") && TempList[i + 1].equals("B") && TempList[i + 2].equals("B")) {
                TempList[i] = "B'";
                Simple = true;
            } else if (TempList[i].equals("B'") && TempList[i + 1].equals("B'") && TempList[i + 2].equals("B'")) {
                TempList[i] = "B";
                Simple = true;
            }
            if (Simple) {
                for (int j = i + 1; j < index - 2; j++) {
                    TempList[j] = TempList[j + 2];
                }
                index -= 2;
                Simple = false;
            }
        }

        for (int i = 0; i < index - 1; i++) {
            if ((TempList[i].equals("U") && TempList[i + 1].equals("U'")) ||
                (TempList[i].equals("U'") && TempList[i + 1].equals("U")) ||
                (TempList[i].equals("D") && TempList[i + 1].equals("D'")) ||
                (TempList[i].equals("D'") && TempList[i + 1].equals("D")) ||
                (TempList[i].equals("R") && TempList[i + 1].equals("R'")) ||
                (TempList[i].equals("R'") && TempList[i + 1].equals("R")) ||
                (TempList[i].equals("L") && TempList[i + 1].equals("L'")) ||
                (TempList[i].equals("L'") && TempList[i + 1].equals("L")) ||
                (TempList[i].equals("F") && TempList[i + 1].equals("F'")) ||
                (TempList[i].equals("F'") && TempList[i + 1].equals("F")) ||
                (TempList[i].equals("B") && TempList[i + 1].equals("B'")) ||
                (TempList[i].equals("B'") && TempList[i + 1].equals("B"))) {
                for (int j = i; j < index - 2; j++) {
                    TempList[j] = TempList[j + 2];
                }
                index -= 2;
                i = -1;
            }
        }

        String[] result = new String[index];
        System.arraycopy(TempList, 0, result, 0, index);
        return result;
    }

    public static int findNextNullIndex(String[] moveList) {
        for (int i = 0; i < moveList.length; i++) {
            if (moveList[i] == null) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String[] solution = null;

        String[] moveList = new String[10000];

        if (args.length > 0) {
            String[] argsMove = new String[args.length];
            for (int i = 0; i < args.length; i++) {
                argsMove[i] = args[i];
            }
            for (int i = 0; i < argsMove.length; i++) {
                String move = argsMove[i];
                applyMove(cube, move);
            }
            PrintCube(cube);
            sc.close();
            return;
        }

        System.out.println("Would you like to randomize the moves?(y/n)");
        String ans = sc.nextLine();
        if (ans.equals("y")) {
            System.out.println("How many moves would you like to do?");
            int randomMoves = sc.nextInt();
            moveList = RandomizeCube(cube, randomMoves);
        }

        while (true) {
            PrintCube(cube);
            System.out.println("Enter your move (or 'exit' to quit)\n(U, D, L, R, F, B with optional ' for counter-clockwise): ");
            System.out.println("Enter 'help' for extra help");
            String move = sc.nextLine();
            if (move.equals("exit")) {
                sc.close();
                return;
            } else if (move.equals("help")) {
                solution = Solving(moveList);
                System.out.println("Solution to solve the cube:");
                for (String step : solution) {
                    System.out.print(step + " ");
                }
                System.out.println();
                continue;
            }

            if (solution != null && solution.length > 0 && solution[0].equals(move)) {
                for (int i = moveList.length - 1; i >= 0; i--) {
                    if (moveList[i] != null) {
                        moveList[i] = null;
                        break;
                    }
                }
                solution = Solving(moveList);
            } else {
                int nextIndex = findNextNullIndex(moveList);
                if (nextIndex != -1) {
                    moveList[nextIndex] = move;
                }
            }

            applyMove(cube, move);
        }
    }
}