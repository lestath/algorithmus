package controller;

import java.util.ArrayList;

import javafx.stage.Stage;
import view.Arrows.Arrow;
import view.handlers.Handler;

public class ViewParams {
	public static Mode MODE = Mode.Normal; 
	public  static ArrayList<Arrow> ARROW_LIST = new ArrayList<Arrow>();
	public static Arrow ACTUAL_ARROW;
	public static Handler ACTUAL_HANDLER;
	public static Stage stg;
	public static MainController ctrl;
}
