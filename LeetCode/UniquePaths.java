public class UniquePaths {

    //Space complexity O(m*n)
    public int findUniquePaths1(int m,int n){
        int[][] map = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0)
                    map[i][j] = 1;
                else
                    map[i][j] = map[i - 1][j] + map[i][j - 1];
            }
        }
        
        return map[m - 1][n - 1];
    }

    //Space complexity O(n)
    public int findUniquePaths2(int m,int n){

        if (m <= 0 || n <= 0) return 0;
        int min = Math.min(m, n);
        int max = Math.max(m, n);
        int[] map = new int[min];
        for(int i=0; i <min;i++)
            map[i] = 1;
        
        for (int i = 0; i < max; i++) {
            for (int j = 0; j < min; j++) {
                    map[j] = map[j] + map[j - 1];
            }
        }
        
        return map[min - 1];
    }
    
}
