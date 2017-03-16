package view.blocks;

import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Polygon;
import model.Conf;
import model.InputBlock;
import model.interfaces.GraphicsBlockInterface;

public class Input extends Polygon implements GraphicsBlockInterface{

	private  InputBlock block;
	private  TextArea blockfield;
	
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
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void prepair(AnchorPane pan) {
		System.out.println(block.getContent());
		this.blockfield.setPromptText(block.getContent());
		this.blockfield.setFocusTraversable(false);;
		this.blockfield.setPrefWidth(this.block.getSize().getWidth()*0.7);
		this.blockfield.setPrefHeight(this.block.getSize().getHeight()*0.8);
		pan.getChildren().add(this.blockfield);
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

}
