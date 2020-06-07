package application;

import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import object.Column;

public class SelectionSort implements Runnable{
	public Stage success;
	public Column[] itemColumn = new Column[10]; 
	public MediaPlayer soundMediaPlayer;
	int delay = 100;
	one_windowController one_1 = new one_windowController();

	@Override
	public void run() {
		one_1.itemColumn = this.itemColumn;
		for (int i = 0; i <10; i++) {
			
			itemColumn[i].setFill(Color.web("#228B22")); 
			int min = itemColumn[i].getValue();
			int id_min =i;
			try {
				Thread.sleep(delay);
			} catch (Exception e) {
				// TODO: handle exception
			}
			for (int j = i+1; j <10; j++) {
				//chuyen mau thu j so sanh
				itemColumn[j].setFill(Color.web("#228B22")); 
				try {
					Thread.sleep(200);
				} catch (Exception e) {
					// TODO: handle exception
				}
				if (itemColumn[j].getValue()<min) {
					min = itemColumn[j].getValue();
					itemColumn[j].setFill(Color.web("#A52A2A"));
					if (i!=id_min) //doi mau min cu tu do sang cam
						itemColumn[id_min].setFill(Color.web("#FF6633"));
					id_min = j;
				}
				try {
					Thread.sleep(delay);
				} catch (Exception e) {
					// TODO: handle exception
				}
			if (j!=id_min) 
				itemColumn[j].setFill(Color.web("#FF6633")); 
		}
			one_1.swap(i, id_min,delay);
			try {
				Thread.sleep(delay);
			} catch (Exception e) {
				// TODO: handle exception
			}
			itemColumn[id_min].setFill(Color.web("#FF6633"));
			itemColumn[i].setFill(Color.web("#0000FF")); 
		}	
		soundMediaPlayer.stop();
//		for(int i = 0; i < 10; i++)
//			System.out.println(itemColumn[i].getValue());
	}
	 
	public void getData(Column [] itemColumns,MediaPlayer soundMediaPlayer,int delay)
	{
		this.itemColumn = itemColumns;
		this.soundMediaPlayer = soundMediaPlayer;
		this.delay = delay;
	}
}
