package model;

import java.awt.Dimension;
import java.awt.Point;

import model.interfaces.BlockInterface;

public class NodeBlock extends Block implements BlockInterface{
	
	private Block leftinblock;
	private Block raightinblock;

	public NodeBlock(Point start, Dimension dim) {
		super(start, dim);
		// TODO Auto-generated constructor stub
	}

	public Block getLeftinblock() {
		return leftinblock;
	}

	public void setLeftinblock(Block leftinblock) {
		this.leftinblock = leftinblock;
	}

	public Block getRaightinblock() {
		return raightinblock;
	}

	public void setRaightinblock(Block reightinblock) {
		this.raightinblock = reightinblock;
	}
	
	public String getCode() {
		return "}";
	}

}
