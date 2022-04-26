import java.util.*;

public class CloneGraph {
    public static void main(String[] args) {

    }

    public GraphNode cloneGraph(GraphNode node) {
        GraphNode dummy = new GraphNode();
        cloneGraph(node,dummy);
        return dummy.neighbors.get(0);
    }

    public void cloneGraph(GraphNode node, GraphNode dummy) {
        Map<GraphNode, GraphNode> createdNodes = new HashMap<>();
        Queue<GraphNode> pendingNodeQueue = new LinkedList<>();
        GraphNode clonedSource = new GraphNode(node.val);
        dummy.neighbors.add(clonedSource);
        createdNodes.put(node, clonedSource);
        pendingNodeQueue.add(node);
        while (pendingNodeQueue.size() > 0) {
            GraphNode polled = pendingNodeQueue.poll();
            GraphNode clonedNode = createdNodes.get(polled);
            for (GraphNode neighbours : polled.neighbors) {
                //check if this node is already created
                if (createdNodes.get(neighbours) == null) {
                    GraphNode temp = new GraphNode(neighbours.val);
                    createdNodes.put(neighbours, temp);
                    pendingNodeQueue.add(neighbours);
                }
                clonedNode.neighbors.add(createdNodes.get(neighbours));
            }

        }
    }

}
