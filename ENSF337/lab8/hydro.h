#ifndef hydro_h
#define hydro_h

void displayHeader();

int readData(FlowList &list);

int menu();

void display(FlowList &list, int size);

void addData(FlowList &list, int &numRecords);

void removeData(FlowList &list);

double average(FlowList &list, int size);

double median(FlowList &list, int size);

void saveData(FlowList &list);

void pressEnter();

#endif