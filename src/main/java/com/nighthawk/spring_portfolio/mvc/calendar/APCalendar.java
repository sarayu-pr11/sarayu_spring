package com.nighthawk.spring_portfolio.mvc.calendar;

import java.util.*;
import java.util.Calendar;
// Prototype Implementation

public class APCalendar {

    /** Returns true if year is a leap year and false otherwise.
     * isLeapYear(2019) returns False
     * isLeapYear(2016) returns True
     */          
    public static boolean isLeapYear(int year) {
        if(year % 400 == 0){
            return true;
        }

        if (year % 100 == 0){
            return false;
        }

        if(year % 4 == 0){
            return true;
        }

        return false;

    }
        
    /** Returns the value representing the day of the week 
     * 0 denotes Sunday, 
     * 1 denotes Monday, ..., 
     * 6 denotes Saturday. 
     * firstDayOfYear(2019) returns 2 for Tuesday.
    */
    public static int firstDayOfYear(int year) {
        Date currentDate = new Date(year-1900, 0, 1);

        return currentDate.getDay();
    }


    /** Returns n, where month, day, and year specify the nth day of the year.
     * This method accounts for whether year is a leap year. 
     * dayOfYear(1, 1, 2019) return 1
     * dayOfYear(3, 1, 2017) returns 60, since 2017 is not a leap year
     * dayOfYear(3, 1, 2016) returns 61, since 2016 is a leap year. 
    */ 
    public static int dayOfYear(int month, int day, int year) {
        // implementation not shown
        Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, day);
        int date = cal.get(Calendar.DAY_OF_YEAR);

        return date;
    }

    /** Returns the number of leap years between year1 and year2, inclusive.
     * Precondition: 0 <= year1 <= year2
    */ 
    public static int numberOfLeapYears(int year1, int year2){
        int num = 0;
        for (int i = year1; i <= year2; i++){
            if (isLeapYear(i)){
                num += 1;
            }
        }
        return(num);
    }

    /** Returns the value representing the day of the week for the given date
     * Precondition: The date represented by month, day, year is a valid date.
    */
    public static int dayOfWeek(int month, int day, int year){
        int firstDay = firstDayOfYear(year);
        int date = dayOfYear(month, day, year) - 1;
        int out = firstDay + date;
        return(out % 7);
    }

    /** Tester method */
    public static void main(String[] args) {
        // Private access modifiers
        System.out.println("firstDayOfYear: " + APCalendar.firstDayOfYear(2022));
        System.out.println("dayOfYear: " + APCalendar.dayOfYear(1, 1, 2022));

        // Public access modifiers
        System.out.println("isLeapYear: " + APCalendar.isLeapYear(2022));
        System.out.println("numberOfLeapYears: " + APCalendar.numberOfLeapYears(2000, 2022));
        System.out.println("dayOfWeek: " + APCalendar.dayOfWeek(1, 1, 2022));
    }

}