
public class word {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      int[] arr = {100,310,12,45,32,61,74,64,324,33333,31,54,12,12};
      //HeadSort(arr);
      quickSort(arr,0,arr.length-1);
      for (int i = 0; i < arr.length; i++) {
    	  System.out.println(arr[i]);
	}
	}
	 public static void quickSort(int[] a,int start,int end) {	
		   int top =start;//记录开始位置和变化
		   int under = end;//记录结束位置和变化
		   int temp = a[start];
		   while(under>top) {
			   while (under>top && a[under]>=temp) {//从后往前比，如果有比关键词小的，交换位置，否则往下比
				   under--;
			} 
			   if (a[under]<=temp) {
				int x =a[under];
				a[under] =a[top];
				a[top] = x;
			}
			   while (under>top && a[top]<temp) {//从前往后比，如果有比关键词大的交换位置，否则忘后比
				top++;
			}
			   if (a[top]>temp) {
				int x =a[top];
				a[top] =a[under];
				a[under] = x;
	//此时第一次循环比较结束，关键值的位置已经确定了。左边的值都比关键值小，右边的值都比关键值大，但是两边的顺序还有可能是不一样的，进行下面的递归调用
			}
			   
			if (top>start) {
				   quickSort(a,start,top-1);//左边序列。第一个索引位置到关键值索引-1
			}if (under<end) {
				quickSort(a, under+1, end);//右边序列。从关键值索引+1到最后一个
		
			}
		
		   } 
		   
	 
	 }
	  public static void HeadSort(int[] arr) {
    	if (arr ==null||arr.length <=1) {
			return;
		}
    	
    	createHead(arr);
    	
    	for (int i = arr.length-1; i>=1; i--) {
			swap(arr, 0, i);
			MinHead(arr, i,0);
		}
    }
	
	public static void createHead(int[] arr) {
		int parent = (arr.length)/2;
		for (int i = parent; i >=0; i--) { 
			MinHead(arr,arr.length,i);
		}
	}
	public static void MinHead(int[] arr,int length,int index) {
		int left =2*index +1;
		int right =2*index +2;
		int minindex =index;
		if (index<length) {
			if (left<length && arr[left]<arr[minindex]) {
				minindex = left;
			}if (right<length && arr[right]<arr[minindex]) {
				minindex = right;
			}if (index !=minindex) {
				swap(arr, index, minindex);
				MinHead(arr,length,minindex);
			}
		}
	}
	
	public static void swap(int[] array, int x, int y) {
		int temp = array[x];
		array[x] = array[y];
		array[y] = temp;

	}
}
