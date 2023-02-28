/**
  *
  * Beschreibung
  *
  * @version 1.0 vom 31.01.2018
  * @author 
  */
import java.util.*;
import java.text.DateFormat;
public class DateTime {
  // Anfang Attribute
  private Calendar cal;
  // Ende Attribute
  
  public DateTime(){
    this.cal = Calendar.getInstance();
  }
  public DateTime(String date, String time){
    this();
    int year, month, day, hour, minute; 
    String [] dates = date.split("."); 
    String [] times = time.split(".");
    year=Integer.parseInt(dates[2]);
    month=Integer.parseInt(dates[1]);
    day=Integer.parseInt(dates[0]);
    minute=Integer.parseInt(dates[1]);
    hour=Integer.parseInt(dates[0]);
    cal.set(year, month, day, hour, minute);
  }
  // Anfang Methoden
  public long getIntMillis() {
    return this.cal.getTimeInMillis();
  }
  public String toString(){
    DateFormat meinDatumFormat = DateFormat.getDateInstance(DateFormat.MEDIUM);
    return meinDatumFormat.format(cal.getTime());
  }

  // Ende Methoden
}
