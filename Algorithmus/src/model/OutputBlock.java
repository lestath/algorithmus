package model;

import java.awt.Dimension;
import java.awt.Point;

import model.interfaces.BlockInterface;

public class OutputBlock extends Block implements BlockInterface{

	OutputBlock(Point p,Dimension dim) {
		super(p,dim);
	}
	
	public void update(){
		
	}
	
	public String getCode(){
		return null;
		
	}

}
