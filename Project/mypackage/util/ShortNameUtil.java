package Project.mypackage.util;

public class ShortNameUtil {
    public static String getShortName(String fullName) {
        String[] parts = fullName.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (String part : parts) {
            if (!part.isEmpty()) {
                sb.append(part.charAt(0));
                sb.append(".");
            }
        }
        return sb.toString();
    }
}
