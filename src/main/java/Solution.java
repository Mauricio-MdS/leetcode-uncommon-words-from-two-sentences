import java.util.HashSet;
import java.util.Set;

class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        Set<String> words = new HashSet<>();
        Set<String> unique = new HashSet<>();

        processSentence(s1, words, unique);
        processSentence(s2, words, unique);

        return unique.toArray(new String[0]);
    }

    private static void processSentence(String s1, Set<String> words, Set<String> unique) {
        StringBuilder stringBuilder = new StringBuilder();

        for (char c : s1.toCharArray()) {
            if (Character.isLetter(c)) {
                stringBuilder.append(c);
            } else {
                addWord(words, unique, stringBuilder);
                stringBuilder = new StringBuilder();
            }
        }
        addWord(words, unique, stringBuilder);
    }

    private static void addWord(Set<String> words, Set<String> unique, StringBuilder stringBuilder) {
        if (words.add(stringBuilder.toString())) {
            unique.add(stringBuilder.toString());
        } else {
            unique.remove(stringBuilder.toString());
        }
    }
}