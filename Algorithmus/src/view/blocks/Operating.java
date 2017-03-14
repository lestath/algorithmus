package view.blocks;
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
	public OperatingBlock block;
	public Operating(OperatingBlock blo){
		block = blo;
		this.setWidth(block.getSize().getWidth());
		this.setHeight(block.getSize().getHeight());
		this.setFill(Conf.BLOCK_COLOR);
		this.update();

	}
	@Override
	public void update() {
		this.setLayoutX(block.getPosition().getX());
		this.setLayoutY(block.getPosition().getY());
	}
}
