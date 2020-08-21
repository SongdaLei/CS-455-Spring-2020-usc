// Name: Songda Lei
// USC NetID:songdale
// CSCI455 PA2
// Spring 2020
// Version 1.1

import java.util.ArrayList;
import java.util.Collections;

/**
 * Class Bookshelf
 * Implements idea of arranging books into a bookshelf.
 * Books on a bookshelf can only be accessed in a specific way so books don’t fall down;
 * You can add or remove a book only when it’s on one of the ends of the shelf.
 * However, you can look at any book on a shelf by giving its location (starting at 0).
 * Books are identified only by their height; two books of the same height can be
 * thought of as two copies of the same book.
 */

public class Bookshelf {

    /**
     Representation invariant:

     <put rep. invar. comment here>
     the shelf has 0 or more books, and the height of each book is greater than 0
     RemoveFront and RemoveLast can be called only on non-empty BookShelf
     GetHeight position 0 <= position < this.size()
     */

    // <add instance variables here>


    /**
     * Creates an empty Bookshelf object i.e. with no books
     */
    private ArrayList <Integer> USCBooks;

    public Bookshelf() {
        USCBooks = new ArrayList<>();

        assert isValidBookshelf():"It is not valid";  // sample assert statement (you will be adding more of these calls)
    }

    /**
     * Creates a Bookshelf with the arrangement specified in pileOfBooks. Example
     * values: [20, 1, 9].
     *
     * PRE: pileOfBooks contains an array list of 0 or more positive numbers
     * representing the height of each book.
     */
    public Bookshelf(ArrayList<Integer> pileOfBooks) {
        USCBooks = new ArrayList<Integer>();
        assert pileOfBooks != null:"pileOfBooks contains an array list of 0 or more positive numbers";
            for (Integer a: pileOfBooks)
            {
                USCBooks.add (a);
            }

        assert isValidBookshelf():"It is not valid";
    }

    /**
     * Inserts book with specified height at the start of the Bookshelf, i.e., it
     * will end up at position 0.
     *
     * PRE: height > 0 (height of book is always positive)
     */
    public void addFront(int height) {
        //heights.add(height);
        assert height >0: "not valid, height need to be greater than 0";
        if (height>0){
            USCBooks.add(0,height);
        }
    }

    /**
     * Inserts book with specified height at the end of the Bookshelf.
     *
     * PRE: height > 0 (height of book is always positive)
     */
    public void addLast(int height) {
        assert height >0: "not valid, height need to be greater than 0";
            USCBooks.add(height);


    }

    /**
     * Removes book at the start of the Bookshelf and returns the height of the
     * removed book.
     *
     * PRE: this.size() > 0 i.e. can be called only on non-empty BookShelf
     */
    public int removeFront() {
        assert USCBooks.size() >0: "not valid, size cannot be empty";
        int first = USCBooks.get(0);
        USCBooks.remove(0);

        return first;   // dummy code to get stub to compile

    }

    /**
     * Removes book at the end of the Bookshelf and returns the height of the
     * removed book.
     *
     * PRE: this.size() > 0 i.e. can be called only on non-empty BookShelf
     */
    public int removeLast() {
        assert USCBooks.size() >0: "not valid, size cannot be empty";
        int last = USCBooks.get(USCBooks.size()-1);
        USCBooks.remove(USCBooks.size()-1);
        return last;   // dummy code to get stub to compile
    }

    /*
     * Gets the height of the book at the given position.
     *
     * PRE: 0 <= position < this.size()
     */
    public int getHeight(int position) {
        assert position >=0: "position needs to be greater or equal 0";
        assert position < USCBooks.size(): "position needs to be less than the shelf size";

        int heightat = USCBooks.get(position);
        return heightat;

        // dummy code to get stub to compile

    }

    /**
     * Returns number of books on the this Bookshelf.
     */
    public int size() {

        assert isValidBookshelf():"not valid";

        int size = USCBooks.size();

        return size;   // dummy code to get stub to compile

    }

    /**
     * Returns string representation of this Bookshelf. Returns a string with the height of all
     * books on the bookshelf, in the order they are in on the bookshelf, using the format shown
     * by example here:  “[7, 33, 5, 4, 3]”
     */
    public String toString() {

        return USCBooks.toString();

    }

    /**
     * Returns true iff the books on this Bookshelf are in non-decreasing order.
     * (Note: this is an accessor; it does not change the bookshelf.)
     */
    public boolean isSorted() {
        ArrayList <Integer> newbooks = new ArrayList<Integer>();
        for (Integer a : USCBooks)
        {
            newbooks.add(a);
        }

        Collections.sort (newbooks);

        if (USCBooks.equals(newbooks)==true)
        {
             return true;
        }
        else {
            return false;}  // dummy code to get stub to compile

    }

    /**
     * Returns true iff the Bookshelf data is in a valid state.
     * (See representation invariant comment for more details.)
     */
    private boolean isValidBookshelf() {
        if (!(USCBooks.size()>=0))
        {
            return false;
        }
        for (int i = 0; i < USCBooks.size(); i++)
        {
            if (USCBooks.get(i)<=0)
            {
                return false;
            }
        }

        return true;  // dummy code to get stub to compile

    }

}

