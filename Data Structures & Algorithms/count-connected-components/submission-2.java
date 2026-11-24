class Solution {

    public class DSU{

        int parent[];
        int[] rank;

        public DSU(int n) {
            parent = new int[n];
            rank = new int[n];

            for(int i = 0; i < n; i++){
                parent[i] = i;
                rank[i] = 0;
            }
        }
        public int find(int x) {
        if(parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }
    public boolean union(int u, int v) {
        int pU = find(u);
        int pV = find(v);

        if(pU == pV) return false;

        if(rank[pU] == rank[pV]) {
            parent[pV] = pU; 
            rank[pU]++;
        } else if(rank[pU] > rank[pV]) {
            parent[pV] = pU;
        } else{
            parent[pU] = pV;
        }

        return true;
    }
    }
    
    public int countComponents(int n, int[][] edges) {
        
        DSU dsu = new DSU(n);
        int res = n;

        for(int[] edge : edges) {
            if(dsu.union(edge[0], edge[1])) res--;
        }
        return res;
    }
}
