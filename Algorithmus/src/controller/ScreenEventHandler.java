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
		this.cont = c;
		this.block = b;
		this.gpb = inter;
	}

	// Obsługa zdarzeń myszy na ekranie rysowania
	@Override
	public void handle(MouseEvent event) {
		    // jeżeli przesuniecie wcisnietego przycisku
			if(event.getEventType().equals(MouseEvent.MOUSE_CLICKED)){	
				if(ViewParams.MODE.equals(Mode.Delete)){
					if(event.getSource() instanceof Arrow){
						this.deleteArrow(event); // usuwanie strzałki
					}else if(!(event.getSource() instanceof AnchorPane)){
						if(event.getSource() instanceof Handler )return;
						GraphicsBlockInterface gbi = (GraphicsBlockInterface) event.getSource(); 
						gbi.delete(); // usuwanie bloku
					}
					return;
				}
				if(event.getSource() instanceof InHandler){
					this.inputHandlerService(event);
				}else if(event.getSource() instanceof OutHandler){
					this.outputHandlerService(event);
				}else if(event.getSource() instanceof AnchorPane){
					if(ViewParams.MODE.equals(Mode.Arrow)){
						//this.arrowOnScreenMoveService(event);
					}	
				}
			}else if(event.getEventType().equals(MouseEvent.MOUSE_DRAGGED)){
				if(ViewParams.MODE.equals(Mode.Normal)){
					this.moveBlock(event);		
				}
			}else if(event.getEventType().equals(MouseEvent.MOUSE_MOVED)){
				if(ViewParams.MODE.equals(Mode.Arrow)){
					this.arrowMove(event);
				}
			} 
	}
	
	/**
	 * Metoda usuwająca strzałkę łączącą
	 */
	private void deleteArrow(MouseEvent event) {
		Arrow ar = (Arrow) event.getSource();
		ar.getOwner().removeConnection();
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
		ViewParams.MODE = Mode.Normal;
	}
	

	/**
	 * Metoda obsługi ruchu myszki ze strzałką
	 * @pam event
	 */
	private void arrowMove(MouseEvent event) {
		if(ViewParams.MODE.equals(Mode.Delete)){return;}
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
		if(ViewParams.MODE.equals(Mode.Delete)){return;}
		double panelwidth = this.cont.getBlockPane().getWidth();//szerokosc panelu bloczow
		double panelheight = this.cont.getBlockPane().getHeight();
		double x = this.block.getPosition().getX();
		double y = this.block.getPosition().getY();
		Bounds b = cont.BlockPane.localToScene(cont.BlockPane.getBoundsInLocal());
		x = event.getSceneX() - b.getMinX();
		y = event.getSceneY()-b.getMinY();
		x = x - this.block.getSize().getWidth()/2;
		y = y - this.block.getSize().getHeight()/2;
		if(x+block.getSize().getWidth()>panelwidth){
			this.cont.getBlockPane().setPrefWidth(panelwidth + 300);
		}
		if(y+block.getSize().getHeight()>panelheight){
			this.cont.getBlockPane().setPrefHeight(panelheight + 300);
		}
		this.block.getPosition().setLocation(x,y);
		gpb.refresh();
	}
	

	/**
	 * Metoda wykonywana w przypadku wcisniecia zaczepu wejsciowego
	 * @param event
	 * 				Zdarzenie myszy
	 */
	private void inputHandlerService(MouseEvent event){
		if(ViewParams.MODE.equals(Mode.Delete)){return;}
		//TODO obsługa zaczepu wejściowego
		if(ViewParams.ACTUAL_ARROW!= null){
			Handler src  = (Handler) event.getSource();
			if(src.getArrow()==null){
				Arrow ar = ViewParams.ACTUAL_ARROW;
				Handler ph = ViewParams.ACTUAL_HANDLER;
				  if(src.getBlock()!= ph.getBlock()){
						ph.setConnected(src.getBlock());
						src.setArrow(ar);
						ar.setEnder(src);
						ar.setOnMouseClicked(new ScreenEventHandler(this.cont,this.block,this.gpb));
						InHandler in = (InHandler) src;
						in.move();
						ViewParams.MODE = Mode.Normal;
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
		if(ViewParams.MODE.equals(Mode.Delete)){return;}
		//TODO obsługa zaczepu wyjściowego
		if(ViewParams.ACTUAL_ARROW== null){
			Handler src  = (Handler)event.getSource();
			if(src.getArrow()==null){ // sprawdzenie cze nie ma już podpięcia
				ViewParams.ACTUAL_HANDLER = src;
				ViewParams.MODE = Mode.Arrow;
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
