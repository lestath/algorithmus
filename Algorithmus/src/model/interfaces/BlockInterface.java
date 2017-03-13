package model.interfaces;

public interface BlockInterface {
    /**
     *
     * @return Zwraca String, który jest kodem w danym języku
     */
    public String getCode();

    /**
     * Wykonuje się przy każdej iteracji funkcji odświeżającej ekran
     */
    public void update();
}
