package view.blocks;

import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Polygon;
import model.BlocksHolder;
import model.Conf;
import model.InputBlock;
import model.interfaces.GraphicsBlockInterface;
import view.handlers.InHandler;
import view.handlers.OutHandler;

public class Input extends Polygon implements GraphicsBlockInterface{

	private  InputBlock block;
	private  TextArea blockfield;
	private InHandler in;
	private OutHandler out;
	
	
	public Input(InputBlock blo){
		block = blo;
		this.getPoints().addAll(new Double[]{
				this.block.getPosition().getX()+this.block.getSize().getWidth()*0.15,
				this.block.getPosition().getY(),
				this.block.getPosition().getX(),
				this.block.getPosition().getY()+this.block.getSize().getHeight(),
				this.block.getPosition().getX()+this.block.getSize().getWidth()*0.85,
				this.block.getPosition().getY()+this.block.getSize().getHeight(),
				this.block.getPosition().getX()+this.block.getSize().getWidth(),
				this.block.getPosition().getY(),
				this.block.getPosition().getX()+this.block.getSize().getWidth()*0.15,
				this.block.getPosition().getY()
				
			});
		this.setFill(Conf.BLOCK_COLOR);
		this.blockfield = new TextArea();
		this.refresh();

	}
	@Override
	public void refresh() {
		this.relocate(block.getPosition().getX(),block.getPosition().getY());
		if(this.blockfield!= null){
			this.labelRelocation();
		}
		if(this.getIn()!=null){
			this.in.move();
		}
		if(this.getOut()!=null){
			this.out.move();
		}
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void prepair(AnchorPane pan) {
		System.out.println(block.getContent());
		this.blockfield.setPromptText(block.getContent());
		this.blockfield.setFocusTraversable(false);;
		this.blockfield.setPrefWidth(this.block.getSize().getWidth()*0.7);
		this.blockfield.setPrefHeight(this.block.getSize().getHeight()*0.8);
		this.setIn(new InHandler(this.getBlock(),this.getBlock().getPrevious()));
		this.setOut(new OutHandler(this.getBlock(),this.getBlock().getNext()));
		pan.getChildren().add(this.blockfield);
		pan.getChildren().add(this.in);
		pan.getChildren().add(this.out);
		this.blockfield.impl_processCSS(true);
		this.refresh();
	}
	
	private void labelRelocation(){
		this.blockfield.relocate(
				this.block.getPosition().getX()+0.15*this.block.getSize().getWidth(),
				this.block.getPosition().getY()+0.1*this.block.getSize().getHeight()
		);
	}
	
	public InputBlock getBlock() {
		return block;
	}
	
	public void setBlock(InputBlock block) {
		this.block = block;
	}
	public TextArea getBlockfield() {
		return blockfield;
	}
	public void setBlockfield(TextArea blockfield) {
		this.blockfield = blockfield;
	}
	public InHandler getIn() {
		return in;
	}
	public void setIn(InHandler in) {
		this.in = in;
	}
	public OutHandler getOut() {
		return out;
	}
	public void setOut(OutHandler out) {
		this.out = out;
	}
	@Override
	public void delete() {
		this.in.removeHandler();
		this.out.removeHandler();
		BlocksHolder.blocklist.remove(this.block);
		AnchorPane pan = (AnchorPane)this.getParent();
		pan.getChildren().remove(this.blockfield);
		
		this.block = null;
		this.blockfield = null;
		
		pan.getChildren().remove(this);
	}

}
