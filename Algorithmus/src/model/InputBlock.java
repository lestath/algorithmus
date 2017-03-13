package model;


import model.interfaces.BlockInterface;

public class InputBlock extends Block implements BlockInterface{

    InputBlock(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	public void setContent(String content) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setPosition(int x, int y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
	public void update(){
		
	}
	
	public String getCode(){
		return null;
		
	}
    
}
