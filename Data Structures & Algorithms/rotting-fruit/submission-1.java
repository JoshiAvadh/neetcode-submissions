class Solution {
    public int orangesRotting(int[][] grid) {
        int fresh = 0;
        int time = 0;
        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) fresh++;
                if(grid[i][j] == 2){
                    q.add(new int[] {i,j});
                }
            }
        }

        int[][] directions = {{0,1}, {0,-1}, {1,0}, {-1, 0}};

        while(fresh > 0 && !q.isEmpty()) {
            int length = q.size();

            for(int i = 0; i < length; i++) {
                int[] pos = q.remove();
                int row = pos[0];
                int col = pos[1];

                for(int[] d : directions) {
                    int r = row + d[0];
                    int c = col + d[1];

                    if(r >= 0 && r < grid.length && c >=0 && c < grid[0].length && grid[r][c] == 1) {
                        grid[r][c] = 2;
                        q.add(new int[] {r,c});
                        fresh--;
                    }
                }
            }
            time++;
        }
        return fresh == 0 ? time : -1;
    }
}
