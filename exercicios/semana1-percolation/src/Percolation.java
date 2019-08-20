import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private static final int IS_OPEN = 1;
    private final WeightedQuickUnionUF wquOpen;
    private final WeightedQuickUnionUF wquFull;
    private int N;
    private int openSites = 0;
    private int indexTop;
    private int indexBottom;
    private int[][] matrix;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        this.N = n;
        this.matrix = new int[N][N];
        this.wquOpen = new WeightedQuickUnionUF((N * N) + 2);
        this.wquFull = new WeightedQuickUnionUF((N * N) + 1);
        this.indexTop = N * N;
        this.indexBottom = (N * N) + 1;

        for (int i = 0; i < N; i++) {
            wquFull.union(indexTop, getIndex(0, i));
            wquOpen.union(indexTop, getIndex(0, i));
            wquOpen.union(indexBottom, getIndex(N - 1, i));
        }
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        if (isOpen(row, col)) {
            return;
        }

        openSites++;
        matrix[row][col] = IS_OPEN;

        conectaVizinho(row, col, row - 1, col); // cima
        conectaVizinho(row, col, row + 1, col); // baixo
        conectaVizinho(row, col, row, col - 1); // esquerda
        conectaVizinho(row, col, row, col + 1); // direita
    }

    private void conectaVizinho(int row, int col, int rowV, int colV) {
        if (!checkRowCol(rowV, colV)) {
            return;
        }

        if (matrix[rowV][colV] == IS_OPEN) {
            wquOpen.union(getIndex(row, col), getIndex(rowV, colV));
            wquFull.union(getIndex(row, col), getIndex(rowV, colV));
        }
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        validateMatrix(row, col);

        return matrix[row][col] == IS_OPEN;
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        validateMatrix(row, col);

        return isOpen(row, col) && wquFull.connected(indexTop, getIndex(row, col));
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return openSites;
    }

    // does the system percolate?
    public boolean percolates() {
        return wquOpen.connected(indexTop, indexBottom);
    }

    private int getIndex(int row, int col) {
        return col + (row * N);
    }

    private boolean checkRowCol(int row, int col) {
        if (row < 0 || col < 0) {
            return false;
        }

        return row < N && col < N;
    }

    private void validateMatrix(int row, int col) {
        if (!checkRowCol(row, col)) {
            throw new IllegalArgumentException("[" + row + ", " + col + "] is invalid");
        }
    }

    public void printMatrix() {
        for (int i = 0; i < N; i++) {
            System.out.println("");
            System.out.print("[ ");
            for (int j = 0; j < N; j++) {
                if(isFull(i, j)) {
                    System.out.print("# ");
                } else if(isOpen(i, j)) {
                    System.out.print("1 ");
                } else {
                    System.out.print("0 ");
                }
            }
            System.out.print("]");
        }
    }
}
