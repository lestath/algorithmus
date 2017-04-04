package view.blocks;


import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Ellipse;
import model.Conf;
import model.StartBlock;
import model.interfaces.GraphicsBlockInterface;
import view.handlers.OutHandler;

public class Start extends Ellipse implements GraphicsBlockInterface{
	private StartBlock block;
	private Label blocklabel;
	private OutHandler outhandler;


	public Start(StartBlock startBlock){
		block = startBlock;
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
		if(this.outhandler!=null){
			this.outhandler.move();
		}
	}
	
	public StartBlock getBlock() {
		return block;
	}
	public void setBlock(StartBlock block) {
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
		pan.getChildren().add(this.blocklabel);
		this.outhandler =new OutHandler(this.getBlock(),this.getBlock().getNext());
		pan.getChildren().add(this.outhandler);
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
	
	public void setOut(OutHandler outhand) {
		this.outhandler = outhand;
	}
	public OutHandler getOut() {
		return this.outhandler;
	}
}
