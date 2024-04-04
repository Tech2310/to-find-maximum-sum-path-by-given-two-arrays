public class MaxSumPath {

  static int maxSumPath(int[] arr1, int[] arr2, int m, int n) {
    // Create a dp table to store maximum sum path ending at each cell
    int[][] dp = new int[m + 1][n + 1];

    // Initialize the first row and column of the dp table
    for (int i = 1; i <= m; i++) {
      dp[i][0] = arr1[i - 1];
    }
    for (int j = 1; j <= n; j++) {
      dp[0][j] = arr2[j - 1];
    }

    // Fill the dp table
    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        if (arr1[i - 1] == arr2[j - 1]) {
          // If elements are same, consider the maximum sum from previous cells and add the current element
          dp[i][j] = Math.max(dp[i - 1][j - 1] + arr1[i - 1], dp[i][j]);
        } else {
          // If elements are different, consider the maximum sum from the previous cells excluding the current element
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }

    // Return the maximum sum path from the last cell of the dp table
    return dp[m][n];
  }

  public static void main(String[] args) {
    int[] arr1 = {2, 3, 7, 10,11,13,15};
    int[] arr2 = {4, 9, 5,12,14};
    int m = arr1.length;
    int n = arr2.length;

    int maxSum = maxSumPath(arr1, arr2, m, n);
    System.out.println("Maximum sum path: " + maxSum);
  }
}

