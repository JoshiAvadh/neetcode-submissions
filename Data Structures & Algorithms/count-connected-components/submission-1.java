class Solution {

    public void dfs(int src, boolean[] vis, List<List<Integer>> adj) {
        vis[src] = true;

        for(int v : adj.get(src)) {
            if(!vis[v]) {
                dfs(v, vis, adj);
            }
        }

    }
    public int countComponents(int n, int[][] edges) {
        boolean[] vis = new boolean[n];
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] e : edges) {
            int u = e[0];
            int v = e[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int components = 0;

        for(int i = 0; i < n; i++) {
            if(!vis[i]) {
                dfs(i, vis, adj);
                components++;
            }
        }
        return components;
    }
}
