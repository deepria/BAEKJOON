
import java.util.*;
import java.io.*;

public class Sudoku {

    public static void main(String args[]) throws Exception {
        InputStream in;
        if (args.length > 0)
            in = new FileInputStream(args[0]);
        else
            in = System.in;

        int puzzleSize = 3;

        Sudoku s = new Sudoku(puzzleSize);

        s.read(in);

        s.solve();

        s.print();
    }

    int SIZE, N;

    int Grid[][];

    public void solve() {
        AlgorithmXSolver solver = new AlgorithmXSolver();
        solver.run(Grid);
    }

    public class AlgorithmXSolver {
        private ColumnNode root = null;
        private ArrayList solution = new ArrayList();

        private void run(int[][] initialMatrix) {
            byte[][] matrix = createMatrix(initialMatrix);
            ColumnNode doubleLinkedList = createDoubleLinkedLists(matrix);
            search(0);
        }

        class Node {
            Node left;
            Node right;
            Node up;
            Node down;
            ColumnNode head;
        }

        class ColumnNode extends Node {
            int size = 0;
            ColumnID info;
        }

        class ColumnID {
            int constraint = -1;
            int number = -1;
            int position = -1;
        }

        private byte[][] createMatrix(int[][] initialMatrix) {
            int[][] clues = null;
            ArrayList cluesList = new ArrayList();
            int counter = 0;
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if (initialMatrix[r][c] > 0) {
                        cluesList.add(new int[] { initialMatrix[r][c], r, c });
                        counter++;
                    }
                }
            }
            clues = new int[counter][]; // store the clues once we've gotten them
            for (int i = 0; i < counter; i++) {
                clues[i] = (int[]) cluesList.get(i);
            }

            byte[][] matrix = new byte[N * N * N][4 * N * N];

