import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class of information about file summary statistics
 *
 * @author ahuryn
 */
public class SummaryStatistics {
    private String start;
    private String finish;
    private String duration;
    private String fileName;

    public SummaryStatistics(String[] fileContent, String fileName) {
        this.fileName = fileName;

        for (int i = 0; i < fileContent.length; i++) {
            if(this.start == null) {
                this.start = DateTimeStatistics.searchForStartString(fileContent[i]);
            }
            if(this.finish == null) {
                this.finish = DateTimeStatistics.searchForFinishString(fileContent[i]);
            }
            if(this.start != null && this.finish != null) {
                int finishInInteger = DateTimeString.convertDateTimeToInt(this.finish);
                int startInInteger = DateTimeString.convertDateTimeToInt(this.start);
                int duration = finishInInteger - startInInteger;
                this.duration = DateTimeString.convertIntToDateTime(duration);
            }
        }
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

    public String getFileName() {
        return fileName;
    }
}
