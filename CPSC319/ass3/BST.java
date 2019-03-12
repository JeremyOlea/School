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

}