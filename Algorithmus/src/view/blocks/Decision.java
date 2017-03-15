package view.blocks;

//TODO Poprawić działanie na przesunięciach myszką oraz zespolić z polem tekstowym
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Polygon;
import model.Conf;
import model.DecisionBlock;
import model.interfaces.GraphicsBlockInterface;

public class Decision extends Polygon implements GraphicsBlockInterface{
	private  DecisionBlock block;
	private  TextField blockfield;
	
	public Decision(DecisionBlock blo){
		block = blo;
		this.getPoints().addAll(new Double[]{
			this.block.getPosition().getX(),
			this.block.getPosition().getY()+this.block.getSize().getHeight()/2,
			this.block.getPosition().getX()+0.25*this.block.getSize().getWidth(),
			this.block.getPosition().getY()+this.block.getSize().getHeight(),
			this.block.getPosition().getX()+0.5*this.block.getSize().getWidth()+0.25*this.block.getSize().getWidth(),
			this.block.getPosition().getY()+this.block.getSize().getHeight(),
			this.block.getPosition().getX()+this.block.getSize().getWidth(),
			this.block.getPosition().getY()+this.block.getSize().getHeight()/2,
			this.block.getPosition().getX()+0.5*this.block.getSize().getWidth()+0.25*this.block.getSize().getWidth(),
			this.block.getPosition().getY(),
			this.block.getPosition().getX()+0.25*this.block.getSize().getWidth(),
			this.block.getPosition().getY(),
			this.block.getPosition().getX(),
			this.block.getPosition().getY()+this.block.getSize().getHeight()/2
		});
		this.setFill(Conf.BLOCK_COLOR);
		this.refresh();

	}
	@Override
	public void refresh() {
		this.relocate(block.getPosition().getX(),block.getPosition().getY());
		if(this.blockfield!= null){
			this.blockFieldRelocation();
		}
	}

	@Override
	public void prepair(AnchorPane pan) {
		this.blockfield = new TextField("Start");
		pan.getChildren().add(this.blockfield);
		this.blockfield.impl_processCSS(true);
		this.refresh();
	}
	
	public DecisionBlock getBlock() {
		return block;
	}
	public void setBlock(DecisionBlock block) {
		this.block = block;
	}
	public TextField getBlockfield() {
		return blockfield;
	}
	public void setBlockfield(TextField blockfield) {
		this.blockfield = blockfield;
	}

	private void blockFieldRelocation(){
		
	}

}
