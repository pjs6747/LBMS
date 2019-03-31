package controller;

/*
Project: LBMS
File: Observer
Author: Group 4
 */

public interface Observer <E> {

    /**
     * Push update
     * @param pushValue The value that will be pushed to the observer
     */
    void update (E pushValue);
}
