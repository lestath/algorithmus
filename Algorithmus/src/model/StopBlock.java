package model;

import java.awt.Dimension;
import java.awt.Point;

import model.interfaces.BlockInterface;

public class StopBlock extends Block implements BlockInterface{

	public StopBlock(Point p,Dimension dim) {
		super(p,dim);
		setContent(Conf.STANDARD_TEXT[Conf.BLOCK.STOP.ordinal()]);
	}

	public void update(){
		
	}
	
	public String getCode(){
		return "}";
	}
}
