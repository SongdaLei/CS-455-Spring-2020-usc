// Name:Songda Lei
// USC NetID:sogndale
// CSCI 455 PA5
// Spring 2020

// Table.cpp  Table class implementation


#include "Table.h"

#include <iostream>
#include <string>
#include <cassert>

using namespace std;


// listFuncs.h has the definition of Node and its methods.  -- when
// you complete it it will also have the function prototypes for your
// list functions.  With this #include, you can use Node type (and
// Node*, and ListType), and call those list functions from inside
// your Table methods, below.

#include "listFuncs.h"


//*************************************************************************

// create an empty table, i.e., one where numEntries() is 0
// (Underlying hash table is HASH_SIZE.)
Table::Table() {
    hashSize=HASH_SIZE;
    data = new ListType [hashSize];
    num = 0;
}

// create an empty table, i.e., one where numEntries() is 0
// such that the underlying hash table is hSize
Table::Table(unsigned int hSize) {
    hashSize=hSize;
    data = new ListType [hashSize];
    num = 0;
}

// returns the address of the value that goes with this key
// or NULL if key is not present.
//   Thus, this method can be used to either lookup the value or
//   update the value that goes with this key.
int * Table::lookup(const string &key) {
    unsigned int hcode = hashCode(key);
    return listlookup(data[hcode], key);
}

// remove a pair given its key
// false iff key wasn't present
bool Table::remove(const string &key) {
    unsigned int hcode = hashCode(key);
    if (listremove(data[hcode], key)){
        num --;
        return true;
    }
    else{
        return false;
    }
}

// insert a new pair into the table
// return false iff this key was already present
//         (and no change made to table)
bool Table::insert(const string &key, int value) {
   unsigned int hcode = hashCode(key);
    if (contains(data[hcode], key)){
        return false;
    }else{
        addfront(data[hcode], key , value);
        num++;
        return true;
    }
}

// number of entries in the table
int Table::numEntries() const {
    return num;
}

// print out all the entries in the table, one per line.
// Sample output:
//   zhou 283
//   sam 84
//   babs 99
void Table::printAll() const {
    for(int i=0; i < hashSize; i++){
        printall (data[i]);
    }

}

// hashStats: for diagnostic purposes only
// prints out info to let us know if we're getting a good distribution
// of values in the hash table.
// Sample output from this function
//   number of buckets: 997
//   number of entries: 10
//   number of non-empty buckets: 9
//   longest chain: 2
void Table::hashStats(ostream &out) const {
    out << "number of buckets: " << hashSize << endl;
    out << "number of entries: " << numEntries() << endl;
    out << "number of non-empty buckets: " << noempty() << endl;
    out << "longest chain: " << longest() << endl;
}


// add definitions for your private methods here
//traverse the table to count the noempty buckets
//returns the number of noempty buckets
int Table::noempty () const{
    int count = 0;
    for (int i=0; i <hashSize; i++){
        if (size(data[i])!=0){
            count++;
        }
    }
    return count;
}

//traverse the table to find the longest chain
//return the length of the longest chain
int Table::longest()const{
    int longest =0;
    for (int i=0; i<hashSize; i++){
        if (size(data[i])>longest){
            longest=size(data[i]);
        }
    }
    return longest;
}
