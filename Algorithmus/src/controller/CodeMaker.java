package controller;

import java.util.ArrayList;

import model.Block;
import model.BlocksHolder;
import model.StartBlock;
import model.StopBlock;
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
	
	//TODO algorytm kodu
	// w tej metodzie można przeprowadzać testy algorytmów generowania kodu 
	public static void test(){
		ArrayList<BlockInterface> lst = BlocksHolder.blocklist;
		Block b;
		boolean start = checkSingleStartBlock();
		boolean stop = checkSingleStopBlock();

		for(BlockInterface bl : lst){
			b = (Block) bl;
			if(b instanceof StartBlock){
				while(b!=null){
					System.out.println(b.getContent());
					b = b.getNext();
				}
				break;
			}
		}
		

		if(!start){System.out.println("No Start Block !!!"); return;}
		if(!stop){System.out.println("No Stop Block !!!"); return;}
		
	}
	
	// metoda zwróci true jeżeli istnieje już blok startowy
	public static boolean checkSingleStartBlock(){
		ArrayList<BlockInterface> lst = BlocksHolder.blocklist;
		Block b;
		for(BlockInterface bl : lst){
			b = (Block) bl;
			if(b instanceof StartBlock){
				return true;
			}
		}
		
		return false;
	}
	
	// metoda zwróci true jeżeli istnieje już blok stopu
	public static boolean checkSingleStopBlock(){
		ArrayList<BlockInterface> lst = BlocksHolder.blocklist;
		Block b;
		for(BlockInterface bl : lst){
			b = (Block) bl;
			if(b instanceof StopBlock){
				return true;
			}
		}
		
		return false;
	}
}
