package object;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Column extends Rectangle implements Comparable{
	public static final int WIDTH = 50;
    public static final int HEIGHT = 3;// 4 la 1 don vi
    private int value; 		// gia tri cua cot
    private int index =0;   // vi tri cot trong mang

    public int getIndex() {
        return index;
    }
    public void setIndex(int index) {
        this.index = index;
    }
    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value=value;
    }
    public Column(int  value) {
        super(WIDTH, value * HEIGHT);
        this.value = value;
        this.setFill(Color.web("#ed4b00"));	   
    }
	public  Column(int x,int y,int weigth,int height) {
		// TODO Auto-generated method stub
		super(x,y,weigth,height);
		this.setFill(Color.web("#ed4b00"));	    
	}
	@Override
	public int compareTo(Object o) {
		  return - value + ((Column)o).value;
	
	}
}

