
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class Mixing {

    public static String mix(String s1, String s2) {
        if (s1.equals(s2)) {
            return "";
        }
        Map<Character, String> s1Map = buildLowercaseCountMap(s1);
        Map<Character, String> s2Map = buildLowercaseCountMap(s2);
        List<String> strings = mergeMaps(s1Map, s2Map);
        strings.sort(Mixing::compare);
        return strings.stream().collect(Collectors.joining("/"));
    }
    
    private static int compare(String s1, String s2) {
        String s1Value = s1.substring(2);
        String s2Value = s2.substring(2);
        if (s1Value.length() == s2Value.length()) {
            char s1Group = s1.charAt(0);
            char s2Group = s2.charAt(0);
            
            if (s1Group == s2Group) {
                // they are the same, sort by the letter
                return s1.substring(2, 3).compareTo(s2.substring(2, 3));
            } else {
                if (s1Group == '=') {
                    return 1;
                } else if (s2Group == '=') {
                    return -1;
                } else {
                    return s1Group - s2Group;
                }
            }
        } else {
            return s2Value.length() - s1Value.length();
        }
    }
    
    private static Map<Character, String> buildLowercaseCountMap(String s) {
        Map<Character, String> counts = new java.util.HashMap<>();
        s.chars().forEach(c -> checkChar((char) c, counts));
        Map<Character, String> returnValue = new java.util.HashMap<>();
        for (Map.Entry<Character, String> entry : counts.entrySet()) {
            if (entry.getValue().length() > 1) {
                returnValue.put(entry.getKey(), entry.getValue());
            }
        }
        return returnValue;
    }
    
    private static void checkChar(Character c, Map<Character, String> map) {
        if (Character.isLetter(c) && Character.isLowerCase(c)) {
            if (map.containsKey(c)) {
                String value = map.get(c);
                map.put(c, value + c);
            } else {
                map.put(c, String.valueOf(c));
            }
        }
    }
    
    private static List<String> mergeMaps(Map<Character, String> map1, Map<Character, String> map2) {
        List<String> returnValue = new java.util.ArrayList<>();
        for (Map.Entry<Character, String> m1Entry : map1.entrySet()) {
            if (map2.containsKey(m1Entry.getKey())) {
                String m2Value = map2.get(m1Entry.getKey());
                if (m1Entry.getValue().length() > m2Value.length()) {
                    returnValue.add("1:" + m1Entry.getValue());
                } else if (m1Entry.getValue().length() < m2Value.length()) {
                    returnValue.add("2:" + m2Value);
                } else {
                    returnValue.add("=:" + m2Value);
                }
            } else {
                returnValue.add("1:" + m1Entry.getValue());
            }
        }
        for (Map.Entry<Character, String> m2Entry : map2.entrySet()) {
            if (!(map1.containsKey(m2Entry.getKey()))) {
                returnValue.add("2:" + m2Entry.getValue());
            }
        }
        return returnValue;
    }
}
