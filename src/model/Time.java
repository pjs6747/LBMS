package model;

import java.time.LocalTime;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Time extends Thread {

  private final static DateTimeFormatter FORMATTED_DATE_TIME = DateTimeFormatter.ofPattern("yyyy/MM/dd, HH:mm:ss");

  private LocalDateTime time;

  private static Time timeCase = null;

  private volatile boolean stop = false;


  /**
   * Uses a thread for the clock to tick every second
   */
  @Override
  public void run() {
    while (!this.stop) {
      this.time = this.time.plusSeconds(1);
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        System.err.print("");
      }
    }
  }


  /**
   * Constructor for a Time. time will start at the current time
   */
  public Time() {
    this.time = LocalDateTime.now();
  }


  /**
   * Constructor for a Time object after deserialization. creating time object from stored bytes
   * @param time: time since last system run
   */
  private Time(LocalDateTime time) {
    this.time = time;
  }


  /**
   * Gets the time of the system.
   * @return object of time as local time
   */
  public LocalTime getTime() {
    return this.time.toLocalTime();
  }


  /**
   * Gets the date of the system.
   * @return object of date as local date
   */
  public LocalDate getDate() {
    return this.time.toLocalDate();
  }

  /**
   * Gets the date and time of the system.
   * @return a local date time object of the system
   */
  public LocalDateTime getDateTime() {
    return this.time;
  }


  /**
   * Gets the case of the system date and time. If there isnt a case yet a new case is created
   * @return the case of the system date and time
   */
  private static Time getTimeCase() {
    if (timeCase == null) {
      timeCase = new Time();
    }
    return timeCase;
  }


  /**
   * Gets the case of the system date time. If there isnt a case yet a new case is created.
   * Also can set time to be local
   * @param time: time from previous system run
   * @return an case of Time
   */
  public static Time getTimeCase(LocalDateTime time) {
    if (time == null) {
      return getTimeCase();
    } else if (timeCase== null) {
      timeCase = new Time(time);
    }
    return timeCase;
  }


  /**
   * Advances the date by number of days.
   * @param days: number of days to advance date
   */
  public void plusDays(long days) {
    this.time = this.time.plusDays(days);
  }


  /**
   * Adds hours to the system time
   * @param hours hours to add
   */
  public void plusHours(long hours){
    this.time = this.time.plusHours(hours);
  }


  /**
   * Creates a formatted string of the date and time.
   * @return formatted string
   */
  public String toString() {
    return this.time.format(FORMATTED_DATE_TIME);
  }


  @Override
  public boolean equals(Object o){
    if (o instanceof Time){
      Time other = (Time) o;
      return time.equals(other.getTime());
    }
    return false;
  }
}
