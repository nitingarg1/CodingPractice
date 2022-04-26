import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRight {
    public static void main(String[] args) {
        Node n = new Node(1);
        n.left=new Node(2);
        n.left.left=new Node(4);
        n.left.right=new Node(5);
        n.right=new Node(3);
        n.right.right=new Node(7);
        new PopulatingNextRight().connect(n);
    }
    public Node connect(Node root) {
        if(root==null)
            return root;
        Queue<Node> nodeQueue= new LinkedList<>();
        nodeQueue.add(root);
        while(nodeQueue.size()>0){
            nodeQueue=connect(nodeQueue);
        }
        return root;
    }

    public Queue<Node> connect(Queue<Node> nodeQueue) {
        Queue<Node> newNodeQueue= new LinkedList<>();
        Node pre = null;
        while(nodeQueue.size()>0){
            Node temp = nodeQueue.poll();
            temp.next=pre;
            pre=temp;
            if(temp.right!=null)
                newNodeQueue.add(temp.right);
            if(temp.left!=null)
                newNodeQueue.add(temp.left);
        }
        return newNodeQueue;
    }
}
