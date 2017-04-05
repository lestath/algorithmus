package view.blocks;

import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Ellipse;
import model.BlocksHolder;
import model.Conf;
import model.StopBlock;
import model.interfaces.GraphicsBlockInterface;
import view.handlers.InHandler;

public class Stop extends Ellipse implements GraphicsBlockInterface{
	private StopBlock block;
	private Label blocklabel;
	private InHandler in;
	
	public Stop(StopBlock StopBlock){
		block = StopBlock;
		this.setRadiusX(block.getSize().getWidth()/2);
		this.setRadiusY(block.getSize().getHeight()/2);
		this.setFill(Conf.BLOCK_COLOR);
		this.refresh();
	}
	@Override
	public void refresh() {
		this.relocate(block.getPosition().getX(),block.getPosition().getY());
		if(this.blocklabel!= null){
			labelRelocation();
		}
		if(this.getIn()!=null){
			this.getIn().move();
		}
	}
	
	public StopBlock getBlock() {
		return block;
	}
	public void setBlock(StopBlock block) {
		this.block = block;
	}
	public Label getBlocklabel() {
		return blocklabel;
	}
	public void setBlocklabel(Label blocklabel) {
		this.blocklabel = blocklabel;
	}
	

	@SuppressWarnings("deprecation")
	@Override
	public void prepair(AnchorPane pan){
		this.blocklabel = new Label(this.block.getContent());
		this.in = new InHandler(this.getBlock(),this.getBlock().getPrevious());
		pan.getChildren().add(this.in);
		pan.getChildren().add(this.blocklabel);
		this.blocklabel.impl_processCSS(true);
		this.refresh();
	}
	
	/**
	 * metoda przesunięcia etykiety razem z ruchem bloku
	 */
	private void labelRelocation(){
		this.blocklabel.relocate(
				this.block.getPosition().getX()+this.getRadiusX()-this.blocklabel.prefWidth(-1)/2,
				this.block.getPosition().getY()+this.getRadiusY()-this.blocklabel.prefHeight(-1)/2
		);
	}
	public InHandler getIn() {
		return in;
	}
	public void setIn(InHandler in) {
		this.in = in;
	}
	@Override
	public void delete() {
		this.in.removeHandler();
		BlocksHolder.blocklist.remove(this.block);
		AnchorPane pan = (AnchorPane)this.getParent();
		pan.getChildren().remove(this.blocklabel);
		this.block = null;
		pan.getChildren().remove(this);
	}
	
	
}
