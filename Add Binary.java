class Solution {
    public String addBinary(String a, String b) {
        StringBuilder ans = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        while(i>=0 || j>=0){
            int sum = carry;
            sum += a.charAt(i) - '0';
            sum += b.charAt(j) - '0';
            ans.append(sum % 2);
            carry = sum / 2;

            i--;
            j--;
        }
        if(carry != 0)ans.append(carry);
        return ans.reverse().toString();
    }
}
