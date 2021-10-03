package dev.dinesh.leetcode;

public class RobotReturnToOrigin {
    public boolean judgeCircle(String moves) {
        int UD = 0, LR = 0;
        for(int index = 0; index < moves.length(); index++) {
            switch(moves.charAt(index)) {
                case 'U':
                    UD++;
                    break;
                case 'D':
                    UD--;
                    break;
                case 'L':
                    LR++;
                    break;
                case 'R':
                    LR--;
                    break;
            }
        }
        return LR == 0 && UD == 0;
    }
}