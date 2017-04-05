package view.handlers;


import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import model.Block;
import view.Arrows.Arrow;

/**
 * 
 * Klasa Reprezentująca zaczep linii dla bloku
 *
 */
public class Handler extends Rectangle {
	Block block; // blok własciciel handlera
	Block connected; // trzyma konkretne wejście/wyjscie
	Arrow arrow; // strzałka w handlerze wejsciowa do bloku

	// pierwszy parametr to blok który jest właścicielem handlera, drugi to skojarzenie konkretnego wejścia innego bloku
	public Handler(Block bl, Block connected){
		this.block = bl;
		this.connected = connected;
		this.setWidth(this.block.getSize().getWidth()*0.05);
		this.setHeight(this.block.getSize().getHeight()*0.15);
	}
	
	public Block getBlock() {
		return block;
	}
	public void setBlock(Block block) {
		this.block = block;
	}

	public Block getConnected() {
		return connected;
	}

	public void setConnected(Block connected) {
		
		this.connected = connected;
		this.block.setNext(this.connected);
		if(this.connected!= null){
			System.out.println("Podłączam nastepnik");
			System.out.println(this.connected.getContent());
		}
	}
	
	/**
	 * metoda usuwa połączenie bloków
	 */
	public void removeConnection(){
		if(arrow!=null){
			arrow.delete();
		}
	}
	
	public Arrow getArrow() {
		return arrow;
	}

	public void setArrow(Arrow arrow) {
		this.arrow = arrow;
	}
	public void removeHandler() {
		this.removeConnection();
		this.block = null;
		this.connected = null;
		AnchorPane pan = (AnchorPane)this.getParent();
		pan.getChildren().remove(this);
	}
}
