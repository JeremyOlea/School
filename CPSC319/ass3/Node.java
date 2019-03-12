public class Node {
    public String word;
    public int counter;
    public Node left;
    public Node right;
    
    public Node(String word) {
        this.word = word;
        counter = 1;
    }

    public void toStrin() {
        System.out.println(word);
    }
}