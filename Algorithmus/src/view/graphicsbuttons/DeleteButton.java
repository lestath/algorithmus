package view.graphicsbuttons;

import java.awt.Point;

import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import model.Conf;

/**
 * 
 * Klasa reprezentuje przycisk przejścia w tryb usuwania
 *
 */
public class DeleteButton extends Rectangle {
	
	public DeleteButton(Point start){
		this.setLayoutX(start.getX());
		this.setLayoutY(start.getY());
		this.setWidth(Conf.MENU_ELEMS_DIM.getWidth());
		this.setHeight(Conf.MENU_ELEMS_DIM.getHeight());
		this.setNormalLook();
	}
	
	/**
	 * Ustawia wygląd przycisku w trybie normalnym
	 */
	public void setNormalLook(){
		this.setFill(Paint.valueOf("green"));
	}
	
	/**
	 * ustawia wygląd przycisku w trybie usuwania 
	 */
	public void setDeleteLook(){
		this.setFill(Paint.valueOf("red"));
	}

}
