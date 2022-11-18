package com.nighthawk.spring_portfolio.mvc.calendar;

/** Simple POJO 
 * Used to Interface with APCalendar
 * The toString method(s) prepares object for JSON serialization
 * Note... this is NOT an entity, just an abstraction
 */
class Year {
   private int year;
   private int month;
   private int day;
   private boolean isLeapYear;
   private int firstDayOfYear;
   private int dayOfYear;
   private int dayOfWeek;

   // zero argument constructor
   public Year() {} 

   /* year getter/setters */
   public int getYear() {
      return year;
   }
   public void setYear(int year) {
      this.year = year;
      this.setIsLeapYear(year);
      this.setfirstDayOfYear(year);
   }

   /* isLeapYear getter/setters */
   public boolean getIsLeapYear(int year) {
      return APCalendar.isLeapYear(year);
   }
   public int getfirstDayOfYear(int year) {
      return APCalendar.firstDayOfYear(year);
   }

   public String dayOfYearToString() {
      return ("{ \"month\": " + this.month + ", " + "\"day\": " + this.day + ", " + "\"year\": " + this.year + ", "
            + "\"dayOfYear\": " + this.dayOfYear + " }");
   }

   private void setfirstDayOfYear(int year) {
      this.firstDayOfYear = APCalendar.firstDayOfYear(year);
   }
   private void setIsLeapYear(int year) {  // this is private to avoid tampering
      this.isLeapYear = APCalendar.isLeapYear(year);
   }

   public void setDate(int month, int day, int year) {
      this.month = month;
      this.day = day;
      this.year = year;
      this.setIsLeapYear(year);
   }

   /* isLeapYearToString formatted to be mapped to JSON */
   public String isLeapYearToString(){
      return ( "{ \"year\": "  +this.year+  ", " + "\"isLeapYear\": "  +this.isLeapYear+ " }" );
   }	
   
   public String firstDayOfYearToString(){
      return ( "{ \"year\": "  +this.year+  ", " + "\"firstDayOfYear\": "  +this.firstDayOfYear+ " }" );
   }	
   /* standard toString placeholder until class is extended */
   public String toString() { 
      return isLeapYearToString(); 
   }

   public static void main(String[] args) {
      Year year = new Year();
      year.setYear(2022);
      year.setDate(3, 5, 2028);
   }
}