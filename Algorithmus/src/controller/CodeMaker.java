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
	
	public static void generateCode(){
		//TODO to tylko kod testowy
		Block b;
		for(BlockInterface block : BlocksHolder.blocklist){
			b = (Block) block;

			if (b.getContent().equals("START")) {
				System.out.println("int main() {");
			}

			if (b.getContent().equals("STOP")) {
				System.out.println("int main() {");
			}

			//System.out.println(b.getContent());
		}
	}
	
	//TODO algorytm generowania kodu kodu
	// w tej metodzie można przeprowadzać testy algorytmów generowania kodu 
	public static void test(){
		ArrayList<BlockInterface> lst = BlocksHolder.blocklist;
		Block b;
		DecisionBlock db;
		boolean start = checkSingleStartBlock();
		boolean stop = checkSingleStopBlock();
		if(!start){System.out.println("No Start Block !!!"); return;}
		if(!stop){System.out.println("No Stop Block !!!"); return;}

		for(BlockInterface bl : lst){
			b = (Block) bl;
			if(b instanceof StartBlock){
				while(b != null){
					if(b instanceof DecisionBlock){
						db = (DecisionBlock) b;
						System.out.println("LEWY ->> " + db.getNoblock().getContent());
					}
					System.out.println(b.getCode());
					b = b.getNext();
				}
				break;
			}
		}
		


		
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
