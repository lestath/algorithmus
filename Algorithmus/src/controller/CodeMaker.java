package controller;

import model.Block;
import model.BlocksHolder;
import model.interfaces.BlockInterface;

/**
 * 
 * Klasa obsługująca generowanie kodu ze schematu blokowego
 *
 */
public class CodeMaker {
	
	public static void generateCode(){
		//TODO to tylko kod testowy
		Block b;
		for(BlockInterface block : BlocksHolder.blocklist){
			b = (Block) block;
			System.out.println(b.getContent());
		}
	}
}
