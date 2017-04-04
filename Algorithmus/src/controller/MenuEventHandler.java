package controller;

import java.awt.Point;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import model.BlocksHolder;
import model.Conf;
import model.DecisionBlock;
import model.InputBlock;
import model.NodeBlock;
import model.OperatingBlock;
import model.StartBlock;
import model.StopBlock;
import view.blocks.Decision;
import view.blocks.Input;
import view.blocks.Node;
import view.blocks.Operating;
import view.blocks.Start;
import view.blocks.Stop;
import view.graphicsbuttons.DeleteButton;

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
		}else if(this.generator instanceof NodeBlock){
			this.nodeHandle();
		}else if(this.generator instanceof DeleteButton){
			this.deleteHandle();
		}
	}
	


	private void nodeHandle() {
		NodeBlock myblock = new NodeBlock((Point)Conf.NEW_ELEMENT_POS.clone(),(Dimension)Conf.STANDARD_BLOCK_DIM.clone());
		 Node op = new Node(myblock);
		 BlocksHolder.blocklist.add(myblock);
		
		 op.setOnMouseDragged(new ScreenEventHandler(this.controller,myblock,op));
		
		 this.controller.getBlockPane().getChildren().add(op);
		 
		 op.prepair(this.controller.getBlockPane());
		 op.getOut().setOnMouseClicked(new ScreenEventHandler(this.controller,myblock,op));
		 op.getIn().setOnMouseClicked(new ScreenEventHandler(this.controller,myblock,op));
		 op.getLeftin().setOnMouseClicked(new ScreenEventHandler(this.controller,myblock,op));
		 op.getRightin().setOnMouseClicked(new ScreenEventHandler(this.controller,myblock,op));
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
		 op.getIn().setOnMouseClicked(new ScreenEventHandler(this.controller,myblock,op));
		 op.getOut().setOnMouseClicked(new ScreenEventHandler(this.controller,myblock,op));
	}
	
	private void startHandle(){
		if(!CodeMaker.checkSingleStartBlock()){  // najpierw sprawdzenie bo może być tylko jeden blok startu
			 StartBlock myblock = new StartBlock((Point)Conf.NEW_ELEMENT_POS.clone(),(Dimension)Conf.STANDARD_BLOCK_DIM.clone());
			 Start op = new Start(myblock);
			 BlocksHolder.blocklist.add(myblock);
			
			 op.setOnMouseDragged(new ScreenEventHandler(this.controller,myblock,op));
			
			 this.controller.getBlockPane().getChildren().add(op);
			 
			 op.prepair(this.controller.getBlockPane());
			 op.getOut().setOnMouseClicked(new ScreenEventHandler(this.controller,myblock,op));
		}
		 
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
		 op.getIn().setOnMouseClicked(new ScreenEventHandler(this.controller,myblock,op));
		 op.getLeftOut().setOnMouseClicked(new ScreenEventHandler(this.controller,myblock,op));
		 op.getRightOut().setOnMouseClicked(new ScreenEventHandler(this.controller,myblock,op));
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
		 op.getIn().setOnMouseClicked(new ScreenEventHandler(this.controller,myblock,op));
		 op.getOut().setOnMouseClicked(new ScreenEventHandler(this.controller,myblock,op));
	}
	
	private void stopHandle(){
		if(!CodeMaker.checkSingleStopBlock()){  // najpierw sprawdzenie bo może być tylko jeden blok stopu
		 StopBlock myblock = new StopBlock((Point)Conf.NEW_ELEMENT_POS.clone(),(Dimension)Conf.STANDARD_BLOCK_DIM.clone());
		 Stop op = new Stop(myblock);
		 BlocksHolder.blocklist.add(myblock);
		 op.setOnMouseDragged(new ScreenEventHandler(this.controller,myblock,op));
		 assert this.controller != null : "Empty contorrler";
		 this.controller.getBlockPane().getChildren().add(op);
		 assert this.controller.getBlockPane() != null : "Block pane null";
		 op.prepair(this.controller.getBlockPane());
		 op.getIn().setOnMouseClicked(new ScreenEventHandler(this.controller,myblock,op));
		}
		 
		 //TODO linijka ponizej do wyrzucenia
		// CodeMaker.generateCode();
	}
	
	private void deleteHandle() {
		if(ViewParams.MODE.equals(Mode.Delete)){
			ViewParams.MODE = Mode.Normal;
			this.controller.getDelete().setNormalLook();
		}else{
			ViewParams.MODE = Mode.Delete;
			this.controller.getDelete().setDeleteLook();
		}
	}
	
}
