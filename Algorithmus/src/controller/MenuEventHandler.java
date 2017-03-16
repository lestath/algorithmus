package controller;

import java.awt.Point;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import model.BlocksHolder;
import model.Conf;
import model.DecisionBlock;
import model.InputBlock;
import model.OperatingBlock;
import model.StartBlock;
import model.StopBlock;
import view.blocks.Decision;
import view.blocks.Input;
import view.blocks.Operating;
import view.blocks.Start;
import view.blocks.Stop;

import java.awt.Dimension;

/**
 * 
 * Klasa odpowiedzialna za obsługę zdarzeń myszy na elementach menu
 * 
 */
public class MenuEventHandler implements EventHandler<MouseEvent>{


	private MainController controller;

	private Object generator;
	
	public MenuEventHandler(MainController cont, Object gen){
		this.generator = gen;
		controller = cont;
	}
	
	/**
	 * metoda obsługi zdarzeń myszy
	 */
	@Override
	public void handle(MouseEvent event) {
		if(this.generator instanceof StartBlock){
			this.startHandle();
		}else if(this.generator instanceof OperatingBlock){
			this.operatingHandle();
		}else if(this.generator instanceof DecisionBlock){
			this.decisionHandle();
		}else if(this.generator instanceof InputBlock){
			this.inputHandle();
		}else if(this.generator instanceof StopBlock){
			this.stopHandle();
		}
	}
	
	private void operatingHandle(){
		 OperatingBlock myblock = new OperatingBlock((Point)Conf.NEW_ELEMENT_POS.clone(),(Dimension)Conf.STANDARD_BLOCK_DIM.clone());
		 Operating op = new Operating(myblock);
		 BlocksHolder.blocklist.add(myblock);
		
		 //eventy
		 op.setOnMouseDragged(new ScreenEventHandler(this.controller,myblock,op));
		 op.getBlockfield().setOnKeyPressed(new KeyEventHandler(this.controller,myblock,op.getBlockfield()));

		  
		 this.controller.getBlockPane().getChildren().add(op);
		 op.prepair(this.controller.getBlockPane());
	}
	
	private void startHandle(){
		 StartBlock myblock = new StartBlock((Point)Conf.NEW_ELEMENT_POS.clone(),(Dimension)Conf.STANDARD_BLOCK_DIM.clone());
		 Start op = new Start(myblock);
		 BlocksHolder.blocklist.add(myblock);
		 op.setOnMouseDragged(new ScreenEventHandler(this.controller,myblock,op));
		 assert this.controller != null : "Empty contorrler";
		 this.controller.getBlockPane().getChildren().add(op);
		 assert this.controller.getBlockPane() != null : "Block pane null";
		 op.prepair(this.controller.getBlockPane());
	}

	private void decisionHandle(){
		 DecisionBlock myblock = new DecisionBlock((Point)Conf.NEW_ELEMENT_POS.clone(),(Dimension)Conf.STANDARD_BLOCK_DIM.clone());
		 Decision op = new Decision(myblock);
		 BlocksHolder.blocklist.add(myblock);
		 
		 // eventy
		 op.setOnMouseDragged(new ScreenEventHandler(this.controller,myblock,op));
		 op.getBlockfield().setOnKeyPressed(new KeyEventHandler(this.controller,myblock,op.getBlockfield()));
		
		 
		 this.controller.getBlockPane().getChildren().add(op);
		 op.prepair(this.controller.getBlockPane());
	}
	
	private void inputHandle(){
		 InputBlock myblock = new InputBlock((Point)Conf.NEW_ELEMENT_POS.clone(),(Dimension)Conf.STANDARD_BLOCK_DIM.clone());
		 Input op = new Input(myblock);
		 BlocksHolder.blocklist.add(myblock);
		
		 //eventy
		 op.setOnMouseDragged(new ScreenEventHandler(this.controller,myblock,op));
		 op.getBlockfield().setOnKeyPressed(new KeyEventHandler(this.controller,myblock,op.getBlockfield()));
		 
		 
		 this.controller.getBlockPane().getChildren().add(op);
		 op.prepair(this.controller.getBlockPane());
	}
	
	private void stopHandle(){
		 StopBlock myblock = new StopBlock((Point)Conf.NEW_ELEMENT_POS.clone(),(Dimension)Conf.STANDARD_BLOCK_DIM.clone());
		 Stop op = new Stop(myblock);
		 BlocksHolder.blocklist.add(myblock);
		 op.setOnMouseDragged(new ScreenEventHandler(this.controller,myblock,op));
		 assert this.controller != null : "Empty contorrler";
		 this.controller.getBlockPane().getChildren().add(op);
		 assert this.controller.getBlockPane() != null : "Block pane null";
		 op.prepair(this.controller.getBlockPane());
		 
		 //TODO linijka ponizej do wyrzucenia
		 CodeMaker.generateCode();
	}
	
}
