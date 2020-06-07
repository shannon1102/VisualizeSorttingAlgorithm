package application;

import java.awt.List;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import object.Column;

public class MergeSort implements Runnable,Initializable{
	public Stage success;
	public Column[] itemColumn = new Column[10]; 
	public MediaPlayer soundMediaPlayer;
	int delay = 100;
	one_windowController one_1 = new one_windowController();
	@Override
    public void initialize(URL location, ResourceBundle resources) {
		one_1.itemColumn = this.itemColumn;
    }
	@Override
	public void run() {
		try {
			sort(itemColumn, 0, 9);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for (int i = 0; i < itemColumn.length; i++) {
			System.out.println(itemColumn[i].getValue());
		}
		soundMediaPlayer.stop();
	}
	void merge(Column arr[], int l, int m, int r) throws InterruptedException 
	{ 
		// Find sizes of two subarrays to be merged 
		int n1 = m - l + 1; 
		int n2 = r - m; 

		/* Create temp arrays */
		Column L[] = new Column[n1]; 
		Column R[] = new Column[n2]; 

		/*Copy data to temp arrays*/
		for (int i=0; i<n1; ++i) 
			L[i] = arr[l + i]; 
		for (int j=0; j<n2; ++j) 
			R[j] = arr[m + 1+ j];


		/* Merge the temp arrays */

		// Initial indexes of first and second subarrays 
		int i = 0, j = 0; 

		// Initial index of merged subarry array 
		int k = l;
		while (i < n1 && j < n2) 
		{ 
			if (L[i].getValue() <= R[j].getValue()) 
			{ 
				Thread.sleep(delay);
				//one_1.transition(k,l+i,delay);
				arr[k].setY(600-arr[k].getValue()*3);
				Thread.sleep(delay);
				arr[k] = L[i];

				arr[k].setFill(L[i].getFill());
				i++;
			} 
			else
			{ 
				Thread.sleep(delay);
				//one_1.transition(k,l+j,delay);
				arr[k].setY(600-arr[k].getValue()*3);
				Thread.sleep(delay);
				arr[k] = R[j];

				arr[k].setFill(L[i].getFill());
				j++; 
			} 
			k++; 
		} 

		/* Copy remaining elements of L[] if any */
		while (i < n1) 
		{
			Thread.sleep(delay);
			//one_1.transition(k,l+i,delay);
			arr[k].setY(600-arr[k].getValue()*3);
			Thread.sleep(delay);
			arr[k] = L[i]; 

			arr[k].setFill(L[i].getFill());
			i++; 
			k++; 
		} 

		/* Copy remaining elements of R[] if any */
		while (j < n2) 
		{ 
			Thread.sleep(delay);
			//one_1.transition(k,l+j,delay);
			arr[k].setY(600-arr[k].getValue()*3);
			
			Thread.sleep(delay);
			
			arr[k] = R[j]; 

			arr[k].setFill(L[i-1].getFill());
			j++; 
			k++; 
		}
		
		
		ArrayList<Double> temp = new ArrayList<Double>();
		for (int n = l; n < k; n++) {
			 temp.add(arr[n].getX());
		}
		Collections.sort(temp);
		
		Iterator itrIterator = temp.iterator();
		for (int k2 = l; k2 < k; k2++) {
			Thread.sleep(delay);
			arr[k2].setY(320 - arr[k2].getValue()*3);
			arr[k2].setX(temp.get(k2-l));
			Thread.sleep(delay);
		}
	} 

	// Main function that sorts arr[l..r] using 
	// merge() 
	void sort(Column arr[], int l, int r) throws InterruptedException 
	{ 
		if (l < r) 
		{ 
			// Find the middle point 
			int m = (l+r)/2; 

			// Sort first and second halves 
			sort(arr, l, m); 
			sort(arr , m+1, r); 

			// Merge the sorted halves 
			merge(arr, l, m, r); 
		} 
	} 
	
	public void getData(Column [] itemColumns,MediaPlayer soundMediaPlayer,int delay)
	{
		this.itemColumn = itemColumns;
		this.soundMediaPlayer = soundMediaPlayer;
		this.delay = delay;
	}
}
