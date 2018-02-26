import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author ahuryn
 *         Created 25.02.2018.
 */
public class DateTimeStringTest {
    @Test
    public void convertSecondsToInt() throws Exception {
        int actual = DateTimeString.convertDateTimeToInt("00.01.2018 00:00:02");
        assertEquals(2,actual);
    }
    @Test
    public void convertMinutesToInt() throws Exception {
        int actual = DateTimeString.convertDateTimeToInt("00.01.2018 00:01:00");
        assertEquals(60,actual);
    }
    @Test
    public void convertMinutesWithSecondsToInt() throws Exception {
        int actual = DateTimeString.convertDateTimeToInt("00.01.2018 00:01:10");
        assertEquals(70,actual);
    }
    @Test
    public void convertHoursToInt() throws Exception {
        int actual = DateTimeString.convertDateTimeToInt("00.01.2018 02:00:00");
        assertEquals(7200,actual);
    }
    @Test
    public void convertHoursWithMinutesToInt() throws Exception {
        int actual = DateTimeString.convertDateTimeToInt("00.01.2018 02:10:00");
        assertEquals(7800,actual);
    }
    @Test
    public void convertHoursWithMinutesAndSecondsToInt() throws Exception {
        int actual = DateTimeString.convertDateTimeToInt("00.01.2018 02:10:30");
        assertEquals(7830,actual);
    }
    @Test
    public void convertIntHoursAndMinutesAndSecondsToDateTime() throws Exception {
        assertEquals("00 02:10:30",DateTimeString.convertIntToDateTime(7830));
    }
    @Test
    public void convertIntHoursWithMinutesToDateTime() throws Exception {
        assertEquals("00 02:10:00",DateTimeString.convertIntToDateTime(7800));
    }

}