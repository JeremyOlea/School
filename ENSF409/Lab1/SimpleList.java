/**
* Implementation of a basic LinkedList
* @author Michael Jeremy Olea
* @version 1.0
* @since January 24, 2019
*/

class SimpleList {
    /**
    * Points to start of LinkedList
     */
    private Node headM;
    /**
    * Contains the size of the LinkedList
     */
    private int sizeM;
    /**
    * A single item in the LinkedList that holds an integer and points to he next item in the LinkedList
    * @author Michael Jeremy Olea
    * @version 1.0
    * @since January 24, 2019
     */
    private class Node {
        /**
        * The value that the Node holds
         */
        public int item;
        /**
        * Object reference to the next Node in the LinkedList
         */
        public Node next;

        /**
        * Default Constructor for Node
         */
        Node() {
            item = 0;
            next = null;
        }

        /**
        * Constructor that initializes the item of the Node
        * @param item that initializes the objects value
         */
        Node(int item) {
            this.item = item;
            next = null;
        }
    }

    /**
    * Default Constructor for the LinkedList
     */
    SimpleList() {
        headM = null;
        sizeM = 0;
    }

    /**
    * Places a new node at the beginning of the list
    * @param newItem will be placed in the item of class Node
     */
    public void push_front(int newItem) {
        Node newNode = new Node(newItem);
        newNode.next = headM;
        headM = newNode;
        sizeM++;
    }

    /**
    * Places a new node at the end of the list
    * @param newItem will be placed in the item of class Node
     */
    public void push_back(int newItem) {
        Node newNode = new Node(newItem);
        if(headM == null) {
            newNode.next = headM;
            headM = newNode;
        }
        else {
            Node position = headM;
            while(position.next != null) {
                position = position.next;
            }
            position.next = newNode;
            newNode.next = null;
        }
        sizeM++;
    }

    /**
    * Replaces Node at a given index with a new Node of a given item
    * @param index will provide the index of the Node that will be replaced
    * @param newItem will be placed in the new Node
     */
    public void set(int index, int newItem) {
        if(index < 0 || index >= sizeM) {
            System.out.printf("Illegal Access. Program Terminates...");
        }

        Node newNode = headM;
        for(int i = 0; i < index; i++) {
            newNode = newNode.next;
        }
        newNode.item = newItem;
    }

    /**
    * Removes the Node at a given index
    * @param index provides the index of the Node that will be removed
     */
    public void remove(int index) {
        if(headM == null || index < 0 || index >= sizeM) {
            return;
        }
        if(index == 0) {
            headM = headM.next;
            sizeM--;
        }
        else {
            Node newNode = headM;
            for(int i = 0; i < index - 1; i++) {
                newNode = newNode.next;
            }
            newNode.next = newNode.next.next;
            sizeM--;
        }
    }

    /**
    * Places a new Node with a given item at the position given
    * @param newItem is the value that will be placed in the item of the new Node
    * @param index is the index where the new Node will be placed
     */
    public void insert(int newItem, int index) {
        if(index < 0 || index > sizeM) {
            return;
        }
        else if(index == 0) {
            push_front(newItem);
        }
        else if(index == sizeM) {
            push_back(newItem);
        }
        else{
            Node position = headM.next;
            Node previous = headM;
            for(int i = 0; i < index-1; i++) {
                position = position.next;
                previous = previous.next;
            }
            Node newNode = new Node(newItem);
            newNode.next = position;
            previous.next = newNode;
            sizeM++;
        }
    }

    /**
    * Gets the size of the LinkedList
    * @return Integer that represents the size of the LinkedList
     */
    public int getSize() {
        return sizeM;
    }

    /**
    * Gets the value of the item in the Node at a given index
    * @param index that represents the index of the Node that will be read
    * @return Integer of the value of the item of the Node at index index
     */
    public int get(int index) {
        if(index < 0 || index >= sizeM) {
            System.out.printf("Invalid print index");
            System.exit(1);
        }
        Node position = headM;
        for(int i = 0; i < index; i++) {
            position = position.next;
        }
        return position.item;
    }

    /**
    * Removes all Nodes in the LinkedList
     */
    public void clear() {
        headM = null;
        sizeM = 0;
    }


    /**
    * Tests to show that the class is working properly
    * @param args that holds the command line arguments
     */
    public static void main(String[] args) {
        SimpleList list = new SimpleList();

        System.out.printf("\nList just after creation - is empty.");
        
        list.push_front(50);
        System.out.printf("\nAfter calling push_front. list must have 50\n");
        print(list);

        list.push_back(440);

        list.set(0,770);
        System.out.printf("\nAfter calling push_back and set function list must have: 770  440\n");
        print(list);

        list.push_back(330);
        list.push_back(220);
        list.push_back(110);

        System.out.printf("\nAfter three more calls, list must be 770, 440, 330, 220, 110\n");
        print(list);

        list.remove(0);
        list.remove(2);
        System.out.printf("\nAfter removing two nodes. list must have: 440 330 110\n");
        print(list);

        list.insert(40, 3);
        list.insert(20, -1);
        list.insert(30, 30000);
        list.insert(10, 0);
        list.insert(33, 2);

        System.out.printf("\nTwo  more nodes inserted, must have: 10, 440, 33, 330, 110, 40\n");
        print(list);

        list.remove(0);
        list.remove(1);
        list.remove(2);
        list.remove(3);
        list.remove(4);
        list.remove(5);
        System.out.printf("\nAfter 6 removes, list must have: 440, 330, 40: \n");
        print(list);

        list.clear();
        System.out.printf("\nAfter call to clear, list must be empty:\n");
        print(list);

        list.push_back(331);
        list.push_back(221);
        list.push_back(111);

        System.out.printf("\nAfter three calls, list must have: 331, 221, 111\n");
        print(list);
    }

    /**
    * Prints all the values of a given LinkedList on the command line
    * @param list that will be printed out
     */
    public static void print(SimpleList list) {
        for(int i = 0; i < list.getSize(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }
}
