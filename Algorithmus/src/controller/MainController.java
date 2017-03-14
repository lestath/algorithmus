package controller;

import java.net.URL;
import java.util.ResourceBundle;



import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import model.Conf;
import model.OperatingBlock;
import view.blocks.Operating;


/**
 * Klasa kontrolująca interfejs graficzny programu
 */
public class MainController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

 
	@FXML
    private AnchorPane BlockPane;

    @FXML
    private FlowPane MenuPane;
    
    /**
     * pole graficznej reprezentacji bloku kodu w menu
     */
    private Operating operating;


    @FXML
    void initialize() {
        assert BlockPane != null : "fx:id=\"BlockPane\" was not injected: check your FXML file 'MainView.fxml'.";
        assert MenuPane != null : "fx:id=\"MenuPane\" was not injected: check your FXML file 'MainView.fxml'.";
     
        // inicjalizacja graficznych bloków operacyjnych
        this.operating = new Operating(new OperatingBlock(0,0,Conf.MENU_ELEMS_DIM));
        
        
        this.MenuPane.getChildren().add(this.operating);
        
        // Dodanie obsługi wydarzeń
        this.operating.setOnMouseClicked(new MenuEventHandler(this,this.operating.block));
        
        
    }

    
    public AnchorPane getBlockPane() {
  		return BlockPane;
  	}


  	public void setBlockPane(AnchorPane blockPane) {
  		BlockPane = blockPane;
  	}


  	public FlowPane getMenuPane() {
  		return MenuPane;
  	}


  	public void setMenuPane(FlowPane menuPane) {
  		MenuPane = menuPane;
  	}


}
