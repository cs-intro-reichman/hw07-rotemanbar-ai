public class Binomial {
    public static void main(String[] args) {
        if (args.length < 2) return;
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        System.out.println(binomial(n, k));
    }

    public static long binomial1(int n, int k) {
        if (k > n) return 0;
        if (k == 0 || k == n) return 1;
        return binomial1(n - 1, k) + binomial1(n - 1, k - 1);
    }

    public static long binomial(int n, int k) {
        if (k > n) return 0;
        if (k == 0 || k == n) return 1;
        if (k > n / 2) k = n - k;
        
        long[][] memo = new long[n + 1][k + 1];
        return binomial(n, k, memo);
    }

    private static long binomial(int n, int k, long[][] memo) {
        if (k < 0 || k > n) return 0;
        if (k == 0 || k == n) return 1;
        
        if (memo[n][k] != 0) {
            return memo[n][k];
        }
        
        memo[n][k] = binomial(n - 1, k, memo) + binomial(n - 1, k - 1, memo);
        return memo[n][k];
    }
}