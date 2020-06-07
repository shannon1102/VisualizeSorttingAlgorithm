package application;

import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import object.Column;
public class BubbleSort implements Runnable{
	public Stage success;
	public Column[] itemColumn = new Column[10]; 
	public MediaPlayer soundMediaPlayer;
	int delay =100;
	one_windowController one_1 = new one_windowController();
	
	@Override
	public void run() {
		one_1.itemColumn = this.itemColumn;
		for (int i = 9; i >= 0; i--) {
			for (int j = 0; j < i; j++) {
				
				itemColumn[j].setFill(Color.web("#228B22"));
				itemColumn[j+1].setFill(Color.web("#228B22"));
				try {
					Thread.sleep(delay);
				} catch (Exception e) {
					// TODO: handle exception
				}
				if (itemColumn[j].getValue()>itemColumn[j+1].getValue()) {
					one_1.swap(j, j+1,delay);
					
				try {
					Thread.sleep(delay);
				} catch (Exception e) {
					// TODO: handle exception
				}
				}
				itemColumn[j].setFill(Color.web("#FF6633"));
				itemColumn[j+1].setFill(Color.web("#FF6633"));
			}
			itemColumn[i].setFill(Color.web("#0000FF"));
		}
		soundMediaPlayer.stop();
//		for(int i = 0; i < 10; i++)
//		{
//			System.out.println(itemColumn[i].getValue());
//		}
	}
	public void getData(Column [] itemColumns,MediaPlayer sound, int delay)
	{
		this.itemColumn = itemColumns;
		this.soundMediaPlayer = sound;
		this.delay = delay;
	}
}
