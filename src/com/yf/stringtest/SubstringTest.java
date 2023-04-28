package com.yf.stringtest;


public class SubstringTest {
    
    public static void main(String[] args) {
        String myStr= "This is my String";
        
        /*
            First method receives the initial position and returns from this initial position to the last of string
            Position starts with 0.
        */
        System.out.println("First substr Method result = " + myStr.substring(5));
        System.out.println("OtherString".substring(5));
        
        
        /*
            Second method receives 2 parameters. initial position and last position
            IMPORTANT: First position is included in returning string, but Last position doesn't
        */
        
        System.out.println("Good Morning all".substring(1, 11));
        
        
        /*Example of find a String inside other String*/        
        String wordSearch = "udemy.com";
        String strToSearch = "This is the study from udemy.com, I am happy with this :|";
        int firstIndex = strToSearch.indexOf(wordSearch);
        int lastIndex = firstIndex + wordSearch.length();
        System.out.println(strToSearch.substring(firstIndex, lastIndex));
        
        //The letters of an String :|
        for (int i =0; i < wordSearch.length(); i++) {
            String letter = wordSearch.substring(i, i + 1);
            System.out.println("letter = " + letter);
        }
        
    }
}
