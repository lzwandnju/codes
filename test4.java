public static void adjustHeap(int[]arr,int i,int len){
  int temp=arr[i];
  for(int j=i*2;j<len;j*=2){
    if(j<len && arr[j]<arr[j+1]){
      j++;
    }
    if(temp>=arr[j]){
      break;
    }
    arr[i]=arr[j];
    i=j;
  }
  arr[i]=temp;
}

public static void headSort(int[]arr){
  for(int i=arr.lengh/2-1;i>=0;i--){
    adjustHeap(arr,i,arr.length-1);
  }
  for(int i=arr.length-1;i>=0;i--){
    int temp=arr[0];
    arr[0]=arr[i];
    arr[i]=temp;
    adjustHeap(arr,0,i-1);
  }
}
public  static void adjustHeap(int[]arr,int i,int len){
  int temp=arr[i];
  for(int j=i*2;j<len;j*=2){
    if(j<len && arr[j]<arr[j+1]){
      j++;
    }
    if(temp>=arr[j]){
      break;
    }
    arr[i]=arr[j];
  }
  arr[i]=temp;
}

public static void heapSort(int []arr){
  for(int i=arr.length/2-1;i>=0;i--){
    adjustHeap(arr,i,arr.length-1);
  }
  for(int i=arr.length-1;i>=0;i--){
    int temp=arr[0];
    arr[0]=arr[i];
    arr[i]=temp;
    adjustHeap(arr,0,i-1);
  }
}

public static void bubbleSort(int[]arr){
  if(arr==null||arr.length==0){
    return ;
  }
  for(int i=0;i<arr.length-1;i++){
    for(int j=0;j<arr.length-i-1;j++){
      if(arr[j+1]<arr[j]){
        int temp=arr[j];
        arr[j]=arr[j+1];
        arr[j+1]=temp;
      }
    }
  }
}
public static void selectSort(int[]arr){
  if(arr==null||arr.length==0){
    return 0;
  }
  for(int i=0;i<arr.length-1;i++){
    for(int j=i+1;j<arr.length;j++){
      if(arr[j]<arr[i]){
        int temp=arr[j];
        arr[j]=arr[i];
        arr[i]=temp;
      }
    }
  }
}

public static void insertSort(int[]arr){
  if(arr==null||arr.length==0){
    return ;
  }
  for(int i=1;i<arr.length;i++){
    int value=arr[i];
    int index=i;
    for(int j=i-1;j>=0;j--){
      if(arr[j]>value){
        arr[j+1]=arr[j];
        index-=1;
      }else{
        break;
      }
    }
    arr[index]=value;
  }
}
public static quickSort(int[]arr,int low, int high){
  int l=low;
  int h=high;
  int pivot=arr[low];
  while(l<h){
    while(pivot<arr[h] && l<h){
      h--;
    }
    if(l<h){
      int temp=arr[h];
      arr[h]=arr[l];
      arr[l]=temp;
      l++;
    }
    while(pivot>arr[l] && l<h){
      l++;
    }
    if(l<h){
      int temp=arr[l];
      arr[l]=arr[h];
      arr[h]=temp;
      h++;
    }
  }
  if(l<high){
    quickSort(arr,l+1,high);
  }
  if(l>low){
    quickSort(arr,low,l-1);
  }
}

public static int binarySearch(int []arr,int k){
  int low=0;
  int high=arr.length-1;
  while(low<=high){
    int middle=low+(high-low)/2;
    if(arr[middle]>k){
      binarySearch(arr,low,middle-1);
    }else if(arr[middle]<k){
      binarySearch(arr,middle+1,high);
    }else{
      return middle;
    }
  }
  return -1;
}

public static int binarySearch(int []arr,int k,int low, int high){
  if(k<arr[low] || k>arr[high] ||low>high){
    return -1;
  }
  int middle=low+(high-low)/2;
  if(arr[middle]>k){
    binarySearch(arr,k,low,middle-1);
  }else if(arr[middle]<k){
    binarySearch(arr,k,middle,high);
  }else{
    return middle;
  }
}















































































































































































































































































































































































endlines；
