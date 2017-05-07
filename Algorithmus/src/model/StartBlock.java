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
		String returnString = "";

		returnString += "#include <stdio.h>";
		returnString += System.getProperty("line.separator");
		returnString += "#include <stdlib.h>";
		returnString += System.getProperty("line.separator");
		returnString += "using namespace std;";
		returnString += System.getProperty("line.separator");
		returnString += System.getProperty("line.separator");
		returnString += "int main(int args, char* argv[]) {";
		return returnString;
	}
}
