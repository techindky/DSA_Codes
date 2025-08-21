class Solution {

    int[] arr;
    int max = 0;
    Random random = new Random();
    public Solution(int[] w) {
        int[] arr = new int[w.length];
        arr[0] = w[0];
        max += w[0];
        for(int i=1; i<w.length; i++){
            arr[i] = arr[i-1] + w[i];
            max+=w[i];
        }
        this.arr = arr;
    }
    
    public int pickIndex() {
        int rnd = random.nextInt(max) + 1;
        int ret = Arrays.binarySearch(arr, rnd); 
        if(ret < 0) ret = -ret - 1;
        return ret;
    }
}
