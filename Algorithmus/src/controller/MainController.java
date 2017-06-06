package controller;

import java.awt.Point;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import model.Conf;
import model.DecisionBlock;
import model.ForBlock;
import model.InputBlock;
import model.NodeBlock;
import model.OperatingBlock;
import model.StartBlock;
import model.StopBlock;
import view.blocks.Decision;
import view.blocks.For;
import view.blocks.Input;
import view.blocks.Node;
import view.blocks.Operating;
import view.blocks.Start;
import view.blocks.Stop;
import view.graphicsbuttons.DeleteButton;


/**
 * Klasa kontrolująca interfejs graficzny programu
 */
public class MainController {

	/**
	 * Pozycja Y elementu w menu
	 */
	private int startpos = 20;
	/**
	 * krok przemieszczenia
	 */
	private int move; 
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

 
	@FXML
    public AnchorPane BlockPane;

    @FXML
    private AnchorPane MenuPane;
    

    @FXML
    private Button generatebtn;

    @FXML
    private Button generatebtn1;

    @FXML
    private ScrollPane scrollpane;



    /**
     * pole graficznej reprezentacji bloku kodu w menu
     */
    private Operating operating;
    private Start start;
    private Decision decision;
    private Input input;
    private Stop stop;
    private Node node;
    private DeleteButton delete;
	private For forr;


    @FXML
    void initialize() {
        assert BlockPane != null : "fx:id=\"BlockPane\" was not injected: check your FXML file 'MainView.fxml'.";
        assert MenuPane != null : "fx:id=\"MenuPane\" was not injected: check your FXML file 'MainView.fxml'.";
     
        this.move = (int)Conf.MENU_ELEMS_DIM.getHeight() + 10;
        
        
        // inicjalizacja graficznych bloków operacyjnych
        this.startInitialize();
        this.operatingInitialize();
        this.forInitialize();
        this.decisionInitialize();
        this.inputInitialize();
        this.outputInitialize();
        this.stopInitialize();
        this.nodeInitialize();
        this.deleteInitialize();
        this.BlockPane.setOnMouseMoved(new ScreenEventHandler(this,null,null));
        this.BlockPane.setOnMouseClicked(new ScreenEventHandler(this,null,null));
        ViewParams.ctrl = this;
        //nasłuch skalowania sceny
        ViewParams.stg.widthProperty().addListener((obs, oldVal, newVal) -> {
        	 ViewParams.ctrl.resizeAll();
       });

        ViewParams.stg.heightProperty().addListener((obs, oldVal, newVal) -> {
        	 ViewParams.ctrl.resizeAll();
       });
    }
    

	// metoda wywowływana po wcisnięciu przycisku generate
    @FXML
    void generateCode(ActionEvent event) {
    	CodeMaker.test();
    }

    

    
    public AnchorPane getBlockPane() {
  		return BlockPane;
  	}


  	public void setBlockPane(AnchorPane blockPane) {
  		BlockPane = blockPane;
  	}


  	public AnchorPane getMenuPane() {
  		return MenuPane;
  	}


  	public void setMenuPane(AnchorPane menuPane) {
  		MenuPane = menuPane;
  	}

  	/**
  	 * Metoda inicjalizacji bloków graficznych
  	 */
  	private void operatingInitialize(){
        this.operating = new Operating(new OperatingBlock(new Point(10,this.startpos),Conf.MENU_ELEMS_DIM));
        this.MenuPane.getChildren().add(this.operating);
        startpos = startpos + move;
       
        // eventy
        this.operating.setOnMouseClicked(new MenuEventHandler(this,this.operating.getBlock()));
  	}
  	
  	private void startInitialize(){
        this.start = new Start(new StartBlock(new Point(10,this.startpos),Conf.MENU_ELEMS_DIM));
        this.MenuPane.getChildren().add(this.start);
        startpos = startpos + move;
        
        //eventy
        this.start.setOnMouseClicked(new MenuEventHandler(this,this.start.getBlock()));
  	}
  	
  	private void decisionInitialize(){
  	  this.decision = new Decision(new DecisionBlock(new Point(10,this.startpos),Conf.MENU_ELEMS_DIM));
      this.MenuPane.getChildren().add(this.decision);
      startpos = startpos + move;
      
      //eventy
      this.decision.setOnMouseClicked(new MenuEventHandler(this,this.decision.getBlock()));
  		
  	}
  	
  	private void inputInitialize(){
    	  this.input = new Input(new InputBlock(new Point(10,this.startpos),Conf.MENU_ELEMS_DIM));
          this.MenuPane.getChildren().add(this.input);
          startpos = startpos + move;
          
          //eventy
          this.input.setOnMouseClicked(new MenuEventHandler(this,this.input.getBlock()));
  	}
  	
  	private void outputInitialize(){
  		
  	}
  	
  	private void nodeInitialize(){
  		this.node = new Node(new NodeBlock(new Point(20,this.startpos),Conf.NODE_DIM));
  		this.MenuPane.getChildren().add(this.node);
  		startpos = startpos + move;
  		
  		//eventy
  		this.node.setOnMouseClicked(new MenuEventHandler(this,this.node.getBlock()));
  	}
  	
  	private void stopInitialize(){
  		 this.stop = new Stop(new StopBlock(new Point(10,this.startpos),Conf.MENU_ELEMS_DIM));
         this.MenuPane.getChildren().add(this.stop);
         startpos = startpos + move;
         
         //eventy
         this.stop.setOnMouseClicked(new MenuEventHandler(this,this.stop.getBlock()));
  	}
  	
    private void deleteInitialize() {
 		 this.delete = new DeleteButton(new Point(20,this.startpos+3*move));
         this.MenuPane.getChildren().add(this.delete);
         this.resizeAll();
         startpos = startpos + move;
         
         //eventy
         this.delete.setOnMouseClicked(new MenuEventHandler(this,this.delete ));
	}
    
    private void forInitialize(){
    	  this.forr = new For(new ForBlock(new Point(10,this.startpos),Conf.MENU_ELEMS_DIM));
          this.MenuPane.getChildren().add(this.forr);
          startpos = startpos + move;
          //eventy
          this.forr.setOnMouseClicked(new MenuEventHandler(this,this.forr.getBlock()));
    }




	public Node getNode() {
		return node;
	}

	

	public DeleteButton getDelete() {
		return delete;
	}


	public void setDelete(DeleteButton delete) {
		this.delete = delete;
	}


	public void setNode(Node node) {
		this.node = node;
	}
	
	/**
	 * Metoda skalująca okno
	 */
	public void resizeAll(){
		 AnchorPane pan = (AnchorPane) this.MenuPane.getParent(); 
		 pan.setPrefHeight(ViewParams.stg.getHeight()-50);
		 pan.setMinHeight(560);
		 pan.setPrefWidth(ViewParams.stg.getWidth());
		 this.MenuPane.setPrefHeight(pan.getPrefHeight());
		 this.scrollpane.setPrefHeight(pan.getPrefHeight()-20);
		 this.scrollpane.setPrefWidth(pan.getPrefWidth()-this.MenuPane.getPrefWidth()-this.generatebtn.getPrefWidth()-30);
		 double btnx = this.scrollpane.getPrefWidth()+this.MenuPane.getPrefWidth()+20;
		 this.generatebtn.setLayoutX(btnx);
		 this.generatebtn1.setLayoutX(btnx);
		 this.delete.relocate(this.delete.getX()+20,pan.getPrefHeight()-this.delete.getHeight()*2);
		 
	}
	
}
