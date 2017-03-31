package view.handlers;

import model.Block;
import model.DecisionBlock;

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
		// przemieszczenie strzałki
		if(this.arrow!=null){
		   this.arrow.getStart().setLocation(
				    this.getLayoutX() + this.getWidth()/2,
				   	this.getLayoutY()+ this.getHeight()/2
				   );
		   this.arrow.move();
		}
	}
	
	public void setConnected(Block connected) {
		this.connected = connected;
		DecisionBlock db = (DecisionBlock) this.block;
		db.setNoblock(this.connected);
		System.out.println("Podłączam nastepnik lewy na nie");
		System.out.println(this.connected.getContent());
		
	}
	
}
