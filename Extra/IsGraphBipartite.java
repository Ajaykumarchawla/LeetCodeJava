package Extra;

import java.util.LinkedList;
import java.util.Queue;
// 785. Is Graph Bipartite?
// Solved
// Medium
// Topics
// Companies
// There is an undirected graph with n nodes, where each node is numbered between 0 and n - 1. You are given a 2D array graph, where graph[u] is an array of nodes that node u is adjacent to. More formally, for each v in graph[u], there is an undirected edge between node u and node v. The graph has the following properties:

// There are no self-edges (graph[u] does not contain u).
// There are no parallel edges (graph[u] does not contain duplicate values).
// If v is in graph[u], then u is in graph[v] (the graph is undirected).
// The graph may not be connected, meaning there may be two nodes u and v such that there is no path between them.
// A graph is bipartite if the nodes can be partitioned into two independent sets A and B such that every edge in the graph connects a node in set A and a node in set B.

// Return true if and only if it is bipartite.

// Example 1:

// Input: graph = [[1,2,3],[0,2],[0,1,3],[0,2]]
// Output: false
// Explanation: There is no way to partition the nodes into two independent sets such that every edge connects a node in one and a node in the other.
// Example 2:

// Input: graph = [[1,3],[0,2],[1,3],[0,2]]
// Output: true
// Explanation: We can partition the nodes into two sets: {0, 2} and {1, 3}.

// Constraints:

// graph.length == n
// 1 <= n <= 100
// 0 <= graph[u].length < n
// 0 <= graph[u][i] <= n - 1
// graph[u] does not contain u.
// All the values of graph[u] are unique.
// If graph[u] contains v, then graph[v] contains u.
public class IsGraphBipartite {
    public boolean isBipartite(int[][] graph) {
        boolean[] visited = new boolean[graph.length];
        int[] modes = new int[graph.length];
        Queue<Integer> queue = new LinkedList<>();

        int mode = 0;
        modes[0] = mode + 1;
        for (int n = 0; n < graph.length; n++) {
            if (!visited[n])
                queue.add(n);

            while (!queue.isEmpty()) {
                int i = queue.remove();
                if (visited[i] == true)
                    continue;
                mode = (modes[i]) % 2 + 1;

                for (int j = 0; j < graph[i].length; j++) {
                    int k = graph[i][j];

                    if (modes[k] == 0) {
                        modes[k] = mode;
                    } else if (modes[k] != mode) {
                        return false;
                    }
                    if (visited[k] == true) {
                        continue;
                    }
                    queue.add(k);

                }
                visited[i] = true;

            }
        }

        return true;
    }
}
// test cases

// [[1],[0]]
// [[1,2,3],[0,2],[0,1,3],[0,2]]
// [[1,3],[0,2],[1,3],[0,2]]
// [[4],[],[4],[4],[0,2,3]]
// [[],[2,4,6],[1,4,8,9],[7,8],[1,2,8,9],[6,9],[1,5,7,8,9],[3,6,9],[2,3,4,6,9],[2,4,5,6,7,8]]
// [[3,4,6],[3,6],[3,6],[0,1,2,5],[0,7,8],[3],[0,1,2,7],[4,6],[4],[]]
// [[1,2,3],[0,3,4],[0,3],[0,1,2],[1]]
// [[1,2,3,4],[0,2,3],[0,1,3,4],[0,1,2,4],[0,2,3]]