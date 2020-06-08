 public void quickSort(int[]arr,int low,int high){
   int l=low;
   int h=high;
   int pivot = arr[low];
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

public int binarySearch(int[]arr,int data,int low, int high){
  if(data<arr[low] || data>arr[high] || low>high){
    return -1;
  }
  int middle=(low+high)/2;
  if(arr[middle]>data){
    binarySearch(arr,data,low,middle-1);
  }else if(arr[middle]<data){
    binarySearch(arr,data,middle+1,high);
  }else{
    return middle;
  }
}

public int binarySearch(int[]arr,int data){
  int low=0;
  int high=arr.length-1;
  while(low<=high){
    int middle = (low+high)/2;
    if(arr[middle]>data){
      high=middle-1;
    }else if(arr[middle]<data){
      low=middle+1;
    }else{
      return middle;
    }
  }
  return -1;
}

public void adjustHeap(int[]arr,int len ,int i){
  int value = arr[i];
  for(int j=2*i;j<len;j*=2){
    if(j<len && arr[j]<arr[j+1]){
      j++;
    }
    if(arr[j]<value){
      break;
    }
    arr[i]=arr[j];
    i=j;
  }
  arr[i]=value;
}

public void heapSort(int[]arr){
  if(arr==null||arr.length==0){
    return ;
  }
  for(int i=arr.length/2-1;i>=0;i++){
    adjustHeap(arr,0,arr.length-1);
  }
  for(int i=arr.length-1;i>=0;i--){
    int temp=arr[0];
    arr[0]=arr[i];
    arr[i]=temp;
    adjustHeap(arr,0,i-1);
  }
}



































































































































































































































































































endline;
