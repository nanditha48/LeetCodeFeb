//Solved using Sliding Window
//Running Time: O(t)
//Space Complexity: O(1)

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length() || s2.length() == 0) return false;
        if(s1.length() == 0) return true;

        int x = s1.length() ; int y = s2.length();
        int[] array1 = new int[26]; //taking up 26 as the size
        int[] array2 = new int[26];

        for(int i=0; i<x; i++){
            array1[s1.charAt(i) - 'a']++; //a here is the first index
            array2[s2.charAt(i) - 'a']++; //a here is the first index
        }
        //Loop through the last of the windows
        for(int i=x; i<y; i++){
            if(Arrays.equals(array1, array2)){
                return true;
            }
            array2[s2.charAt(i-x) - 'a']--; //pop out the previous element of array2 from the window
            array2[s2.charAt(i) - 'a']++;   //add in the next element to the window
        }
        if(Arrays.equals(array1, array2))return true;
        else return false;
    }
}
