/**
 * The rand7() API is already defined in the parent class SolBase.
 * public int rand7();
 * @return a random integer in the range 1 to 7
 */
class Solution extends SolBase {
    public int rand10() {
        while (true) {
            int num = (super.rand7() - 1) * 7 + super.rand7();
            if (num <= 40) return (num % 10) + 1;
        }
    }
}
