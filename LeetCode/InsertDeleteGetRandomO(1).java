public class RandomizedSet {
    private final ArrayList<Integer> arr;
    private final HashMap<Integer, Integer> pos;
    private final Random rng;

    public RandomizedSet() {
        arr = new ArrayList<>();
        pos = new HashMap<>();
        rng = new Random();
    }

    public boolean insert(int val) {
        if (pos.containsKey(val)) return false;
        pos.put(val, arr.size());
        arr.add(val);
        return true;
    }

    public boolean remove(int val) {
        Integer idx = pos.get(val);
        if (idx == null) return false;

        int lastIdx = arr.size() - 1;
        int lastVal = arr.get(lastIdx);

        // Move lastVal into idx
        arr.set(idx, lastVal);
        pos.put(lastVal, idx);

        // Remove tail
        arr.remove(lastIdx);
        pos.remove(val);
        return true;
    }

    public int getRandom() {
        int idx = rng.nextInt(arr.size());
        return arr.get(idx);
    }
}
