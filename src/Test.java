import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
	public static void main(String[] args) {
		String str = "window.X_Anti_Forge_Token = 'd82e8d04-7765-4e4a-8874-f5c72ce5939f'; window.X_Anti_Forge_Code = '99365302'";
		//String pattern = ".*X_Anti_Forge_Token = \\'(.*?)\\'";

		String pattern = " \\'(.*?)\\'";

		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(str);
		System.out.println(m.find());
		System.out.println(m.group(1));
		
		// int[] a = new int[5];
		// int b =1;
		// int c =3;
		// TreeMap<String, String>
		// TreeSet<Integer> aIntegers =new TreeSet<>();
		// for (int i = 0; i < 50; i++) {
		// aIntegers.add(i);
		// }
		// System.out.println(aIntegers.toString());
		//
		// for (int i = 0; i < a.length; i++) {
		// Random aRandom =new Random();
		// a[i] =aRandom.nextInt(100);
		// }
		Date aDate = new Date();
		// System.out.println("��ʼʱ��:"+aDate.getTime());
		// Update(a, b, c);
		// Delete(a, b);
		// Insert(a, b);
		// Search(a, b);
		// insertSort(a);
		int[] a = new int[] { 50, 100, 6, 3, 2, 1, 5, -5, 6, 8 };
		quickSort(a,0,a.length-1);
		for (int i = 0; i < a.length; i++) { 
			System.out.print(a[i] + "   ");
		}
		Date bDate = new Date();
		Long aLong = bDate.getTime() - aDate.getTime();
		System.out.println("time:" + aLong);

	}
	
