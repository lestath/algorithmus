package controller;

import java.util.ArrayList;

import model.Block;
import model.BlocksHolder;
import model.DecisionBlock;
import model.StartBlock;
import model.StopBlock;
import model.interfaces.BlockInterface;

/**
 * 
 * Klasa obsługująca generowanie kodu ze schematu blokowego
 *
 */
public class CodeMaker {
	public static SourceManager sourceManager = SourceManager.getInstance();
	
	public static void generateCode(){
		//TODO to tylko kod testowy
		Block b;
		for(BlockInterface block : BlocksHolder.blocklist){
			
			b = (Block) block;

			System.out.println(b.getCode());
			sourceManager.addln(b.getCode());
		}
		sourceManager.save();
	}
	
	//TODO algorytm generowania kodu kodu
	// w tej metodzie można przeprowadzać testy algorytmów generowania kodu 
	public static void test(){
		//generateCode();
		ArrayList<BlockInterface> lst = BlocksHolder.blocklist;
		Block b;
		DecisionBlock db;
		boolean start = checkSingleStartBlock();
		boolean stop = checkSingleStopBlock();
		if(!start){System.out.println("No Start Block !!!"); return;}
		if(!stop){System.out.println("No Stop Block !!!"); return;}

		for(BlockInterface bl : lst) {
			b = (Block) bl;
			if(b instanceof StartBlock){
				while(b != null) {
					System.out.println(b.getCode());
					sourceManager.addln(b.getCode());
					if(b instanceof DecisionBlock){
						db = (DecisionBlock) b;
						System.out.println(db.getNoblock().getCode());
						sourceManager.addln(db.getNoblock().getCode());
						System.out.println("} else {");
						sourceManager.addln("} else {");
					}
					b = b.getNext();
				}
				break;
			}
		}
		sourceManager.save();
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
