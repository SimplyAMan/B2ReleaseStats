import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ahuryn
 *         Created 24.02.2018.
 */
public class SummaryStatistics {
    private String start;
    private String finish;
    private String duration;

    public boolean searchForStartString(String line) {
        boolean result = false;
        Pattern pattern = Pattern.compile("============== (\\d{2}\\.\\d{2}\\.\\d{4} \\d{2}:\\d{2}:\\d{2}) запуск " +
                "==============");
        Matcher matcher = pattern.matcher(line);
        result = matcher.find();
        if (result) {
            this.start = matcher.group(1);
        }

        return result;
    }

    public boolean searchForFinishString(String line) {
        boolean result = false;
        Pattern pattern = Pattern.compile("============== (\\d{2}\\.\\d{2}\\.\\d{4} \\d{2}:\\d{2}:\\d{2}) стоп " +
                "==============");
        Matcher matcher = pattern.matcher(line);
        result = matcher.find();
        if (result) {
            this.finish = matcher.group(1);
            int finishInInteger = DateTimeString.convertDateTimeToInt(this.finish);
            if (this.start != null) {
                int startInInteger = DateTimeString.convertDateTimeToInt(this.start);
                int duration = finishInInteger - startInInteger;
                this.duration = DateTimeString.convertIntToDateTime(duration);
            }
        }

        return result;
    }

    public String getStart() {
        return start;
    }

    public String getFinish() {
        return finish;
    }

    public String getDuration() {
        return duration;
    }
}
