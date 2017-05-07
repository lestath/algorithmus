package model;

import java.awt.Dimension;
import java.awt.Point;


import javafx.scene.paint.Paint;

/**
 * 
 *Klasa konfiguracyjna do standaryzacji wymiarów
 *
 */
public class Conf {
	public enum BLOCK{START,DECISION,OPERATING,INPUT,STOP};
	public static Dimension MENU_ELEMS_DIM = new Dimension(60,30);
	public static Dimension DELETE_BTN_DIM = new Dimension(40,40);
	public static Dimension NODE_DIM = new Dimension(30,30);
	public static Point NEW_ELEMENT_POS = new Point(10,10);
	public static Paint BLOCK_COLOR = Paint.valueOf("royalblue");
	public static Paint NODE_COLOR = Paint.valueOf("grey");
	public static Paint IN_HANDLER_COLOR = Paint.valueOf("black");
	public static Paint OUT_HANDLER_COLOR = Paint.valueOf("red");
	public static Dimension STANDARD_BLOCK_DIM = new Dimension(180,60);
	public static String [] STANDARD_TEXT = new String[]{"START", "Condition", "type name = value", "Output here...", "STOP"};
}
