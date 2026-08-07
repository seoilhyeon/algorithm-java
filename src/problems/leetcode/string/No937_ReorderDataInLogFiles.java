package problems.leetcode.string;

import java.util.*;

public class No937_ReorderDataInLogFiles {

    class Solution {
        public String[] reorderLogFiles(String[] logs) {
            List<String> letterLogs = new ArrayList<>();
            List<String> digitLogs = new ArrayList<>();

            for (String log : logs) {
                String[] idAndWords = log.split(" ", 2);
                if (Character.isDigit(idAndWords[1].charAt(0))) digitLogs.add(log);
                else letterLogs.add(log);
            }

            letterLogs.sort((e1, e2) -> {
                String[] idAndWords1 = e1.split(" ", 2);
                String[] idAndWords2 = e2.split(" ", 2);

                int comp = idAndWords1[1].compareTo(idAndWords2[1]);
                if (comp != 0) {
                    return comp;
                }
                return idAndWords1[0].compareTo(idAndWords2[0]);
            });

            List<String> result = letterLogs;
            result.addAll(digitLogs);

            return result.toArray(new String[0]);
        }
    }
}