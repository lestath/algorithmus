package view.handlers;

import model.Block;

/**
 * 
 * Klasa reprezentująca prawy zaczep bloku
 *
 */
public class RightOutHandler extends OutHandler {

	public RightOutHandler(Block bl) {
		super(bl);
		// TODO Auto-generated constructor stub
	}

	public void move(){
		relocate(
				this.block.getPosition().getX()-this.getWidth()/2+this.block.getSize().getWidth(),
				this.block.getPosition().getY()+this.block.getSize().getHeight()/2-this.getHeight()/2
				);
	}
}
