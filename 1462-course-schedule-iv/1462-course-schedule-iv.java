class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        // Step 1: Initialize a 2D boolean reachability matrix
        // isPre[i][j] will be true if course i is a prerequisite of course j
        boolean[][] isPre = new boolean[numCourses][numCourses];
        
        // Step 2: Set direct prerequisites from the input
        for (int[] edge : prerequisites) {
            int pre = edge[0];
            int course = edge[1];
            isPre[pre][course] = true;
        }
        
        // Step 3: Floyd-Warshall Algorithm to find transitive reachability
        // k is the intermediate course
        for (int k = 0; k < numCourses; k++) {
            for (int i = 0; i < numCourses; i++) {
                for (int j = 0; j < numCourses; j++) {
                    // If i is a pre of k, AND k is a pre of j, then i is a pre of j
                    if (isPre[i][k] && isPre[k][j]) {
                        isPre[i][j] = true;
                    }
                }
            }
        }
        
        // Step 4: Answer each query in O(1) time
        List<Boolean> result = new ArrayList<>();
        for (int[] query : queries) {
            int u = query[0];
            int v = query[1];
            result.add(isPre[u][v]);
        }
        
        return result;
    }
}