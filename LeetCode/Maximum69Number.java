class Solution {
    public int maximum69Number (int num) {
        StringBuilder t = new StringBuilder();
        t.append(num);
        int idx = t.indexOf("6");
        if (idx != -1) t.setCharAt(idx, '9');
        return Integer.parseInt(t.toString());
    }
}
