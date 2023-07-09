package javawebapplication.utility;

import java.text.ParseException;
import java.util.Date;

//to check the values entered as Input
public class DataValidator {
 //validating the input in the text-field
  public static boolean isName(String val) {

    String name = "^[A-Za-z ]*$";
    /*
     * if (isNotNull(val)) { return val.matches(name);
     * 
     * } else { return false; }
     */
    if (val.matches(name)) {
      return true;
    } else {
      return false;
    }
  }
  
//checking the input value entered as Roll.No.  
  public static boolean isRollNO(String val) {
    String passregex = "^([0-9]{2}[A-Z]{2}[0-9]{1,})\\S$";

    if (val.matches(passregex)) {
      return true;
    } else {
      return false;
    }
  }

 //validating the password
  public static boolean isPassword(String val) {
    String passregex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[\\S])[A-Za-z0-9\\S]{6,12}$";

    if (val.matches(passregex)) {
      return true;
    } else {
      return false;
    }
  }

 //validating the phone number entered
  public static boolean isPhoneNo(String val) {
    String regex = "^[7-9][0-9]{9}$";
    if (val.matches(regex)) {
      return true;
    } else {
      return false;
    }
  }

 //checking for null values,if any
  public static boolean isNull(String val) {
    if (val == null || val.trim().length() == 0) {
      return true;
    } else {
      return false;
    }
  }
  //not null values
   public static boolean isNotNull(String val) {
    return !isNull(val);
  }

 //validating integer values
  public static boolean isInteger(String val) {

    if (isNotNull(val)) {
      try {
        int i = Integer.parseInt(val);
        return true;
      } catch (NumberFormatException e) {
        return false;
      }

    } else {
      return false;
    }
  }

  //checking for long values
  public static boolean isLong(String val) {
    if (isNotNull(val)) {
      try {
        long i = Long.parseLong(val);
        return true;
      } catch (NumberFormatException e) {
        return false;
      }

    } else {
      return false;
    }
  }

  /*public static boolean isIntegerName(String val) {
    String match = "^[0-9]{3}$";

    if (val.matches(match)) {
      return true;
    } else {
      return false;
    }

  }*/

  //validating the e-mail entered
  public static boolean isEmail(String val) {

    String emailreg = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    if (isNotNull(val)) {
      try {
        return val.matches(emailreg);
      } catch (NumberFormatException e) {
        return false;
      }

    } else {
      return false;
    }
  }

  //Date
  public static boolean isDate(String val) {

    Date d = null;
    if (isNotNull(val)) {
      d = DataUtility.getDate(val);
    }
    return d != null;
  }

 
}