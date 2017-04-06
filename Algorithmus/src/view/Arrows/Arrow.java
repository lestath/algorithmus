package view.Arrows;


import java.awt.Point;
import controller.ViewParams;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import model.Block;
import model.BlocksHolder;
import model.interfaces.BlockInterface;
import view.handlers.Handler;
import view.handlers.LeftInHandler;
import view.handlers.LeftOutHandler;
import view.handlers.RightInHandler;
import view.handlers.RightOutHandler;

public class Arrow extends Polyline{	
	private enum WhereToGo{LEFT,RIGHT};
	private Point start;
	private Point stop;
	private Line leftarm;
	private Line rightarm;
	private double armsize = 30;
	private AnchorPane node;
	private Handler owner; // wlasciciel stralki wyjscie strzalki
	private Handler ender; // handler na koncu strzalki (wejscie strzalki)
	

	public Arrow(Point start, Point stop,AnchorPane n){
		this.start = start;
		this.stop = stop;
		this.node = n;	
	    this.node.getChildren().add(this);
	    this.move(stop.getX(),stop.getY());
	    this.setStrokeWidth(2);
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
		this.moveForMouse();
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

	/**
	 * Zmiana aktualnego polożenia ścieżki
	 */
	public void move(){
	    this.generateRoute();
	}
	
	
	/**
	 * Poruszanie się strzałki za myszką (zanim jeszcze klikniemy w wejście bloku końcowego)
	 */
	public void moveForMouse(){
		this.getPoints().clear();
	    this.getPoints().addAll(
	    		this.start.getX(),
	    		this.start.getY(),
	    		this.stop.getX(),
	    		this.stop.getY()
	    );
	}
	
	/**
	 * Metoda zawierająca algorytm generujący ścieżkę łącznika
	 */
	private void generateRoute() {
		this.getPoints().clear();
		this.getPoints().add(this.start.getX());
		this.getPoints().add(this.start.getY());
		// ustalenie z jakim wyjściem mamy do czynienia i dorzucenie odpowiedniego punktu
		this.establishOut();
		//wygenerowanie lini pośredniej
		this.setInnerLine();
		//ustalenie wejścia
		this.establishIn();
		this.getPoints().add(this.stop.getX());
		this.getPoints().add(this.stop.getY());
	}

	private void establishIn() {
		if(this.ender!=null){
			if(this.ender instanceof LeftInHandler){
				this.getPoints().add(this.stop.getX()-10);
				this.getPoints().add(this.stop.getY());
			}else if(this.ender instanceof RightInHandler){
				this.getPoints().add(this.stop.getX()+10);
				this.getPoints().add(this.stop.getY());
			}else{
				this.getPoints().add(this.stop.getX());
				this.getPoints().add(this.stop.getY()-10);
			}
		}
	}

	/**
	 * Ustalenie początkowej lini wyjścia
	 */
	private void establishOut() {
		if(this.owner!=null){
			if(this.owner instanceof LeftOutHandler){
				this.getPoints().add(this.start.getX()-10);
				this.getPoints().add(this.start.getY());
			}else if(this.owner instanceof RightOutHandler){
				this.getPoints().add(this.start.getX()+10);
				this.getPoints().add(this.start.getY());
			}else{
				this.getPoints().add(this.start.getX());
				this.getPoints().add(this.start.getY()+10);
			}
		}
	}
	
	/**
	 * Ustalenie przebiegu lini pośredniej
	 */
	private void setInnerLine() {
		this.getPoints().add(this.stop.getX());
		this.getPoints().add(this.getPoints().get(3));
		if(this.start.getX()>=this.stop.getX()){ // sprawdzenie pojscia w lewo
			if(this.start.getY()<=this.stop.getY()){ // sprawdzenie czy bloczek wyjscia na gorze
				System.out.println("Weszło do kolizji");
				this.getPoints().add(this.stop.getX()-this.getColisionMove(
															this.owner.getBlock().getPosition().getY(),
															this.ender.getBlock().getPosition().getY(),
															this.stop.getX(),
															WhereToGo.LEFT
													  ));
				this.getPoints().add(this.getPoints().get(5));
				this.getPoints().add(this.getPoints().get(6));
				this.getPoints().add(this.stop.getY()-10);
			}else{//bloczek wyjscia na dole
				//TODO sytuacja nietypowa z dolu do gory przejscie (trzeba ominąc siebie samego)
			}
		}else{ // idziemy w prawo
			if(this.start.getY()<=this.stop.getY()){ // sprawdzenie czy bloczek wyjscia na gorze
				System.out.println("Weszło do kolizji");
				this.getPoints().add(this.stop.getX()+this.getColisionMove(
															this.owner.getBlock().getPosition().getY(),
															this.ender.getBlock().getPosition().getY(),
															this.stop.getX(),
															WhereToGo.RIGHT
													  ));
				this.getPoints().add(this.getPoints().get(5));
				this.getPoints().add(this.getPoints().get(6));
				this.getPoints().add(this.stop.getY()-10);
			}else{//bloczek wyjscia na dole
				//TODO sytuacja nietypowa z dolu do gory przejscie (trzeba ominąc siebie samego)
			}
		}
	}
	/**
	 * Metoda sprawdza czy nastepuje kolizja jeżeli tak to zwraca przesunięcie
	 * @param start
	 * 				pozycja startowa y
	 * @param stop
	 * 				pozycja końcowa y
	 * @param x
	 * 				pozycja x 
	 * @param w
	 * 			Sprawdza czy idziemy w lewo czy w prawo
	 * @return
	 * 			zwraca przesunięcie kolizji
	 */

	private double getColisionMove(double start,double stop,double x,WhereToGo w){
		
		double yy;
		double xx;
		double colision = 0.00;
		if(w.equals(WhereToGo.LEFT)){ // idziemy w lewo
			Block blo;
			for(BlockInterface b: BlocksHolder.blocklist){ // iteracja po bloczkach
				blo = (Block)b;
				yy=blo.getPosition().getY();
				xx=blo.getPosition().getX();
				System.out.println("jestesmy w iteratorze 1");
				if(yy>start && yy<stop){
					System.out.println("jestesmy w iteratorze 2");
					if(xx<=x && x<= xx + blo.getSize().getWidth()){
						colision = x-xx+10; 	
					}
				}
			}
		}else{ // idziemy w prawo
			Block blo;
			for(BlockInterface b: BlocksHolder.blocklist){ // iteracja po bloczkach
				blo = (Block)b;
				yy=blo.getPosition().getY();
				xx=blo.getPosition().getX();
				System.out.println("jestesmy w iteratorze 1");
				if(yy>start && yy<stop){
					System.out.println("jestesmy w iteratorze 2");
					if(xx<=x && x<= xx + blo.getSize().getWidth()){
						colision = xx + blo.getSize().getWidth()-x+10; 	
					}
				}
			}
		}
		System.out.println("Sprawdza w kolizji "+colision);
		return colision;

	}
	
	public void delete(){
		if(getOwner() != null){
			getOwner().setConnected(null);
			getOwner().getBlock().setNext(null);
			getOwner().setArrow(null);
		}
		if(getEnder()!= null)getEnder().setArrow(null);
		ViewParams.ARROW_LIST.remove(this);
		node.getChildren().remove(this);
	}
}
