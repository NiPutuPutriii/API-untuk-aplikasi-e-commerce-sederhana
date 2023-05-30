public class Main {
    public static int soal6Code(int[] n) {
        if (n == null || n.length == 0) {
            return 0;
        }

        int currentLength = 1;
        int maxLength = 1;

        for (int i = 1; i < n.length; i++) {
            if (n[i] == n[i - 1] + 1) {
                currentLength++;
            } else if (n[i] != n[i - 1]) {
                maxLength = Math.max(maxLength, currentLength);
                currentLength = 1;
            }
        }

        maxLength = Math.max(maxLength, currentLength);

        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};

        int longestConsecutive = soal6Code(nums);
        System.out.println("Panjang urutan terpanjang: " + longestConsecutive);
    }
}
