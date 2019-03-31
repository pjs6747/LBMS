package model;

/*
Project: LBMS
File: Visit
Author: Group 4
 */

import java.time.LocalDate;
import java.time.LocalTime;

public class Visit {

    /**
     * Visitor makeing the visit
     */
    private Visitor visitor;
    /**
     * Date of the visit
     */
    private LocalDate Date;

    /**
     * Start time of visit
     */
    private LocalTime startTime;

    /**
     * End time of visit
     */
    private LocalTime endTime;


    public Visit(Visitor visitor, LocalDate date, LocalTime startTime){
        this.visitor = visitor;
        this.startTime = startTime;
        this.Date = date;
    }

    /**
     * Records the time the visit ended
     * @param endTime
     */
    public void endVisit(LocalTime endTime){
        this.endTime = endTime;
    }

    /**
     * Gets visitor
     * @return visit visitor
     */
    public Visitor getVisitor() {
        return visitor;
    }

    /**
     * Gets startDate
     * @return visit startDate
     */
    public LocalDate getDate() {
        return Date;
    }

    public LocalTime getStartTime(){return startTime;}

    /**
     * Gets endDate
     * @return visit endDate
     */
    public LocalTime getEndTime() {
        return endTime;
    }

    @Override
    public String toString() {
        return visitor + " visited on " + Date + " at " + startTime + " and left at " + endTime;
    }
}
