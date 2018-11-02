import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Atest {
  public static void main(String[] args) {
	/*   int[] a = new int[10000];
		int b =100;
		int c =3;	
		for (int i = 0; i < a.length; i++) {
				Random aRandom =new Random();
				a[i] =aRandom.nextInt(10000);
		}
		Sort(a);
//		for (int i = 0; i < a.length; i++) {
//			System.out.println("�����"+a[i]);
//		}
		Date aDate =new Date();
		//System.out.println("��ʼʱ��:"+aDate.getTime());
		//Update(a, b, c);
		//Delete(a, b);
		//Insert(a, b);
		//Search(a, b);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
			
		}
		Date bDate =new Date();
		Long aLong =bDate.getTime() - aDate.getTime();
		System.out.println("time:"+aLong);*/
	  Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String todayTime = sdf.format(d);
		System.out.println(todayTime);
		
}
  
  public static void Sort(int[] a) { 
	    int temp =0;
	 
		for (int i = 0; i < a.length-1; i++) {
			  temp = i;
			  for (int j = i+1; j < a.length; j++) {
				   if (a[temp]>a[j]) {
					   temp = j;
				}
			} 
			  if (temp!=i) {
				int t =a[temp];
				   a[temp]= a[i];
				   a[i] =t;			   
			}
		}	  
  }
  public static int Search(int[] a,int b) {
	     
	     int mid=0;
	     int start =0;
	     int end =a.length-1;
		while (start<=end) {
		 mid =(start +end)/2;		  
		 if (a[mid] == b) {
			System.out.println("位置坐标为:"+mid);
		}else if (a[mid]>b) {
			//Search(a, b,sm,mid);
			return start -1;
		}else {
			return	end -1;
		}
	}
	     return mid;
	/*   for (int i = 0; i < a.length; i++) {	   
		    if(a[i] == b) {
		       System.out.println("第:"+count+"个");	       
		    }
		    count ++;
	}*/
	   
	  /* Date aDate =new Date();
		System.out.println("Searchʱ�䣺"+aDate.getTime());*/
	
	   
}

public static int[] Insert(int[] a,int b) {
	   
	   int[] arr =new int[a.length+1];
	   for (int i = 0; i < arr.length; i++) {
		if (i <= a.length-1) {
			arr[i] = a[i];
		}else {
			arr[arr.length-1] = b;
		}
		
	}
	   
//		for (int i = 0; i < arr.length; i++) {
//			System.out.println("���������:" +arr[i]);
//		} 
	   Atest.Sort(a);
		/*Date aDate =new Date();
		System.out.println("insertʱ�䣺"+aDate.getTime());*/
	   return arr;
	   
}
public static int[] Delete(int[] a,int b) {
	   
    int count =0;
  
   for (int i = 0; i < a.length; i++) {
	   int flag =0;
	   if (a[i] == b) {				  
		  count++;		  
		  for (int K = i; K < a.length; K++) {
			if (a[K]==b) {
				flag++;
				System.out.println(flag);
			}else {
				break;
			}
		}			  
		  
	}else {
		a[i-flag] =a[i];
	}
	   //System.arraycopy(a, 0, arr, 0, arr.length);
	  
}
   int[] arr =new int[a.length-count];
   for (int j = 0; j < arr.length; j++) {
	     arr[j] =a[j];
}
//	for (int i = 0; i < arr.length; i++) {
//	System.out.println("ɾ��������:" +arr[i]);
//}
   //Atest.Sort(a);
   /*Date aDate =new Date();
	System.out.println("Deleteʱ�䣺"+aDate.getTime());*/
   return arr;
}

public static int[] Update(int[] a,int b,int c) {
	   int[] arr =new int[a.length];
	   
	   for (int i = 0; i < arr.length; i++) {
		if (a[i] == b) {
			//System.out.println("�޸�ǰ��"+a[i]);
			a[i] = c;
			//System.out.println("�޸ĺ�:"+a[i]);
		}
	}
	   Atest.Sort(a);
	   /*Date aDate =new Date();
		System.out.println("Updateʱ��:"+aDate.getTime());*/
	   return arr;
}
  
}
