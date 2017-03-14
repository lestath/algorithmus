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

	public OperatingBlock(int x, int y,Dimension dim) {
		super(x, y);
		super.setSize(dim);
		// TODO Auto-generated constructor stub
	}
	
	public OperatingBlock(int x, int y,Dimension dim,Point p) {
		super(x, y);
		super.setSize(dim);
		super.setPosition(p);
		// TODO Auto-generated constructor stub
	}
	
	public void update(){
		
	}
	
	public String getCode(){
		return null;
	}
}
