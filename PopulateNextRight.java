import javax.swing.plaf.synth.SynthEditorPaneUI;

public class PopulateNextRight {
    public static void main(String[] args) {
        Node first = new Node(1);
        first.left = new Node(2);
        first.right= new Node(3);
        first.left.left= new Node(4);
        first.left.right= new Node(5);
        first.right.left= new Node(6);
        first.right.right= new Node(7);
        System.out.println(new PopulateNextRight().connect(first));
    }
    public Node connect(Node root) {
        connect(root, null);
        return root;
    }

    public void connect(Node node, Node next) {
        if (node == null)
            return;
        node.next = next;
        connect(node.left, node.right);
        if (next != null)
            next = next.left;
        connect(node.right, next);

    }
}
