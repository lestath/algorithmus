package controller;

import java.awt.Point;

import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import model.Block;
import model.interfaces.GraphicsBlockInterface;
import view.Arrows.Arrow;
import view.handlers.Handler;
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
			if(event.getEventType().equals(MouseEvent.MOUSE_CLICKED)){
				if(event.getSource() instanceof InHandler){
					this.inputHandlerService(event);
				}else if(event.getSource() instanceof OutHandler){
					this.outputHandlerService(event);
				}else if(event.getSource() instanceof AnchorPane){
					if(ViewParams.ARROW_MODE){
						//this.arrowOnScreenMoveService(event);
					}	
				}
			}else if(event.getEventType().equals(MouseEvent.MOUSE_DRAGGED)){
				if(!ViewParams.ARROW_MODE){
					this.moveBlock(event);		
				}
			}else if(event.getEventType().equals(MouseEvent.MOUSE_MOVED)){
				if(ViewParams.ARROW_MODE){
					this.arrowMove(event);
				}
			} 
	}
	
	/**
	 * Metoda obsługi kliknięcia na screen gdy jest w trybie strzałek
	 * @param event
	 */
	private void arrowOnScreenMoveService(MouseEvent event){
		AnchorPane src = (AnchorPane) event.getSource();
		src.getChildren().remove(ViewParams.ACTUAL_ARROW );
		ViewParams.ARROW_LIST.remove(ViewParams.ACTUAL_ARROW);
		ViewParams.ACTUAL_HANDLER = null;
		ViewParams.ACTUAL_ARROW = null;
		ViewParams.ARROW_MODE = false;
	}
	

	/**
	 * Metoda obsługi ruchu myszki ze strzałką
	 * @pam event
	 */
	private void arrowMove(MouseEvent event) {
		// TODO obsluga strzałki  (łacznika bloków)
		Arrow ar = ViewParams.ACTUAL_ARROW;
		ar.move(event.getX()-10,event.getY()-10);
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
		if(ViewParams.ACTUAL_ARROW!= null){
			Handler src  = (Handler) event.getSource();
			if(src.getArrow()==null){
				Arrow ar = ViewParams.ACTUAL_ARROW;
				Handler ph = ViewParams.ACTUAL_HANDLER;
				  if(src.getBlock()!= ph.getBlock()){
						ph.setConnected(src.getBlock());
						src.setArrow(ar);
						
						InHandler in = (InHandler) src;
						in.move();
						ViewParams.ARROW_MODE = false;
						ViewParams.ARROW_LIST.add(ViewParams.ACTUAL_ARROW);
						ViewParams.ACTUAL_ARROW = null;
				  }
			}
			
		}
	}
	
	
	/**
	 * Metoda wykonywana w przypadku wcisniecia zaczepu wyjsciowego
	 * @param event
	 * 			Zdarzenie myszy
	 */
	private void outputHandlerService(MouseEvent event){
		//TODO obsługa zaczepu wyjściowego
		if(ViewParams.ACTUAL_ARROW== null){
			System.out.println("Wcisnieto zaczep wyjscia");
			Handler src  = (Handler)event.getSource();
			if(src.getArrow()==null){ // sprawdzenie cze nie ma już podpięcia
				ViewParams.ACTUAL_HANDLER = src;
				ViewParams.ARROW_MODE = true;
				ViewParams.ACTUAL_ARROW = new Arrow(
						 new Point((int)(src.getLayoutX()+src.getWidth()/2),(int)(src.getLayoutY()+src.getWidth()/2))
						, new Point((int)src.getLayoutX()+50,(int)src.getLayoutY()+50)
						,this.cont.getBlockPane()
				);
				Arrow ar = ViewParams.ACTUAL_ARROW;
				ar.setOwner(src);
				src.setArrow(ar);
				OutHandler o = (OutHandler) src;
				o.move();
			}
		}
	}

}
