import java.util.*;

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
            System.out.print(node.toString());
            System.out.printf(" ");
            inOrderTraverse(node.right);
        }
    }

    public void preOrderTraverse(Node node) {
        if(node != null) {
            System.out.print(node.toString());
            System.out.printf(" ");
            preOrderTraverse(node.left);
            preOrderTraverse(node.right);
        }
    }

    public void postOrderTraverse(Node node) {
        if(node != null) {
            postOrderTraverse(node.left);
            postOrderTraverse(node.right);
            System.out.print(node.toString());
            System.out.printf(" ");
        }
    }

    public int findTotals(Node current) {
        int count = 1;
        if(current.left != null) {
            count += findTotals(current.left);
        }
        if(current.right != null) {
            count += findTotals(current.right);
        }
        return count;
    }

    public int findUnique(Node current) {
        int count = 0;
        if(current.left != null) {
            count += findUnique(current.left);
        }
        if(current.right != null) {
            count += findUnique(current.right);
        }
        if(current.counter == 1) {
            count++;
            return count;
        }
        else return count;
    }

    public int findHeight(Node current) {
        if(current == null){
            return 0;
        }
        else {
            int depthLeft = findHeight(current.left);
            int depthRight = findHeight(current.right);

            if(depthLeft > depthRight)
                return (depthLeft+1);
            else
                return (depthRight+1);
        }
    }

    public ArrayList<Node> mostFrequent(Node current) {
        ArrayList<Node> word = new ArrayList<Node>();
        word.add(current);
        if(current.right != null)  {
            ArrayList<Node> r = new ArrayList<Node>();
            r.addAll(mostFrequent(current.right));
            if(word.get(0).counter < r.get(0).counter) {
                word.clear();
                word.addAll(r);
            }
            else if(word.get(0).counter == r.get(0).counter) {
                word.addAll(r);
            }
        }

        if(current.left != null) {
            ArrayList<Node> l = new ArrayList<Node>();
            l.addAll(mostFrequent(current.left));
            if(word.get(0).counter < l.get(0).counter) {
                word.clear();
                word.addAll(l);
            }
            else if(word.get(0).counter == l.get(0).counter) {
                word.addAll(l);
            }
        }

        return word;
    }

    public Node searchWord(String word, Node current) {
        Node searchedWord = null;
        if(current.word.equals(word.toLowerCase())) {
            searchedWord = current;
        }
        if(current.left != null) {
            searchedWord = searchWord(word, current.left);
        }
        if(current.right != null && searchedWord == null) {
            searchedWord = searchWord(word, current.right);
        }
        return searchedWord;
    }

}