import java.util.*;

class Graph {
    private Map<Integer, List<Integer>> adjList; 

    // Constructor
    public Graph() {
        adjList = new HashMap<>();
    }

    public void addEdge(int source, int destination) {
        adjList.putIfAbsent(source, new ArrayList<>());
        adjList.putIfAbsent(destination, new ArrayList<>());
        adjList.get(source).add(destination);
        adjList.get(destination).add(source); 
    }

    public void bfs(int startNode) {
        Set<Integer> visited = new HashSet<>(); 
        Queue<Integer> queue = new LinkedList<>(); 

        queue.add(startNode);
        visited.add(startNode);

        System.out.print("BFS: ");

        while (!queue.isEmpty()) {
            int currentNode = queue.poll(); 
            System.out.print(currentNode + " ");

            for (int neighbor : adjList.getOrDefault(currentNode, new ArrayList<>())) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                }
            }
        }
        System.out.println();
    }

    public void dfs(int startNode) {
        Set<Integer> visited = new HashSet<>();
        System.out.print("DFS: ");
        dfsHelper(startNode, visited); 
        System.out.println();
    }

    private void dfsHelper(int node, Set<Integer> visited) {
        visited.add(node); 
        System.out.print(node + " "); 

        for (int neighbor : adjList.getOrDefault(node, new ArrayList<>())) {
            if (!visited.contains(neighbor)) {
                dfsHelper(neighbor, visited); 
            }
        }
    }
}