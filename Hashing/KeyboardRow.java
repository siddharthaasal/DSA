import java.util.*;
class KeyboardRow {
    public String[] findWords(String[] words) {
        HashSet<Character> row1 = new HashSet<>();
        HashSet<Character> row2 = new HashSet<>();
        HashSet<Character> row3 = new HashSet<>();
        List<String> ans = new ArrayList<>();
        String r1 = "qwertyuiop";
        String r2 = "asdfghjkl";
        String r3 = "zxcvbnm";
        for (int i = 0; i < r1.length(); i++) {
            char ch = r1.charAt(i);
            row1.add(ch);
        }
        for (int i = 0; i < r2.length(); i++) {
            char ch = r2.charAt(i);
            row2.add(ch);
        }
        for (int i = 0; i < r3.length(); i++) {
            char ch = r3.charAt(i);
            row3.add(ch);
        }

        for (var word : words) {
            String loweWord = word.toLowerCase();
            int inR1 = 0, inR2 = 0, inR3 = 0;
            char[] ch = loweWord.toCharArray();
            for (int i = 0; i < ch.length; i++) {
                if (row1.contains(ch[i])) {
                    inR1++;
                } else if (row2.contains(ch[i])) {
                    inR2++;
                } else {
                    inR3++;
                }
            }
            if (inR1 == ch.length || inR2 == ch.length || inR3 == ch.length) {
                ans.add(word);
            }
        }

        return ans.stream().toArray(String[]::new);
    }
}