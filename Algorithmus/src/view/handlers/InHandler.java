package view.handlers;


import model.Block;
import model.Conf;

/**
 * Klasa reprezentująca zaczep linii wejścia bloku
 *
 */
public class InHandler extends Handler{

	public InHandler(Block bl) {
		super(bl);
		this.setFill(Conf.IN_HANDLER_COLOR);
	}

	public void move(){
		relocate(
				this.block.getPosition().getX()+this.block.getSize().getWidth()/2-this.getWidth()/2,
				this.block.getPosition().getY()-this.getHeight()/2
		);
	}
}
