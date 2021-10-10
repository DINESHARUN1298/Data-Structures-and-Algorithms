package dev.dinesh.leetcode.amazon;

import java.util.HashSet;

public class UniqueEmailAddresses {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> uniqueAddresses = new HashSet<>();
        for(String email: emails) {
            StringBuilder address = new StringBuilder();
            for(int index = 0; index < email.length(); index++) {
                char ch = email.charAt(index);
                if(ch == '.') {
                    continue;
                } else if(ch == '+') {
                    while(email.charAt(index) != '@') {
                        index++;
                    }
                    address.append(email.substring(index));
                    break;
                } else if(ch == '@')  {
                    address.append(email.substring(index));
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