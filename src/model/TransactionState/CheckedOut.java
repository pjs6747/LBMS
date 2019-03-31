package model.TransactionState;

public class CheckedOut implements TransactionState {

  /**
   * Returns false to being returned
   * @return false
   */
  public boolean getReturnState(){
    return false;
  }
}
