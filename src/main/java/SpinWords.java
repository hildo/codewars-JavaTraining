
public class SpinWords {

    public String spinWords(String sentence) {
        StringBuilder sb = new StringBuilder();
        String[] words = sentence.split(" ");
        for (String word : words) {
            if (sb.length() > 0) {
                sb.append(" ");
            }
            if (word.length() < 5) {
                sb.append(word);
            } else {
                sb.append(new StringBuilder(word).reverse().toString());
            }
        }
        return sb.toString();
    }
}
