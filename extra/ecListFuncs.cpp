/*  Name:Songda Lei
 *  USC NetID:songdale
 *  CS 455 Sping 2020
 *
 *  See ecListFuncs.h for specification of each function.
 *
 *  NOTE: remove the print statements below as you implement each function
 *  or you will receive no credit for that function.
 *
 */

#include <iostream>

#include "ecListFuncs.h"

using namespace std;


ListType toList(const vector<int> & nums) {
    if (nums.size()==0)
    {
        return NULL;
    }else {
        ListType list = new Node(nums[0]);
        ListType newlist = list;
        for (int i = 1; i<nums.size(); i++){
            newlist->next= new Node (nums[i]);
            newlist = newlist -> next;
        }
        return list;
    }
    
}



int numRuns(ListType list) {

    int count = 0;
    int howmany = 0;
    while (list!=NULL&&list->next!=NULL){
        ListType node = list;
        ListType nextnode = list -> next;
        if (node ->data == nextnode->data){
            howmany ++;
        }else {
            howmany = 0;
        }
        if (howmany ==1){
            count ++;
        }
        list =  list ->next;
    }
    return count;
}



ListType reverseCopy(ListType list) {
    ListType newlist = NULL;
    ListType cur = NULL;
    if (list==NULL|| list->next==NULL){
        return list;
    }else{
        while (list!=NULL){
            cur = new Node(list->data, newlist);
            list = list->next;
            newlist = cur;
        }
        return newlist;
    }

}



void removeMiddle(ListType &list) {
    ListType dup = list;
    int size = 0;
    ListType dup2 = list;
    int mid = 0;
    while (dup!=NULL){
        size ++;
        dup = dup ->next;
    }
    if (size == 0 || size == 1){
        list = NULL;
        return;
    }else if (size == 2){
        list = list -> next;
        return;
    }else {
        if (size % 2 ==0){
            mid = (size - 1)/2;
        }else {
            mid = size / 2;
        }
        for (int i = 1; i < mid; i++){
            dup2 = dup2 ->next;
        }
        dup2 -> next = dup2 -> next ->next;
    }
}



void splitOnVal(ListType &list, int splitVal, ListType &a, ListType &b) {
    if (list == NULL){
        a=NULL;
        b=NULL;
        return;
    }
    bool contains = false;
    ListType dup = list;
    while (dup !=NULL){
        if (dup -> data == splitVal){
            contains = true;
            break;
        }
        dup = dup->next;
    }
    ListType loc = NULL;
    a = list;
    if (contains){
        if (list->data == splitVal){
            b = list -> next;
            a = NULL;
            list = NULL;
            return;
        }else {
            while (list != NULL){
                if (list -> data == splitVal){
                    loc -> next = NULL;
                    b = list -> next;
                    break;
                }
                loc = list;
                list = list -> next;
            }
            list = NULL;
        }
    }else{
        a = list;
        b = NULL;
        list = NULL;
        return;
    }
}


//14Fall//////////////////
void splice (ListType & list, int value, ListType sublist){
    if (list==NULL){
        list = sublist;
        return;
    }
    if (value==0){
        while(sublist->next!=0){
            sublist=sublist->next;
        }
        sublist->next=list;
        return;
    }
    if (sublist==NULL){
        return;
    }
    ListType duplist = list;
    ListType dup2 = list;
    for (int i=1; i<value+1; i++){
        dup2 = dup2 ->next;
    }
    for (int i = 1; i<value; i++){
        duplist=duplist->next;
    }
    duplist->next = sublist;
    while (sublist->next!=NULL){
        sublist=sublist->next;
    }
    
    sublist->next = dup2;
    
}

