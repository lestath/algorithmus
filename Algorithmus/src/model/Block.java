package model;
import java.awt.*;

public abstract class Block {
    Object previous = null;
    Object next = null;
    Point pos = null;
    Dimension size = null;
    String content = "";
}
