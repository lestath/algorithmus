package view.handlers;

import javafx.scene.shape.Rectangle;
import model.Block;

/**
 * 
 * Klasa Reprezentująca zaczep linii dla bloku
 *
 */
public class Handler extends Rectangle {
	Block block;

	public Handler(Block bl){
		this.block = bl;
		this.setWidth(this.block.getSize().getWidth()*0.08);
		this.setHeight(this.block.getSize().getHeight()*0.1);
	}
	
	public Block getBlock() {
		return block;
	}
	public void setBlock(Block block) {
		this.block = block;
	}
}
