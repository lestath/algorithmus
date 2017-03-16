package view.blocks;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import model.Conf;
import model.OperatingBlock;
import model.interfaces.GraphicsBlockInterface;


/**
 * 
 * Klasa reprezentująca graficzny element (Blok operacyjny)
 *
 */
public class Operating extends Rectangle implements GraphicsBlockInterface{

	private  OperatingBlock block;
	private  TextArea blocktextarea;
	public Operating(OperatingBlock blo){
		block = blo;
		this.setWidth(block.getSize().getWidth());
		this.setHeight(block.getSize().getHeight());
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
	
	public OperatingBlock getBlock() {
		return block;
	}
	public void setBlock(OperatingBlock block) {
		this.block = block;
	}
	public TextArea getBlocktextarea() {
		return blocktextarea;
	}
	public void setBlocktextarea(TextArea blocktextarea) {
		this.blocktextarea = blocktextarea;
	}

}
