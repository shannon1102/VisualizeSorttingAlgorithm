package application;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.util.Duration;
import object.Column;
import object.ColumnArray;

public class one_windowController implements Initializable{
	ColumnArray dataList; //chua du lieu cac cot
	public Column[] itemColumn = new Column[10]; //tham chieu toi cac cot trong datalist
	public Text[] listLabel= new Text[10]; //Chua gia tri label  cac cot
	public Text[] listBuckets= new Text[10]; //Chua gia tri label cu bucket  cac cot
	int checkAlgBucket =0;
	String ssound = "sound.mp3";
	Media sound = new Media(new File(ssound).toURI().toString());
    MediaPlayer mediaPlayer = new MediaPlayer(sound);
	ParallelTransition pt= new ParallelTransition();
	int delay;
	String aglorithmString;
	
	public String[] Pse = new String[4];
	
	@FXML
	private AnchorPane anchorpaneAnimation;
	@FXML
	private AnchorPane logAnchorPane;
    @FXML
    private Button startChoicebox;
    @FXML 
    private Button randomButton;
    @FXML
    private ChoiceBox<String> delayChoiceBox = new ChoiceBox<String>();
    @FXML
    private ChoiceBox<String> aglorithmChoiceBox = new ChoiceBox<String>();
    @FXML
    void start() {
    	String delayString = delayChoiceBox.getValue();
    	String subDelayString = delayString.substring(0,3);
    	delay = Integer.parseInt(subDelayString);
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.play();
        MediaView mediaView = new MediaView(mediaPlayer);
        anchorpaneAnimation.getChildren().add(mediaView);
        if (aglorithmString == "Bubble Sort") {
        	Text tmp= new Text(Pse[0]);
        	tmp.setX(30);
        	tmp.setY(30);
        	logAnchorPane.getChildren().add(tmp);
        	BubbleSort t1 = new BubbleSort();
        	t1.getData(itemColumn,mediaPlayer,delay);
        	Thread secondThread = new Thread(t1);
        	secondThread.start();
		}
        if (aglorithmString == "Selection Sort") {
        	Text tmp= new Text(Pse[1]);
        	tmp.setX(30);
        	tmp.setY(30);
        	
        	logAnchorPane.getChildren().add(tmp);
        	SelectionSort t2 = new SelectionSort();
        	t2.getData(itemColumn,mediaPlayer,delay);
        	Thread secondThread2 = new Thread(t2);
        	secondThread2.start();
		}
        if (aglorithmString == "Merge Sort") {
        	Text tmp= new Text(Pse[2]);
        	tmp.setX(30);
        	tmp.setY(30);
        	logAnchorPane.getChildren().add(tmp);
        	MergeSort t3 = new MergeSort();
        	t3.getData(itemColumn, mediaPlayer, delay);
        	Thread secondThread3 = new Thread(t3);
        	secondThread3.start();
		}
        if (aglorithmString == "Bucket Sort") {
        	Text tmp= new Text(Pse[3]);
        	tmp.setX(30);
        	tmp.setY(30);
        	logAnchorPane.getChildren().add(tmp);
        	BucketSort t4 = new BucketSort();
        	t4.getData(itemColumn, mediaPlayer, delay,listLabel);
        	Thread secondThread4 = new Thread(t4);
        	secondThread4.start();
		}
        

       }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    	// TODO Auto-generated method stub
    	delayChoiceBox.getItems().addAll("100 ms","250 ms","500 ms");
    	aglorithmChoiceBox.getItems().addAll("Bubble Sort","Selection Sort","Merge Sort","Bucket Sort");
    }
    
    @FXML
    void randomValue() 
    {
    	aglorithmString = aglorithmChoiceBox.getValue();
    	mediaPlayer.stop();
    	logAnchorPane.getChildren().clear();  
    	anchorpaneAnimation.getChildren().clear();    	
    	dataList = new ColumnArray();
    	dataList.generateArray(aglorithmString);
    	Pse=dataList.getPse();
    	
    	checkAlgBucket=dataList.getCheckAlgBucket();
    	
    	if(checkAlgBucket==1)
    	{
    		itemColumn = dataList.getItemColumn();
    		listLabel= dataList.getListLabel();
        	listBuckets= dataList.getListBucket();
    		anchorpaneAnimation.getChildren().addAll(itemColumn);
        	anchorpaneAnimation.getChildren().addAll(listLabel);
        	anchorpaneAnimation.getChildren().addAll(listBuckets);
        	
    	}else {
    		itemColumn = dataList.getItemColumn();
    		anchorpaneAnimation.getChildren().addAll(itemColumn);
			
		}
    }
    public void swap(int i, int j,int delay)
    {
    	pt.getChildren().clear();
    	TranslateTransition tt1 = new TranslateTransition();
        tt1.setDuration(Duration.millis(delay));
        tt1.setByX(70*(j-i));
        tt1.setNode(itemColumn[i]);

        TranslateTransition tt2 = new TranslateTransition();
        tt2.setDuration(Duration.millis(delay));
        tt2.setByX(70*(i-j));
        tt2.setNode(itemColumn[j]);
        
        pt.getChildren().addAll(tt1, tt2); 
        pt.play();
        
        Column tmp = itemColumn[i];
        itemColumn[i] = itemColumn[j];
        itemColumn[j] = tmp;
    }
    public void transition(int k, int i,int delay)
    {
    	System.out.println("a"+k+"/"+i);
    	TranslateTransition tt1 = new TranslateTransition();
    	System.out.println("b"+k+"/"+i);
        tt1.setDuration(Duration.millis(delay));
        System.out.println("c"+k+"/"+i);
        tt1.setByY((k-i)*70+300);
        System.out.println("d"+k+"/"+i);
        tt1.setNode(itemColumn[i]);
        System.out.println("e"+k+"/"+i);
        tt1.play();
    }

}

