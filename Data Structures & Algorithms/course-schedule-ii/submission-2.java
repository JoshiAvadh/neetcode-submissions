class Solution {
    //public boolean isCycle(int src, boolean[] vis, boolean[] recPath, List<List<Integer>> adj) {
    //     vis[src] = true;
    //     recPath[src] = true;

    //     for (int v : adj.get(src)) {
    //         if (!vis[v]) {
    //             if (isCycle(v, vis, recPath, adj))
    //                 return true;
    //         } else if (recPath[v])
    //             return true;
    //     }

    //     recPath[src] = false;
    //     return false;
    //}

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] p : prerequisites) {
            int u = p[1];
            int v = p[0];

            adj.get(u).add(v);
        }
        // boolean[] vis = new boolean[numCourses];
        // boolean[] recPath = new boolean[numCourses];

        // for(int i = 0; i < numCourses; i++) {
        //     if(!vis[i]){ 
        //         if(isCycle(i, vis, recPath, adj)) return new int[0] ;
        //     }
        //}

        int[] ind = new int[numCourses];

        for(int i = 0; i < adj.size(); i++) {
            for(int v : adj.get(i)) {
                ind[v]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < ind.length; i++) {
            if(ind[i] == 0) {
                q.add(i);
            }
        }

        while(!q.isEmpty()) {

            int src = q.remove();
            ans.add(src);

            for(int v : adj.get(src)) {
                ind[v]--;
                if(ind[v] == 0) q.add(v);
            }
        }
        if(ans.size() < numCourses) return new int[0];
        int[] ansArr = new int[numCourses];

        for(int i = 0; i < ans.size(); i++) {
            ansArr[i] = ans.get(i);
        }

        return ansArr;

    }
}
