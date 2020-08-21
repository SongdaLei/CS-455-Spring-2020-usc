// Name:Songda Lei
// USC NetID:songdale
// CSCI 455 PA5
// Spring 2020

/*
 * grades.cpp
 * A program to test the Table class.
 * How to run it:
 *      grades [hashSize]
 *
 * the optional argument hashSize is the size of hash table to use.
 * if it's not given, the program uses default size (Table::HASH_SIZE)
 *
 */

#include "Table.h"

// cstdlib needed for call to atoi
#include <cstdlib>

using namespace std;

//Print the command summary
void printCmdSummary() {
    cout<< "Valid commands are <insert>, <change>, <lookup>, <remove>, <print>, <stats>, ";
    cout << "<help>, <quit>"<<endl<<endl;
}

void help() {
    cout<< "Command Instruction" <<endl;
    cout<<"<insert> name score \nInsert this name and score in the grade table. If this name was already present,print a message to that effect, and don't do the insert." <<endl;
    cout << "<change> name newscore \nChange the score for name. Print an appropriate message if this name isn't present." <<endl;
    cout << "<lookup> name \nLookup the name, and print out his or her score, or a message indicating that student is not in the table." <<endl;
    cout << "<remove> name \nRemove this student. If this student wasn't in the grade table, print a message to that effect." <<endl;
    cout << "<print> \nPrint out all names and scores in the table." <<endl;
    cout << "<size> \nPrint out the number of entries in the table." <<endl;
    cout << "<stats> \nPrint out statistics about the hash table at this point. (Calls hashStats() method)"<<endl;
    cout << "<help> \nPrint out a brief command summary." <<endl;
    cout << "<quit> \nExit the program." <<endl;
}

char commandabbr (string cmd){
    if (cmd == "insert") return 'i';
    if (cmd == "change") return 'c';
    if (cmd == "lookup") return 'l';
    if (cmd == "remove") return 'r';
    if (cmd == "print") return 'p';
    if (cmd == "size") return 's';
    if (cmd == "stats") return 't';
    if (cmd == "help") return 'h';
    if (cmd == "quit") return 'q';
    return 'n';
}

// Insert a new name and new score
void insert(Table* & grades, string name, int score);
// Change the score for a certain student
void change(Table* & grades, string name, int newscore);
// Lookup the score of a student
void lookup(Table* & grades, string name);
// Remove a student
void remove(Table* & grades, string name);
//Switch fuction to reduce line
void switchfunc (Table* & grades, char c, string name, int score, bool& keepgoing);

int main(int argc, char * argv[]) {

   // gets the hash table size from the command line

   int hashSize = Table::HASH_SIZE;

   Table * grades;  // Table is dynamically allocated below, so we can call
   // different constructors depending on input from the user.

   if (argc > 1) {
      hashSize = atoi(argv[1]);  // atoi converts c-string to int

      if (hashSize < 1) {
         cout << "Command line argument (hashSize) must be a positive number"
              << endl;
         return 1;
      }

      grades = new Table(hashSize);

   }
   else {   // no command line args given -- use default table size
      grades = new Table();
   }


   grades->hashStats(cout);

   // add more code here
   // Reminder: use -> when calling Table methods, since grades is type Table*

    string cmd;
    string name;
    int score;
    bool keepgoing = true;
    //printCmdSummary();
    do {
        cout << "cmd> ";
        cin >> cmd;
        if (cin.fail()) {
           cout << "ERROR: input stream failed." << endl;
           keepgoing = false;
        }
        else {
            char c = commandabbr(cmd);
            switchfunc(grades, c, name, score, keepgoing);
            
        }
    }while (keepgoing==true);
   return 0;
}

// Insert a new name and new score
void insert(Table* & grades, string name, int score){
    grades->insert(name, score);
//    if (grades->insert(name, score)){
//        cout << "This insert is a success!\n" << name << " with score " << score <<endl;
//    }else{
//        cout << "This insert failed!\n"<< "The student you trying to insert is already in the list" << endl;
//    }
}

// Change the score for a certain student
void change (Table* & grades, string name, int score){
    if (grades->lookup(name)!=NULL){
        *grades->lookup(name)=score;
    }
//    if (grades->lookup(name)!=NULL){
//        int oldscore = *(grades->lookup(name));
//        *grades->lookup(name)=score;
//        cout << "This change is a success!\n";
//        cout << "Change " <<name << " with score " << oldscore << " to " << score<<endl;
//    }else{
//        cout << "This change failed!\n"<< "The student you trying to change score is not in the list" << endl;
//    }
}

// Lookup the score of a student
void lookup (Table* & grades, string name){
    if (grades->lookup(name)!=NULL){
        cout <<  *grades->lookup(name) << endl;
    }
//    if (grades->lookup(name)==NULL){
//        cout << "This lookup failed!\n"<< "The student you trying to lookup score is not in the list" << endl;
//    }else{
//        cout << "This lookup is a success!\n";
//        cout << name << " has a score of " << *grades->lookup(name) << endl;
//    }
}

// Remove a student
void remove (Table* & grades, string name){
    grades->remove(name);
//    if (grades->remove(name)){
//        cout << "This remove is a success!\n";
//        cout << "You have removed "<<name<<" from the list" << endl;
//    }else {
//        cout << "This remove failed!\n"<< "The student you trying to remove is not in the list" << endl;
//    }
}

//Switch fuction to reduce line
void switchfunc (Table* & grades, char c, string name, int score, bool & keepgoing){
    switch (c){
    case 'i':
//        cout << "You choose to insert." << endl;
//        cout << "Plz enter the student name and score." << endl;
        cin >> name;
        cin >> score;
        insert(grades, name, score);
        break;

    case 'c':
//        cout << "You choose to change." << endl;
//        cout << "Plz enter the student name and the score you want to change." << endl;
        cin >> name;
        cin >> score;
        change(grades, name, score);
        break;

    case 'l':
//        cout <<"You choose to lookup." << endl;
//        cout << "Plz enter the student name you want to lookup." << endl;
        cin >>name;
        lookup(grades, name);
        break;

    case 'r':
//        cout <<"You choose to remove." << endl;
//        cout << "Plz enter the student name you want to remove." << endl;
        cin >>name;
        remove(grades,name);
        break;

    case 'p':
//        cout <<"You choose to print." << endl;
        grades->printAll();
        break;

    case 's':
//        cout <<"You choose to get the size." << endl;
//        cout <<"There are " <<grades->numEntries() << " students in the list" <<endl;
        cout <<grades->numEntries()<<endl;
        break;

    case 't':
//        cout <<"You choose to get the stats." << endl;
        grades->hashStats(cout);
        break;

    case 'h':
//        cout <<"You choose to get help." << endl;
        printCmdSummary();
        help();
        break;

    case 'q':
        keepgoing=false;
        break;

    case 'n':
        cout << "ERROR: invalid command" <<endl;
        printCmdSummary();
        help();
        break;
    }
}

