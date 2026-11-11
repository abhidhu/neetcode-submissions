class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        int[] board = new int[n];
        helper(board, ans, n, new boolean[n], new boolean[n+n], new boolean[n+n], 0);
        return ans;
    }

    private void helper(int[] board, List<List<String>> ans, int n, boolean[] col, boolean[] leftDia, boolean[] rightDia, int i) {
        if(i==n) {
            ans.add(answer(n, board));
            return;
        }

        for(int j=0; j<n; j++) {
            if(col[j] || leftDia[i+j] || rightDia[n+(j-i)]) {
                continue;
            }

            col[j]=true;
            leftDia[i+j]=true;
            rightDia[n+(j-i)]=true;
            board[i]=j;

            helper(board, ans, n, col, leftDia, rightDia, i+1);

            col[j]=false;
            leftDia[i+j]=false;
            rightDia[n+(j-i)]=false;
        }
    }

    private List<String> answer(int n, int[] board) {
        List<String> ans = new ArrayList<>();
        
        for(int i=0; i<n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[board[i]] = 'Q';
            ans.add(new String(row));
        }
        return ans;
    }

}