//	  public static void insertSort(int[] arr) { for (int i = 1; i < arr.length;
//	  i++) { int temp = arr[i]; int j = 0; for (j = i - 1; j>=0 && temp<arr[j];
//	  j--) { arr[j+1] = arr[j];
//	
//	  } System.out.println("第"+i+"趟排序"); arr[j+1] = temp; }
//	  
//	  }
	 

		 

	public static void quickSort(int[] a, int low, int high) {
		  int start = low; int end = high; int key = a[low];
   
		  while(end>start){ //从后往前比较 
			  while(end>start&&a[end]>=key) {
				  end--;
			  }
		  //如果没有比关键值小的，比较下一个，直到有比关键值小的交换位置，然后又从前往后比较 ;
			  if(a[end]<=key){ 
				  int temp =
		  a[end]; a[end] = a[start]; a[start] = temp; 
		  } //从前往后比较
		  while(end>start&&a[start]<=key)
		  {
			  if(a[start]>=key){ int temp = a[start]; a[start] = a[end]; a[end] = temp;}   //如果没有比关键值大的，比较下一个，直到有比关键值大的交换位置 start++;
		  }
		 
		  //此时第一次循环比较结束，关键值的位置已经确定了。左边的值都比关键值小，右边的值都比关键值大，但是两边的顺序还有可能是不一样的，进行下面的递归调用 }
		  //递归 
		  if(start>low) quickSort(a,low,start-1);
		  //左边序列。第一个索引位置到关键值索引-1
		  if(end<high) quickSort(a,end+1,high);
		  //右边序列。从关键值索引+1到最后一个

	}
	}

	/*public static void HeadSort(int[] a) {

		if (a == null || a.length <= 1) {// 判断数组
			return;
		}
		createHead(a);// 建堆
		for (int i = a.length - 1; i >= 1; i--) {// 循环遍历每个数，从最底层遍历，之后看最小堆是否成立
			swap(a, 0, i);
			minHead(a, i, 0);
		}
	}

	public static void createHead(int[] a) {
		int parent = (a.length) / 2;// 父节点
		for (int i = parent; i >= 0; i--) {
			minHead(a, a.length, i);// 建立最小堆
		}
	}

	public static void minHead(int[] a, int length, int index) {
		int left = 2 * index + 1;
		int right = 2 * index + 2;
		int minindex = index;
		if (left < length && a[left] < a[minindex]) {
			minindex = left;
		}
		if (right < length && a[right] < a[minindex]) {
			minindex = right;
		}
		if (index != minindex) {
			swap(a, index, minindex);
			minHead(a, length, minindex);
		}

	}
*/
	
	public static void sortHead(int[] arr) {
		if (arr==null || arr.length <=1) {
			return;
		}
		
		createHead(arr);
		for (int i = arr.length-1; i >=1; i--) {
			swap(arr, 0, i);
			maxHead(arr, i, 0);
		}
	}
	
	
	public static void createHead(int[] arr) {
		
		
		int parent = (arr.length)/2;
		
		for (int i = parent; i >=0; i--) {
			maxHead(arr, arr.length, i);
		}
	}
	
	
	public static  void  maxHead(int[] arr,int length,int index) {
		int left =2 * index +1;
		int right =2 *index +2;
		int maxindex =index;
		if (index<length) {
			if (left<length && arr[left]>arr[maxindex]) {
				maxindex = left;
			}if (right<length && arr[right]>arr[maxindex]) {
				maxindex = right;
			}if (index != maxindex) {
				swap(arr, index, maxindex);
				maxHead(arr, length, maxindex);
			}
		}
	}
	
	public static void swap(int[] array, int x, int y) {
		int temp = array[x];
		array[x] = array[y];
		array[y] = temp;

	}

	public static int Search(int[] a, int b) {

		int count = 1;
		int temp = 0;
		for (int i = 0; i < a.length; i++) {

			if (a[i] == b) {
				System.out.println("λ���ڵ�:" + count + "����");
			}
			count++;
		}

		/*
		 * Date aDate =new Date(); System.out.println("Searchʱ�䣺"+aDate.getTime());
		 */
		return count;

	}

	public static int[] Insert(int[] a, int b) {

		int[] arr = new int[a.length + 1];
		for (int i = 0; i < arr.length; i++) {
			if (i <= a.length - 1) {
				arr[i] = a[i];
			} else {
				arr[arr.length - 1] = b;
			}

		}

		// for (int i = 0; i < arr.length; i++) {
		// System.out.println("���������:" +arr[i]);
		// }
		// Atest.Sort(a);
		/*
		 * Date aDate =new Date(); System.out.println("insertʱ�䣺"+aDate.getTime());
		 */
		return arr;

	}

	public static int[] Delete(int[] a, int b) {

		int count = 0;

		for (int i = 0; i < a.length; i++) {
			int flag = 0;
			if (a[i] == b) {
				count++;
				for (int K = i; K < a.length; K++) {
					if (a[K] == b) {
						flag++;
						System.out.println(flag);
					} else {
						break;
					}
				}

			} else {
				a[i - flag] = a[i];
			}
			// System.arraycopy(a, 0, arr, 0, arr.length);

		}
		int[] arr = new int[a.length - count];
		for (int j = 0; j < arr.length; j++) {
			arr[j] = a[j];
		}
		// for (int i = 0; i < arr.length; i++) {
		// System.out.println("ɾ��������:" +arr[i]);
		// }
		// Atest.Sort(a);
		/*
		 * Date aDate =new Date(); System.out.println("Deleteʱ�䣺"+aDate.getTime());
		 */
		return arr;
	}

	public static int[] Update(int[] a, int b, int c) {
		int[] arr = new int[a.length];

		for (int i = 0; i < arr.length; i++) {
			if (a[i] == b) {
				// System.out.println("�޸�ǰ��"+a[i]);
				a[i] = c;
				// System.out.println("�޸ĺ�:"+a[i]);
			}
		}
		// Atest.Sort(a);
		/*
		 * Date aDate =new Date(); System.out.println("Updateʱ��:"+aDate.getTime());
		 */
		return arr;
	}

	public static void insertSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int temp = arr[i];
			int j = 0;
			for (j = i - 1; j >= 0; j--) {
				if (arr[j] > temp) {
					arr[j + 1] = arr[j];
				} else {
					break;
				}
			}
			arr[j + 1] = temp;
		}
	}
}
