package model.TransactionState;

public class TransactionContext {

  /**
   * State of transaction
   */
  private TransactionState state;


  public TransactionContext(){
    this.state = new CheckedOut();
  }

  /**
   * sets state of context
   * @param state state to change context to
   */
  public void setState(TransactionState state){
    this.state = state;
  }

  /**
   * Checks if the book from the transaction is returned
   * @return return status
   */
  public boolean checkReturned(){
    return state.getReturnState();
  }
}
