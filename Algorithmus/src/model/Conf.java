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
	public static Dimension MENU_ELEMS_DIM = new Dimension(100,50);
	public static Point NEW_ELEMENT_POS = new Point(10,10);
	public static Paint BLOCK_COLOR = Paint.valueOf("royalblue");
	public static Dimension STANDARD_BLOCK_DIM = new Dimension(180,60);
	public static String [] STANDARD_TEXT = new String[]{"START","condition","code here ...","input := output := ","STOP"};
}
