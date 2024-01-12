package in.org.utilities;

import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.*;

public final class DateTimeFormatUtility {

    private DateTimeFormatUtility() {}

    public static String getCurrentDateAndTime(String dateAndTime) {
        return new SimpleDateFormat(dateAndTime).format(new Date());
    }

    public static String getCurrentTime(String time) {
        return LocalTime.now().format(DateTimeFormatter.ofPattern(time));
    }

    public static String getCurrentDay() {
        return LocalDate.now().getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.getDefault());
    }

    public static String getGmtTimeandDate(String gmtTime) {
        DateFormat dateFormat = new SimpleDateFormat(gmtTime);
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return dateFormat.format(new Date());
    }

    public static String getGmtDay() {
        return LocalDate.now().getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.getDefault());
    }

    public static double getLocalTemp() throws IOException {
        URL url = new URL("https://api.openweathermap.org/data/2.5/weather?"
                + "lat=19.151850&lon=72.937088&appid=39d6e113ba973b83f4756906d29de267&units=metric");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        Scanner scanner = new Scanner(con.getInputStream());
        String response = scanner.useDelimiter("\\A").next();
        scanner.close();

        JSONObject json = new JSONObject(response);
        return json.getJSONObject("main").getDouble("temp");
    }

    public static List<String> getNumberOfDaysInBetween(List<String> startDates, String currentDateAndTime) {
        List<String> diffInDaysValues = new ArrayList<>();

        for(String startDate : startDates) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try{
                Date start = simpleDateFormat.parse(startDate);
                Date end = simpleDateFormat.parse(currentDateAndTime);
                String diffInDays = String.valueOf((end.getTime() - start.getTime()) / (24 * 60 * 60 * 1000));
                diffInDaysValues.add(diffInDays);
            }
            catch(Exception ignored) {}
        }
        return diffInDaysValues;
    }
}