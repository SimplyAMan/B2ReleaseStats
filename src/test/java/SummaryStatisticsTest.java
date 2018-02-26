import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * @author ahuryn
 *         Created 24.02.2018.
 */
public class SummaryStatisticsTest {
    @org.junit.Test
    public void searchForStartString() throws Exception {
        SummaryStatistics statistics = new SummaryStatistics();
        boolean actual = statistics.searchForStartString("============== 22.01.2018 14:09:02 запуск ==============");
        assertEquals(true,actual);
        assertEquals("22.01.2018 14:09:02",statistics.getStart());
    }
    @org.junit.Test
    public void searchForFinishString() throws Exception {
        SummaryStatistics statistics = new SummaryStatistics();
        boolean actual = statistics.searchForFinishString("============== 22.01.2018 14:09:02 стоп ==============");
        assertEquals(true,actual);
        assertEquals("22.01.2018 14:09:02",statistics.getFinish());
    }
    @org.junit.Test
    public void getDuration() throws Exception {
        SummaryStatistics statistics = new SummaryStatistics();
        boolean isStartExists = statistics.searchForStartString("============== 22.01.2018 14:09:02 запуск " +
                "==============");
        boolean isFinishExists = statistics.searchForFinishString("============== 22.01.2018 14:09:04 стоп " +
                "==============");
        assertEquals("22.01.2018 14:09:04",statistics.getFinish());
    }
    @org.junit.Test
    public void getDurationWhenFinishInAnotherDay() throws Exception {
        SummaryStatistics statistics = new SummaryStatistics();
        boolean isStartExists = statistics.searchForStartString("============== 22.01.2018 23:53:02 запуск " +
                "==============");
        boolean isFinishExists = statistics.searchForFinishString("============== 23.01.2018 00:02:04 стоп " +
                "==============");
        assertEquals("00 00:09:02",statistics.getDuration());
    }

}
