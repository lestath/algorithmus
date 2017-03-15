package model;


import java.awt.Dimension;
import java.awt.Point;

import model.interfaces.BlockInterface;

public class InputBlock extends Block implements BlockInterface{

    InputBlock(Point p,Dimension dim) {
		super(p,dim);

	}

	public void setContent(String content) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
