import java.io.*;
import java.util.*;

public class SudoKu_Hard_19998 extends AbstractSudokuSolver {

    public static int[][] arr = new int[9][9];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 9; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        SudoKu_Hard_19998 solver = new SudoKu_Hard_19998();

        solver.solve(arr);

    }

    private int[][] makeExactCoverGrid(int[][] sudoku) {
        int[][] R = sudokuExactCover();
        for (int i = 1; i <= S; i++) {
            for (int j = 1; j <= S; j++) {
                int n = sudoku[i - 1][j - 1];
                if (n != 0) {
                    for (int num = 1; num <= S; num++) {
                        if (num != n) {
                            Arrays.fill(R[getIdx(i, j, num)], 0);
                        }
                    }
                }
            }
        }
        return R;
    }

    private int[][] sudokuExactCover() {
        int[][] R = new int[9 * 9 * 9][9 * 9 * 4];

        int hBase = 0;

        for (int r = 1; r <= S; r++) {
            for (int c = 1; c <= S; c++, hBase++) {
                for (int n = 1; n <= S; n++) {
                    R[getIdx(r, c, n)][hBase] = 1;
                }
            }
        }

        for (int r = 1; r <= S; r++) {
            for (int n = 1; n <= S; n++, hBase++) {
                for (int c1 = 1; c1 <= S; c1++) {
                    R[getIdx(r, c1, n)][hBase] = 1;
                }
            }
        }

        for (int c = 1; c <= S; c++) {
            for (int n = 1; n <= S; n++, hBase++) {
                for (int r1 = 1; r1 <= S; r1++) {
                    R[getIdx(r1, c, n)][hBase] = 1;
                }
            }
        }

        for (int br = 1; br <= S; br += side) {
            for (int bc = 1; bc <= S; bc += side) {
                for (int n = 1; n <= S; n++, hBase++) {
                    for (int rDelta = 0; rDelta < side; rDelta++) {
                        for (int cDelta = 0; cDelta < side; cDelta++) {
                            R[getIdx(br + rDelta, bc + cDelta, n)][hBase] = 1;
                        }
                    }
                }
            }
        }

        return R;
    }

    private int getIdx(int row, int col, int num) {
        return (row - 1) * S * S + (col - 1) * S + (num - 1);
    }

    public void generateAllSolutions() {
        int[][] cover = sudokuExactCover();
        DancingLinks dlx = new DancingLinks(cover, new SudokuHandler(S));
        dlx.runSolver();
    }

    protected void runSolver(int[][] sudoku) {
        int[][] cover = makeExactCoverGrid(sudoku);
        DancingLinks dlx = new DancingLinks(cover, new SudokuHandler(S));
        dlx.runSolver();
    }

}

class DancingLinks {

    static final boolean verbose = true;

    class DancingNode {
        DancingNode L, R, U, D;
        ColumnNode C;

        DancingNode hookDown(DancingNode n1) {
            assert (this.C == n1.C);
            n1.D = this.D;
            n1.D.U = n1;
            n1.U = this;
            this.D = n1;
            return n1;
        }

        DancingNode hookRight(DancingNode n1) {
            n1.R = this.R;
            n1.R.L = n1;
            n1.L = this;
            this.R = n1;
            return n1;
        }

        void unlinkLR() {
            this.L.R = this.R;
            this.R.L = this.L;
            updates++;
        }

        void relinkLR() {
            this.L.R = this.R.L = this;
            updates++;
        }

        void unlinkUD() {
            this.U.D = this.D;
            this.D.U = this.U;
            updates++;
        }

        void relinkUD() {
            this.U.D = this.D.U = this;
            updates++;
        }

        public DancingNode() {
            L = R = U = D = this;
        }

        public DancingNode(ColumnNode c) {
            this();
            C = c;
        }
    }

    class ColumnNode extends DancingNode {
        int size;
        String name;

        public ColumnNode(String n) {
            super();
            size = 0;
            name = n;
            C = this;
        }

        void cover() {
            unlinkLR();
            for (DancingNode i = this.D; i != this; i = i.D) {
                for (DancingNode j = i.R; j != i; j = j.R) {
                    j.unlinkUD();
                    j.C.size--;
                }
            }
            header.size--;
        }

