package Project.mypackage;

import Project.mypackage.util.ShortNameUtil;
import Project.mypackage.util.NumberToWordsUtil;


public class Main {
    public static void main(String[] args) {


        String fullName = "John Doe";
        String shortName = ShortNameUtil.getShortName(fullName);
        System.out.println("Short name: " + shortName);

        int number = 123456789;
        String words = NumberToWordsUtil.convert(number);
        System.out.println("Number in words: " + words);
    }
}

