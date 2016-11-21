package agh.cs.lab2;

/**
 * Created by robert on 21.11.16.
 */
public interface IPositionChangeListener {
    /**
     * updates the position of a car after movement
     *
     * @param oldPosition
     *          The position of a car before update.
     * @param newPosition
     *          The position of a car after update.
     *
     */
    void positionChanged(Position oldPosition, Position newPosition);
}
