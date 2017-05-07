package model;


import java.awt.Dimension;
import java.awt.Point;

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
			String word[] = line.split(" ", 3);
			for (String w : word) {
				//System.err.println("w: " + w);
			}
			switch (word[0]) {
				case "int":
					returnString += "int";
					break;
				case "float":
					returnString += "float";
					break;
				case "string":
					returnString += "string";
					break;
				default:
					System.err.println("Typ jednej ze zmiennych nie jest zadeklarowany!");
					break;
			}
			returnString += " ";
			if (word[1].isEmpty()) {
				System.err.println("Zmienna musi mieć nazwę!");
			} else {
				returnString += word[1];
			}
			returnString += " ";
			returnString += word[2].replaceAll(":=", "=");
			returnString += ";";
		}

		return returnString;
	}
    
}
