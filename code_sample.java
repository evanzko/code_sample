
// Evan Ko
// Coding Sample
// This program will read a line of text from the command line
// and print out the number of unique words

import java.util.*;
import java.io.*;

public class code_sample {
   
   public static void main(String args[]) {
      Scanner in = new Scanner(System.in);
      System.out.print("Please enter a sentence to be parsed: ");
      String[] sentence = in.nextLine().split(" "); // splits the input text into tokens
      Map<String, Integer> dict = parseString(sentence);
      String mostCommon = getMax(dict);
      int unique = dict.keySet().size();
      System.out.println("The number of unique words in this string is " + unique);
      System.out.println("The most common word was " + mostCommon);
   }
   
   // Pre: Accepts a String Array as its argument
   // Post: returns the number of unique Strings in the passed in array
   // returns 0 if the passed in array is empty
   public static Map<String, Integer> parseString(String[] s) {
      Map<String, Integer> dict = new HashMap<String, Integer>();
      for (int i = 0; i < s.length; i++) {
         String temp = s[i];
         if (!dict.containsKey(temp)) {
            dict.put(temp, 1); // put a new key value pair into the dict,
            // the word is the key
         } else {
            dict.put(temp, dict.get(temp) + 1); // increment the value by 1
         }
      }
      return dict;
   }
   
   //Pre:  Accepts a map as a parameter and finds the most Common string
   //Post: returns the most common string in the map, tie breakers are broken by which string comes first
   public static String getMax(Map<String, Integer> d) {
      int freq = 0;
      String max = "";
      for (String s : d.keySet()) {
         int i = d.get(s);
         if (i > freq) {
            freq = i;
            max = s;
         }
      }
      return max;
   }
}