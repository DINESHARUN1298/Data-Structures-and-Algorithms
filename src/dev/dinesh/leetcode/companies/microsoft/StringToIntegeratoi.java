package dev.dinesh.leetcode.companies.microsoft;

public class StringToIntegeratoi {

    public int myAtoi(String s) {

        boolean signPositive = true;
        int result = 0;
        int index = 0;
        int len = s.length();

        while(index < len && s.charAt(index) == ' ') {
            index++;
        }

        if(index < len && s.charAt(index) == '+') {
            index++;
        } else if(index < len && s.charAt(index) == '-') {
            signPositive = false;
            index++;
        }

        while(index < len && Character.isDigit(s.charAt(index))) {

            if((result > Integer.MAX_VALUE / 10) ||(result == Integer.MAX_VALUE / 10 && s.charAt(index) - '0' > Integer.MAX_VALUE % 10)) {
                return signPositive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = 10 * result + s.charAt(index) - '0';
            index++;

        }

        return signPositive ? result : result * -1;

    }

}