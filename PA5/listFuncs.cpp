// Name:Songda Lei
// USC NetID:sogndale
// CSCI 455 PA5
// Spring 2020


#include <iostream>

#include <cassert>

#include "listFuncs.h"

using namespace std;

Node::Node(const string &theKey, int theValue) {
    key = theKey;
    value = theValue;
    next = NULL;
}

Node::Node(const string &theKey, int theValue, Node *n) {
    key = theKey;
    value = theValue;
    next = n;
}




//*************************************************************************
// put the function definitions for your list functions below

/**Check whether the list contains the str
 *@param list the list to be checked
 *@param str the key of the entry
 *@return true if the key exists in the list
*/
bool contains (ListType list, string str){
    while (list!=NULL){
        if (list->key==str){
            return true;
        }
        list = list->next;
    }
    return false;
    
}

/**Add a new node in the front of the list
 *@param list the list to be worked on
 *@param str key of the entry
 *@param value value of the entry
 *@return true if addfront is successful
*/
bool addfront (ListType & list, string str, int value){
    if (contains (list,str)){
        return false;
    }else {
        list = new Node(str,value,list);
        return true;
    }
}

/**Add a new node in the back of the list
 *@param list the list to be worked on
 *@param str key of the entry
 *@param value value of the entry
 *@return true if addlast is sucessful
*/
bool addlast (ListType & list, string str, int value){
    if (contains(list,str)){
        return false;
    }
    ListType newlist = list;//do not want list to move, move newlist
    ListType newnode = new Node (str,value);
    if (list == NULL){
        list = newnode;
        return true;
    }
    while (newlist ->next!=NULL){
        newlist = newlist->next;
    }
    newlist ->next = newnode;
    return true;
    
}

/**Remove a existing node from the list
 *@param list the list to be worked on
 *@param str key of the entry
 *@return true if remove is sucessful
*/
bool listremove (ListType & list, string str){
    ListType cur = list;
    ListType pre = NULL;
    if (!contains(list, str)){
        return false;
    }else{
        if (list->key==str){ //if the str is the first one in the list
            list = list->next;
            return true;
        }
        while (cur != NULL){
            if (cur->key==str){//other cases
                pre->next=cur->next;
                delete cur;
                return true;
            }
            pre = cur;
            cur = cur -> next;
        }
       return false;
    }
}

/**Change the value of a existing node from the list
 *@param list the list to be worked on
 *@param str key of the entry that needs to change value
 *@param value new value
 *@return true if remove is sucessful
*/
bool changevalue (ListType & list, string str, int value){
    //ListType cur = list;
    if (!contains(list, str)){
        return false;
    }
        int *p = listlookup(list, str);
        *p = value;
        return true;
}

/**Get the size of the list
 *@param list the list to be worked on
 *@return the size of this list
*/
int size (ListType list){
    int size=0;
    while (list!=NULL){
        size ++;
        list = list -> next;
    }
    return size;
}

/**Look up for the address of certain key in the list
 *@param list the list to be worked on
 *@param str the key needs to be search for
 *@return the address pointer of the key
*/
int * listlookup (ListType list, string str){
    if (!contains(list, str)){
        return NULL;
    }else {while (list !=NULL){
        if (list->key==str){
            return &(list->value);
        }
        list = list->next;
        
    }
        return NULL;
    }
}

/**Print all the entries in the list
 *@param list the list to be worked on
*/
void printall (ListType list){
    while (list!=NULL){
        cout << list->key  << " " << list->value <<endl;
        list = list ->next;
    }
}
