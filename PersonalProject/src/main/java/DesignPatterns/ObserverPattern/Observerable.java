package DesignPatterns.ObserverPattern;

import java.util.ArrayList;

/**
 * Observerable: Its the main class, the class that is being observed.
 * A Observerable pushes to all the "Observers" about any change in itself.
 *
 * Its a Publisher implementation.
 */
public interface Observerable {
    public void addObserver(Observer observer);
    public void removeObserver(Observer observer);
    public void notifyObservers();
}
