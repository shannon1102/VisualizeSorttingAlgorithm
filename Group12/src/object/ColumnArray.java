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
	String[] Pse = new String[] {
				 
				 
			            	"Bubble Sort Pseudocode: \n" + 
			                "procedure bubbleSort( A : list of sortable items )\r\n" + 
			        		"    n = length(A)\r\n" + 
			        		"    repeat\r\n" + 
			        		"        newn = 0\r\n" + 
			        		"        for i = 1 to n-1 inclusive do\r\n" + 
			        		"            if A[i-1] > A[i] then\r\n" + 
			        		"                swap(A[i-1], A[i])\r\n" + 
			        		"                newn = i\r\n" + 
			        		"            end if\r\n" + 
			        		"        end for\r\n" + 
			        		"        n = newn\r\n" + 
			        		"    until n <= 1\r\n" + 
			        		"end procedure"
			        		,
			        		"Selection Sort Pseudocode: \n" +
			        		"		procedure selection sort \n"+
			        		"		   list  : array of items \n"+
			        		"		   n     : size of list\n"+
			        		"		   for i = 1 to n - 1\n"+
			        		"		      min = i    \n"+		  
			        		"		      for j = i+1 to n \n"+
			        		"		         if list[j] < list[min] then\n"+
			        		"		            min = j;\n"+
			        		"		         end if\n"+
			        		"		      end for\n"+
			        		"		      if indexMin != i  then\n"+
			        		"		         swap list[min] and list[i]\n"+
			        		"		      end if\n"+
			        		"		   end for\n"+
			        		"		end procedure"
			        		,  
			        		  "Merge Sort Pseudocode: \n"+
			        		        "  procedure merge( arr[], l,  r )\r\n" + 
				        			"  If r > l \n"+
				        		    "	1. Find the middle point to divide the array into two halves:\n"+
				        		    "		middle m = (l+r)/2\n"+
				        		    "	2. Call mergeSort for first half:   \n"+
				        	        "		Call mergeSort(arr, l, m)\n"+
				        	        "	3. Call mergeSort for second half:\n"+
				        		    "		Call mergeSort(arr, m+1, r)\n"+
				        		    "	4. Merge the two halves sorted in step 2 and 3:\n"+
				        		    "		Call merge(arr, l, m, r)\n" +
			        		        "end procedure"
			        		        ,
			        		        
			        		        
			        		        "Bucket Sort Pseudocode: \n"+
			        		        		"procedure bucketSort(array, maxValue) is\r\n" +
											"	maxValue = the maximum key value in the array\r\n" +
					        		        "	Buckets = new array of (maxValue + 1) empty lists\r\n" +
					        		        "	for i = 1 to length(array) do\r\n" + 
					        		        "		Buckets[array[i]] ++ \r\n" +
											"	sortedArray = array after sorting\r\n" +
					        		        "	for i = 1 to length(Buckets) do\r\n" +
											"		for j = 1 to Buckets[i] do\r\n" +
					        		        "			sortedArray[n++]=i\r\n" +
					        		        "	return sortedArray\r\n"+
			        		        "end procedure"};


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
	public String[] getPse() {
		
		return this.Pse;
	}	
		
	
	

}
