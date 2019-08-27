package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTimeHelper {
    // Convert 2/12/2019 1800 to 2nd of December 2019, 6pm
    public String getFormattedDate(String date) {
        SimpleDateFormat inputFormat = new SimpleDateFormat("dd/M/yyyy HHmm");
        Date formattedDate = new Date();

        try {
            formattedDate = inputFormat.parse(date);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }

        int hour = Integer.parseInt(new SimpleDateFormat("h").format(formattedDate));
        int min = Integer.parseInt(new SimpleDateFormat("m").format(formattedDate));
        String period = (new SimpleDateFormat("a").format(formattedDate)).toLowerCase();
        String timeFormat;

        if (min > 0)
            timeFormat = hour + "." + min + " " + period;
        else
            timeFormat = hour + " " + period;

        Calendar cal=Calendar.getInstance();
        cal.setTime(formattedDate);
        int day=cal.get(Calendar.DATE);

        if(!((day>10) && (day<19)))
            switch (day % 10) {
                case 1:
                    return new SimpleDateFormat("d'st' 'of' MMMM yyyy").format(formattedDate) + " " + timeFormat;
                case 2:
                    return new SimpleDateFormat("d'nd' 'of' MMMM yyyy").format(formattedDate) + " " + timeFormat;
                case 3:
                    return new SimpleDateFormat("d'rd' 'of' MMMM yyyy").format(formattedDate) + " " + timeFormat;
                default:
                    return new SimpleDateFormat("d'th' 'of' MMMM yyyy").format(formattedDate) + " " + timeFormat;
            }
        return new SimpleDateFormat("d'th' 'of' MMMM yyyy").format(formattedDate) + " " + timeFormat;
    }
}
