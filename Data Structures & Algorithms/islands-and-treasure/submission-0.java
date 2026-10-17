class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 0) {
                    q.add(new int[] {i,j});
                }
            }
        }
        if(q.size() == 0) return;

        int[][] dir = {{-1, 0}, {0, -1}, {1,0}, {0,1}};

        while(!q.isEmpty()) {
            int[] pos = q.remove();
            int row = pos[0];
            int col = pos[1];

            for(int[] d : dir) {
                int r = row + d[0];
                int c = col + d[1];

                if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length  || grid[r][c] != Integer.MAX_VALUE) {
                    continue;
                }
                q.add(new int[] {r, c});
                grid[r][c] = grid[row][col] + 1;
            }
        }
    }
}
