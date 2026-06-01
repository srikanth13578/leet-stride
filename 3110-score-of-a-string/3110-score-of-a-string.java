class Solution {
    public int scoreOfString(String s) {

        int totalScore = 0;

        for(int i = 0;i < s.length() - 1;i ++ ){
            totalScore += Math.abs(s.charAt(i) - s.charAt(i + 1));
        }

        return totalScore;    

    }
}