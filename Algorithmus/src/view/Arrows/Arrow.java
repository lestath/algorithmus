package view.Arrows;


import java.awt.Point;


import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;

public class Arrow extends Polyline{	
	private Point start;
	private Point stop;
	private Line leftarm;
	private Line rightarm;
	private double armsize = 30;
	private AnchorPane node;
	
	public Arrow(Point start, Point stop,AnchorPane n){
		this.start = start;
		this.stop = stop;
		this.node = n;	
		double lx;
		double ly;
		double rx;
		double ry;
		if(start.getX()<stop.getX()){
			lx = stop.getX() - armsize;
			rx = stop.getX();
		}else{
			lx = stop.getX() + armsize;
			rx = stop.getX();
		}
		
		if(start.getY()>stop.getY()){
			ry = stop.getY()+armsize;
			ly = stop.getY();
		}else{
			ry = stop.getY()-armsize;
			ly = stop.getY();
		}
	    this.getPoints().addAll(
	     start.getX(),
	     start.getY(),
	     stop.getX(),
	     stop.getY()
	    );
		this.leftarm = new Line(stop.getX(),stop.getY(),lx,ly);
	    this.rightarm = new Line(stop.getX(),stop.getY(),rx,ry);
	    this.node.getChildren().add(this.leftarm);
	    this.node.getChildren().add(this.rightarm);
	    this.node.getChildren().add(this);
	    this.move(stop.getX(),stop.getY());
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
		double lx;
		double ly;
		double rx;
		double ry;
		if(start.getX()<stop.getX()){
			lx = stop.getX() - armsize;
			rx = stop.getX();
		}else{
			lx = stop.getX() + armsize;
			rx = stop.getX();
		}
		
		if(start.getY()>stop.getY()){
			ry = stop.getY()+armsize;
			ly = stop.getY();
		}else{
			ry = stop.getY()-armsize;
			ly = stop.getY();
		}
		this.rightarm.relocate(rx,ry);
		this.leftarm.relocate(lx,ly);
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
	
	
	
}
