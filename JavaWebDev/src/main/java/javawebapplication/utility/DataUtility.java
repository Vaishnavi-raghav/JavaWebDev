package javawebapplication.utility;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Data Utility class to format data from one format to another
 * 
 * @author Navigable Set
 * @version 1.0
* @Copyright (c) Navigable Set
 */

public class DataUtility 
{
  //Application Date Format
  
  public static final String APP_DATE_FORMAT = "MM/dd/yyyy";

    //    public static final String APP_TIME_FORMAT = "MM/dd/yyyy HH:mm:ss";

 //to format a date
  private static final SimpleDateFormat formatter = new SimpleDateFormat(APP_DATE_FORMAT);

  //private static final SimpleDateFormat timeFormatter = new SimpleDateFormat(APP_TIME_FORMAT);

  //for trimming spaces
  public static String getString(String val) {
    if (DataValidator.isNotNull(val)) {
      return val.trim();
    } else {
      return val;
    }
  }

  //converting object to string
  public static String getStringData(Object val) {
    
    if (val != null) {
      return val.toString();
    } else {
      return "";
    }
  }

// Converts String into Integer
  public static int getInt(String val) {
    if (DataValidator.isInteger(val)) {
      return Integer.parseInt(val);
    } else {
      return 0;
    }
  }

// Converts String into Long
  
  public static long getLong(String val) {
    if (DataValidator.isLong(val)) {
      return Long.parseLong(val);
    } else {
      return 0;
    }
  }

// Converts String into Date
  
   public static Date getDate(String val) {
          Date date = null;
          try {
              date = formatter.parse(val);
          } catch (Exception e) {

          }
          return date;
      }

  public static Date getDate1(String val) {
    Date date = null;
    
    try {
      date = formatter.parse(val);
      
    }catch(Exception e){}
    return date;
  }
//Converts Date into String

  public static String getDateString(Date date) {
    
    try {
       if(date!=null) {
        return formatter.format(date);
      }
      else{
        return "";
      }
    } catch (Exception e) {
      return "";
    }
    
  }

  //tells the date after a specific number of days
  public static Date getDate(Date date, int day) {
    return null;
  }

//String to time
  public static Timestamp getTimestamp(long l) {

    Timestamp timeStamp = null;
    try {
      timeStamp = new Timestamp(l);
    } catch (Exception e) {
      return null;
    }
    return timeStamp;
  }
  
 
  public static Timestamp getTimestamp(String cdt) {

    Timestamp timeStamp = null;
    try {
    //    timeStamp = new Timestamp((timeFormatter.parse(cdt)).getTime());
    } catch (Exception e) {
      return null;
    }
    return timeStamp;
  }
 //time to long
  public static long getTimestamp(Timestamp tm) {
    try {
      return tm.getTime();
    } catch (Exception e) {
      return 0;
    }
  }
  
//provides the current time
  public static Timestamp getCurrentTimestamp() {
    Timestamp timeStamp = null;
    try {
      timeStamp = new Timestamp(new Date().getTime());
    } catch (Exception e) {
    }
    return timeStamp;

  }



}