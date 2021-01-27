// Rabin-Karp Algorithm
// Time Complexity: O(nm)
// Space Complexity: O(1)
// can be used when multiple pattern has the same length.
// Plagarism detection

import java.util.ArrayList;
import java.util.List;

public class RabinKarpSearch{
    private int prime = 101;

    private List<Integer> patternSearch(String t, String p){
        char[] text = t.toCharArray();
        char[] pattern = p.toCharArray();

        int m = pattern.length;
        int n = text.length;
        long patternHash = createHash(pattern, m-1);
        long textHash = createHash(text, m-1);
        List<Integer> arr = new ArrayList<>();
        for (int i=1; i <= n-m+1; i++){
            if(patternHash == textHash && checkEqual(text, i-1, i+m-2, pattern, 0, m-1)){
                // First Start Index
                arr.add(i-1);
            }
            if(i < n-m+1){
                textHash = recalculateHash(text, i-1, i+m-1, textHash, m);
            }
        }
        return arr;
    }

    private long recalculateHash(char[] str, int oldIndex, int newIndex, long oldHash, int patternLen){
        long newHash = oldHash - str[oldIndex];
        newHash /= prime;
        newHash += str[newIndex] * Math.pow(prime, patternLen-1);
        return newHash;
    }

    private long createHash(char[] str, int end){
        long hash = 0;
        for (int i=0; i<=end; i++){
            hash += str[i] * Math.pow(prime,i);
        }
        return hash;
    }

    private boolean checkEqual(char[] str1, int start1, int end1, char[] str2, int start2, int end2){
        if(end1-start1 != end2-start2){
            return false;
        }
        while (start1<=end1 && start2<=end2){
            if(str1[start1] != str2[start2]){
                return false;
            }
            start1++;
            start2++;
        }
        return true;
    }

    public static void main(String args[]){
        RabinKarpSearch rks = new RabinKarpSearch();
        System.out.println(rks.patternSearch("AABAACAADAABAABA", "AABA"));
        // 0, 9, 12
    }
}
