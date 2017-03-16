package controller;

import javafx.event.EventHandler;
import javafx.geometry.Bounds;
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
	MainController cont;

	ScreenEventHandler(MainController c,Block b, GraphicsBlockInterface inter){
		this.block = b;
		this.gpb = inter;
		this.cont = c;
	}
	
	@Override
	public void handle(MouseEvent event) {
		if(event.getEventType().equals(MouseEvent.MOUSE_DRAGGED)){
			double x = this.block.getPosition().getX();
			double y = this.block.getPosition().getY();
			Bounds b = cont.BlockPane.localToScene(cont.BlockPane.getBoundsInLocal());
			x = event.getSceneX() - b.getMinX();
			y = event.getSceneY()-b.getMinY();
			x = x - this.block.getSize().getWidth()/2;
			y = y - this.block.getSize().getHeight()/2;
			this.block.getPosition().setLocation(x,y);
			gpb.refresh();
			
		}
		// TODO Auto-generated method stub
		
	}
	

}
