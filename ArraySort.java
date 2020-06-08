public class ArraySort {
  public static void bubbleSort(int[]arr){
    for(int i=0;i<arr.length-1;i++){
      for(int j=0;j<arr.length-1-i;j++){
        if(arr[j]>arr[j+1]){
          swap(arr,j,j+1);
        }
      }
    }
  }
public static void selectSort(int[]arr){
  for(int i=0;i<arr.length-1;i++){
    for(int j=i+1;j<arr.length;j++){
      if(arr[i]>arr[j]){
        swap(arr,i,j);
      }
    }
  }
}

public static void swap(int[]arr,int index1,int index2){
  int temp = arr[index1];
  arr[index1]=arr[index2];
  arr[index2]=temp;
}

public static void quickSort(int[]arr,int low, int high){
  int l = low;
  int r = high;
  int povit = arr[low];
  while(l < h){
    while(povit<arr[h] && l<h){
      h--;
    }
    if(l<h){
      swap(arr,l,h);
      l++;
    }
    while(povit>arr[l] && l<h){
      l++;
    }
    if(l<h){
      swap(arr,l,h);
      h++;
    }
  }
  if(l>low)quickSort(arr,low,l-1);
  if(h<high)quickSort(arr,h+1,high);
}


public void static bubbleSort(int[]arr){
  for(int i=0;i<arr.length-1;i++){
    for(int j=0;j<arr.length-i-1;j++){
      if(arr[j]>arr[j+1]){
        int temp=arr[j];
        arr[j]=arr[j+1];
        arr[j+1]=temp;
      }
    }
  }
}

public static void selectSort(int[]arr){
  for(int i=0;i<arr.length-1;i++){
    for(int j=i+1;j<arr.length;j++){
      if(arr[i]>arr[j]){
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
      }
    }
  }
}

public static void quickSort(int []arr,int low,int high){
  int l=low;
  int h=high;
  int povit = arr[low];
  while(l<h){
    while(povit<arr[h] && l<h){
      h--;
    }
    if(l<h){
      int temp = pivot;
      pivot=arr[h];
      arr[h]=temp;
    }
    while(povit>arr[l] && l<h){
      l++;
    }
    if(l<h){
      int temp=pivot;
      pivot=arr[l];
      arr[l]=temp;
    }
  }
  if(l>low)quickSort(arr,low,l-1);
  if(h>high)quickSort(arr,l+1,high);
}





























}
