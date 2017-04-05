package view.graphicsbuttons;

import java.awt.Point;

import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import model.Conf;

/**
 * 
 * Klasa reprezentuje przycisk przejścia w tryb usuwania
 *
 */
public class DeleteButton extends Rectangle {
	
	private ImagePattern background1;
	private ImagePattern background2;
	
	public DeleteButton(Point start){
		this.setLayoutX(start.getX());
		this.setLayoutX(start.getY());
		AnchorPane p = (AnchorPane)this.getParent();
		this.setWidth(Conf.DELETE_BTN_DIM.getWidth());
		this.setHeight(Conf.DELETE_BTN_DIM.getHeight());
		Image img = new Image(this.getClass().getResource("/resources/DeleteRed.png").toString());
		Image img2 = new Image(this.getClass().getResource("/resources/DeleteRedUsing.png").toString());
		this.background1 = new ImagePattern(img);
		this.background2 = new ImagePattern(img2);
		this.setNormalLook();
	}
	
	/**
	 * Ustawia wygląd przycisku w trybie normalnym
	 */
	public void setNormalLook(){
		this.setFill(this.background1);
	}
	
	/**
	 * ustawia wygląd przycisku w trybie usuwania 
	 */
	public void setDeleteLook(){
		this.setFill(this.background2);
	}

}
