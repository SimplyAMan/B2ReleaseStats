import java.io.*;

/**
 * @author ahuryn
 *         Created 25.02.2018.
 */
public class B2ReleaseStats {
    public static void main(String[] argc) {
        String fileName = "d:\\Temp\\20180224\\300346_3-37-0-24_20180122-1409#1\\Full_300346_22_01_2018_14_27_35.log";
        BufferedReader br;
        SummaryStatistics statistics = new SummaryStatistics();
        try {
            br = new BufferedReader(new InputStreamReader (new FileInputStream(fileName),"Cp1251"));
            String line;
            boolean isStartFound = false;
            boolean isFinishFound = false;
            while ((line = br.readLine()) != null) {
                if(!isStartFound) {
                    isStartFound = statistics.searchForStartString(line);
                }
                else {
                    isFinishFound = statistics.searchForFinishString(line);
                    if (isFinishFound)
                        break;
                }
            }
            System.out.println("start - " + statistics.getStart());
            System.out.println("finish - " + statistics.getFinish());
            System.out.println("duration - " + statistics.getDuration());
        }
        catch (FileNotFoundException e) {
            System.out.println("File " + fileName + " not found");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