        void uncover() {
            for (DancingNode i = this.U; i != this; i = i.U) {
                for (DancingNode j = i.L; j != i; j = j.L) {
                    j.C.size++;
                    j.relinkUD();
                }
            }
            relinkLR();
            header.size++;
        }
    }

    private ColumnNode header;
    private int solutions = 0;
    private int updates = 0;
    private SolutionHandler handler;
    private List<DancingNode> answer;

    private void search(int k) {
        if (header.R == header) {
            if (verbose) {

            }
            handler.handleSolution(answer);
            if (verbose) {

            }
            System.exit(0);
            solutions++;
        } else {
            ColumnNode c = selectColumnNodeHeuristic();
            c.cover();

            for (DancingNode r = c.D; r != c; r = r.D) {
                answer.add(r);

                for (DancingNode j = r.R; j != r; j = j.R) {
                    j.C.cover();
                }

                search(k + 1);

                r = answer.remove(answer.size() - 1);
                c = r.C;

                for (DancingNode j = r.L; j != r; j = j.L) {
                    j.C.uncover();
                }
            }
            c.uncover();
        }
    }

    private ColumnNode selectColumnNodeNaive() {
        return (ColumnNode) header.R;
    }

    private ColumnNode selectColumnNodeHeuristic() {
        int min = Integer.MAX_VALUE;
        ColumnNode ret = null;
        for (ColumnNode c = (ColumnNode) header.R; c != header; c = (ColumnNode) c.R) {
            if (c.size < min) {
                min = c.size;
                ret = c;
            }
        }
        return ret;
    }

    private ColumnNode selectColumnNodeRandom() { // select a column randomly
        ColumnNode ptr = (ColumnNode) header.R;
        ColumnNode ret = null;
        int c = 1;
        while (ptr != header) {
            if (Math.random() <= 1 / (double) c) {
                ret = ptr;
            }
            c++;
            ptr = (ColumnNode) ptr.R;
        }
        return ret;
    }

    private ColumnNode selectColumnNodeNth(int n) {
        int go = n % header.size;
        ColumnNode ret = (ColumnNode) header.R;
        for (int i = 0; i < go; i++)
            ret = (ColumnNode) ret.R;
        return ret;
    }

    private void printBoard() {
        System.out.println("Board Config: ");
        for (ColumnNode tmp = (ColumnNode) header.R; tmp != header; tmp = (ColumnNode) tmp.R) {

            for (DancingNode d = tmp.D; d != tmp; d = d.D) {
                String ret = "";
                ret += d.C.name + " --> ";
                for (DancingNode i = d.R; i != d; i = i.R) {
                    ret += i.C.name + " --> ";
                }
                System.out.println(ret);
            }
        }
    }

    private ColumnNode makeDLXBoard(int[][] grid) {
        final int COLS = grid[0].length;
        final int ROWS = grid.length;

        ColumnNode headerNode = new ColumnNode("header");
        ArrayList<ColumnNode> columnNodes = new ArrayList<ColumnNode>();

        for (int i = 0; i < COLS; i++) {
            ColumnNode n = new ColumnNode(Integer.toString(i));
            columnNodes.add(n);
            headerNode = (ColumnNode) headerNode.hookRight(n);
        }
        headerNode = headerNode.R.C;

        for (int i = 0; i < ROWS; i++) {
            DancingNode prev = null;
            for (int j = 0; j < COLS; j++) {
                if (grid[i][j] == 1) {
                    ColumnNode col = columnNodes.get(j);
                    DancingNode newNode = new DancingNode(col);
                    if (prev == null)
                        prev = newNode;
                    col.U.hookDown(newNode);
                    prev = prev.hookRight(newNode);
                    col.size++;
                }
            }
        }

        headerNode.size = COLS;

        return headerNode;
    }

    public DancingLinks(int[][] grid) {
        this(grid, new DefaultHandler());
    }

    public DancingLinks(int[][] grid, SolutionHandler h) {
        header = makeDLXBoard(grid);
        handler = h;
    }

    public void runSolver() {
        solutions = 0;
        updates = 0;
        answer = new LinkedList<DancingNode>();
        search(0);

    }

}

