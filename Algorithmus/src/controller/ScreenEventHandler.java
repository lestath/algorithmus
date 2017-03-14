package controller;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import model.Block;
import model.interfaces.GraphicsBlockInterface;

/**
 * 
 * Klasa obsługująca zdarzenia myszy na głównym ekranie układania bloków
 *
 */
public class ScreenEventHandler implements EventHandler<MouseEvent>{

	Block block;
	GraphicsBlockInterface gpb;
	private int x,y;

	ScreenEventHandler(Block b, GraphicsBlockInterface inter){
		this.block = b;
		this.gpb = inter;
		this.x = x+(int)b.getPosition().getX();
		this.y = y+(int)b.getPosition().getY();
	}
	
	@Override
	public void handle(MouseEvent event) {
		if(event.getEventType().equals(MouseEvent.MOUSE_DRAGGED)){
			x = (int)event.getX();
			y = (int)event.getY();
			System.out.println(x);
			System.out.println(y);
			this.block.getPosition().setLocation(x,y);
			gpb.update();
		}
		// TODO Auto-generated method stub
		
	}
	

}
