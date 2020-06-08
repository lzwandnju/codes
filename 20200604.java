public void bubbleSort(int[]arr){
  if(arr==null||arr.length==0){
    return ;
  }
  for(int i=0;i<arr.length-1;i++){
    for(int j=0;j<arr.length-i-1;j++){
      if(arr[j+1]<arr[j]){
        int temp=arr[j+1];;
        arr[j+1]=arr[j];
        arr[j]=temp;
      }
    }
  }
}

public void selectSort(int[]arr){
  if(arr==null||arr.length==0){
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


public void insertSort(int[]arr){
  if(arr==null||arr.length==0){
    return ;
  }
  for(int i=1;i<arr.length;i++){
    int value=arr[i];
    int index=i;
    for(int j=i-1;j>=0;j--){
      if(value<arr[j]){
        arr[j+1]=arr[j];
        index-=1;
      }else{
        break;
      }
    }
    arr[index]=value;
  }
}

public void quickSort(int[]arr,int low,int high){
  int l=low;
  int h=high;
  int pivot = arr[low];
  while(l<h){
    while(pivot<arr[h] && l<h){
      h--;
    }
    if(l<h){
      int temp=arr[l];
      arr[l]=arr[h];
      arr[h]=temp;
      l++;
    }
    while(pivot>arr[l] && l<h){
      l++;
    }
    if(l<h){
      int temp=arr[h];
      arr[h]=arr[l];
      arr[l]=temp;
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

public int binarySearch(int []arr,int k){
  int low=0;
  int high=arr.length-1;
  while(low<=high){
    int middle=(low+high)/2;
    if(arr[middle]<k){
      low=middle+1;
    }else if(arr[middle]>k){
      high=middle-1;
    }else{
      return middle;
    }
  }
}

public int binarySearch(int[]arr,int k,int low,int high){
  if(k>arr[high]||k<arr[low]||low>high){
    return -1;
  }
  int middle=(low+high)/2;
  if(arr[middle]>k){
    binarySearch(arr,k,low,middle-1);
  }else if(arr[middle]<k){
    binarySearch(arr,k,middle+1,high);
  }else{
    return middle;
  }
}

public void adjustHeap(int[]arr,int i,int len){
  int temp=a[i];
  for(int j=i*2;j<len;j*=2）{
    if(j<len && arr[j] <arr[j+1]){
      j++;
    }
    if(temp>=arr[j]){
      break;
    }
    arr[i]=arr[j];
  }
  arr[i]=temp;
}

public void heapSort(int[]arr){
  if(arr==null||arr.length==0){
    return ;
  }
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


缓存：本地缓存与分布式缓存，guava本地缓存，redis memory cache分布式缓存
队列：异步化操作，解耦操作，采用消息队列，rabbitmq、rocketmq，
应用拆分：将大的应用拆分为小的应用，降低项目之间的依赖性
数据库分库分表：分布式数据库，分库分表
降级和熔断：hystrix实现降级和熔断
限流：采用guava中的令牌桶或者破桶原理，限流
负载均衡：采用nginx反向代理，采用权重、随机、轮询的负载均衡方式，ribbon提供负载均衡器
分布式调度：elastic-job zookeeper，rxjava异步化编程
高效搜索手段：es数据库，solr数据库，es使用倒排索引的方式，加速文本的搜索
zipkin：追踪任务的id，定位服务调用日志，通过kibana收集日志































































































































endline;
