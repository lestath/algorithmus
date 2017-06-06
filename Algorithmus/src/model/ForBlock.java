package model;

import java.awt.Dimension;
import java.awt.Point;

import model.interfaces.BlockInterface;

public class ForBlock extends Block implements BlockInterface {

	private Block noblock;  // odpowiedź nie w bloku decyzyjnym
	
    public ForBlock(Point p,Dimension dim){
		super(p,dim);
		setContent(Conf.STANDARD_TEXT[Conf.BLOCK.FOR.ordinal()]);
	}
    public void setPosition(int x, int y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
	public void update(){
		
	}
	
	public String getCode(){
		return "for(" + getContent() + ") {";
	}
	public Block getNoblock() {
		return noblock;
	}
	public void setNoblock(Block noblock) {
		this.noblock = noblock;
	}
}
