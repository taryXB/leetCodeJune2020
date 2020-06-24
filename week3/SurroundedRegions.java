/* Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

Example:

X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X
Explanation:

Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are not flipped to 'X'. Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'. Two cells are connected if they are adjacent cells connected horizontally or vertically.
 */

class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        if(m==0) return;
        int n = board[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if((i==0 || j==0 || i==m-1 || j==n-1) && board[i][j]=='O') {
                    dfs(board, i , j);
                }
            }
        }
        for(int i = 0; i < m; i++){
            for(int j = 0 ; j < n; j++){
                if(board[i][j]=='1')
                    board[i][j]='O';
                else
                    board[i][j]='X';
            }
        }
    }
    private void dfs(char[][] board, int i, int j) {
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j]!='O')
            return;
        board[i][j] = '1';
        dfs(board, i+1, j);
        dfs(board, i-1, j);
        dfs(board, i, j+1);
        dfs(board, i, j-1);
    }
}
