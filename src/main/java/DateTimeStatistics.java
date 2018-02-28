import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Searches the mark of start and finish in full log file
 *
 * @author ahuryn
 */
public class DateTimeStatistics {
    /**
     * Is used for looking start mark in full log file
     *
     * @param  line the line where is looking a start mark
     * @return string that consists day and time of start
     */
    public static String searchForStartString(String line) {
        String result = null;
        String regexp = "============== (\\d{2}\\.\\d{2}\\.\\d{4} \\d{2}:\\d{2}:\\d{2}) запуск ==============";
        /*System.out.println(line);
        System.out.println(regexp);*/
        Pattern pattern = Pattern.compile(regexp);
        Matcher matcher = pattern.matcher(line);
        if (matcher.find()) {
            result = matcher.group(1);
        }
        return result;
    }

    /**
     * Is used for looking finish mark in full log file
     * @param  line the line where is looking a finish mark
     * @return string that consists day and time of finish
     */
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
