import java.util.*;

public class BST {
    public Node root;

    private static class Node {
        public String word;
        public int counter;
        public Node left;
        public Node right;
        
        public Node(String word) {
            this.word = word;
            counter = 1;
        }
    }

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
                    current = current.left;
                    if(current == null){
                        parent.left = newNode;
                        return;
                    }
                }
                else if(word.compareTo(current.word) > 0) {
                    current = current.right;
                    if(current == null){
                        parent.right = newNode;
                        return;
                    }
                }
                else { //if equal
                    current.counter += 1;
                    return;
                }
            }
        }
    }

    public void inOrderTraverse(Node node) {
        if(node != null) {
            inOrderTraverse(node.left);
            System.out.printf(node.word + " ");
            inOrderTraverse(node.right);
        }
    }

    public void preOrderTraverse(Node node) {
        if(node != null) {
            System.out.printf(node.word + " ");
            preOrderTraverse(node.left);
            preOrderTraverse(node.right);
        }
    }

    public void postOrderTraverse(Node node) {
        if(node != null) {
            postOrderTraverse(node.left);
            postOrderTraverse(node.right);
            System.out.printf(node.word + " ");
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

    public void printFrequent(Node current) {
        ArrayList<Node> list = findFreq(current);
        for(int i = 0; i < list.size(); i++) {
            //ArrayList printed backwards to match the order it was printed in the d2l document
            System.out.println(list.get(list.size() - 1 - i).word + " = " + list.get(list.size() - 1 - i).counter + " times");
        }    
    }

    public ArrayList<Node> findFreq(Node current) {
        ArrayList<Node> word = new ArrayList<Node>();
        word.add(current);
        if(current.right != null)  {
            ArrayList<Node> r = new ArrayList<Node>();
            r.addAll(findFreq(current.right)); //will hold current most frequent word(s)
            //if a word is more frequent, it will replace whole arraylist
            if(word.get(0).counter < r.get(0).counter) {
                word.clear();
                word.addAll(r);
            } //if word is same frequency, add it on to the arraylist
            else if(word.get(0).counter == r.get(0).counter) {
                word.addAll(r);
            }
        }
        
        //same thing but check left side
        if(current.left != null) {
            ArrayList<Node> l = new ArrayList<Node>();
            l.addAll(findFreq(current.left));
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

    public boolean searchWord(String word, Node current) {
        boolean isFound = false;
        if(current.word.equals(word.toLowerCase())) {
            System.out.println("Word found! It has " + current.counter + " occurrences");
            return true;
        }
        if(current.left != null) {
            isFound = searchWord(word, current.left);
        }
        if(current.right != null && isFound == false) {
            isFound = searchWord(word, current.right);
        }
        return isFound;
    }

}