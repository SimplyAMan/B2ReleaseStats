import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Methods convertion numbers and strings
 * @author ahuryn
 */
public class DateTimeString {
    /**
     * Convert number to string that consists date and time
     *
     * @param  dateTime number that needs to convert to string
     * @return string that consists date and time
     */
    public static String convertIntToDateTime(int dateTime) {
        String result = "";

        int days = dateTime / (24 * 60 * 60);
        int hours = (dateTime - days * 24 * 60 * 60) / (60 * 60);
        int minutes = (dateTime - days * 24 * 60 * 60 - hours * 60 * 60) / 60;
        int seconds = (dateTime - days * 24 * 60 * 60 - hours * 60 * 60 - minutes * 60);

        result = String.format("%1$02d %2$02d:%3$02d:%4$02d",days,hours,minutes,seconds);

        return result;
    }

    /**
     * Convert string to number of date and time
     *
     * @param  dateTime string that need to convert to number
     * @return number that consist string to number
     */
    public static int convertDateTimeToInt(String dateTime) {
        int result = 0;
        Pattern pattern = Pattern.compile("(\\d{2})\\.(\\d{2})\\.(\\d{4}) (\\d{2}):(\\d{2}):(\\d{2})");
        Matcher matcher = pattern.matcher(dateTime);

        if (matcher.find()) {
            int months = Integer.parseInt(matcher.group(2));
            int yeard = Integer.parseInt(matcher.group(3));
            int days = Integer.parseInt(matcher.group(1));
            int hours = Integer.parseInt(matcher.group(4));
            int minutes = Integer.parseInt(matcher.group(5));
            int seconds = Integer.parseInt(matcher.group(6));
            result = days * 24 * 60 * 60 + hours * 60 * 60 + minutes * 60 + seconds;
        }
        return result;
    }
}
