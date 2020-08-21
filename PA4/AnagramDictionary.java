// Name:Songda Lei
// USC NetID:songdale
// CS 455 PA4
// Spring 2020

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


/**
 A dictionary of all anagram sets.
 Note: the processing is case-sensitive; so if the dictionary has all lower
 case words, you will likely want any string you test to have all lower case
 letters too, and likewise if the dictionary words are all upper case.
 */

public class AnagramDictionary {
    private Map<String, ArrayList<String>> Diction;
    /**
     Create an anagram dictionary from the list of words given in the file
     indicated by fileName.
     PRE: The strings in the file are unique.
     @param fileName  the name of the file to read from
     @throws FileNotFoundException  if the file is not found
     */
    public AnagramDictionary(String fileName) throws FileNotFoundException {

        Diction = new HashMap<String, ArrayList<String>>();
        try {
            File file = new File(fileName);
            Scanner in = new Scanner(file);
            while (in.hasNextLine()) {
                String word = in.nextLine();
                char [] arr = word.toCharArray();
                Arrays.sort(arr); //sort the char arr into certain order
                String str = new String (arr);//convert the char arr into string
                if (Diction.containsKey(str)){//if the keyset of the map contains the anagram of this word
                    Diction.get(str).add(word);
                }
                else{//if the keyset of map does not contain the anagram of this word
                    ArrayList <String> list = new ArrayList<>();
                    list.add(word);
                    Diction.put(str,list);
                }
            }
            in.close();
        }
        catch (FileNotFoundException e){
            System.out.println("Error: File does not exist: " + fileName);
            throw e;

        }


    }


    /**
     Get all anagrams of the given string. This method is case-sensitive.
     E.g. "CARE" and "race" would not be recognized as anagrams.
     @param s string to process
     @return a list of the anagrams of s
     */
    public ArrayList<String> getAnagramsOf(String s) {
        char [] arr = s.toCharArray();
        Arrays.sort(arr);
        String str = new String (arr);
        if (Diction.containsKey(s)){
        return Diction.get(str);}
        else{
            return new ArrayList<>();// DUMMY CODE TO GET IT TO COMPILE
        }
    }


}

