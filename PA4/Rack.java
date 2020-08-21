// Name:Songda Lei
// USC NetID:songdale
// CS 455 PA4
// Spring 2020

import java.util.*;

/**
 A Rack of Scrabble tiles
 */

public class Rack {

    //convert the string word to a string with no duplicate letter
    //save the multiplicity of letters in an array
    //use allSubsets to generate the all the anagrams
    //@param the word we want to generate all of its anagrams
    //@return an arraylist of all the anagrams of that word
    public ArrayList <String> output(String word){
        Map<Character, Integer> map = new TreeMap<>();
        char arr[]=word.toCharArray();
        for (int i =0; i<arr.length; i++){
            if (map.containsKey(arr[i])){
                map.put(arr[i], map.get(arr[i])+1);
            }else{
                map.put(arr[i], 1);
            }
        } //put the word into a map of character and multiplicity of that character

        //convert the map into a string with no duplicate letter and a multiplicity array
        String str = "";
        int [] mult = new int [map.size()];
        int i =0;
        for (Map.Entry<Character,Integer> entry: map.entrySet()){
            mult[i] = entry.getValue();
            i++;
            str = str + entry.getKey();
        }

        ArrayList <String> list = allSubsets(str, mult,0);
        list.remove(0);//remove the first empty element
        return list;
    }




    /**
     Finds all subsets of the multiset starting at position k in unique and mult.
     unique and mult describe a multiset such that mult[i] is the multiplicity of the char
     unique.charAt(i).
     PRE: mult.length must be at least as big as unique.length()
     0 <= k <= unique.length()
     @param unique a string of unique letters
     @param mult the multiplicity of each letter from unique.
     @param k the smallest index of unique and mult to consider.
     @return all subsets of the indicated multiset.  Unlike the multiset in the parameters,
     each subset is represented as a String that can have repeated characters in it.
     @author Claire Bono
     */
    private static ArrayList<String> allSubsets(String unique, int[] mult, int k) {
        ArrayList<String> allCombos = new ArrayList<>();

        if (k == unique.length()) {  // multiset is empty
            allCombos.add("");
            return allCombos;
        }

        // get all subsets of the multiset without the first unique char
        ArrayList<String> restCombos = allSubsets(unique, mult, k+1);

        // prepend all possible numbers of the first char (i.e., the one at position k)
        // to the front of each string in restCombos.  Suppose that char is 'a'...

        String firstPart = "";          // in outer loop firstPart takes on the values: "", "a", "aa", ...
        for (int n = 0; n <= mult[k]; n++) {
            for (int i = 0; i < restCombos.size(); i++) {  // for each of the subsets
                // we found in the recursive call
                // create and add a new string with n 'a's in front of that subset
                allCombos.add(firstPart + restCombos.get(i));
            }
            firstPart += unique.charAt(k);  // append another instance of 'a' to the first part
        }

        return allCombos;
    }


}

