// Name: Songda Lei
// USC NetID: songdale
// CS 455 PA3
// Spring 2020


import java.util.Random;

/**
   MineField
      class with locations of mines for a game.
      This class is mutable, because we sometimes need to change it once it's created.
      mutators: populateMineField, resetEmpty
      includes convenience method to tell the number of mines adjacent to a location.
 */
public class MineField {
   
   // <put instance variables here>
   private int totalrow;
   private int totalcol;
   private int NofM;
   private boolean [][] mineData;
   
   
   /**
      Create a minefield with same dimensions as the given array, and populate it with the mines in the array
      such that if mineData[row][col] is true, then hasMine(row,col) will be true and vice versa.  numMines() for
      this minefield will corresponds to the number of 'true' values in mineData.
    * @param mineData  the data for the mines; must have at least one row and one col.
    */
   public MineField(boolean[][] mineData) {
       assert mineData.length>0 && mineData[0].length>0:"mines array must have at least one row and one col.";

       totalrow = mineData.length;
       totalcol = mineData[0].length;
       this.mineData = new boolean[totalrow][totalcol];
       for (int i=0; i<totalrow; i++)
       {
           for (int j=0; j<totalcol; j++)
           {
               this.mineData [i][j] = mineData[i][j];
               if (mineData [i][j]==true)
               {
                   NofM ++;
               }
           }
       }
      
   }
   
   
   /**
      Create an empty minefield (i.e. no mines anywhere), that may later have numMines mines (once 
      populateMineField is called on this object).  Until populateMineField is called on such a MineField, 
      numMines() will not correspond to the number of mines currently in the MineField.
      @param numRows  number of rows this minefield will have, must be positive
      @param numCols  number of columns this minefield will have, must be positive
      @param numMines   number of mines this minefield will have,  once we populate it.
      PRE: numRows > 0 and numCols > 0 and 0 <= numMines < (1/3 of total number of field locations). 
    */
   public MineField(int numRows, int numCols, int numMines) {
       assert numRows>0 && numCols>0: "numRows > 0 and numCols > 0";
       assert 0 <= numMines && numMines < ((double) numCols* (double) numRows)/3.00 :
               "0 <= numMines < (1/3 of total number of field locations)";
       totalrow = numRows;
       totalcol = numCols;
       NofM = numMines;
       mineData = new boolean[totalrow][totalcol];

   }
   

   /**
      Removes any current mines on the minefield, and puts numMines() mines in random locations on the minefield,
      ensuring that no mine is placed at (row, col).
      @param row the row of the location to avoid placing a mine
      @param col the column of the location to avoid placing a mine
      PRE: inRange(row, col)
    */
   public void populateMineField(int row, int col) {
      assert inRange(row,col):"row or col not in range";
      resetEmpty();
      int minerow;
      int minecol;
      int counter = 0;
      Random R = new Random();

      while (counter < NofM)
      {
          minecol = R.nextInt(totalcol);
          minerow = R.nextInt(totalrow);
          if (hasMine(minerow,minecol) || minecol==col && minerow==row)
          {
              continue;
          }
          else
          {
              mineData [minerow][minecol]=true;
              counter++;
          }
      }
   }
   
   
   /**
      Reset the minefield to all empty squares.  This does not affect numMines(), numRows() or numCols()
      Thus, after this call, the actual number of mines in the minefield does not match numMines().  
      Note: This is the state the minefield is in at the beginning of a game.
    */
   public void resetEmpty() {
       mineData = new boolean[totalrow][totalcol];
   }

   
  /**
     Returns the number of mines adjacent to the specified mine location (not counting a possible 
     mine at (row, col) itself).
     Diagonals are also considered adjacent, so the return value will be in the range [0,8]
     @param row  row of the location to check
     @param col  column of the location to check
     @return  the number of mines adjacent to the square at (row, col)
     PRE: inRange(row, col)
   */
   public int numAdjacentMines(int row, int col) {
      assert inRange(row,col):"row or col not in range";
       int counter =0;
       for (int i = row -1; i<=row + 1; i++)
       {
           for (int j = col -1; j<=col+1; j++)
           {
               if(inRange(i,j)==true)
               {
                   if (mineData[i][j] == true&&!(i==row&&j==col))
                   {
                       counter++;
                   }
               }
           }
       }

       return counter;       // DUMMY CODE so skeleton compiles
   }
   
   
   /**
      Returns true iff (row,col) is a valid field location.  Row numbers and column numbers
      start from 0.
      @param row  row of the location to consider
      @param col  column of the location to consider
      @return whether (row, col) is a valid field location
   */
   public boolean inRange(int row, int col) {
       boolean range = false;
       if (row >=0 && row < totalrow && col>=0 && col <totalcol)
       {
           range = true;
       }
       return range;       // DUMMY CODE so skeleton compiles
   }
   
   
   /**
      Returns the number of rows in the field.
      @return number of rows in the field
   */  
   public int numRows() {
      return totalrow;       // DUMMY CODE so skeleton compiles
   }
   
   
   /**
      Returns the number of columns in the field.
      @return number of columns in the field
   */    
   public int numCols() {
      return totalcol;       // DUMMY CODE so skeleton compiles
   }
   
   
   /**
      Returns whether there is a mine in this square
      @param row  row of the location to check
      @param col  column of the location to check
      @return whether there is a mine in this square
      PRE: inRange(row, col)   
   */    
   public boolean hasMine(int row, int col) {
       assert inRange(row,col):"row or col not in range";
       return mineData[row][col];       // DUMMY CODE so skeleton compiles
   }
   
   
   /**
      Returns the number of mines you can have in this minefield.  For mines created with the 3-arg constructor,
      some of the time this value does not match the actual number of mines currently on the field.  See doc for that
      constructor, resetEmpty, and populateMineField for more details.
    * @return
    */
   public int numMines() {
       return NofM;       // DUMMY CODE so skeleton compiles
   }

   
   // <put private methods here>
    ///////////////////test program for MineFieldTester.java///////////////////
   private void test ()
   {
       String str1="T";
       String str2="F";
       for (int i=0; i < mineData.length; i++)
       {
           for (int j=0; j <mineData[0].length; j++)
           {
               if (mineData[i][j]==true)
               {
                   System.out.printf("%-5s",str1);
               }
               else
               {
                   System.out.printf("%-5s",str2);
               }
           }
           System.out.println();
       }
       System.out.println("AdjecentMines");
       for (int i =0; i<mineData.length; i++)
       {
           for (int j =0; j <mineData[0].length; j++)
           {
               System.out.printf("%-5d",numAdjacentMines(i,j));
           }
           System.out.println();
       }
       System.out.println("Number of mines is " + numMines());
       System.out.println("Number of rows is " + numRows());
       System.out.println("Number of columns is " + numCols());

   }

         
}

