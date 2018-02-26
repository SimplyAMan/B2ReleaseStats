import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ahuryn
 *         Created 26.02.2018.
 */
public class DateTimeStatistics {
    public static String searchForStartString(String line) {
        String result = null;
        String regexp = "============== (\\d{2}\\.\\d{2}\\.\\d{4} \\d{2}:\\d{2}:\\d{2}) запуск ==============";
        System.out.println(line);
        System.out.println(regexp);
        Pattern pattern = Pattern.compile(regexp);
        Matcher matcher = pattern.matcher(line);
        if (matcher.find()) {
            result = matcher.group(1);
        }
        return result;
    }
    public static String searchForFinishString(String line) {
        String result = null;
        Pattern pattern = Pattern.compile("============== (\\d{2}\\.\\d{2}\\.\\d{4} \\d{2}:\\d{2}:\\d{2}) стоп " +
                "==============");
        Matcher matcher = pattern.matcher(line);
        if (matcher.find()) {
            result = matcher.group(1);
        }

        return result;
    }
}
