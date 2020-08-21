// ectest.cpp
// CSCI 455 Spring 2020, Extra Credit assignment

// Note: this uses separate compilation.  You put your code in ecListFuncs.cpp
// Code in this file calls those funcs.
// You do not need to modify or submit this file.

// ectest.cpp
// a command-based program to manipulate lists.
// to run it use the command:   ectest
//


#include <vector>
#include <iostream>
#include <cctype>
#include <cassert>
#include <string>

// for istringstream
#include <sstream>

#include "ecListFuncs.h"

using namespace std;


int promptForInt (string prompt);
void doBuildList(ListType & theList);
void doHelp();
void add10(ListType list);
void doReverseCopy(ListType list);
void doSplitOnVal(ListType & list);
bool readAndDispatchCommand(ListType & theList);
void dosplice(ListType & theList);//14Fall//////////////////
bool allUnique (ListType list);
void compress (ListType & list);//16Spring//////////////////
bool isCircularList (ListType list);//16Fall//////////////////
void gut (ListType & list);//17Spring//////////////////
void removeEveryother (ListType & list);//17Fall//////////////////
void dupe (ListType & list);//17Fall//////////////////
void insertAt(ListType & list, int val, int loc);//19Spring//////////////////
void removetil7 (ListType &list);//19Fall//////////////////
void insert0Between(ListType & list);

//*************************************************************************


/* a little test program */

int main ()
{

   bool keepgoing = true;

   ListType theList = NULL;

   doHelp();

   do {

      keepgoing = readAndDispatchCommand(theList);

      cout << "The list: ";
      printList (theList);

   } while (keepgoing);

   return 0;
}


/*
 * reads a command and executes it.
 * The command execution updates and/or uses theList, thus it's passed
 * by reference here.
 * Returns false iff the command entered was q (quit)
 */
bool readAndDispatchCommand(ListType & theList) {

   char cmd;

   string lineStr;

   cout << "\nPlease enter a command [b, i, s, n, r, m, p, h, q]: ";
   cin >> cmd;
   getline(cin, lineStr);  // consume and ignore the rest of the line

   if (cmd == 'b') {
      doBuildList(theList);
   }
   else if (cmd == 'i') {
      int val = promptForInt ("Value to insert");
      insertFront (theList, val);
   }
   else if (cmd == 's') {
//      doSplitOnVal(theList);
       dosplice(theList);
       
   }
   else if (cmd == 'n') {
      cout << "The number of runs in the list is: " << numRuns(theList) << endl;
   }
   else if (cmd == 'm') {
      removeMiddle(theList);
   }
   else if (cmd == 'r') {
      doReverseCopy(theList);
   }
   else if (cmd == 'p') {
      cout << "Print list: " << endl;
      printList(theList); cout << endl;
   }
   else if (cmd == 'q') {
      return false;
   }
   else if (cmd=='u'){
       cout << allUnique(theList);
   }
   else if (cmd =='c'){
//       compress(theList);
//       printList(theList);
       cout<< isCircularList(theList)<< endl;
   }
    else if (cmd=='g'){
        gut(theList);
        printList(theList);
    }
    else if (cmd=='e'){
        removeEveryother(theList);
        printList(theList);
    }
    else if (cmd=='d'){
        dupe(theList);
        printList(theList);
    }
    else if (cmd=='a'){
        int val = 44;
        int loc = 5;
           insertAt(theList,val,loc);
           printList(theList);
       }
    else if (cmd=='v'){
        removetil7(theList);
        printList(theList);
    }
    else if (cmd=='z'){
        insert0Between(theList);
        printList(theList);
    }
   else {
      doHelp();
   }
    
   return true;
    
}


/*
 * promptForInt: Prompts for and reads an integer.
 */
int promptForInt (string prompt)
{
   int value;

   cout << prompt << ": ";
   cin >> value;
   return value;
}


// reads the numbers from next line in cin into a vector
// Note: this code uses istringstream: this is the analogous feature
//     to using a Scanner on a String in Java.
void readNums(vector<int> & nums) {

   nums.clear();  // empty out any previous values
                             
   string lineStr;

   getline(cin, lineStr);

   if (lineStr.empty()) {
      return;
   }

   istringstream istr(lineStr);

   int num;

   while (istr >> num) { // comes out false if we reach end of string (i.e., eoln)
      nums.push_back(num);
   }
}




// prints a command summary
void doHelp() {
   cout << "Valid commands are" << endl;
   cout << "         b(uild new list), i(nsert in front), s(plit on a value)" << endl;
   cout << "         n(umber of runs), r(everse copy) " <<endl;
   cout << "         m(remove Middle element), p(rint), h(elp), q(uit)." << endl;
}


// adds 10 to all elements in the list
void add10(ListType list) {
   Node *p = list;
   while (p != NULL) {
      p->data += 10;
      p = p->next;
   }
}


// prompts for and reads in values from user into a vector
// and builds a list of those values from the vector
// (Note: it does not require O(n) space to build a list,
// but this is to test your toList function).
void doBuildList(ListType & list) {
   vector<int> nums;
   
   clearList(list);
   cout << "Please enter a sequence of ints followed by <nl> (e.g:1 2 3): ";
   readNums(nums);
   list = toList(nums);
}


// makes a reverse copy of the list.  Prints out the copy,
// modifies the copy, and then prints the copy.
// (when used with the main program, you will be able to see that
//  the original is unchanged if reverseCopy works correctly)
void doReverseCopy(ListType list) {
   ListType revCopy = reverseCopy(list);

   cout << "The reverse copy: ";
   printList(revCopy);
   cout << "Add 10 to all elements in the copy only: ";
   add10(revCopy);
   printList(revCopy);
}


