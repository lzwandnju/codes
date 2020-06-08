public void bubbleSort(int[]arr){
  if(arr==null || arr.length==0){
    return ;
  }
  for(int i=0;i<arr.length-1;i++){
    for(int j=0;j<arr.length-i-1;j++){
      if(arr[j]>arr[j+1]){
        int temp = arr[j];
        arr[j]=arr[j+1];
        arr[j+1]=temp;
      }
    }
  }
}

public void selectSort(int arr[]){
  if(arr==null || arr.length==0){
    return ;
  }
  for(int i=0;i<arr.length-1;i++){
    for(int j=i+1;j<arr.length;j++){
      if(arr[i]>arr[j]){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
      }
    }
  }
}

public void quickSort(int []arr,int low, int high){
  int l=low;
  int h=high;
  int povit=arr[low];
  while(l<h){
    while(povit < arr[h] && l<h){
      h--;
    }
    if(l<h){
      int temp=arr[l];
      arr[l]=arr[h];
      arr[h]=temp;
      l++;
    }
    while(povit > arr[l] && l<h){
      l++;
    }
    if(l<h){
      int temp=arr[l];
      arr[l]=arr[h];
      arr[h]=temp;
      h++;
    }
  }
  if(l>low)
    quickSort(arr,low,l-1);
  if(l<high)
    quickSort(arr,l+1,high);
}

public void binarySearch(int[]arr,int a){
  int low=0;
  int high=arr.length-1;
  while(low<=high){
    int middle = (low+high)/2;
    if(arr[middle]<a){
      high = middle-1;
    }else if(arr[middle]>a){
      low=middle+1;
    }else{
      return middle;
    }
    return -1;
  }
}

public void binarySearch(int[]arr,int a,int low, int high){
  int middle = (low+high)/2;
  if(a<arr[low] || a>arr[high]||low>high){
    return -1;
  }
  if(a<arr[middle]){
    binarySearch(arr,a,low, middle-1);
  }else if(a>arr[middle]){
    binarySearch(arr,a,middle+1,high);
  }else{
    return middle;
  }
}

public static void binarySearch(int []arr, a){
  int low=0;
  int high=arr.length-1;
  while(low<=high){
    int middle=(low+high)/2;
    if(arr[middle]>a){
      high=middle-1;
    }else if(arr[middle]<a){
      low=middle+1;
    }else{
      return middle;
    }
  }
  return -1;
}

public static void binarySearch(int[]arr,int a, int low, int high){
  int middle = (low+high)/2;
  if(a<arr[low] || a>arr[high]||low>high){
    return -1;
  }
  if(a> arr[middle]){
    binarySearch(arr,a,middle+1,high);
  }else if(a<arr[middle]){
    binarySearch(arr,a,low,middle-1);
  }else{
    return middle;
  }
  return -1;
}

public static void Fribonacci(int n){
  if(n<=2)
    return 1;
  else
    return Fribonacci(n-1)+Fribonacci(n-2);
}

public static void hanio(int n,char a, char b,char c){
  if(n==1)
    System.out.println("move"+n+"from"+a+"to"+c);
  else{
    hanio(n-1,a,c,b);
    System.out.println("move"+n+"from"+a+"to"+c);
    hanio(n-1,b,a,c);
  }
}

public static void insertSort(int[]arr){
  for(int i=1;i<arr.length;i++){
    int value = arr[i];
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

public static void insertSort(int[]arr){
  for(int i=1;i<arr.length;i++){
    int value = arr[i];
    int index = i;
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

public static void insertSort(int[]arr){
  if(arr==null || arr.length==0)
    return;
  for(int i=1;i<arr.length;i++){
    int value  = arr[i];
    int index=1;
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
