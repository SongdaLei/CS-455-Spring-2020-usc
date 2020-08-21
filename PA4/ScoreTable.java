// Name:Songda Lei
// USC NetID:songdale
// CS 455 PA4
// Spring 2020
import java.util.*;

public class ScoreTable {

//    This class has information about Scrabble scores for scrabble letters and words. In scrabble not every letter
//    has the same value. Letters that occur more often in the English language are worth less (e.g., 'e' and 's' are
//    each worth 1 point), and letters that occur less often are worth more (e.g., 'q' and 'z' are worth 10 points
//    each). Here are all the letter values:
//            (1 point)-A, E, I, O, U, L, N, S, T, R
//            (2 points)-D, G
//            (3 points)-B, C, M, P
//            (4 points)-F, H, V, W, Y
//            (5 points)-K
//            (8 points)- J, X
//            (10 points)-Q, Z
    private int table [] = new int []
        {1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10};
    private Map <String,Integer> scoremap;

    //compute scores of all the words in an arraylist
    //@param arraylist of words that to compute scores of each word
    //@return a treemap of words(Key) and scores(value)
    private Map<String,Integer> scoremap(ArrayList<String> list){
        scoremap = new TreeMap<>();
        for (String a: list ){
            String a1 = a.toLowerCase();
            char []arr = a1.toCharArray();
            int wordscore =0;
            for (Character b: arr){
                wordscore += table[b-'a'];
            }
            scoremap.put(a,wordscore);
        }
        return scoremap;
    }

    //@param arraylist of words that to compute all the scores of each word
    //use scoremap fucntion to compute the score
    //use comparator to sort the word
    //print all the entry in the map according to score order
    public void printable (ArrayList <String> list) {
        Map<String,Integer> scoremap2 = scoremap(list);
        ArrayList<Map.Entry<String,Integer>> listofentry = new ArrayList<>();
        for (Map.Entry<String,Integer> a : scoremap2.entrySet())
        {
            listofentry.add(a);
        }
        Collections.sort(listofentry, new SortComparator());
        System.out.println("All of the words with their scores (sorted by score):");
        for (Map.Entry entry: listofentry){
            System.out.println(entry.getValue()+": "+entry.getKey());
        }

    }

    //use comparator to rearrange all entries in the map
    class SortComparator implements Comparator<Map.Entry<String, Integer>>{
        public int compare (Map.Entry<String,Integer>a, Map.Entry<String,Integer>b){
            return b.getValue()- a.getValue();
        }
    }



}
