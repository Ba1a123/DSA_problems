import java.util.Arrays;

class Item {
    int pf;
    int wg;

    public Item(int pf, int wg) {
        this.pf = pf;
        this.wg = wg;
    }
}

class MaxProfits {
    public static int profitmet(Item[] items, int n, int w) {
        Arrays.sort(items, (a, b) -> (b.pf - a.pf));
        int tp = 0;
        for (int i = 0; i < n; i++) {
            if (items[i].wg <= w) {
                tp += items[i].pf;
                w -= items[i].wg;
            }
        }
        return tp;
    }

    public static void main(String[] args) {
        Item[] items = new Item[3];
        items[0] = new Item(60, 10);
        items[1] = new Item(100, 20);
        items[2] = new Item(60, 10);

        int a = profitmet(items, 3, 50);
        System.out.print(a);
    }
}
