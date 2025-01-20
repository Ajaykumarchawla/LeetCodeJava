package Extra;

import java.util.ArrayList;
import java.util.List;
// 133. Clone Graph
// Solved
// Medium
// Topics
// Companies
// Given a reference of a node in a connected undirected graph.

// Return a deep copy (clone) of the graph.

// Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.

// class Node {
//     public int val;
//     public List<Node> neighbors;
// }

// Test case format:

// For simplicity, each node's value is the same as the node's index (1-indexed). For example, the first node with val == 1, the second node with val == 2, and so on. The graph is represented in the test case using an adjacency list.

// An adjacency list is a collection of unordered lists used to represent a finite graph. Each list describes the set of neighbors of a node in the graph.

// The given node will always be the first node with val = 1. You must return the copy of the given node as a reference to the cloned graph.

// Example 1:

// Input: adjList = [[2,4],[1,3],[2,4],[1,3]]
// Output: [[2,4],[1,3],[2,4],[1,3]]
// Explanation: There are 4 nodes in the graph.
// 1st node (val = 1)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
// 2nd node (val = 2)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).
// 3rd node (val = 3)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
// 4th node (val = 4)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).
// Example 2:

// Input: adjList = [[]]
// Output: [[]]
// Explanation: Note that the input contains one empty list. The graph consists of only one node with val = 1 and it does not have any neighbors.
// Example 3:

// Input: adjList = []
// Output: []
// Explanation: This an empty graph, it does not have any nodes.

// Constraints:

// The number of nodes in the graph is in the range [0, 100].
// 1 <= Node.val <= 100
// Node.val is unique for each node.
// There are no repeated edges and no self-loops in the graph.
// The Graph is connected and all nodes can be visited starting from the given node.
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

public class CloneGraph {
    private Node cloneNodes(Node[] nodes, Node node) {
        if (nodes[node.val] != null) {
            // System.out.println("it has value");
            return nodes[node.val];
        } else {
            // System.out.println("it has no value");
            Node newNode = new Node(node.val);
            nodes[node.val] = newNode;

            newNode.neighbors = new ArrayList<>();
            for (Node temp : node.neighbors) {
                Node tempNode = cloneNodes(nodes, temp);
                newNode.neighbors.add(tempNode);
            }
            return nodes[node.val];
        }
    }

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Node[] nodes = new Node[101];
        return cloneNodes(nodes, node);
    }
}

// test cases
// [[2,4],[1,3],[2,4],[1,3]]
// [[2,4,3],[1,3],[1,2,4],[1,3]]
// [[]]
// []
// [[2],[1]]
// [[2,3,4,14,19,35,59],[1,7,11,47,61,66],[1,24,41,52,68,98],[1,5,6,8,37,80],[4,9],[4,20,42,69],[2,10,17],[4,13,26,54,65,71,82],[5,12,16,23,38],[7,57],[2],[9,15,18,84],[8,32],[1,48],[12,46,58,76,85],[9,90],[7,21,30,70],[12,22],[1,27,86],[6,75,91],[17,49,51,99],[18,25,34,63,88],[9,40],[3,45,50,62],[22,36,72],[8,31],[19,28,33,55],[27,29],[28,97],[17],[26],[13],[27,64,83],[22],[1,39,44],[25],[4,60],[9],[35],[23,43],[3],[6],[40],[35,89],[24],[15],[2],[14,94],[21],[24],[21,53],[3,56,77],[51,87],[8,67],[27],[52],[10],[15],[1],[37],[2],[24],[22,74,79],[33,73],[8,93],[2],[54],[3,78],[6,95],[17],[8,81],[25],[64],[63],[20],[15,92],[52],[68],[63],[4],[71],[8],[33],[12],[15],[19],[53],[22],[44],[16],[20],[76],[65],[48,100],[69,96],[95],[29],[3],[21],[94]]