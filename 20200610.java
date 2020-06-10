
public void bubbleSort(int[]arr){
  if(arr==null||arr.length==0){
    return;
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

public void selectSort(int[]arr){
  if(arr==null||arr.length==0){
    return ;
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

public int binarySearch(int[]arr,int k){
  int low=0;
  int high=arr.length-1;
  while(low<=high){
    int middle=(low+high)/2;
    if(arr[middle]>k){
      high=middle-1;
    }else if(arr[middle]<k){
      low=middle+1;
    }else{
      return middle;
    }
  }
}

public int binarySearch(int[]arr,int k,int low,int high){
  if(k>high||k<low||arr[low]>arr[high]){
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
  int temp=arr[i];
  for(int j=i*2;j<len;j*=2){
    if(j<len &&  arr[j]<arr[j+1]){
      j++;
    }
    if(arr[j]<=temp){
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

缓存：本地缓存与分布式缓存，guava本地缓存，redis memory cache 分布式缓存
队列：异步化操作，解耦业务，采用消息队列，rabbitmq  rocketmq 或者kafka
应用拆分：将大的应用拆分为小的应用，降低项目之间的耦合性，构建微服务集群
数据库分库分表:分布式数据库，分库分表
降级和熔断：采用hystrix进行访问的降级和熔断，防止出现峰值访问，导致系统崩溃
限流：确保系统可以稳定的提供服务，比如热点访问或者秒杀等场景，采用guava中的令牌桶原理或者破桶原理限流
复杂均衡: 采用nginx进行反向代理，在nginx侧进行负载均衡，采用随机、hash、轮询或者权重的方式访问不同的生产机器
分布式调度：elastic-job  zookeeper进行分布式调度，rxjava异步化的编程，或者采用disruptor方式调用
高效的搜索引擎：es搜索，solr搜索，es底层采用了倒排索引的方式来进行搜索，提高文本的搜索效率
监控: 采用octopus、zipkin、skywalking或者kabana来进行相关的系统监控与日志的搜索，定位产生问题的报警等信息








































































































































































































endline;
