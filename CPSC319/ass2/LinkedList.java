class LinkedList {
    private Node headM;
    private int sizeM;

    private class Node {
        public String item;
        public Node next;

        Node(String item) {
            this.item = item;
            next = null;
        }
    }

    public LinkedList() {
        headM = null;
        sizeM = 0;
    }


    public void push_front(String newItem) {
        Node newNode = new Node(newItem);
        newNode.next = headM;
        headM = newNode;
        sizeM++;
    }

    public void push_back(String newItem) {
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

    public void set(int index, String newItem) {
        if(index < 0 || index >= sizeM) {
            System.out.printf("Illegal Access. Program Terminates...");
        }

        Node newNode = headM;
        for(int i = 0; i < index; i++) {
            newNode = newNode.next;
        }
        newNode.item = newItem;
    }

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

    public void insert(String newItem, int index) {
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

    public int getSize() {
        return sizeM;
    }

    public String get(int index) {
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

    public void clear() {
        headM = null;
        sizeM = 0;
    }

    public Node getHead() {
        return headM;
    }

}
