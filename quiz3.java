public void bubbleSort(int []arr){
  if(arr==null||arr.length==0){
    return ;
  }
  for(int i=0;i<arr.length-1;i++){
    for(int j=0;j<arr.length-i-1;j++){
      if(arr[j+1]<arr[j]){
        int temp=arr[j+1];
        arr[j+1]=arr[j];
        arr[j]=temp;
      }
    }
  }
}

public void selectSort(int[]arr){
  if(arr==null||arr.length==0){
    return;
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
    return;
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


public void quickSort(int[]arr,int low,int high){
  if(arr==null||arr.length==0){
    return ;
  }
  int l=low;
  int h=high;
  int pivot=arr[low];
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
  if(arr==null||arr.length==0){
    return -1;
  }
  int low=0;
  int high=arr.length-1;
  while(l<=h){
    int middle=low+(high-low)/2;
    if(arr[middle]>k){
      high=middle-1;
    }else if(arr[middle]<k){
      low=middle+1;
    }else{
      return middle;
    }
  }
  return -1;
}

public int binarySearch(int[]arr,int k,int low,int high){
  if(low>high||k<arr[low]||k>arr[high]){
    return -1;
  }
  int middle=low+(high-low)/2;
  if(arr[middle]>k){
    binarySearch(arr,k,low,middle-1);
  }else if(arr[middle]<k){
    binarySearch(arr,k,middle+1,high);
  }else{
    return middle;
  }
}

int match(char*str,char*ptn){
  if(*ptn=='\0'){
    return 0;
  }
  if(*ptn=='*'){
    do{
      if(match(str++,ptn++)){
        return 1;
      }
    }while(*str!='\0');
    return 0;
  }
  if(*str=='\0'){
    return 0;
  }
  if(*str==*ptn||*ptn=='?'){
    return match(str+1,ptn+1);
  }
  return 0;
}

void reverseWord(char*str){
  int len = strlen(str);
  char*i=str;
  char*j=str+n-1;
  whil(i<j){
    char temp=*i;
    *i=*j;
    *j=temp;
    i++;
    j--;
  }
}
void reverseString(char*str,int len){
  if(str==NULL){
    return ;
  }
  char*first=str;
  char*last=str+len-1;
  while(first<last){
    char temp=*first;
    *first=*last;
    *last=temp;
    first++;
    last--;
  }
}

void reverseSentence(char*str){
  if(str==NULL){
    return ;
  }
  reverseString(str,strlen(str));
  char*p=str;
  char*index=NULL;
  while(*p!='\0'){
    while(*p!='\0' && *p==' '){
      p++;
    }
    index=p;
    while(*p!='\0' &&*p!=' '){
      p++;
    }
    int len=p-index;
    reverseString(index,p-index);
  }
}

bool isBackTraverse(int*a,int start,int end){
  if(start>=end){
    return false;
  }
  int root=a[end];
  int i=start;
  int j=end;
  if(i<j){
    while(a[i]<root && i<j){
      i++;
    }
    while(a[j]>root && i<j){
      j--;
    }
  }
  if(i<j){
    return false;
  }
  isBackTraverse(a,start,i-1);
  isBackTraverse(a,i+1,end);
}

bool  isBackTrave(int*arr,int start,int end){
  if(start>=end){
    return false;
  }
  int i=start;
  int j=end;
  int root=arr[end];
  if(i<j){
    while(arr[i]<root && i<j){
      i++;
    }
    while(arr[j]>root && i<j){
      j--;
    }
  }
  if(i<j){
    return false;
  }
  isBackTrave(arr,start,i-1);
  isBackTrave(arr,i+1,end);
}

int maxDepth(Node*root){
  int depth=0;
  return helper(root,depth);
}

int helper(Node*&root,int &depth){
  if(root==NULL){
    depth=0;
    return 0;
  }
  int ld=0;
  int rd=0;
  int maxLeft = helper(root->left,ld);
  int rightLeft = helper(root->right,rd);
  depth=max(ld,rd)+1;
  return max(maxLeft,max(maxRight,ld+rd));
}

Node*getLastKNode(Node*&head,int k){
  if(head==NULL||k==0){
    return NULL;
  }
  Node*p=head;
  Node*pk=head;
  for(int i=0;i<k;i++){
    if(pk->next!=NULL){
      pk=pk->next;
    }else{
      return NULL;
    }
  }
  while(pk->next!=NULL){
    pk=pk->next;
    p=p->next;
  }
  return p;
}

void findTwoNum(int*arr,int dest,int n){
  if(arr==NULL){
    return ;
  }
  int *first=arr;
  int *last=arr+n-1;
  int sum=*first+*last;
  while(sum<dest && first<last){
    if(sum<dest){
      sum=*(++first);
    }else{
      sum=*(--last);
    }
  }
  if(sum==dest){
    cout<<*first<<" "<<*last<<endl;
  }
}

public void bubbleSort(int[]arr){
  if(arr==null||arr.length==0){
    return ;
  }
  for(int i=0;i<arr.length-1;i++){
    for(int j=0;j<arr.length-i-1;j++){
      if(arr[j+1]<arr[j]){
        int value=arr[j+1];
        arr[j+1]=arr[j];
        arr[j]=value;
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
  for(int i=1;i<arr.length-1;i++){
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


public void quickSort(int[]arr,int low, int high){
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

public  int binarySearch(int []arr,int k){
  int low=0;
  int high=arr.length-1;
  while(low<=high){
    int middle=low+(high-low)/2;
    if(arr[middle]>k){
      high=middle-1;
    }else if(arr[middle]<k){
      low=middle+1;
    }else{
      return middle;
    }
  }
  return -1;
}

public int binarySearch(int[]arr,int k,int low,int high){
  if(arr[low]>k||arr[high]<k||low>=high){
    return -1;
  }
  int middle=low+(high-low)/2;
  if(arr[middle]>k){
    binarySearch(arr,k,low,middle-1);
  }else if(arr[middle]<k){
    binarySearch(arr,k,middle+1,high);
  }else{
    return middle;
  }
}

public static void adjustHeap(int[]arr,int i,int len){
  int temp=arr[i];
  for(int j=i*2;j<arr.length;j*=2){
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
  for(int i=arr.length/2-1;i>=0;i--){
    adjustHeap(arr,0,arr.length-1);
  }
  for(int i=arr.length-1;i>=0;i--){
    int temp=arr[0];
    arr[0]=arr[i];
    arr[i]=temp;
    adjustHeap(arr,0,i-1);
  }
}

public static void adjustHeap(int[]arr,int i,int len){
  int temp=arr[i];
  for(int j=i*2;j<len;j*=2){
    if(arr[j]<arr[j+1]){
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

public static void heapSort(int[]arr){
  for(int i=arr.length/2-1;i>=0;i--){
    adjustHeap(arr,0,arr.length-1);
  }
  for(int i=arr.length-1;i>=0;i--){
    int temp=arr[0];
    arr[0]=arr[i];
    arr[i]=temp;
    adjustHeap(arr,0,i-1);
  }
}

public void bubbleSort(int arr[]){
  if(arr==null || arr.length==0){
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
  if(arr==null ||arr.length==0){
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

public void quickSort(int []arr. int low,int high){
  int l=low;
  int h=high;
  int pivot=arr[low];
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
  int high=arr.length-2;
  while(low<=high){
    int middle=low+(high-low)/2;
    if(arr[middle]<k){
      low=middle+1;
    }else if(arr[middle]>k){
      high=middle-1;
    }else{
      return middle;
    }
  }
  return -1;
}

public int binarySearch(int[]arr,int k,int low,int high){
  if(k<arr[low] || k>arr[high] || low>high){
    return -1;
  }
  int middle=low+(high-low)/2;
  if(arr[middle]>k){
    binarySearch(arr,k,middle+1,high);
  }else if(arr[middle]<k){
    binarySearch(arr,k,low,middle-1);
  }else{
    return ;
  }
}

































































































































































































































































endline
