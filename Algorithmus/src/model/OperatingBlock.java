package model;

import java.awt.Dimension;

import model.interfaces.BlockInterface;

public class OperatingBlock extends Block implements BlockInterface{

	public OperatingBlock(int x, int y,Dimension dim) {
		super(x, y);
		super.setSize(dim);
		// TODO Auto-generated constructor stub
	}
	
	public void update(){
		
	}
	
	public String getCode(){
		return null;
	}
}
