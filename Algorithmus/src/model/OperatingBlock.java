package model;

import java.awt.Dimension;
import java.awt.Point;

import model.interfaces.BlockInterface;

/**
 * 
 * Klasa bloku operacyjnego
 *
 */
public class OperatingBlock extends Block implements BlockInterface{

	public OperatingBlock(Point p,Dimension dim) {
		super(p,dim);
		setContent(Conf.STANDARD_TEXT[Conf.BLOCK.OPERATING.ordinal()]);

	}
	
	public void update(){
		
	}
	
	public String getCode(){
		return null;
	}
}