abstract class AbstractSudokuSolver {

    protected int S = 9;
    protected int side = 3;

    protected abstract void runSolver(int[][] sudoku);

    public boolean solve(int[][] sudoku) {
        if (!validateSudoku(sudoku)) {
            System.out.println("Error: Invalid sudoku. Aborting....");
            return false;
        }
        S = sudoku.length;
        side = (int) Math.sqrt(S);
        runSolver(sudoku);
        return true;
    }

    public boolean solve(String[] s) {
        return solve(fromCharArr(s));
    }

    private static int[][] fromCharArr(String[] s) {
        int S = s.length;
        int[][] out = new int[S][S];
        for (int i = 0; i < S; i++) {
            for (int j = 0; j < S; j++) {
                int num = s[i].charAt(j) - '1';
                if (num >= 1 && num <= S)
                    out[i][j] = num;
            }
        }
        return out;
    }

    public static void printSolution(int[][] result) {
        int N = result.length;
        for (int i = 0; i < N; i++) {
            String ret = "";
            for (int j = 0; j < N; j++) {
                ret += result[i][j] + " ";
            }
            System.out.println(ret);
        }
        System.out.println();
    }

    protected static boolean validateSudoku(int[][] grid) {
        if (grid.length != 9 && grid.length != 16)
            return false;
        for (int i = 0; i < grid.length; i++) {
            if (grid[i].length != grid.length)
                return false;
            for (int j = 0; j < grid[i].length; j++) {
                if (!(i >= 0 && i <= grid.length))
                    return false;
            }
        }

        int N = grid.length;

        boolean[] b = new boolean[N + 1];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 0)
                    continue;
                if (b[grid[i][j]])
                    return false;
                b[grid[i][j]] = true;
            }
            Arrays.fill(b, false);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[j][i] == 0)
                    continue;
                if (b[grid[j][i]])
                    return false;
                b[grid[j][i]] = true;
            }
            Arrays.fill(b, false);
        }

        int side = (int) Math.sqrt(N);

        for (int i = 0; i < N; i += side) {
            for (int j = 0; j < N; j += side) {
                for (int d1 = 0; d1 < side; d1++) {
                    for (int d2 = 0; d2 < side; d2++) {
                        if (grid[i + d1][j + d2] == 0)
                            continue;
                        if (b[grid[i + d1][j + d2]])
                            return false;
                        b[grid[i + d1][j + d2]] = true;
                    }
                }
                Arrays.fill(b, false);
            }
        }
        return true;
    }

}

interface SolutionHandler {
    void handleSolution(List<DancingLinks.DancingNode> solution);
}

class SudokuHandler implements SolutionHandler {
    int size = 9;

    public void handleSolution(List<DancingLinks.DancingNode> answer) {
        int[][] result = parseBoard(answer);
        AbstractSudokuSolver.printSolution(result);
    }

    private int[][] parseBoard(List<DancingLinks.DancingNode> answer) {
        int[][] result = new int[size][size];
        for (DancingLinks.DancingNode n : answer) {
            DancingLinks.DancingNode rcNode = n;
            int min = Integer.parseInt(rcNode.C.name);
            for (DancingLinks.DancingNode tmp = n.R; tmp != n; tmp = tmp.R) {
                int val = Integer.parseInt(tmp.C.name);
                if (val < min) {
                    min = val;
                    rcNode = tmp;
                }
            }
            int ans1 = Integer.parseInt(rcNode.C.name);
            int ans2 = Integer.parseInt(rcNode.R.C.name);
            int r = ans1 / size;
            int c = ans1 % size;
            int num = (ans2 % size) + 1;
            result[r][c] = num;
        }
        return result;
    }

    public SudokuHandler(int boardSize) {
        size = boardSize;
    }

}

class DefaultHandler implements SolutionHandler {
    public void handleSolution(List<DancingLinks.DancingNode> answer) {
        for (DancingLinks.DancingNode n : answer) {
            String ret = "";
            ret += n.C.name + " ";
            DancingLinks.DancingNode tmp = n.R;
            while (tmp != n) {
                ret += tmp.C.name + " ";
                tmp = tmp.R;
            }
            System.out.println(ret);
        }
    }
}
