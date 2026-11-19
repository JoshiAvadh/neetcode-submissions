class Solution {
    public boolean dfs(int src, boolean[] visited, boolean[] recPath, List<List<Integer>> adj) {

        visited[src] = true;
        recPath[src] = true;

        for(int v : adj.get(src)) {
            if(!visited[v]) {
                if(dfs(v, visited, recPath, adj))return true;
            } else if(recPath[v]) return true;
        }

        recPath[src] = false;
        return false;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] pre : prerequisites) {
            int u = pre[1];
            int v = pre[0];
            adj.get(u).add(v);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] recPath = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                if (dfs(i, visited, recPath, adj)) {
                    return false;
                }
            }
        }

        return true;
    }
}
