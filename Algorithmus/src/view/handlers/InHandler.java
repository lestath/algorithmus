package view.handlers;


import model.Block;
import model.Conf;

/**
 * Klasa reprezentująca zaczep linii wejścia bloku
 *
 */
public class InHandler extends Handler{

	public InHandler(Block bl,Block b) {
		super(bl,b);
		this.setFill(Conf.IN_HANDLER_COLOR);
	}

	public void move(){
		relocate(
				this.block.getPosition().getX()+this.block.getSize().getWidth()/2-this.getWidth()/2,
				this.block.getPosition().getY()-this.getHeight()/2
		);
		
		// przemieszczenie strzałki
		if(this.arrow!=null){
		   this.arrow.getStop().setLocation(
				    this.getLayoutX() + this.getWidth()/2,
				   	this.getLayoutY()+ this.getHeight()/2
				   );
		   this.arrow.move();
		}
	}
}
