class Solution {
    public int shipWithinDays(int[] weights, int D) {
        int min = 0;
        int max = 0;
        
        for (int w : weights) {
            min = Math.max(w, min);
            max += w;
        }
        
        int retVal = 0;
        while(min <= max) { // O( log(max - min) )
            int mid = (min + max) / 2;
            int daysRequired = numberOfDaysNeededWithCapacity(weights, mid); // O(n)
            
            if (daysRequired > D) {
                min = mid + 1;
            } else {
                retVal = mid;
                max = mid - 1;
            }
            
        }
        return retVal;
    }
    
    private int numberOfDaysNeededWithCapacity(int[] weights, int capacity) {
        int daysRequired = 1;
        int current = 0;
        
        for (int w : weights) {
            current += w;
            if (current > capacity) {
                daysRequired++;
                current = w;
            }
        }
        return daysRequired;
    }
}
