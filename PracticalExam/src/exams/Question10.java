package exams;

public class Question10 {
	
	public static void main(String[] args) {
		
		int day = 28;
		int month = 12;
		int year = 1995;
	    int wDayNo = 0;
	    String dayNames[] = new String[] {
	      "Monday",
	      "Tuesday",
	      "Wednesday",
	      "Thursday",
	      "Friday",
	      "Saturday",
	      "Sunday"
	    };
	    
	    if (validateDate(day, month, year) == 1) {
	        System.out.printf("Date is correct [%02d/%02d/%02d].\n", day, month, year);

	        wDayNo = wd(year, month, day);

	        System.out.printf("week day is: %s\n", dayNames[wDayNo]);
	      } else {
	        System.out.printf("Date is in-correct.\n");
	      }
		
	}
	
	static int validateDate(int d, int m, int y) {
	    if (y >= 1800 && y <= 2999) {
	      if (m >= 1 && m <= 12) {
	        if (d >= 1 && d <= 31) {
	          if ((d >= 1 && d <= 30) && (m == 4 || m == 6 || m == 9 || m == 11))
	            return 1; //valid date
	          else if ((d >= 1 && d <= 30) && (m == 1 || m == 3 || m == 5 || m == 7 || m == 8 || m == 10 || m == 12))
	            return 1; //valid date
	          else if ((d >= 1 && d <= 28) && (m == 2))
	            return 1; //valid date
	          else if (d == 29 && m == 2 && ((y % 400 == 0) || (y % 4 == 0 && y % 4 != 0)))
	            return 1; //valid date
	          else
	            return 0; //invalid day
	        } else {
	          return 0; //day is invalid
	        }
	      } else {
	        return 0; //month is invalid
	      }
	    } else {
	      return 0; //year is invalid
	    }
	  }

	  static int wd(int year, int month, int day) {
	    int wday = 0;
	    wday = (day + ((153 * (month + 12 * ((14 - month) / 12) - 3) + 2) / 5) +
	        (365 * (year + 4800 - ((14 - month) / 12))) +
	        ((year + 4800 - ((14 - month) / 12)) / 4) -
	        ((year + 4800 - ((14 - month) / 12)) / 100) +
	        ((year + 4800 - ((14 - month) / 12)) / 400) -
	        32045) %
	      7;
	    return wday;
	  }

}