            for (int d = 0; d < N; d++) {

                for (int r = 0; r < N; r++) {

                    for (int c = 0; c < N; c++) {
                        if (!filled(d, r, c, clues)) {

                            int rowIndex = c + (N * r) + (N * N * d);

                            int blockIndex = ((c / SIZE) + ((r / SIZE) * SIZE));
                            int colIndexRow = 3 * N * d + r;
                            int colIndexCol = 3 * N * d + N + c;
                            int colIndexBlock = 3 * N * d + 2 * N + blockIndex;
                            int colIndexSimple = 3 * N * N + (c + N * r);

                            matrix[rowIndex][colIndexRow] = 1;
                            matrix[rowIndex][colIndexCol] = 1;
                            matrix[rowIndex][colIndexBlock] = 1;
                            matrix[rowIndex][colIndexSimple] = 1;
                        }
                    }
                }
            }
            return matrix;
        }

        private boolean filled(int digit, int row, int col, int[][] prefill) {
            boolean filled = false;
            if (prefill != null) {
                for (int i = 0; i < prefill.length; i++) {
                    int d = prefill[i][0] - 1;
                    int r = prefill[i][1];
                    int c = prefill[i][2];
                    int blockStartIndexCol = (c / SIZE) * SIZE;
                    int blockEndIndexCol = blockStartIndexCol + SIZE;
                    int blockStartIndexRow = (r / SIZE) * SIZE;
                    int blockEndIndexRow = blockStartIndexRow + SIZE;
                    if (d != digit && row == r && col == c) {
                        filled = true;
                    } else if ((d == digit) && (row == r || col == c) && !(row == r && col == c)) {
                        filled = true;
                    } else if ((d == digit) && (row > blockStartIndexRow) && (row < blockEndIndexRow)
                            && (col > blockStartIndexCol) && (col < blockEndIndexCol) && !(row == r && col == c)) {
                        filled = true;
                    }
                }
            }
            return filled;
        }

        private ColumnNode createDoubleLinkedLists(byte[][] matrix) {
            root = new ColumnNode();
            ColumnNode curColumn = root;
            for (int col = 0; col < matrix[0].length; col++) {
                ColumnID id = new ColumnID();
                if (col < 3 * N * N) {
                    int digit = (col / (3 * N)) + 1;
                    id.number = digit;
                    int index = col - (digit - 1) * 3 * N;
                    if (index < N) {
                        id.constraint = 0;
                        id.position = index;
                    } else if (index < 2 * N) {
                        id.constraint = 1;
                        id.position = index - N;
                    } else {
                        id.constraint = 2;
                        id.position = index - 2 * N;
                    }
                } else {
                    id.constraint = 3;
                    id.position = col - 3 * N * N;
                }
                curColumn.right = new ColumnNode();
                curColumn.right.left = curColumn;
                curColumn = (ColumnNode) curColumn.right;
                curColumn.info = id;
                curColumn.head = curColumn;
            }
            curColumn.right = root;
            root.left = curColumn;

            for (int row = 0; row < matrix.length; row++) {
                curColumn = (ColumnNode) root.right;
                Node lastCreatedElement = null;
                Node firstElement = null;
                for (int col = 0; col < matrix[row].length; col++) {
                    if (matrix[row][col] == 1) {
                        Node colElement = curColumn;
                        while (colElement.down != null) {
                            colElement = colElement.down;
                        }
                        colElement.down = new Node();
                        if (firstElement == null) {
                            firstElement = colElement.down;
                        }
                        colElement.down.up = colElement;
                        colElement.down.left = lastCreatedElement;
                        colElement.down.head = curColumn;
                        if (lastCreatedElement != null) {
                            colElement.down.left.right = colElement.down;
                        }
                        lastCreatedElement = colElement.down;
                        curColumn.size++;
                    }
                    curColumn = (ColumnNode) curColumn.right;
                }
                if (lastCreatedElement != null) {
                    lastCreatedElement.right = firstElement;
                    firstElement.left = lastCreatedElement;
                }
            }
            curColumn = (ColumnNode) root.right;
            for (int i = 0; i < matrix[0].length; i++) {
                Node colElement = curColumn;
                while (colElement.down != null) {
                    colElement = colElement.down;
                }
                colElement.down = curColumn;
                curColumn.up = colElement;
                curColumn = (ColumnNode) curColumn.right;
            }
            return root;
        }

        private void search(int k) {
            if (root.right == root) {
                mapSolvedToGrid();
                return;
            }
            ColumnNode c = choose();
            cover(c);
            Node r = c.down;
            while (r != c) {
                if (k < solution.size()) {
                    solution.remove(k);
                }
                solution.add(k, r);

                Node j = r.right;
                while (j != r) {
                    cover(j.head);
                    j = j.right;
                }
                search(k + 1);

                Node r2 = (Node) solution.get(k);
                Node j2 = r2.left;
                while (j2 != r2) {
                    uncover(j2.head);
                    j2 = j2.left;
                }
                r = r.down;
            }
            uncover(c);
        }

        private void mapSolvedToGrid() {
            int[] result = new int[N * N];
            for (Iterator it = solution.iterator(); it.hasNext();) {
                int number = -1;
                int cellNo = -1;
                Node element = (Node) it.next();
                Node next = element;
                do {
                    if (next.head.info.constraint == 0) {
                        number = next.head.info.number;
                    } else if (next.head.info.constraint == 3) {
                        cellNo = next.head.info.position;
                    }
                    next = next.right;
                } while (element != next);
                result[cellNo] = number;
            }
            int resultCounter = 0;
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    Grid[r][c] = result[resultCounter];
                    resultCounter++;
                }
            }
        }

        private ColumnNode choose() {
            ColumnNode rightOfRoot = (ColumnNode) root.right;
            ColumnNode smallest = rightOfRoot;
            while (rightOfRoot.right != root) {
                rightOfRoot = (ColumnNode) rightOfRoot.right;
                if (rightOfRoot.size < smallest.size) {
                    smallest = rightOfRoot;
                }
            }
            return smallest;
        }

        private void cover(Node column) {

            column.right.left = column.left;
            column.left.right = column.right;

            Node curRow = column.down;
            while (curRow != column) {
                Node curNode = curRow.right;
                while (curNode != curRow) {
                    curNode.down.up = curNode.up;
                    curNode.up.down = curNode.down;
                    curNode.head.size--;
                    curNode = curNode.right;
                }
                curRow = curRow.down;
            }
        }

        private void uncover(Node column) {
            Node curRow = column.up;
            while (curRow != column) {
                Node curNode = curRow.left;
                while (curNode != curRow) {
                    curNode.head.size++;
                    curNode.down.up = curNode;
                    curNode.up.down = curNode;
                    curNode = curNode.left;
                }
                curRow = curRow.up;
            }
            column.right.left = column;
            column.left.right = column;
        }

    }

    public Sudoku(int size) {
        SIZE = size;
        N = size * size;

        Grid = new int[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                Grid[i][j] = 0;
    }

    static int readInteger(InputStream in) throws Exception {
        int result = 0;
        boolean success = false;

        while (!success) {
            String word = readWord(in);

            try {
                result = Integer.parseInt(word);
                success = true;
            } catch (Exception e) {
                if (word.compareTo("x") == 0) {
                    result = 0;
                    success = true;
                }
            }
        }

        return result;
    }

    static String readWord(InputStream in) throws Exception {
        StringBuffer result = new StringBuffer();
        int currentChar = in.read();
        String whiteSpace = " \t\r\n";
        while (whiteSpace.indexOf(currentChar) > -1) {
            currentChar = in.read();
        }

        while (whiteSpace.indexOf(currentChar) == -1) {
            result.append((char) currentChar);
            currentChar = in.read();
        }
        return result.toString();
    }

    public void read(InputStream in) throws Exception {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Grid[i][j] = readInteger(in);
            }
        }
    }

    void printFixedWidth(String text, int width) {
        for (int i = 0; i < width - text.length(); i++)
            System.out.print(" ");
        System.out.print(text);
    }

    public void print() {
        int digits = (int) Math.floor(Math.log(N) / Math.log(10)) + 1;

        /*
         * int lineLength = (digits + 1) * N + 2 * SIZE - 3;
         * StringBuffer line = new StringBuffer();
         * 
         * for (int lineInit = 0; lineInit < lineLength; lineInit++)
         * line.append('-');
         */

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                printFixedWidth(String.valueOf(Grid[i][j]), digits);
                /*
                 * if ((j < N - 1) && ((j + 1) % SIZE == 0))
                 * System.out.print(" ");
                 */
                System.out.print(" ");
            }
            System.out.println();

            /*
             * if ((i < N - 1) && ((i + 1) % SIZE == 0))
             * System.out.println(line.toString());
             */
        }
    }

}
