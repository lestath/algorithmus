package view.Arrows;


import java.awt.Point;


import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import view.handlers.Handler;

public class Arrow extends Polyline{	
	private Point start;
	private Point stop;
	private Line leftarm;
	private Line rightarm;
	private double armsize = 30;
	private AnchorPane node;
	private Handler owner; // wlasciciel stralki wyjscie strzalki
	private Handler ender; // handler na koncu strzalki (wejscie stralki)
	

	public Arrow(Point start, Point stop,AnchorPane n){
		this.start = start;
		this.stop = stop;
		this.node = n;	
		this.move();
	    this.node.getChildren().add(this);
	    this.move(stop.getX(),stop.getY());
	    this.setStrokeWidth(5);
	}
	
	/**
	 * Metoda przemieszcza koniec strzałki za kursorem myszy
	 * @param x
	 * 			Współrzedna x
	 * @param y
	 * 			Współrzedna y
	 */
	public void move(double x, double y){
		this.stop.setLocation(x, y);
		this.getPoints().set(2,stop.getX());
		this.getPoints().set(3,stop.getY());
	}

	public Point getStart() {
		return start;
	}

	public void setStart(Point start) {
		this.start = start;
	}

	public Point getStop() {
		return stop;
	}

	public void setStop(Point stop) {
		this.stop = stop;
	}

	public Line getLeftarm() {
		return leftarm;
	}

	public void setLeftarm(Line leftarm) {
		this.leftarm = leftarm;
	}

	public Line getRightarm() {
		return rightarm;
	}

	public void setRightarm(Line rightarm) {
		this.rightarm = rightarm;
	}

	public double getArmsize() {
		return armsize;
	}

	public void setArmsize(double armsize) {
		this.armsize = armsize;
	}
	

	public Handler getOwner() {
		return owner;
	}

	public void setOwner(Handler owner) {
		this.owner = owner;
	}
	
	
	
	public Handler getEnder() {
		return ender;
	}

	public void setEnder(Handler ender) {
		this.ender = ender;
	}

	public void move(){
	    this.getPoints().clear();
	    this.getPoints().addAll(
	    		this.start.getX(),
	    		this.start.getY(),
	    		this.stop.getX(),
	    		this.stop.getY()
	    );
	}

	
	
}
