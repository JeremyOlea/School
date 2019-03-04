#ifndef list_h
#define list_h

struct ListItem {
    int year;
    double flow;
};

struct Node {
    ListItem item;
    Node *next;
};

class FlowList {
public:
    FlowList();
    void add(int year, double flow);
    void insert(const ListItem& itemA);
    void print() const;
    Node* get_headM() const;
    void remove(int year);
 private:
        Node *headM;
};

#endif