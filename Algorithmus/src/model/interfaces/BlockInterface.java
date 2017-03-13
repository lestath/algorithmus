package model.interfaces;

public interface BlockInterface {
    /**
     *
     * @param content String wyświetlany w bloczku
     */
    void setContent(String content);

    /**
     * @param x Pozycja X na ekranie
     * @param y Pozycja Y na ekranie
     */
    void setPosition(int x, int y);

    /**
     *
     * @return Zwraca String, który jest kodem w danym języku
     */
    String toCode();
}
