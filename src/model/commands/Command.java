package model.commands;


public interface Command {
    void execute();
    String requestParams();
}
