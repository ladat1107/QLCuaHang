package hcmute.models;

import java.io.Serializable;

public class CateAndNum implements Serializable{

	private static final long serialVersionUID = 1L;
	private int cateID;
	private String cateName;
	private int numPro;
	public int getCateID() {
		return cateID;
	}
	public void setCateID(int cateID) {
		this.cateID = cateID;
	}
	public String getCateName() {
		return cateName;
	}
	public void setCateName(String cateName) {
		this.cateName = cateName;
	}
	public int getNumPro() {
		return numPro;
	}
	public void setNumPro(int numPro) {
		this.numPro = numPro;
	}
	public CateAndNum() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CateAndNum(int cateID, String cateName, int numPro) {
		super();
		this.cateID = cateID;
		this.cateName = cateName;
		this.numPro = numPro;
	}
}
