// Name: Songda Lei
// USC NetID:songdale
// CSCI455 PA2
// Spring 2020
// Version 1.1

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/*
read the firstline input
check the firstline input
create a new Bookshelf with input arr
create a new BookshelfKeeper with input book
read the input after first line
check those input and do the puts and picks
 */

public class BookshelfKeeperProg {
    //main function using Scanner to get the input.
    //Put the firstline input in a arr
    public static void main(String[] args)  {
        System.out.println("Please enter initial arrangement of books followed by newline:");
        Scanner in = new Scanner(System.in);
        ArrayList <Integer>arr = new ArrayList<>();
        String firstline = in.nextLine();
        Scanner linescanner = new Scanner(firstline);
        Bookshelf Book;

        while (linescanner.hasNextInt())
        {
            arr.add(linescanner.nextInt());
        }
        checkinputarr(arr);

        Book = new Bookshelf(arr);
        BookshelfKeeper keeper = new BookshelfKeeper(Book);
        int startcall =0;
        System.out.println(arr.toString()+ " " + startcall +" " + startcall);
        System.out.println("Type pick <index> or put <height> followed by newline. Type end to exit.");

        while(in.hasNextLine()) {
            String afterfirst = in.nextLine();

            Scanner scan = new Scanner(afterfirst);

            checkpickput(scan, keeper);

        }
    }

    //check the firstline input
    public static void checkinputarr (ArrayList<Integer> list)
    {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i + 1) < list.get(i)) {
                System.out.println("ERROR: Heights must be specified in non-decreasing order.");
                System.out.println("Exiting Program.");
                System.exit(-1);
            }
        }
        for (Integer a : list) {
            if (a <= 0) {
                System.out.println("ERROR: Height of a book must be positive.\n" +
                        "Exiting Program.");
                System.exit(-1);
            }
        }
    }
    //check the inputs after first line, also do the pick or put action
    public static void checkpickput (Scanner in, BookshelfKeeper shelf)
    {
        if (in.hasNext("pick"))
        { String call = in.next();
            int index = in.nextInt();
            if (index > shelf.getNumBooks()-1)
            {
                System.out.println("ERROR: Entered pick operation is invalid on this shelf.\n" + "Exiting Program.");
                System.exit(-1);
            }
            shelf.pickBook(index);
            System.out.println(shelf.toString());
        }
        else if (in.hasNext("put"))
        {
            String call = in.next();
            int height = in.nextInt();
            if (height<=0)
            {
                System.out.println("ERROR: Height of a book must be positive.\n" + "Exiting Program.");
                System.exit(-1);
            }
            shelf.putBook(height);
            System.out.println(shelf.toString());
        }
        else if (in.hasNext("end"))
        {
            System.out.println("Exiting Program.");
            System.exit(-1);
        }
        else
        {
            System.out.println("ERROR: Operation should be either pick or put.\n" + "Exiting Program.");
            System.exit(-1);
        }
    }


}
