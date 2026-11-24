class Solution {
    public boolean dfs(int src, int parent, boolean[] visited, List<List<Integer>> adj) {
        visited[src] = true;

        for (int v : adj.get(src)) {
            if (!visited[v]) {
                if (dfs(v, src, visited, adj))
                    return true;
            } else if (v != parent) {
                return true;
            }
        }
        return false;
    }

    public boolean validTree(int n, int[][] edges) {

        boolean[] visited = new boolean[n];
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int components = 0;
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                if(dfs(i, -1, visited, adj)) return false;
                components++;
            }
        }
        return components > 1 ? false : true;
    }
}
