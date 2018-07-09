package utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class UtilityLibrary {

	public static String getDate(String currentDate, int days) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yy");
		Calendar c = Calendar.getInstance();
		try {
			c.setTime(sdf.parse(currentDate));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		c.add(Calendar.DAY_OF_MONTH, days);
		String newDate = sdf.format(c.getTime());
		String[] date = newDate.split(" ");
		return date[0] + " " + date[1] + " " + "20" + date[2];
	}

}
