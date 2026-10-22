class Solution {
    public int[][] dir = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        boolean[][] pac = new boolean[heights.length][heights[0].length];
        boolean[][] alt = new boolean[heights.length][heights[0].length];

        Queue<int[]> pacQ = new LinkedList<>();
        Queue<int[]> altQ = new LinkedList<>();

        for(int c = 0; c < heights[0].length; c++) {
            pacQ.add(new int[] {0,c});
            altQ.add(new int[]{heights.length - 1, c});
        }

        for(int r = 0; r < heights.length; r++) {
            pacQ.add(new int[] {r, 0});
            altQ.add(new int[] {r, heights[0].length - 1});
        }

        bfs(pacQ, pac, heights);
        bfs(altQ, alt, heights);

        List<List<Integer>> res = new ArrayList<>();

        for(int r = 0; r < heights.length; r++) {
            for(int c = 0; c < heights[0].length; c++) {
                if(pac[r][c] && alt[r][c]) {
                    res.add(Arrays.asList(r,c));
                }
            }
        }
        return res;
    }

    public void bfs(Queue<int[]> q, boolean[][] ocean, int[][] heights) {
        while(!q.isEmpty()) {
            int[] pos = q.remove();
            int row = pos[0];
            int col = pos[1];
            ocean[row][col] = true;
            for(int[] d : dir) {
                int r = row + d[0];
                int c = col + d[1];

                if(r >= 0 && r < heights.length && c >= 0 && c < heights[0].length && !ocean[r][c] && heights[r][c] >= heights[row][col]) {
                    q.add(new int[] {r, c});
                } 
            }
        }
    }
}