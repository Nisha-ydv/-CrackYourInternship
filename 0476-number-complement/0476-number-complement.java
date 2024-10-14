class Solution {
    public int findComplement(int num) {
      int digit=(int)(Math.log(num)/Math.log(2))+1;
        int mask=(1<<digit)-1;
        return num^mask;
    }
}