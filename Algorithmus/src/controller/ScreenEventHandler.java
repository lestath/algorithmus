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

	ScreenEventHandler(Block b, GraphicsBlockInterface inter){
		this.block = b;
		this.gpb = inter;
	}
	
	@Override
	public void handle(MouseEvent event) {
		if(event.getEventType().equals(MouseEvent.MOUSE_DRAGGED)){
			this.block.getPosition().setLocation(
					block.getPosition().getX()+event.getX()-block.getSize().getWidth()/2.0
					,block.getPosition().getY()+event.getY()-block.getSize().getHeight()/2.0);
			gpb.refresh();
		}
		// TODO Auto-generated method stub
		
	}
	

}
