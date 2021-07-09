package Utilities;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class getCurrentDate {
	
	public static String formatDateToString(Date date, String format,
            String timeZone) {
        // null check
        if (date == null) return null;
        // create SimpleDateFormat object with input format
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        // default system timezone if passed null or empty
        if (timeZone == null || "".equalsIgnoreCase(timeZone.trim())) {
            timeZone = Calendar.getInstance().getTimeZone().getID();
        }
        // set timezone to SimpleDateFormat
        sdf.setTimeZone(TimeZone.getTimeZone(timeZone));
        // return Date in required format with timezone as String
        return sdf.format(date);
    }
	
	
public static String getPSTTime(){
		
	Date date = new Date();
		
	String todaysDate=formatDateToString(date, "MM/dd/yyyy", "PST");
		
		
		
	return todaysDate;
		
	}


public static String getISTTime(){
	
	Date date = new Date();
		
	String todaysDate=formatDateToString(date, "EEEE, dd MMMM yyyy, hh:mm:ss.SSS a", "IST");

	return todaysDate;
		
	}

public static String getISTDate()
{
	Date date = new Date();
	
	String todaysDate=formatDateToString(date, "yyyy-MM-dd", "IST");

	return todaysDate;
}

public static String getISTDate2()
{
	Date date = new Date();
	
	String todaysDate=formatDateToString(date, "yyyymmdd", "IST");

	return todaysDate;
}

public static String getISTTime2()
{
	Date date = new Date();
	
	String todaysDate=formatDateToString(date, "hh:mm:ss", "IST");

	return todaysDate;
}

public static String getISTTime3()
{
	Date date = new Date();
	
	String todaysDate=formatDateToString(date, "hhmmss", "IST");

	return todaysDate;
}

public static String getTimeStamp(){
	
	long s=System.currentTimeMillis();
		
String strLong=Long.toString(s);

	return strLong;
		
	}

public static String getISTTimeHTML(){
	
	Date date = new Date();
		
	String todaysDate=formatDateToString(date, "dd MM yyyy - hh:mm:ss", "IST");

	return todaysDate;
		
	}
public static String getISTTimeHTMLforfolder(){
	
	Date date = new Date();
		
	String todaysDate=formatDateToString(date, "dd_MM_yy_hhmmss", "IST");

	return todaysDate;
		
	}

public static String getISTDate1(){
	
	Date date = new Date();
		
	String todaysDate=formatDateToString(date, "dd/MM/yyyy", "IST");
		
		
		
	return todaysDate;
		
	}
public static String getISTDateddMM(){
	
	Date date = new Date();
		
	String todaysDate=formatDateToString(date, "dd_MM", "IST");
		
		
		
	return todaysDate;
		
	}


public static String get_CurrentDate()
{
	Date date = new Date();
	
	String todaysDate=formatDateToString(date, "yyyy-MM-dd", "IST");

	return todaysDate;
}

public static Date ConvertStringToDate(String dateString) throws Exception{
	Date date = null;
	date=new SimpleDateFormat("dd/MM/yyyy").parse(dateString); 
	return date;
}

public static boolean ComparebtwDates(String dateExpected, String dateActual) {
	boolean res=false;
	try{
		Date convtrdExpectedDate= ConvertStringToDate(dateExpected);
		Date convtrdActualDate= ConvertStringToDate(dateActual);
		 if (convtrdExpectedDate.compareTo(convtrdActualDate) > 0)
			  res=false;
		  else
			  res = true;
		 return res;
	}catch(Exception e){
		e.printStackTrace();
		res=false;
		return res;
	}
	
}
public static String getISTDateRMS()
{
	Date date = new Date();
	
	String todaysDate=formatDateToString(date, "dd-MMM-yyyy", "IST");

	return todaysDate;
}


public static String getISTTimetoGeneratefileBST(){
	
	Date date = new Date();
		
	String todaysDate=formatDateToString(date, "yyyyMMddhhmmss", "BST");

	return todaysDate;
		
	}

}
