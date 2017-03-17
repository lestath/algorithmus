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
			if(event.getEventType().equals(MouseEvent.MOUSE_DRAGGED)){
				if(!ViewParams.ARROW_MODE){
					this.moveBlock(event);		
				}
			}
			
			if(event.getEventType().equals(MouseEvent.MOUSE_MOVED)){
				if(ViewParams.ARROW_MODE){
					this.arrowMove(event);
				}
			}
			
			// jeżeli kliknięcie
			if(event.getEventType().equals(MouseEvent.MOUSE_CLICKED)){
				if(event.getSource() instanceof InHandler){
					System.out.println("Chyba ok");
					this.inputHandlerService(event);
				}else if(event.getSource() instanceof OutHandler){
					this.outputHandlerService(event);
				}else if(event.getSource() instanceof AnchorPane){
					if(event.getButton().equals(event.isSecondaryButtonDown())){
						this.arrowOnScreenMoveService(event);
					}
				}
			}
	}
	
	/**
	 * Metoda obsługi kliknięcia na screen gdy jest w trybie strzałek
	 * @param event
	 */
	private void arrowOnScreenMoveService(MouseEvent event){
		if(ViewParams.ARROW_MODE){
			if(ViewParams.ACTUAL_ARROW!=null){
				AnchorPane src = (AnchorPane) event.getSource();
				src.getChildren().remove(ViewParams.ACTUAL_ARROW.getRightarm());
				src.getChildren().remove(ViewParams.ACTUAL_ARROW.getLeftarm());
				src.getChildren().remove(ViewParams.ACTUAL_ARROW);
				ViewParams.ACTUAL_ARROW = null;
				ViewParams.ARROW_MODE = false;
				System.out.println("Weszło w usuwanie szczaly");
			}
		}
	}
	

	/**
	 * Metoda obsługi ruchu myszki ze strzałką
	 * @pam event
	 */
	private void arrowMove(MouseEvent event) {
		// TODO obsluga strzałki  (łacznika bloków)
		Arrow ar = ViewParams.ACTUAL_ARROW;
		ar.move(event.getX(),event.getY());
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
			InHandler src  = (InHandler) event.getSource();
			ViewParams.ARROW_MODE = false;
			ViewParams.ARROW_LIST.add(ViewParams.ACTUAL_ARROW);
			ViewParams.ACTUAL_ARROW = null;
		}
	}
	
	
	/**
	 * Metoda wykonywana w przypadku wcisniecia zaczepu wejsciowego
	 * @param event
	 * 			Zdarzenie myszy
	 */
	private void outputHandlerService(MouseEvent event){
		//TODO obsługa zaczepu wyjściowego
		if(ViewParams.ACTUAL_ARROW== null){
			System.out.println("Wcisnieto zaczep wyjscia");
			OutHandler src  = (OutHandler) event.getSource();
			ViewParams.ARROW_MODE = true;
			ViewParams.ACTUAL_ARROW = new Arrow(
					 new Point((int)src.getLayoutX(),(int)src.getLayoutY())
					, new Point((int)src.getLayoutX()+50,(int)src.getLayoutY()+50)
					,this.cont.getBlockPane()
			);
		}
	}

}
