package view.handlers;

import model.Block;

public class LeftInHandler extends InHandler {

	public LeftInHandler(Block bl, Block b) {
		super(bl, b);
		// TODO Auto-generated constructor stub
	}
	
	public void move(){
		relocate(
				this.block.getPosition().getX(),
				this.block.getPosition().getY()+this.block.getSize().getHeight()
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
