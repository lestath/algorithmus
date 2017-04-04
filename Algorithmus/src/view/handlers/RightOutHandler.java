package view.handlers;

import model.Block;
import model.DecisionBlock;

/**
 * 
 * Klasa reprezentująca prawy zaczep bloku
 *
 */
public class RightOutHandler extends OutHandler {

	public RightOutHandler(Block bl,Block b) {
		super(bl,b);
		// TODO Auto-generated constructor stub
	}

	public void move(){
		relocate(
				this.block.getPosition().getX()-this.getWidth()/2+this.block.getSize().getWidth(),
				this.block.getPosition().getY()+this.block.getSize().getHeight()/2-this.getHeight()/2
				);
		// przemieszczenie strzałki
		if(this.arrow!=null){
		   this.arrow.getStart().setLocation(
				    this.getLayoutX() + this.getWidth()/2,
				   	this.getLayoutY()+ this.getHeight()/2
				   );
		   this.arrow.move();
		}
	}
}
