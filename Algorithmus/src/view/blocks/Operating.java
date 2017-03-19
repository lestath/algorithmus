package view.blocks;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import model.Conf;
import model.OperatingBlock;
import model.interfaces.GraphicsBlockInterface;
import view.handlers.InHandler;
import view.handlers.OutHandler;


/**
 * 
 * Klasa reprezentująca graficzny element (Blok operacyjny)
 *
 */
public class Operating extends Rectangle implements GraphicsBlockInterface{

	private  OperatingBlock block;
	private  TextArea blockfield;
	private InHandler in;
	private OutHandler out;
	
	public Operating(OperatingBlock blo){
		block = blo;
		this.setWidth(block.getSize().getWidth());
		this.setHeight(block.getSize().getHeight());
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
		this.blockfield.setFocusTraversable(false);
		this.blockfield.setPrefWidth(this.block.getSize().getWidth()*0.7);
		this.blockfield.setPrefHeight(this.block.getSize().getHeight()*0.8);
		this.setIn(new InHandler(this.getBlock()));
		this.setOut(new OutHandler(this.getBlock()));
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
	
	public OperatingBlock getBlock() {
		return block;
	}
	public void setBlock(OperatingBlock block) {
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
	
	

}
