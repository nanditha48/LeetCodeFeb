//zigzag order
//we can use a string builder or a list to represent a row 
//combine it into one string builder
//We use a string builder because when we append a character on sb it takes constant time while list takes linear complexity.

class Solution {
    public String convert(String s, int numRows) {
        //Define StringBuilder
        StringBuilder[] sbs = new StringBuilder[numRows];
        for(int i=0; i< numRows; i++){
            sbs[i] = new StringBuilder();
        }
        //Defining the variables
        char[] arr = s.toCharArray();
        int n = arr.length;
        int index = 0;
        
        //Traverse the zig zag
        while(index < n){
            //Going Down
            for(int j=0; j<numRows && index<n; j++){
                sbs[j].append(arr[index++]);
            }
            //Go up
            for(int j= numRows-2; j>0 && index < n; j--){
                sbs[j].append(arr[index++]);
            }
        }
        //Combine all the stringbuilders to one
        StringBuilder res = sbs[0];
        for(int i=1; i<numRows; i++){
            res.append(sbs[i].toString());
        }
        return res.toString();
    }
}
