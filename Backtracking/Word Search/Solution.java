class Solution {
    boolean[] [] marked;
    public boolean exist(char[][] board, String word) {
        marked= new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length && i>=0; i++){
            for (int k = 0; k < board[i].length && k>=0; k++){
                if (search(0, i, k, board, word)) return true;
            }
        } 

        return false;
    }

    public boolean search(int d, int i, int k, char[][] board, String word){
        //System.out.printf("r %d %d c \n", i, k);
        if (i < board.length && i>=0 && k < board[i].length && k>=0){
            if (marked[i][k]) return false;
        } else{
            return false;
        }

        char ch = board[i][k];
        if (word.charAt(d) == ch){
            //System.out.println(ch);
            if (d+1==word.length()) return true;
            marked[i][k] = true;
            if (search(d+1, i+1, k, board, word) || search(d+1, i-1, k, board, word)|| 
            search(d+1, i, k+1, board, word)|| search(d+1, i, k-1, board, word)){
                return true;
            } else{
                marked[i][k] =false;
                return false;
            }       
        }
    
        return false;
    }
}
