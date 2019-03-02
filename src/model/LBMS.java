package model;

import java.util.ArrayList;

public class LBMS {

  Library library;
  ArrayList<Visit> visits;
  ArrayList<Visitor> visitors;
  ArrayList<Visit> openVisits;



  public LBMS(){
    library = new Library();
    visits = new ArrayList<>();
    visitors = new ArrayList<>();
    this.openVisits = new ArrayList<>();
  }


  public void registerVisitor(Visitor visitor){
    this.visitors.add(visitor);
  }


  public void startVisit(long ID){
    for (Visitor visitor : visitors){
      if (visitor.getVisitorID() == ID){
        this.openVisits.add(new Visit(visitor, "Temp", "Temp"));
        return;
      }
    }
  }

  public void endVisit(long ID) {
    for (Visitor visitor : visitors) {
      if (visitor.getVisitorID() == ID) {
        for (Visit visit : openVisits){
          if (visit.getVisitor().getVisitorID() == ID){
            visit.endVisit("Temp");
            openVisits.remove(visit);
            visits.add(visit);
            return;
          }
        }
      }
    }
  }








}
