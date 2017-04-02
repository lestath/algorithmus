package model;

import java.awt.Dimension;
import java.awt.Point;

import model.interfaces.BlockInterface;

public class StartBlock extends Block implements BlockInterface{


	public StartBlock(Point p,Dimension dim) {
		super(p,dim);
		setContent(Conf.STANDARD_TEXT[Conf.BLOCK.START.ordinal()]);
	}

	public void update(){
		
	}
	
	public String getCode(){
		return "int main(int args, char* argv[]) {";
	}
}
