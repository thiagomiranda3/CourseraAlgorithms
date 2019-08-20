public class Test {

    public static void main(String[] args) {
        Percolation percolation = new Percolation(4);

        percolation.open(0, 1);
        percolation.open(1, 1);
        percolation.open(1, 2);
        percolation.open(2, 2);
        percolation.open(2, 3);
        percolation.open(3, 3);

        percolation.open(2, 0);
        percolation.open(3, 0);
        percolation.open(3, 1);

        System.out.println("Percolates: " + percolation.percolates());
        System.out.println("Open Sites: " + percolation.numberOfOpenSites());

        percolation.printMatrix();
    }
}
