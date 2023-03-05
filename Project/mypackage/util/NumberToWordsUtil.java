package Project.mypackage.util;

public class NumberToWordsUtil {
    private static final String[] UNITS = { "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
            "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen",
            "nineteen" };
    private static final String[] TENS = { "", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty",
            "ninety" };
    private static final String[] THOUSANDS = { "", "thousand", "million", "billion", "trillion" };

    public static String convert(int number) {
        if (number == 0) {
            return "zero";
        }

        StringBuilder sb = new StringBuilder();

        int i = 0;
        while (number > 0) {
            if (number % 1000 != 0) {
                sb.insert(0, convertToWords(number % 1000) + THOUSANDS[i] + " ");
            }
            number /= 1000;
            i++;
        }

        return sb.toString().trim();
    }

    private static String convertToWords(int number) {
        StringBuilder sb = new StringBuilder();
        if (number >= 100) {
            sb.append(UNITS[number / 100]).append(" hundred ");
            number %= 100;
        }
        if (number >= 20) {
            sb.append(TENS[number / 10]).append(" ");
            number %= 10;
        }
        if (number > 0) {
            sb.append(UNITS[number]).append(" ");
        }
        return sb.toString();
    }
}
