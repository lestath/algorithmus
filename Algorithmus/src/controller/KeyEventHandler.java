package controller;

import javafx.event.EventHandler;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import model.Block;

/**
 * 
 * Klasa odbierająca wydarzenia na przyciskach klawiatury
 *
 */
public class KeyEventHandler implements EventHandler<KeyEvent> {

	private MainController controller;
	private Object object;
	private Block block;
	
	public KeyEventHandler(MainController cont,Block blo,Object ob){
		this.controller = cont;
		this.object = ob;
		this.block = blo;
	}
	@Override
	public void handle(KeyEvent event) {
		if(event.getCode()==KeyCode.ENTER){
			this.onEnter();
		}

	}

	/*
	 *  Metoda wykonująca sie po przyciśnięciu klawisza Enter
	 */
	private void onEnter(){
		
		if(this.object instanceof TextField){
			TextField tf = (TextField) this.object;
			if(!tf.getText().isEmpty()){
				this.block.setContent(tf.getText());
				this.controller.getBlockPane().requestFocus();
			}
			
		}else if( this.object instanceof TextArea){
			TextArea ta = (TextArea) this.object;
			if(!ta.getText().isEmpty()){
				this.block.setContent(ta.getText());
				this.controller.getBlockPane().requestFocus();
			}
			
		}
	}
	
}
