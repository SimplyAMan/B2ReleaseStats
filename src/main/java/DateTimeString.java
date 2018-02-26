import com.sun.xml.internal.ws.api.ha.StickyFeature;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ahuryn
 *         Created 25.02.2018.
 */
public class DateTimeString {
    public static String convertIntToDateTime(int dateTime) {
        String result = "";

        int days = dateTime / (24 * 60 * 60);
        int hours = (dateTime - days * 24 * 60 * 60) / (60 * 60);
        int minutes = (dateTime - days * 24 * 60 * 60 - hours * 60 * 60) / 60;
        int seconds = (dateTime - days * 24 * 60 * 60 - hours * 60 * 60 - minutes * 60);

        result = String.format("%1$02d %2$02d:%3$02d:%4$02d",days,hours,minutes,seconds);

        return result;
    }

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
