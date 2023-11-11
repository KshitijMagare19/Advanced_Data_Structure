package Algo;

public class ShelfPlacement {

    public static void minSpacePreferLarge(int wall, int m, int n) {
        int num_m = 0, num_n = 0, min_empty = wall;
        int p = wall / m, q = 0, rem = wall % m;
        num_m = p;
        num_n = q;
        min_empty = rem;

        while (wall >= n) {
            q += 1;
            wall = wall - n;
            p = wall / m;
            rem = wall % m;

            if (rem <= min_empty) {
                num_m = p;
                num_n = q;
                min_empty = rem;
            }
        }

        System.out.println(num_m + " " + num_n + " " + min_empty);
    }

    public static void main(String[] args) {
        int wall = 29, m = 3, n = 9;
        minSpacePreferLarge(wall, m, n);

        wall = 76;
        m = 1;
        n = 10;
        minSpacePreferLarge(wall, m, n);
    }
}
