package view.blocks;

import javafx.scene.shape.Rectangle;
import model.Conf;
import model.OperatingBlock;

/**
 * 
 * Klasa reprezentująca graficzny element (Blok operacyjny)
 *
 */
public class Operating extends Rectangle {
	OperatingBlock block;
	public Operating(OperatingBlock blo){
		block = blo;
		this.setWidth(block.getSize().getWidth());
		this.setHeight(block.getSize().getHeight());
		this.setFill(Conf.BLOCK_COLOR);
	}
}
