package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Collection;
import java.util.ResourceBundle;

import javafx.animation.TranslateTransition;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import object.Column;

public class BucketSort implements Runnable,Initializable{
	public Stage success;
	public Column[] itemColumn = new Column[10]; 
	public Text[] listLabel= new Text[10]; 
	public MediaPlayer soundMediaPlayer;
	
	int delay = 100;
	one_windowController one_1 = new one_windowController();
	@Override
    public void initialize(URL location, ResourceBundle resources) {
		one_1.itemColumn = this.itemColumn;
    }
	@Override
	public void run() {
	
		for (int i = 0; i < itemColumn.length; i++) {
			System.out.println(itemColumn[i].getValue());
		}
		
		try {
			bucketSort(itemColumn,10,listLabel);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		for (int i = 0; i < itemColumn.length; i++) {
			System.out.println(itemColumn[i].getValue() + "---"+itemColumn[i].getX()+""+itemColumn[i].getY());
		}
		 


		
		soundMediaPlayer.stop();
	}
	public void bucketSort(Column arr[],int n,Text[] listLabel) throws InterruptedException 
	{ 
		int[] checkTraversed= new int[10];
		for(int i = 0; i < n; i++) {
			checkTraversed[i]=0;
		}
		
	    ArrayList<Integer>[] bucket = new ArrayList[10];

			    // Create empty buckets
	    for(int i = 0; i < n; i++){	
	    	bucket[i] = new ArrayList<Integer>();
	    
	    }

			    // Add elements into the buckets
	    for (int i = 0; i < n; i++) {
	    	int bucketIndex = (int) (arr[i].getValue() / n);
	    	itemColumn[i].setFill(Color.web("#1A2B3C"));
	    	Thread.sleep(delay*3);
	    	itemColumn[i].setVisible(false);
	    	System.out.println(listLabel[i].getText() +"-" +listLabel[i].getX()+" "+listLabel[i].getY());
	    	transition(40+30*bucketIndex +3*itemColumn[i].getValue(),i,delay,listLabel[i]);
	    	System.out.println(listLabel[i].getText() +"-" +listLabel[i].getX()+" "+listLabel[i].getY());
			bucket[bucketIndex].add(arr[i].getValue());
		}
		for(int i = 0; i < n; i++) {
			Collections.sort(bucket[i]);
		}

		int index = 0;
		for (int i = 0; i < n; i++) {
			 for (int j = 0, size = bucket[i].size(); j < size; j++) {
			        arr[index].setValue(bucket[i].get(j));
			        arr[index].setX(index*70+3);
			        arr[index].setY(320-arr[index].getValue()*3-20);
			        arr[index].setHeight(arr[index].getValue()*3);
			        index++;
			      }
			    }
		Thread.sleep(delay*10);
		for (int i = 0; i < n; i++) {
			// Thread.sleep(300);
//			 System.out.println(listLabel[i].getText() +"-" +listLabel[i].getX()+" "+listLabel[i].getY());
//			 
//			 //listLabel[i].setX(i*70+20);
//			 System.out.println(listLabel[i].getText() +"-" +listLabel[i].getX()+" "+listLabel[i].getY());
//			 System.out.println("\n");
			 Thread.sleep(10*delay);
			 for (int j = 0; j < n; j++) {
				 if(Integer.parseInt(listLabel[j].getText())==arr[i].getValue())
				 {
					 if(checkTraversed[j]==0) {
					  listLabel[j].setFont(new Font("Times New Roman", 40));
					  listLabel[j].setFill(Color.RED);
					  Thread.sleep(delay*3);
					  listLabel[j].setVisible(false);
					  checkTraversed[j]=1;
					  System.out.println("Vanbadao");
					  break;
					 }
					 
				 }
			 }
			 Thread.sleep(delay);
			 arr[i].setVisible(true);
			 Thread.sleep(delay*5);
		}
	}
	
	public void getData(Column [] itemColumns,MediaPlayer sound, int delay,Text[] listLaTexts)
	{
		this.itemColumn = itemColumns;
		this.soundMediaPlayer = sound;
		this.delay = delay;
		this.listLabel= listLaTexts;
	}
	  public void transition(int k, int i,int delay,Object x)
	    {
	   
	    	TranslateTransition tt1 = new TranslateTransition();
	        tt1.setDuration(Duration.millis(delay));
	        tt1.setByY(k);
	        tt1.setNode((Node) x);
	        //tt1.setNode(listLabel[i]);
	        tt1.play();
	    }
	  public int checkText(Text[] listLable)
	  {
		  
		  return 1;
		  
	  }
	  
}
