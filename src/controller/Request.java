package controller;

import java.io.FileNotFoundException;

public interface Request{
  public String execute(String requeString) throws FileNotFoundException;
}
