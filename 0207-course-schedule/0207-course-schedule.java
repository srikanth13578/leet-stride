import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
      
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        
        int[] indegree = new int[numCourses];
        
        for (int[] pair : prerequisites) {
            int course = pair[0];
            int pre = pair[1];
            adj.get(pre).add(course); 
            indegree[course]++;       
        }
        
     
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        
        
        int coursesTaken = 0;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            coursesTaken++;
            
       
            for (int nextCourse : adj.get(current)) {
                indegree[nextCourse]--;
                
                
                if (indegree[nextCourse] == 0) {
                    queue.add(nextCourse);
                }
            }
        }
        
      
        return coursesTaken == numCourses;
    }
}