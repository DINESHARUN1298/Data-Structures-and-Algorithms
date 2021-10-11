package dev.dinesh.leetcode.amazon;

import java.util.HashSet;

public class UniqueEmailAddresses {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> uniqueAddresses = new HashSet<>();
        for(String email: emails) {
            StringBuilder address = new StringBuilder();
            for(int index = 0; index < email.length(); index++) {
                char ch = email.charAt(index);
                int length = email.length();
                if(ch == '.') {
                    continue;
                } else if(ch == '+') {
                    while(email.charAt(index) != '@') {
                        index++;
                    }
                    while(index < length){
                        address.append(email.charAt(index++));
                    }
                    break;
                } else if(ch == '@')  {
                    while(index < length){
                        address.append(email.charAt(index++));
                    }
                    break;
                } else  {
                    address.append(ch);
                }
            }
            uniqueAddresses.add(address.toString());
        }
        return uniqueAddresses.size();
    }
}