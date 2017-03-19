package view.handlers;


import model.Block;
import model.Conf;

/* 
 * Klasa reprezentująca zaczep linii wyjściowej z bloku
 *
 */
public class OutHandler extends Handler{

	public OutHandler(Block bl) {
		super(bl);
		this.setFill(Conf.OUT_HANDLER_COLOR);
	}

	public void move(){
		relocate(
				this.block.getPosition().getX()+this.block.getSize().getWidth()/2-this.getWidth()/2,
				this.block.getPosition().getY()+this.block.getSize().getHeight()-this.getHeight()/2
				);
	}
	
}
