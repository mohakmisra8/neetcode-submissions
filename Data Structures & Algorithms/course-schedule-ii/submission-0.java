class Solution {
    // each course as a node, each pre-requisite as a directed edge
    // use dfs
    // detect cycles and add a course to the result after all its pre-requisites are processed
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<numCourses;i++) {
            graph.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];
        for(int[] p:prerequisites) {
            graph.get(p[1]).add(p[0]);
            indegree[p[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i<numCourses; i++) {
            if(indegree[i] == 0) {
                q.offer(i);
            }
        }

        int index = 0;
        int processed = 0;
        int[] order = new int[numCourses];
        while(!q.isEmpty()) {
            int node = q.poll();
            order[index++]= node; // record order
            for(int next: graph.get(node)) {
                indegree[next]--; // pre-requisite satisifed
                if(indegree[next] == 0) {
                    q.offer(next);
                }
            }
        }

        return index == numCourses ? order:new int[0];
    }
}
