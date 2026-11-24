class Solution {
    class DSU{
        int parent[];
        int rank[];
        public DSU(int n) {
            parent = new int[n];
            rank = new int[n];

            for(int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }
        public int find(int x) {
            if(parent[x] == x) return x;
            return parent[x] = find(parent[x]);
        }
        public boolean union(int u, int v) {
            int pu = find(u);
            int pv = find(v);

            if(pu == pv) return false;

            if(rank[pu] == rank[pv]) {
                parent[pv] = pu;
                rank[pu]++;
            } else if(rank[pu] > rank[pv]) {
                parent[pv] = pu;
            } else {
                parent[pu] = pv;
            }
            return true;
        }
        
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length + 1;

        DSU dsu = new DSU(n);

        for(int[] edge : edges) {
            if(!(dsu.union(edge[0], edge[1]))){
                return new int[] {edge[0], edge[1]};
            }
        }
        return new int[] {-1, -1};
    }
}
