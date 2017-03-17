package view.blocks;



import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Polygon;
import model.Conf;
import model.DecisionBlock;
import model.interfaces.GraphicsBlockInterface;
import view.handlers.InHandler;
import view.handlers.LeftOutHandler;
import view.handlers.RightOutHandler;

public class Decision extends Polygon implements GraphicsBlockInterface{
	private  DecisionBlock block;
	private  TextField blockfield;
	private InHandler in;
	private RightOutHandler rightout;
	private LeftOutHandler leftout;
	
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
		this.blockfield = new TextField();
		this.refresh();
		

	}
	@Override
	public void refresh() {
		this.relocate(block.getPosition().getX(),block.getPosition().getY());
		if(this.blockfield!= null){
			this.blockFieldRelocation();
		}
		if(this.getLeftOut()!=null){
			this.getLeftOut().move();
		}
		if(this.getRightOut()!=null){
			this.getRightOut().move();
		}
		if(this.getIn()!=null){
			this.getIn().move();
		}
	}

	@SuppressWarnings("deprecation")
	@Override
	public void prepair(AnchorPane pan) {
		this.blockfield.setFocusTraversable(false);;
		this.blockfield.setPromptText(block.getContent());
		this.blockfield.setPrefWidth(this.block.getSize().getWidth()*0.6);
		this.leftout = new LeftOutHandler(this.getBlock());
		this.rightout = new RightOutHandler(this.getBlock());
		this.in = new InHandler(this.getBlock());
		pan.getChildren().add(this.leftout);
		pan.getChildren().add(this.rightout);
		pan.getChildren().add(this.in);
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
		this.blockfield.relocate(
				this.block.getPosition().getX()+0.2*this.block.getSize().getWidth(),
				this.block.getPosition().getY()+0.35*this.block.getSize().getHeight()
		);
	}
	public LeftOutHandler getLeftOut() {
		return leftout;
	}
	public void setLeftOut(LeftOutHandler leftout) {
		this.leftout = leftout;
	}
	public InHandler getIn() {
		return in;
	}
	public void setIn(InHandler in) {
		this.in = in;
	}
	public RightOutHandler getRightOut() {
		return rightout;
	}
	public void setRightOut(RightOutHandler rightout) {
		this.rightout = rightout;
	}
	
	

}
