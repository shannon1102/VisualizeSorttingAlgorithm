package object;

import java.util.Random;

import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class ColumnArray {
	public int NUMBER = 10;
	public Column[] itemColumn = new Column[NUMBER];	
	String listColorString[] = {"#FF0000","#0000FF","#00FF00","#FFFF00",
			"#00FFFF","#FF00FF","#C0C0C0","#808080","#800000","#808000","#008000"};
	Text listLabel[]= new Text[10];
	Text listBucket[]= new Text[10];
	int checkAlgBucket=0;
	public void generateArray(String aglo) {
		if(aglo == "Merge Sort") {
			for(int i= 0;i<NUMBER;i++)
			{
				Random r = new Random();
				int ran = 1 + r.nextInt(99);
				itemColumn[i] = new Column(ran);
				itemColumn[i].setX(i*70+3);
				itemColumn[i].setY(320-ran*3);
				itemColumn[i].setIndex(i);
				itemColumn[i].setFill(Color.web(listColorString[i]));
			}
		}
		else if(aglo == "Bucket Sort")
		{
			for(int i= 0;i<NUMBER;i++)
			{
				Random r = new Random();
				int ran = 1 + r.nextInt(99);
				itemColumn[i] = new Column(ran);
				itemColumn[i].setX(i*70+3);
				itemColumn[i].setY(300-ran*3);
				itemColumn[i].setIndex(i);
				itemColumn[i].setFill(Color.web(listColorString[i]));
				listLabel[i] = new Text(Integer.toString(ran));
				//listLabel[i]= new Text("vandayroi");
				listLabel[i].setX(i*70+20);
				listLabel[i].setY(300-ran*3);
				
				listBucket[i] = new Text(Integer.toString(i) + ":");
				listBucket[i].setX(0);
				listBucket[i].setY(340 +i*30);
				
				
				checkAlgBucket=1;
				
			}
			
		}else {
			for(int i= 0;i<NUMBER;i++)
			{
				Random r = new Random();
				int ran = 1 + r.nextInt(99);
				itemColumn[i] = new Column(ran);
				itemColumn[i].setX(i*70+3);
				itemColumn[i].setY(500-ran*3);
				itemColumn[i].setIndex(i);
			}
		}
	}

	public int getNumber() {
		return NUMBER;
	}

	public void setNumber(int number) {
		this.NUMBER = number;
	}

	public Column[] getItemColumn() {
		return itemColumn;
	}

	public void setItemColumn(Column[] itemColumn) {
		this.itemColumn = itemColumn;
	}
	public Text[] getListLabel() {
		return listLabel;
	} 
	public Text[] getListBucket() {
		return listBucket;
	} 
	public int getCheckAlgBucket() {
		return checkAlgBucket;
	}
		
		
	
	

}
