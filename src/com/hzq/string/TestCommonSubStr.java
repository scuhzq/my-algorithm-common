package com.hzq.string;

public class TestCommonSubStr {

    public static void main(String[] args) {
        System.out.println(getLCSeqLen("acbcbcecd", "abcbced"));
    }

    //1.获取最长公共子序列
    public static int getLCSeqLen(String s1, String s2){
        int len1, len2;
        if(s1 == null || s2 == null || (len1 = s1.length()) <= 0 || (len2 = s2.length()) <= 0){
            return 0;
        }
        int[][] dp = new int[len1][len2];
        for (int i = 0; i < len1; i++){
            for (int j = 0; j <  len2; j++){
                char chI = s1.charAt(i);
                char chJ = s2.charAt(j);
                //1.判断chI和chJ的关系
                if(chI == chJ){
                    if(i == 0 || j == 0){
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i-1][j-1] + 1;
                    }
                } else {
                    if(i == 0 || j == 0){
                        dp[i][j] = 0;
                    } else {
                        dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                    }
                }
            }
        }
        System.out.println(getLCSeq(s1, s2, dp));
        return dp[len1 - 1][len2 - 1];
    }
    //2.找到最长的公共子序列
    public static String getLCSeq(String s1, String s2, int[][] dp){
        StringBuffer sb = new StringBuffer();
        int i = s1.length(), j = s2.length();
        while (i > 0 && j > 0){
            char chI = s1.charAt(i - 1);//i和j从 endIndex开始，所以要 -1
            char chJ = s2.charAt(j - 1);
            if(chI == chJ){
                sb.append(chI);
                i--;
                j--;
            } else {
                int m1 = dp[i-1][j];
                int m2 = dp[i][j-1];
                if(m1 == m2){
                    i--;
                } else if(m1 > m2){
                    i--;
                } else {
                    j--;
                }
            }
        }
        return sb.reverse().toString();
    }

    //获取最长公共子串
    public static String getLCStr(String s1, String s2){
        int len1, len2;
        if(s1 == null || s2 == null || (len1 = s1.length()) <= 0 || (len2 = s2.length()) <= 0){
            return "";
        }
        int[][] dp = new int[len1][len2];
        int maxLen = 0, maxEnd = 0;
        for (int i = 0; i < len1; i++){
            for (int j = 0; j < len2; j++){
                char chI = s1.charAt(i);
                char chJ = s2.charAt(j);
                //1.判断chI和chJ的关系
                if(chI == chJ){
                    if(i == 0 || j == 0){
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i-1][j-1] + 1;
                    }
                } else {
                    dp[i][j] = 0;
                }
                //2.更新maxLen
                if(dp[i][j] > maxLen){
                    maxLen = dp[i][j];
                    maxEnd = i;
                }
            }
        }
        return s1.substring(maxEnd - maxLen + 1, maxEnd + 1);
    }

}
