class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 0) {
                    q.add(new int[] {i, j});
                }
            }
        }
        if(q.size() == 0) return;
        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while(!q.isEmpty()) {
            int length = q.size();

            for(int i = 0; i < length; i++) {
                int[] pos = q.remove();
                int row = pos[0];
                int col = pos[1];

                for(int[] d : dir) {
                    int r = row + d[0];
                    int c = col + d[1];

                    if(r < grid.length && r >= 0 && c < grid[0].length && c >= 0 && grid[r][c] == Integer.MAX_VALUE) {
                        grid[r][c] = grid[row][col] + 1;
                        q.add(new int[] {r,c});
                    }
                }
            }
        }
    } 
}