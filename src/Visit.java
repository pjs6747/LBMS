public class Visit {

  /**
   * Visitor makeing the visit
   */
  private Visitor visitor;

  /**
   * Date of the visit
   */
  private String Date;

  /**
   * Start time of visit
   */
  private String startTime;

  /**
   * End time of visit
   */
  private String endTime;


  public void Visit(Visitor visitor, String date, String startTime){
    this.visitor = visitor;
    this.startTime = startTime;
    this.Date = date;
  }

  /**
   * Records the time the visit ended
   * @param endDate
   */
  public void endVisit(String endDate){
    this.endTime = endDate;
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
  public String getStartDate() {
    return startTime;
  }

  /**
   * Gets endDate
   * @return visit endDate
   */
  public String getEndDate() {
    return endTime;
  }

  @Override
  public String toString() {
    return visitor.toString() + "visited on" + Date + "at" + startTime + "and left at" + endTime;
  }
}
