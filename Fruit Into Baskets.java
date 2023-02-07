//Asked in Google
//Sliding Window Approach
class Solution {
    public int totalFruit(int[] fruits) {
        int start =0;
        int end = 0;
        int maxCount = 0;
        HashMap<Integer, Integer> basket = new HashMap<>();
        while(end < fruits.length){
            //add the fruits to the basket
            basket.put(fruits[end], end++); //need a counter to count
               if(basket.size() <=2)
            maxCount = Integer.max(maxCount, end-start); 
            //if the basket has > 2 types of fruits
            if(basket.size() > 2){
                //remove the min element from the list
                int min = basket.values().stream().mapToInt(Integer::valueOf).min().getAsInt();
                basket.remove(fruits[min]);
                //increment the start pointer the 1
                start = min +1 ;

            } 

        }
        return maxCount;
    }
}
