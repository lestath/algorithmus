package view.blocks;


import java.awt.Dimension;

import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Ellipse;
import model.BlocksHolder;
import model.Conf;
import model.NodeBlock;
import model.interfaces.GraphicsBlockInterface;
import view.handlers.InHandler;
import view.handlers.LeftInHandler;
import view.handlers.OutHandler;
import view.handlers.RightInHandler;

public class Node extends Ellipse implements GraphicsBlockInterface{
	private NodeBlock block;
	private OutHandler out;
	private InHandler in;
	private LeftInHandler leftin;
	private RightInHandler rightin;
	
	
	public Node(NodeBlock block){
		this.block = block;
		this.block.setSize(new Dimension((int)block.getSize().getWidth(),(int)block.getSize().getHeight()));
		this.setRadiusX(block.getSize().getWidth()/2);
		this.setRadiusY(block.getSize().getHeight()/2);
		this.setFill(Conf.NODE_COLOR);
		this.refresh();
	}


	@Override
	public void refresh() {
		this.relocate(block.getPosition().getX(),block.getPosition().getY());
		if(this.getIn()!=null){
			this.in.move();
		}
		if(this.getOut()!=null){
			this.out.move();
		}
		if(this.getLeftin()!=null){
			this.leftin.move();
		}
		if(this.getRightin()!=null){
			this.rightin.move();
		}
	}



	@Override
	public void prepair(AnchorPane pan) {
		this.setIn(new InHandler(this.getBlock(),this.getBlock().getPrevious()));
		this.setOut(new OutHandler(this.getBlock(),this.getBlock().getNext()));
		this.setLeftin(new LeftInHandler(this.getBlock(),this.getBlock().getLeftinblock()));
		this.setRightin(new RightInHandler(this.getBlock(),this.getBlock().getRaightinblock()));
		double w = this.block.getSize().getWidth()*0.15;
		this.in.setWidth(w);
		this.out.setWidth(w);
		this.leftin.setWidth(w);
		this.rightin.setWidth(w);
		pan.getChildren().add(this.in);
		pan.getChildren().add(this.out);
		pan.getChildren().add(this.leftin);
		pan.getChildren().add(this.rightin);
		this.refresh();
	}


	public NodeBlock getBlock() {
		return block;
	}


	public void setBlock(NodeBlock block) {
		this.block = block;
	}


	public OutHandler getOut() {
		return out;
	}


	public void setOut(OutHandler out) {
		this.out = out;
	}


	public InHandler getIn() {
		return in;
	}


	public void setIn(InHandler in) {
		this.in = in;
	}


	public LeftInHandler getLeftin() {
		return leftin;
	}


	public void setLeftin(LeftInHandler leftout) {
		this.leftin = leftout;
	}


	public RightInHandler getRightin() {
		return rightin;
	}


	public void setRightin(RightInHandler rightin) {
		this.rightin = rightin;
	}


	@Override
	public void delete() {
		this.in.removeHandler();
		this.out.removeHandler();
		this.leftin.removeHandler();
		this.rightin.removeHandler();
		AnchorPane pan = (AnchorPane)this.getParent();
		BlocksHolder.blocklist.remove(this.block);
		this.block = null;

		pan.getChildren().remove(this);
	}
	
	
	
}
