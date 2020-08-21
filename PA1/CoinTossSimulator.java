//Name: Songda Lei
//USC NetId:8374371181
//CSCI 455 PA1
//Spring 2020

import java.util.Random;

/**
 * class CoinTossSimulator
 * 
 * Simulates trials of repeatedly tossing two coins and allows the user to access the
 * cumulative results.
 * 
 * NOTE: we have provided the public interface for this class.  Do not change
 * the public interface.  You can add private instance variables, constants, 
 * and private methods to the class.  You will also be completing the 
 * implementation of the methods given. 
 * 
 * Invariant: getNumTrials() = getTwoHeads() + getTwoTails() + getHeadTails()
 * 
 */
public class CoinTossSimulator {
   int twoheads;
   int twotails;
   int oneheadonetail;
   int totaltrails;


   /**
      Creates a coin toss simulator with no trials done yet.
   */
   public CoinTossSimulator() {
      int twoheads=0;
      int twotails=0;
      int oneheadonetail=0;
      int totaltrails=0;

   }


   /**
      Runs the simulation for numTrials more trials. Multiple calls to this method
      without a reset() between them *add* these trials to the current simulation.
      
      @param numTrials  number of trials to for simulation; must be >= 1
    */
   public void run(int numTrials) {

      for (int i = numTrials; i>0; i--)
      {
         Random random = new Random();
         int toss1 = random.nextInt(2);;
         int toss2 = random.nextInt(2);;
         if (toss1 + toss2 == 2)
         {
            twoheads ++;
         }
         else if (toss1 + toss2 == 0)
         {
            twotails ++;
         }
         else if (toss1 + toss2 == 1)
         {
            oneheadonetail ++;
         }
      }

      totaltrails = totaltrails + numTrials;
 
   }


   /**
      Get number of trials performed since last reset.
   */
   public int getNumTrials() {
       return totaltrails; // DUMMY CODE TO GET IT TO COMPILE
   }


   /**
      Get number of trials that came up two heads since last reset.
   */
   public int getTwoHeads() {
       return twoheads; // DUMMY CODE TO GET IT TO COMPILE
   }


   /**
     Get number of trials that came up two tails since last reset.
   */  
   public int getTwoTails() {
       return twotails; // DUMMY CODE TO GET IT TO COMPILE
   }


   /**
     Get number of trials that came up one head and one tail since last reset.
   */
   public int getHeadTails() {
       return oneheadonetail; // DUMMY CODE TO GET IT TO COMPILE
   }


   /**
      Resets the simulation, so that subsequent runs start from 0 trials done.
    */
   public void reset() {
      twoheads = 0;
      twotails = 0;
      oneheadonetail = 0;
      totaltrails = 0;
   }

}
