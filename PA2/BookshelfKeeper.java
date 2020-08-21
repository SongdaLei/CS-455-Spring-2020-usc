// Name: Songda Lei
// USC NetID:songdale
// CSCI455 PA2
// Spring 2020
// Version 1.1

import java.util.ArrayList;

/**
 * Class BookshelfKeeper
 *
 * Enables users to perform efficient put or pick operation on a bookshelf of books kept in
 * non-decreasing order by height, with the restriction that single books can only be added
 * or removed from one of the two *ends* of the bookshelf to complete a higher level pick or put
 * operation.  Pick or put operations are performed with minimum number of such adds or removes.
 *
 * Uses a Bookshelf class to model this restricted access.
 */
public class BookshelfKeeper {

    /**
     Representation invariant:

     <put rep. invar. comment here>

     Bookshelf is sorted and valid.
     Pick book position should be in the range from 0 to Bookshelf size -1.
     Put book height is greater than 0.
     */

    // <add instance variables here>
    //private  ArrayList<Integer> Keeper;
    private int total = 0;
    private int calls = 0;
    private Bookshelf books;


    /**
     * Creates a BookShelfKeeper object with an empty bookshelf
     *
     */
    public BookshelfKeeper() {
        books = new Bookshelf();
        assert isValidBookshelfKeeper();

    }

    /**
     * Creates a BookshelfKeeper object initialized with the given sorted bookshelf.
     * Note: method does not make a defensive copy of the bookshelf.
     *
     * PRE: sortedBookshelf.isSorted() is true.
     */
    public BookshelfKeeper(Bookshelf sortedBookshelf) {
        assert sortedBookshelf.isSorted() == true : "not valid, not sorted";
        books = sortedBookshelf;
        assert isValidBookshelfKeeper();

    }

    /**
     * Removes a book from the specified pos in the bookshelf and keeps bookshelf sorted
     * after picking up the book.
     *
     * Returns the number of calls to mutators on the contained bookshelf used to complete this
     * operation. This must be the minimum number to complete the operation.
     *
     * PRE: pos must be in the range [0, getNumBooks()).
     */
    public int pickBook(int pos) {
        assert pos >=0 && pos < getNumBooks():"not valid, pos must be in the range [0, getNumBooks()).";
        if (pos+1<=getNumBooks()/(double)2)
        {
            total +=pos*2+1;
            calls = pos*2+1;
            ArrayList <Integer> arr = new ArrayList<>();
            for (int i =0; i < pos + 1; i++) {
                arr.add (books.removeFront());
            }
            for (int i = arr.size() -2; i >=0; i--)
            {
                books.addFront(arr.get(i));
            }
        }
        else {
            total += (getNumBooks()-pos-1)*2+1;
            calls = (getNumBooks()-pos-1)*2+1;
            ArrayList <Integer> arr = new ArrayList<>();
            int remain = getNumBooks()-pos;
            for (int i =0; i < remain; i++) {
                arr.add (books.removeLast());
            }
            for (int i = arr.size()-2 ; i >=0; i--)
            {
                books.addLast(arr.get(i));
            }

        }
        return calls;
    }

    /**
     * Inserts book with specified height into the shelf.  Keeps the contained bookshelf sorted
     * after the insertion.
     *
     * Returns the number of calls to mutators on the contained bookshelf used to complete this
     * operation. This must be the minimum number to complete the operation.
     *
     * PRE: height > 0
     */
    public int putBook(int height) {
        assert height>0:"not valid height ,height > 0";
        int pos = 0 ;

        if (getNumBooks()==0)
        {
            size0(height);
        }
        else if (getNumBooks()==1)
        {
            size1(height);
        }
        else {
            for (int i = 0; i < getNumBooks() - 1; i++) {
                if (books.getHeight(i) <= height && books.getHeight(i + 1) >= height) {
                    pos = getputpos(height);
                    if ((pos + 1) <= getNumBooks() /(double) 2) {
                        calls = left(pos,height);
                        return calls;
                    } else {
                        calls= right(pos,height);
                        return calls;
                    }
                } else if (height <= books.getHeight(0)) {
                    calls = first(height);
                    return calls;
                } else if (books.getHeight(getNumBooks() - 1) <= height) {
                   calls = last(height);
                    return calls;
                }
            }
        }
        return calls;
    }

