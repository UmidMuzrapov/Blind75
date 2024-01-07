class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length - 1;
        int n = matrix[0].length - 1;
        boolean[][] marked = new boolean[m+1][n+1];

        for (int r=0;r <= m; r++){
            for (int c=0; c<=n; c++){
                if (matrix[r][c]==0){
                    marked[r][c]= true;
                }
            }
        }

        for (int r=0; r <= m ; r++){
            for (int c=0; c<=n; c++){
                if (marked[r][c] && matrix[r][c]==0){
                    rZ(r, matrix);
                    cZ(c, matrix);
                }
            }
        }
    }

    private void rZ(int r, int[][] matrix){
        for (int c=0; c <matrix[0].length; c++){
            matrix[r][c] = 0;
        }
    }

    private void cZ(int c, int[][] matrix){
        for (int r=0; r< matrix.length; r++){
                matrix[r][c]=0;
        }
    }
}
