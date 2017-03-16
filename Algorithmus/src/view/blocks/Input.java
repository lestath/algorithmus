package view.blocks;

import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Polygon;
import model.Conf;
import model.InputBlock;
import model.interfaces.GraphicsBlockInterface;

public class Input extends Polygon implements GraphicsBlockInterface{

	private  InputBlock block;
	private  TextArea blocktextarea;
	
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
		this.refresh();

	}
	@Override
	public void refresh() {
		this.relocate(block.getPosition().getX(),block.getPosition().getY());
		if(this.blocktextarea!= null){
			this.labelRelocation();
		}
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void prepair(AnchorPane pan) {
		this.blocktextarea = new TextArea();
		System.out.println(block.getContent());
		this.blocktextarea.setPromptText(block.getContent());
		this.blocktextarea.setFocusTraversable(false);;
		this.blocktextarea.setPrefWidth(this.block.getSize().getWidth()*0.7);
		this.blocktextarea.setPrefHeight(this.block.getSize().getHeight()*0.8);
		pan.getChildren().add(this.blocktextarea);
		this.blocktextarea.impl_processCSS(true);
		this.refresh();
	}
	
	private void labelRelocation(){
		this.blocktextarea.relocate(
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
	public TextArea getBlocktextarea() {
		return blocktextarea;
	}
	public void setBlocktextarea(TextArea blocktextarea) {
		this.blocktextarea = blocktextarea;
	}

}
