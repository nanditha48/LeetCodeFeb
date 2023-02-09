
//Time: O(n)
//Space: O(n)
class Solution {
    public long distinctNames(String[] ideas) {
      //Group Suffixes By First Letter
        Set<String>[] suffixesByLetter = new Set[26];
        for(int i=0; i<26; i++) suffixesByLetter[i] = new HashSet<>();
        for(String idea : ideas){
            suffixesByLetter[idea.charAt(0) - 'a'].add(idea.substring(1));


        }
      //Calculate Valid Pairs
        long pairs = 0;
        for(int i=0; i< 26; i++){
            for(int j=i + 1; j<26; j++){
                int overlapping = 0;
                for(String suffix : suffixesByLetter[i]){
                    if(suffixesByLetter[j].contains(suffix)){
                        overlapping++;
                    }
                }
                pairs += (suffixesByLetter[i].size() - overlapping) *
                (suffixesByLetter[j].size() - overlapping) 
                * 2;
            }
        }
        return pairs;
    }
}
