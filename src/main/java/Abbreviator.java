import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class Abbreviator {
    
    private static final String[] DELIMETERS = new String[] {" ", "-", "'"};

    private String abbreviateWord(String word) {
        if (word.length() < 4) {
            return word;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(word.charAt(0));
            sb.append(word.length() - 2);
            sb.append(word.charAt(word.length() - 1));
            return sb.toString();
        }
    }
    
    private List<String> findWords(String delimeter, List<String> input) {
        List<String> returnValue = new java.util.ArrayList<>();
        for (String text : input) {
            returnValue.addAll(Arrays.asList(text.split(delimeter)));
        }
        return returnValue;
    }

    private String alphaOnly(String input) {
        StringBuilder sb = new StringBuilder();
        char[] chars = input.toCharArray();
        for (char c : chars) {
            if (Character.isAlphabetic(c)) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
    
    private Collection<String> checkedWords(Collection<String> input) {
        Collection<String> returnValue = new java.util.HashSet<>();
        for (String inputWord : input) {
            returnValue.add(alphaOnly(inputWord));
        }
        return returnValue;
    }
    
    private Map<String, String> getDictionary(List<String> input) {
        List<String> words = input;
        for (String delimeter : DELIMETERS) {
            words = findWords(delimeter, words);
        }
        Collection<String> checkedWords = checkedWords(words);
        Map<String, String> returnValue = new java.util.HashMap<>();
        for (String word : checkedWords) {
            String abbrev = abbreviateWord(word);
            if (!(abbrev.equals(word))) {
                returnValue.put(word, abbrev);
            }
        }
        return returnValue;
    }
    
    public String abbreviate(String string) {
        String returnValue = string;
        Map<String, String> dictionary = getDictionary(Collections.singletonList(string));
        
        List<String> keys = new java.util.ArrayList();
        keys.addAll(dictionary.keySet());
        Collections.sort(keys, 
            (Comparator<String>) (k1, k2) -> {
                int diff = k1.length() - k2.length();
                if (diff > 0) {
                    return -1;
                } else if (diff < 0) {
                    return 1;
                } else {
                    return 0;
                }
            }
        );
        
        for (String key : keys) {
            returnValue = returnValue.replaceAll(key, dictionary.get(key));
        }
        return returnValue;
    }

}
