package dev.dinesh.leetcode.contests.contest3;

public class TimeNeededToBuyTickets {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int loopCnt = tickets[k],timeTaken = 0;
        while(loopCnt > 0) {
            for(int index = 0; index < tickets.length; index++) {
                if(tickets[index] > 0) {
                    tickets[index]--;
                    timeTaken++;
                }
                if(loopCnt == 1 && index == k) {
                    return timeTaken;
                }
            }
            loopCnt--;
        }
        return -1;
    }
}