package mypack;
public class util
{
    private static final String[] UNITS = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    private static final String[] TENS = {"", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
    private static final String[] TEENS = {"", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    private static final String HUNDRED = "hundred";
    private static final String THOUSAND = "thousand";
    public String shortNmae(String fname, String lname)
    {
        String sname=fname.charAt(0)+"."+lname;
        return sname;
    }
    public String numToWords(int num)
    {
    
        if (num == 0) {
            return "zero";
        }

        StringBuilder words = new StringBuilder();

        // handle thousands place
        if (num >= 1000) {
            words.append(numToWords(num / 1000)).append(" ").append(THOUSAND).append(" ");
            num %= 1000;
        }

        // handle hundreds place
        if (num >= 100) {
            words.append(UNITS[num / 100]).append(" ").append(HUNDRED).append(" ");
            num %= 100;
        }

        // handle tens place
        if (num >= 10 && num < 20) {
            words.append(TEENS[num % 10]).append(" ");
            num = 0;
        } else if (num >= 20) {
            words.append(TENS[num / 10]).append(" ");
            num %= 10;
        }

        // handle units place
        if (num > 0) {
            words.append(UNITS[num]).append(" ");
        }

        return words.toString().trim();
    }
}

    
