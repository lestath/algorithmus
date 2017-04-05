package model;
import model.interfaces.BlockInterface;

import java.awt.*;

/**
 *
 */
public class Block implements BlockInterface {
    private Block previous;
    private Block next;
    private Object handle;
    private Point position;
    private Dimension size;
    private String content;
    private String code;

    public Block(Point start,Dimension dim){
     	this.position = start;
     	this.size = dim;
    }

    /**
     * Zwraca obiekt poprzedzający ten blok
     * @return (Object) blok poprzedzający
     */
    public Block getPrevious() {
        return previous;
    }

    /**
     * Ustawia blok poprzedzający
     * @param previous blok poprzedzający
     */
    public void setPrevious(Block previous) {
        this.previous = previous;
    }

    /**
     * Zwraca blok następujący
     * @return (Object) blok następujący
     */
    public Block getNext() {
        return next;
    }

    /**
     * Ustawia blok następujący
     * @param next blok następujący
     */
    public void setNext(Block next) {
        this.next = next;
    }

    /**
     * Zwraca linię następującą po bloku
     * @return (Object) linia następująca po bloku
     */
    public Object getHandle() {
        return handle;
    }

    /**
     * Ustawia linię następującą po bloku
     * @param handle linia następująca po bloku
     */
    public void setHandle(Object handle) {
        this.handle = handle;
    }

    /**
     * Zwraca pozycję bloku
     * @return (Point) pozycja bloku
     */
    public Point getPosition() {
        return position;
    }

    /**
     * Ustawia pozycję bloku
     * @param position pozycja bloku
     */
    public void setPosition(Point position) {
        this.position = position;
    }

    /**
     * Zwraca rozmiar bloku
     * @return (Dimension) rozmiar bloku
     */
    public Dimension getSize() {
        return size;
    }

    /**
     * Ustawia rozmiar bloku
     * @param size rozmiar bloku
     */
    public void setSize(Dimension size) {
        this.size = size;
    }

    /**
     * Zwraca tekst wyświetlany graficznie na bloku
     * @return (String) tekst wyświetlany na bloku
     */
    public String getContent() {
        return content;
    }

    /**
     * Ustawia tekst wyświetlany na bloku
     * @param content tekst wyświetlany na bloku
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * Zwraca kod gotowy dla edytora
     * @return (String) kod gotowy dla edytora
     */
    public String getCode() {
        return code;
    }

    /**
     * Ustawia kod dla edytora
     * @param code kod dla edytora
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Wykonuje się przy każdej iteracji funkcji odświeżającej ekran
     */
    @Override
    public void update() {

    }
    
    
}