    /**
     * Returns the total number of calls made to mutators on the contained bookshelf
     * so far, i.e., all the ones done to perform all of the pick and put operations
     * that have been requested up to now.
     */
    public int getTotalOperations() {

        return total;   // dummy code to get stub to compile
    }

    /**
     * Returns the number of books on the contained bookshelf.
     */
    public int getNumBooks() {

        return books.size();   // dummy code to get stub to compile
    }

    /**
     * Returns string representation of this BookshelfKeeper. Returns a String containing height
     * of all books present in the bookshelf in the order they are on the bookshelf, followed
     * by the number of bookshelf mutator calls made to perform the last pick or put operation,
     * followed by the total number of such calls made since we created this BookshelfKeeper.
     *
     * Example return string showing required format: “[1, 3, 5, 7, 33] 4 10”
     *
     */
    public String toString() {

        return books.toString() + " " + calls+" "+ total;   // dummy code to get stub to compile

    }

    /**
     * Returns true iff the BookshelfKeeper data is in a valid state.
     * (See representation invariant comment for details.)
     */
    private boolean isValidBookshelfKeeper() {

        if (!(getNumBooks()>=0))
        {
            return false;
        }
        for (int i = 0; i < getNumBooks(); i++)
        {
            if (books.getHeight(i)<=0)
            {
                return false;
            }
        }

        return true;  // dummy code to get stub to compile

    }

    // add any other private methods here
    //in put action, return the position of the book of certain height
    public int getputpos (int H)
    {
        int pos =0;
        int firstpos = 0;
        int secondpos = 0;
        for (int i = 0; i < getNumBooks() - 1; i++) {
            if (books.getHeight(i) < H && books.getHeight(i + 1) > H) {
                pos = i+1;
                return pos;
            }
            //below is for extra credit
            else if (books.getHeight(i) == H && books.getHeight(i + 1) != H)
            {
               firstpos = i;
               secondpos = i+1;
                if ((firstpos + 1) <= getNumBooks() /(double) 2)
                {
                    pos = firstpos;
                }
                else {
                    pos = secondpos;
                }
                return pos;
            }
            else if (books.getHeight(i) == H && books.getHeight(i + 1) == H)
            {
                int g = i;
                for ( int j = i; j<getNumBooks(); j++)
                {
                    if (books.getHeight(j)==books.getHeight(i))
                    {
                        g++;
                    }
                    if (books.getHeight(g)!=books.getHeight(i))
                    {
                        break;
                    }
                }
                firstpos = i;
                secondpos = g;
                if (firstpos * 2 + 1 <= (getNumBooks() - secondpos - 1) * 2 + 1)
                {
                    pos = firstpos;
                }
                else {
                    pos = secondpos;
                }
                return pos;
            }
        }
        return pos;
    }
    //if book shelf contains no book
    public int size0 (int H )
    {
        books.addFront(H);
        total +=1;
        calls =1;
        return calls;
    }
    //if book shelf contains one book
    public int size1 (int H)
    {
        if (H <= books.getHeight(0)) {
            total += 1;
            calls = 1;
            books.addFront(H);
            return calls;
        } else if (books.getHeight(getNumBooks() - 1) <= H) {
            total += 1;
            calls = 1;
            books.addLast(H);
            return calls;
        }
        return calls;
    }
    //put action starts from the left
    public int left (int position, int H)
    {
        total += position * 2 + 1;
        calls = position * 2 + 1;
        ArrayList <Integer> arr = new ArrayList<>();
        for (int j =0; j<position; j++)
        {
            arr.add(books.removeFront());
        }
        books.addFront(H);

        for (int g = arr.size()-1; g>=0;g--)
        {
            books.addFront(arr.get(g));
        }
        return calls;
    }
    //put action starts from the right
    public int right (int position, int H)
    {
        ArrayList <Integer> arr = new ArrayList<>();
        int remain = getNumBooks()-position;
        for (int j =0; j<remain; j++)
        {
            arr.add(books.removeLast());
        }
        books.addLast(H);
        for (int g = arr.size()-1; g>=0;g--)
        {
            books.addLast(arr.get(g));
        }
        total += (getNumBooks() - position - 1) * 2 + 1;
        calls = (getNumBooks() - position - 1) * 2 + 1;
        return calls;
    }
    //if height less than the first book
    public int first ( int H)
    {
        total += 1;
        calls = 1;
        books.addFront(H);
        return calls;
    }
    //if height greater than the last book
    public int last ( int H)
    {
        total += 1;
        calls = 1;
        books.addLast( H);
        return calls;
    }
}

