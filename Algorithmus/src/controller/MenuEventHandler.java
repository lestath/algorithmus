package controller;

import java.awt.Point;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import model.Conf;
import model.OperatingBlock;
import view.blocks.Operating;
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
	
	@Override
	public void handle(MouseEvent event) {
		if(this.generator instanceof OperatingBlock){
			 System.out.println("weszło");
			 OperatingBlock myblock = new OperatingBlock((int)Conf.NEW_ELEMENT_POS.getX(),(int)Conf.NEW_ELEMENT_POS.getY(),(Dimension)Conf.STANDARD_BLOCK_DIM.clone(),(Point)Conf.NEW_ELEMENT_POS.clone());
			 Operating op = new Operating(myblock);
			 op.setOnMouseDragged(new ScreenEventHandler(myblock,op));
			 
			 this.controller.getBlockPane().getChildren().add(op);
		}
		System.out.println("nowy handler poszło");
	}

}
