package view.handlers;

import model.Block;

/**
 * 
 * Klasa reprezentująca lewy zaczep bloku
 *
 */
public class LeftOutHandler extends OutHandler{

	public LeftOutHandler(Block bl,Block b) {
		super(bl,b);
	}

	public void move(){
		relocate(
				this.block.getPosition().getX()-this.getWidth()/2,
				this.block.getPosition().getY()+this.block.getSize().getHeight()/2-this.getHeight()/2
				);
	}
	
}
