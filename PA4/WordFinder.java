// Name:Songda Lei
// USC NetID:songdale
// CS 455 PA4
// Spring 2020
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

//This is the main class for this program
//responsible for processing the command-line argument, and handling any error processing.
public class WordFinder {
    private static String textfile = "sowpods.txt";
    private static String quit = ".";

    //ask AnagramDictionary to process the txt file
    //read command and transfer the command to rack to create all the anagrams
    //check each anagram is in the txt file or not
    //@param args different dictionary
    public static void main(String[] args) {
        AnagramDictionary Dictionary = null;
        try{
            if(args.length>0){//if the user input a command-line argument
                Dictionary = new AnagramDictionary(args[0]);
            }
            else {
                Dictionary = new AnagramDictionary(textfile);
            }
        } catch (FileNotFoundException e) {
            System.out.println(args[0] + " is a wrong file name!");
            System.exit(0);
            //e.printStackTrace();
        }

        System.out.println("Type " + quit + " to quit.");
        Scanner in = new Scanner(System.in);
        while(true){
            System.out.printf("Rack? ");
            String word = in.nextLine();
            if (word.equals(quit)){//if the user inputs a ., end the while loop
                break;
            }
            else{
                Rack rack = new Rack();
                ArrayList <String> list = rack.output(word);//generate all the anagrams of this word
                int counter =0;
                ArrayList<String> anagrams = new ArrayList<>();
                for (String a:list){
                    if (Dictionary.getAnagramsOf(a).isEmpty()==false){
                        counter +=Dictionary.getAnagramsOf(a).size();
                        anagrams.addAll(Dictionary.getAnagramsOf(a));
                        //add all anagrams that can be found in the txt file into an arraylist
                    }
                }
                System.out.println("We can make " + counter + " words from \"" + word + "\"");
                ScoreTable table = new ScoreTable();
                if(anagrams.size()>0){table.printable(anagrams);} //print the list of score and anagrams
            }
        }

    }
}
