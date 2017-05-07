package model;


import java.awt.Dimension;
import java.awt.Point;
import java.util.regex.Pattern;

import model.interfaces.BlockInterface;

public class InputBlock extends Block implements BlockInterface{

    public InputBlock(Point p, Dimension dim) {
		super(p, dim);
		setContent(Conf.STANDARD_TEXT[Conf.BLOCK.INPUT.ordinal()]);
	}

    public void setPosition(int x, int y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
	public void update(){
		
	}
	
	public String getCode(){
		String returnString = "";
		String[] lines = getContent().split(System.getProperty("line.separator"));
		for (String line : lines) {
			line = line.replaceAll(Pattern.quote("+"), " << ");
			returnString += line;
		}
		return "cout << " + returnString + " << endl;";
	}
    
}
