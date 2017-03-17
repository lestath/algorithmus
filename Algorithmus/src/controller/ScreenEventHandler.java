package controller;

import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.input.MouseEvent;
import model.Block;
import model.Conf;
import model.interfaces.GraphicsBlockInterface;
import view.handlers.InHandler;
import view.handlers.OutHandler;

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
		    // jeżeli przesuniecie wcisnietego przycisku
			if(event.getEventType().equals(MouseEvent.MOUSE_DRAGGED)){
				this.moveBlock(event);									
			}
			// jeżeli kliknięcie
			if(event.getEventType().equals(MouseEvent.MOUSE_CLICKED)){
				if(event.getSource() instanceof InHandler){
					this.inputHandlerService(event);
				}
				if(event.getSource() instanceof OutHandler){
					this.outputHandlerService(event);
				}
			}
	}
	
	/**
	 * Metoda odpowiedzialna za przessuwanie bloków
	 * @param event 
	 * 				Parametr zdarzenia myszy
	 */
	private void moveBlock(MouseEvent event){
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
	

	/**
	 * Metoda wykonywana w przypadku wcisniecia zaczepu wejsciowego
	 * @param event
	 * 				Zdarzenie myszy
	 */
	private void inputHandlerService(MouseEvent event){
		//TODO obsługa zaczepu wejściowego
		System.out.println("Wcisnieto zaczep wejscia");
	}
	
	
	/**
	 * Metoda wykonywana w przypadku wcisniecia zaczepu wejsciowego
	 * @param event
	 * 			Zdarzenie myszy
	 */
	private void outputHandlerService(MouseEvent event){
		//TODO obsługa zaczepu wyjściowego
		System.out.println("Wcisnieto zaczep wyjscia");
	}

}
