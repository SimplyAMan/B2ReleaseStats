import static org.junit.Assert.*;

/**
 * @author ahuryn
 *         Created 26.02.2018.
 */
public class DateTimeStatisticsTest {
    @org.junit.Test
    public void searchForStartString() throws Exception {
        String actual = DateTimeStatistics.searchForStartString("============== 22.01.2018 14:09:02 запуск ==============");
        assertEquals("22.01.2018 14:09:02",actual);
    }
    @org.junit.Test
    public void searchForFinishString() throws Exception {
        String actual = DateTimeStatistics.searchForFinishString("============== 22.01.2018 14:09:02 стоп ==============");
        assertEquals("22.01.2018 14:09:02",actual);
    }
    @org.junit.Test
    public void searchForFinishStringWhereItsNot() throws Exception {
        String actual = DateTimeStatistics.searchForStartString("============== 22.01.2018 14:09:02 стоп ==============");
        assertEquals(null,actual);
    }

}