package view.handlers;

import model.Block;


public class RightInHandler extends InHandler{

	public RightInHandler(Block bl, Block b) {
		super(bl, b);
		// TODO Auto-generated constructor stub
	}
	
	public void move(){
			relocate(
				this.block.getPosition().getX()+this.block.getSize().getWidth()-this.getWidth()/2,
				this.block.getPosition().getY()+this.block.getSize().getHeight()/2-this.getHeight()/2
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
