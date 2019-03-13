public class BST {
    public Node root;

    public BST() {
        root = null;
    }

    public void addNode(String word) {
        Node newNode = new Node(word);
        if(root == null) 
            root = newNode;
        else {
            Node current = root;
            Node parent;

            while(true) {
                parent = current;
                if(word.compareTo(current.word) < 0) {
                    //System.out.println(word + " is less than " + current.word);
                    current = current.left;
                    if(current == null){
                        parent.left = newNode;
                        return;
                    }
                }
                else if(word.compareTo(current.word) > 0) {
                    //System.out.println(word + " is greater than " + current.word);
                    current = current.right;
                    if(current == null){
                        parent.right = newNode;
                        return;
                    }
                }
                else {
                    //System.out.println(word + " is equal to " + current.word);
                    current.counter += 1;
                    return;
                }
            }
        }
    }

    public void inOrderTraverse(Node node) {
        if(node != null) {
            inOrderTraverse(node.left);
            System.out.println(node.toString());
            inOrderTraverse(node.right);
        }
    }

    public void preOrderTraverse(Node node) {
        if(node != null) {
            System.out.println(node.toString());
            preOrderTraverse(node.left);
            preOrderTraverse(node.right);
        }
    }

    public void postOrderTraverse(Node node) {
        if(node != null) {
            postOrderTraverse(node.left);
            postOrderTraverse(node.right);
            System.out.println(node.toString());
        }
    }

}