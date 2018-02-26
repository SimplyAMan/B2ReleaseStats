import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * @author ahuryn
 *         Created 24.02.2018.
 */
public class SummaryStatisticsTest {
    @org.junit.Test
    public void FileWithoutStartAndFinishData(){
        String[] lines = {
                "Банк - 300346 ПАТ \"АЛЬФА-БАНК\" У М.КИЄВІ\n",
                "Версия ScriptRunner.exe - 3.4.0.1\n",
                "Пользователь - alishnyanskiy\n",
                "Имя компьютера - ALFA\\WD-KV-79561\n"};
        SummaryStatistics summaryStatistics = new SummaryStatistics(lines, "test.txt");
        assertEquals(null,summaryStatistics.getStart());
        assertEquals(null,summaryStatistics.getFinish());
        assertEquals(null,summaryStatistics.getDuration());
    }
    @org.junit.Test
    public void FileWithoutFinishData(){
        String[] lines = {
                "============== 22.01.2018 14:09:02 запуск ==============\n",
                "Банк - 300346 ПАТ \"АЛЬФА-БАНК\" У М.КИЄВІ\n",
                "Версия ScriptRunner.exe - 3.4.0.1\n",
                "Пользователь - alishnyanskiy\n",
                "Имя компьютера - ALFA\\WD-KV-79561\n"};
        SummaryStatistics summaryStatistics = new SummaryStatistics(lines, "test.txt");
        assertEquals("22.01.2018 14:09:02",summaryStatistics.getStart());
        assertEquals(null,summaryStatistics.getFinish());
        assertEquals(null,summaryStatistics.getDuration());
    }
    @org.junit.Test
    public void FileWithStartAndFinish(){
        String[] lines = {
                "============== 22.01.2018 14:09:02 запуск ==============\n",
                "Банк - 300346 ПАТ \"АЛЬФА-БАНК\" У М.КИЄВІ\n",
                "Версия ScriptRunner.exe - 3.4.0.1\n",
                "Пользователь - alishnyanskiy\n",
                "============== 22.01.2018 14:09:04 стоп ==============\n",
                "Имя компьютера - ALFA\\WD-KV-79561\n"};
        SummaryStatistics summaryStatistics = new SummaryStatistics(lines, "test.txt");
        assertEquals("22.01.2018 14:09:02",summaryStatistics.getStart());
        assertEquals("22.01.2018 14:09:04",summaryStatistics.getFinish());
        assertEquals("00 00:00:02",summaryStatistics.getDuration());
    }

}
