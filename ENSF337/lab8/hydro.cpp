#include <iostream>
#include <fstream>
using namespace std;
#define FILENAME "flow.txt"
#include "list.h"
#include "hydro.h"
#include <stdlib.h>


int main(void) 
{
    FlowList x;
    int numRecords;
    displayHeader();
    numRecords = readData(x);
    int quit = 0;

    while(1)
    {
        switch(menu())
        {
            case 1:
                display(x, numRecords);
                pressEnter();
                break;
            case 2:
                addData(x, numRecords);
                pressEnter();
                break;
            case 3:
                saveData(x);
                pressEnter();
                break;
            case 4:
                removeData(x);
                pressEnter();
                break;
            case 5:
                cout << "\nProgram terminated!\n\n";
                quit = 1;
                break;
            default:
                cout << "\nNot a valid input.\n";
        }
    if(quit == 1) break;
    }
}

void displayHeader()
{
    cout << "\nProgram: Flow Studies, Fall 2017";
    cout << "\nVersion: 1.0";
    cout << "\nLab Section: B01";
    cout << "\nProduced by: Michael Jeremy Olea";
    pressEnter();
}

void pressEnter()
{
    cout << "\n<<<Press Enter to Continue>>>\n";
    while(1)
    {
        if(cin.get() == '\n')
            return;
    }
}

int menu()
{
    cout << "\nPlease select on the following operations\n";
    cout << "\t1. Display flow list, average and median\n";
    cout << "\t2. Add data.\n";
    cout << "\t3. Save data into the file\n";
    cout << "\t4. Remove data\n";
    cout << "\t5. Quit\n";
    cout << "Enter your choice (1, 2, 3, 4, or 5)\n";
    int selected;
    cin >> selected;
    return selected;
}

int readData(FlowList &list)
{
    int y;
    double f;
    int length = 0;
    ifstream input;
    input.open(FILENAME);
    if(input.fail())
    {
        cout << "\nError: cannot open file 'flow.txt'\n";
        exit(1);
    }
    while(!input.eof())
    {
        input >> y >> f;
        length++;
        ListItem *data = new ListItem {y,f};
        list.insert(*data);
    }
    return length;
}

void display(FlowList &list, int size)
{
    list.print();
    cout << "\n\n";
    cout << "the average is " << average(list, size) << " in billions of cubic meters\n";
    cout << "the median is " << median(list, size) << " in billions of cubic meters";
}

double average(FlowList &list, int size)
{
    Node* select = list.get_headM();
    double sum = 0;
    while(select)
    {
        sum += select->item.flow;
        select = select->next;
    }
    
    return (sum/size);
}

double median(FlowList &list, int size)
{
    Node* med = list.get_headM();
    for(int i = 0; i < (size-1)/2; i++)
    {
        med = med->next;
    }
    return med->item.flow;
}

void addData(FlowList &list, int &numRecords)
{
    Node *check = list.get_headM();
    ListItem *new_item = new ListItem;
    cout << "\nInput a year and a flow\n";
    cin >> new_item->year >> new_item->flow;
    if(cin.fail())
    {
        cout << "\nInvalid input\n";
        return;
    }
    while(check)
    {
        if(check->item.year == new_item->year)
        {
            cout << "\nError: Duplicate year\n";
            return;
        }
        check = check->next;
    }
    numRecords++;
    list.insert(*new_item);
    cout << "\nData successfully added\n";
}

void saveData(FlowList &list)
{
    ofstream output;
    output.open(FILENAME);
    if(output.fail())
    {
        cout << "\nError: cannot open file 'flow_Output.txt'\n" << endl;
        exit(1);
    }
    Node *select = list.get_headM();
    while(select)
    {
        output << select->item.year << "\t" << select->item.flow;
        output << "\n";
        select = select->next;
    }
    output.close();
    cout << "\nFile successfully saved\n";
}

void removeData(FlowList &list)
{
    Node *check = list.get_headM();
    int removeYear;
    cout << "\nEnter year you want to remove\n";
    cin >> removeYear;
    if(cin.fail())
    {
        cout << "Invalid input";
        return;
    }
    while(check)
    {
        if(check->item.year == removeYear)
        {
            list.remove(removeYear);
            cout << "Year successfully removed";
            return;
        }
        check = check->next;
    }
    cout << "\nYear does not exist\n";
}