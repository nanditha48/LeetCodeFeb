//Solved using Sliding Window Approach
//TC = O(n)
class Solution {
    public List<Integer> findAnagrams(String s, String p) {

       int n = s.length();
       int m = p.length(); 
       if(n < m)
       return new ArrayList();

       //Now we will go from m to n and check all the substrings to see whethernthey are equal to p or not
       int[] pfreq = new int[26];
       int[] sfreq = new int[26];
       //Now we will store the freq of all the chracters in p
       for(int i=0; i<m; i++){
           pfreq[p.charAt(i) - 'a']++;

       }
       for(int i=0; i<m; i++){ //m because size of the window would be m
           sfreq[s.charAt(i) - 'a']++;
           
       }
       List<Integer> res = new ArrayList<>();
       for(int i=m; i<n; i++){
           if(Arrays.equals(pfreq, sfreq)){
               res.add(i-m);
           }
           sfreq[s.charAt(i)-'a']++;
           sfreq[s.charAt(i-m)-'a']--;
           
       }
       if(Arrays.equals(pfreq, sfreq)){
           res.add(n-m);
       }
       return res;

    }
}
