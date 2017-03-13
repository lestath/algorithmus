package model;

import model.interfaces.BlockInterface;

public class DecisionBlock extends Block implements BlockInterface {

    DecisionBlock(int x, int y) {
        super(x, y);
    }

    public void setPosition(int x, int y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
	public void update(){
		
	}
	
	public String getCode(){
		return null;
		
	}
}
