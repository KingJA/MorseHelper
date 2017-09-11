package sample.kingja.morsehelper;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:TODO
 * Create Time:2017/9/7 15:44
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class MorseUtil {
    private static final long T = 40;
    private static final boolean DOT = true;
    private static final boolean DASH = false;
    public static final Map<String, Boolean[]> morses = new HashMap<>();
    public static final long TIME_DOT = 1 * T;
    public static final long TIME_DASH = 2 * T;
    public static final long TIME_DOT_DASH = 1 * T;
    public static final long TIME_LETTER_LETTER = 2 * T;
    public static final long TIME_WORD_WORD = 7 * T;

    public static final String[] MORSE_CHAR = {"0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "A", "B",
            "C", "D", "E", "F", "G", "H",
            "I", "J", "K", "L", "M", "N",
            "O", "P", "Q", "R", "S", "T",
            "U", "V", "W", "X", "Y", "Z", "{", "}"};


    public int hex2dec(String hexStr) {
        return Integer.valueOf(hexStr, 16);
    }
}

