package genericUtilities;


import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;

public class JavaUtils
{
	/**
	 * This method is used to give the random number
	 * @author Arvind
	 * @return
	 */
	public int getRandomNumber()
	{
		Random ran = new Random();
		int random = ran.nextInt(1000);
		return random;
	}
	
	public String systemDate()
	{
		LocalDate date = LocalDate.now();
		DateTimeFormatter d = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String systemDate = d.format(date);
		return systemDate;
	}
	
	public String sysDateTime()
	{
		Date date = new Date();
		SimpleDateFormat sim = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
		String systemDateInFormat = sim.format(date);
		return systemDateInFormat;
	}
	
	public String futureDateIntermsOfMonths(long futureMon)
	{
		LocalDate date = LocalDate.now();
		LocalDate future = date.plusMonths(futureMon);
		
		DateTimeFormatter d = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String futureMonth = d.format(future);
		return futureMonth;
	}

}
