package model;

import java.awt.Dimension;
import java.awt.Point;

import model.interfaces.BlockInterface;

public class StartBlock extends Block implements BlockInterface{


	public StartBlock(Point p,Dimension dim) {
		super(p,dim);
		this.setContent("Start");
	}

	public void update(){
		
	}
	
	public String getCode(){
		return null;
		
	}
}
