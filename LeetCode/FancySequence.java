class Fancy {
    List<Long> sequence;
    long add;
    long mul;
    final int mod = 1000000007;
    public Fancy() {
        sequence = new ArrayList<>();
        add = 0;
        mul = 1;
    }
    
    public void append(int val) {
        long currentVal = val;
        long normalizedVal = (currentVal - add + mod) % mod;
        normalizedVal = (normalizedVal * modInverse(mul)) % mod;
        sequence.add(normalizedVal);
    }
    
    public void addAll(int inc) {
        add = (add + inc) % mod;
    }
    
    public void multAll(int m) {
        mul = (mul * m) % mod;
        add = (add * m) % mod;
    }
    
    public int getIndex(int idx) {
        if (idx >= sequence.size()) return -1;
        long normalizedVal = sequence.get(idx);
        long result = (normalizedVal * mul) % mod;
        result = (result + add) % mod;
        return (int) result;
    }

    private long modInverse(long base) {
        long res = 1;
        long exp = mod - 2;
        base %= mod;
        while (exp > 0) {
          if (exp % 2 == 1) {
            res = (res * base) % mod;
          }
          base = (base * base) % mod;
          exp /= 2;
        }
        return res;
    }
}

/**
 * Your Fancy object will be instantiated and called as such:
 * Fancy obj = new Fancy();
 * obj.append(val);
 * obj.addAll(inc);
 * obj.multAll(m);
 * int param_4 = obj.getIndex(idx);
 */
