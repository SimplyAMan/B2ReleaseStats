import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ahuryn
 *         Created 25.02.2018.
 */
public class B2ReleaseStats {
    public static void main(String[] argc) {
//        File f = new File("d:\\Temp\\20180224\\300346_3-37-0-24_20180122-1409#1");
        if (argc.length < 1) {
            System.out.println("Usage: B2ReleaseStats <path>");
            return;
        }

        File f = new File(argc[0]);
        File[] matchingFiles = f.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.startsWith("Full_") && name.endsWith("log");
            }
        });

        for (int i = 0; i < matchingFiles.length; i++) {
            String fileName = matchingFiles[i].getAbsolutePath();
            SummaryStatistics summaryStatistics = getStatistics(fileName);

            System.out.println(
                    summaryStatistics.getFileName() + "\t"
                            + summaryStatistics.getStart() + "\t"
                            + summaryStatistics.getFinish() + "\t"
                            + summaryStatistics.getDuration());
        }
    }

    public static SummaryStatistics getStatistics(String fullFileName) {
        BufferedReader br;
        SummaryStatistics summaryStatistics = null;
        List<String> contentOfFile = new ArrayList<>();
        try {
            br = new BufferedReader(new InputStreamReader (new FileInputStream(fullFileName),"Cp1251"));
            String line;
            while ((line = br.readLine()) != null) {
                contentOfFile.add(new String(line.getBytes("UTF-8")));
            }
            summaryStatistics = new SummaryStatistics(contentOfFile.toArray(new String[contentOfFile
                    .size()]), new File(fullFileName).getName());
        }
        catch (FileNotFoundException e) {
            System.out.println("File " + fullFileName + " not found");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return summaryStatistics;
    }
}