// test split function on list and print results
void doSplitOnVal(ListType & list) {
   ListType list1 = NULL;
   ListType list2 = NULL;

   int val = promptForInt("Value to split on");

   splitOnVal(list, val, list1, list2);
   cout << "Elements before the split: ";
   printList(list1);
   cout << "Elements after the split: ";
   printList(list2);
   cout << "(The list should be empty now.)" << endl;
}

//14Fall//////////////////
void dosplice (ListType &list){
    ListType node1 = new Node (6);
    ListType node2 = new Node (6);
    ListType node3 = new Node (6);
    
    node1->next=node2;
    node2->next=node3;
    ListType sublist = node1;
    printList(sublist);
    int value = promptForInt("the value");
    splice(list, value, NULL);
    cout << "List after splice: ";
    printList(list);
    cout << "Sublist: ";
    printList(sublist);
    
    
}

//15Fall//////////////////
bool allUnique (ListType list){
    bool flag = false;
    ListType list1 = list;
    while (list1!=NULL){
        int count = 0;
        int x = list1->data;
        ListType list2 = list;
        while (list2!=NULL){
            int y = list2->data;
            if (x!=y){
                flag = true;
            }else{
                count ++;
                if (count==2){
                    return false;}
            }
            list2 = list2->next;
        }
        list1 = list1->next;
    }
    return true;
}

//16Spring//////////////////
void compress (ListType & list){
    if (list==NULL){
        return;
    }
    if (list->next==NULL){
        return;
    }
    ListType dup = list;
    while (dup!=NULL){
        while (dup->next!=NULL&&dup->data==dup->next->data){
            ListType temp = dup -> next;
            dup->next=dup->next->next;
            delete temp;
        }
        dup= dup->next;
    }
}

//16Fall//////////////////
bool isCircularList (ListType list){
    ListType dup = list;
    while (list->next!=NULL){
        list = list->next;
    }
    ListType temp = list->next;
    return temp==dup;
}

//17Spring//////////////////
void gut(ListType & list){
    if (list==NULL||list->next==NULL){
        return;
    }
    ListType dup = list;
    ListType dup2 = list;
    while (dup->next!=NULL){
        ListType temp = dup->next;
        dup = dup ->next;
        temp=NULL;
    }
    dup2->next=dup;
}

//17Fall//////////////////
void removeEveryother (ListType & list){
    if (list==NULL||list->next==NULL){
        return;
    }
    ListType dup = list;
    int size = 0;
    while(dup !=NULL){
        size ++;
        dup = dup ->next;
    }
    ListType dup2 = list;
    if (size%2==0){
        while (dup2!=NULL){
            ListType temp = dup2 -> next;
            dup2 -> next = dup2 -> next -> next;
            delete temp;
            dup2 = dup2 -> next;
        }
    }else {
        while (dup2->next!=NULL){
            ListType temp = dup2 ->next;
            dup2 -> next = dup2 -> next -> next;
            delete temp;
            dup2 = dup2 -> next;
        }
    }
}

//18Fall//////////////////
void dupe (ListType & list){
    ListType dup = list;
    if(dup==NULL){
        return;
    }
    while (dup!=NULL){
        ListType dupnode = new Node(dup->data, dup->next);
        dup->next = dupnode;
        dup=dup->next->next;
    }
}

//19Spring//////////////////
void insertAt(ListType & list, int val, int loc){
    ListType dup1 = list;
    int size = 0;
    if (list==NULL){
        list = new Node(val);
        return;
    }
    while (dup1 !=NULL){
        dup1 = dup1->next;
        size++;
    }
    delete dup1;
    if (loc ==0){
        list = new Node (val,list);
        return;
    }
    if (loc >= size){
        loc = size;
    }
    ListType dup2 = list;
    for (int i = 1; i<loc ; i++){
        dup2 = dup2 ->next;
    }
    dup2 -> next = new Node (val, dup2->next);
}

//19Fall//////////////////
void removetil7 (ListType & list){
    ListType dup = list;
    if (dup==NULL ||dup -> data==7){
        return;
    }
    while (dup->next!=NULL){
        if (dup->data!=7){
            ListType temp =dup->next;
            dup=dup->next;
            delete temp;
        }else{
            break;
        }
    }
    if (dup->data==7){
        list = dup;
        return;
    }
    else{
        dup = dup ->next;
        list = dup;
        return;
    }
}

//exam
void insert0Between(ListType & list) {
    if (list==NULL||list->next==NULL){
        return;
    }
    ListType dup = list;
    while (dup->next!=NULL){
        ListType node = new Node (0,dup->next);
        dup->next = node;
        dup= dup ->next->next;
    }
}



//*****************************************************************
// utility list funcs and Node methods
// (function comments for these are in ecListFuncs.h)

void insertFront(ListType &list, int val) {
   list = new Node(val, list);
}


void printList(ListType list) {

   if (list == NULL) {
      cout << "<empty>";
   }

   Node *p = list;
   while (p != NULL) {
      cout << p->data << " ";
      p = p->next;
   }
   cout << endl;
}


void clearList(ListType &list) {

   Node *rest = list;

   while (list != NULL) {
      rest = list->next;  // rest is all but the first element
      delete list;  // reclaims one node only
      list = rest;
   }

}

Node::Node(int item) {
   data = item;
   next = NULL;
}

Node::Node(int item, Node *n) {
   data = item;
   next = n;
}

