
class CountSquares {
    private final Map<Integer, Integer> cnt = new HashMap<>();

    private int key(int x, int y) { return x * 1001 + y; }

    public CountSquares() { }

    public void add(int[] point) {
        cnt.merge(key(point[0], point[1]), 1, Integer::sum);
    }

    public int count(int[] point) {
        int px = point[0], py = point[1];
        int total = 0;
        for (Map.Entry<Integer, Integer> e : cnt.entrySet()) {
            int dx = e.getKey() / 1001, dy = e.getKey() % 1001;

            // true diagonal: equal side lengths, and non-zero area
            if (Math.abs(dx - px) != Math.abs(dy - py) || dx == px) continue;

            total += e.getValue()
                   * cnt.getOrDefault(key(dx, py), 0)
                   * cnt.getOrDefault(key(px, dy), 0);
        }
        return total;
    }
}