#include <iostream>
#include <fstream>
#include <stdlib.h>
using namespace std;
#include "list.h"
#include "hydro.h"

FlowList::FlowList(): headM(0)
{
}


void FlowList::insert(const ListItem& itemA)
{
    Node *new_node = new Node;
    new_node->item = itemA;
 
    if (headM == 0 || itemA.flow <= headM->item.flow) {
        new_node->next = headM;
        headM = new_node;

        // point one
    }
    else {
        Node *before = headM;      // will point to node in front of new node
        Node *after = headM->next; // will be 0 or point to node after new node
        while(after != 0 && itemA.flow > after->item.flow) {
            before = after;
            after = after->next;
        }
        new_node->next = after;
        before->next = new_node;
        // point two
    }
}

void FlowList::print() const
{
    cout << "Year \t Flow (in billions of cubic meters)\n";
    if (headM != 0) {
        cout << headM->item.year << " \t " << headM->item.flow;
        for (const Node *p = headM->next; p != 0; p = p->next)
            cout << "\n" << p->item.year << " \t " << p->item.flow;
    }
    else
    cout << "Linked-list is empty";
}

Node* FlowList::get_headM() const
{
    return headM;
}

void FlowList::remove(const int year)
{   
    if(headM == 0)
        return;
    if(headM->item.year == year)
    {
        Node *doomed = headM;
        headM = headM->next;
        delete doomed;
    }
    else {
        Node *before = headM;
        Node *maybe_doomed = headM->next;
        while(maybe_doomed != 0 && maybe_doomed->item.year != year) {
            before = maybe_doomed;
            maybe_doomed = maybe_doomed->next;
        }
        if(maybe_doomed->item.year == year)
        {
            before->next = maybe_doomed->next;
            delete maybe_doomed;
        }
        // point three
    }
    return;
}

//    while(check)
//     {
//         if(check->item.year == itemA.year) //checks if year already exists
//         return;

//         check = check->next;
//     }
    