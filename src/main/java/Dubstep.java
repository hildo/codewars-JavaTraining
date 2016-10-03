public class Dubstep {

    public static String SongDecoder(String song) {
        String returnValue = song;
        int wubIndex = returnValue.indexOf("WUB");
        while (wubIndex != -1) {
            if ((wubIndex > 0) && (returnValue.substring(wubIndex -1, wubIndex).equals(" "))) {
                returnValue = returnValue.replaceFirst("WUB", "");
            } else {
                returnValue = returnValue.replaceFirst("WUB", " ");
            }
            wubIndex = returnValue.indexOf("WUB");
        }
        return returnValue.trim();
    }
}
