// Name:Songda Lei
// USC NetID:songdale
// CSCI 455 PA5
// Spring 2020


//*************************************************************************
// Node class definition
// and declarations for functions on ListType

// Note: we don't need Node in Table.h
// because it's used by the Table class; not by any Table client code.

// Note2: it's good practice to not put "using" statement in *header* files.  Thus
// here, things from std libary appear as, for example, std::string

#ifndef LIST_FUNCS_H
#define LIST_FUNCS_H


struct Node {
    std::string key;
    int value;
    
    Node *next;
    
    Node(const std::string &theKey, int theValue);
    
    Node(const std::string &theKey, int theValue, Node *n);
};


typedef Node * ListType;

//*************************************************************************
//add function headers (aka, function prototypes) for your functions
//that operate on a list here (i.e., each includes a parameter of type
//ListType or ListType&).  No function definitions go in this file.
/**Check whether the list contains the str
 *@param list the list to be checked
 *@param str the key of the entry
 *@return true if the key exists in the list
*/
bool contains (ListType list, std::string str);

/**Add a new node in the front of the list
 *@param list the list to be worked on
 *@param str key of the entry
 *@param value value of the entry
 *@return true if addfront is successful
*/
bool addfront (ListType & list, std::string str, int value);

/**Add a new node in the back of the list
 *@param list the list to be worked on
 *@param str key of the entry
 *@param value value of the entry
 *@return true if addlast is sucessful
*/
bool addlast (ListType & list, std::string str, int value);

/**Remove a existing node from the list
 *@param list the list to be worked on
 *@param str key of the entry
 *@return true if remove is sucessful
*/
bool listremove (ListType & list, std::string str);

/**Change the value of a existing node from the list
 *@param list the list to be worked on
 *@param str key of the entry that needs to change value
 *@param value new value
 *@return true if remove is sucessful
*/
bool changevalue (ListType & list, std::string str, int value);

/**Get the size of the list
 *@param list the list to be worked on
 *@return the size of this list
*/
int size (ListType list);

/**Look up for the address of certain key in the list
 *@param list the list to be worked on
 *@param str the key needs to be search for
 *@return the address pointer of the key
*/
int * listlookup (ListType list, std::string str);

/**Print all the entries in the list
 *@param list the list to be worked on
*/
void printall (ListType list);












// keep the following line at the end of the file
#endif

