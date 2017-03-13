package controller;

import java.net.URL;
import java.util.ResourceBundle;


import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import model.Conf;
import model.OperatingBlock;
import view.blocks.Operating;
import javafx.scene.input.MouseEvent;

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
     
        this.operating = new Operating(new OperatingBlock(0,0,Conf.MENU_ELEMS_DIM));
      operating.setOnMouseClicked(new EventHandler<MouseEvent>(){
          @Override
          public void handle(MouseEvent arg0) {
        	  System.out.println("ok");
          }
      });
        this.MenuPane.getChildren().add(this.operating);
        
    }

}
