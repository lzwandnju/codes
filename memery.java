void permute(string&str,int depth,int n){
  if(depth==n){
    result.push_back(str);
    return;
  }
  for(int i=depth;i<n;i++){
    swap(str[depth,str[i]]);
    permuate(str,depth+1,n);
    swap(str[depth],str[i]);
  }
}

void swap(char c1,char c2){
  char temp=c1;
  c1=c2;
  c2=temp;
}

public void permute(char[]str,int i){
  if(i>=str.length){
    return ;
  }
  if(i==str.length-1){
    System.out.println(String.valueOf(str));
  }else{
    for(int j=i;j<arr.length;j++){
      swap(str[j],str[i]);
      permute(str,i+1);
      swap(str[j],str[i]);
    }
  }
}

public int lcs(String str1, Sring str2){
  int len1 = str1.length;
  int len2 = str2.length;
  int c[][]=new int[len1+1][len2+1];
  for(int i=0;i<=len1;i++){
    for(int j=0;j<=len2;j++){
      if(i==0 || j==0){
        c[i][j]=0;
      }else if(str1.charAt(i-1) == str2.charAt(j-1)){
        c[i][j]=c[i-1][j-1]+1;
      }else{
        c[i][j]=max(c[i-1][j],c[i][j-1]);
      }
    }
  }
  return c[len1][len2];
}

public int lcs(String str1,String str2){
  int len1 = str1.length;
  int len2 = str2.length;
  int result = 0;
  int c[][]=new int[len1+1][len2+1];
  for(int i=0;i<=len1;i++){
    for(int j=0;j<=len2;j++){
      if(i==0||j==0){
        c[i][j]=0;
      }else if(str1.charAt(i-1) == str2.charAt(j-1)){
        c[i][j] = max(c[i-1][j-1]+1,result);
        result  = c[i][j];
      }else{
        c[i][j]=0;
      }
    }
  }
  return result;
}


public void deleteNode(ListNode head,ListNode delNode){
  if(delNode==null || head==null){
    return ;
  }
  if(head==delNode){
    head=null;
  }else{
    if(delNode.next == NULL){
      ListNode p = head;
      while(p.next.next!=null){
        p = p.next;
      }
      p.next = null;
    }else{
      delNode.data = delNode.next.data;
      delNode.next = delNode.next.next;
    }
  }
}

bool deleteNode(Node*&head,Node*p){
  if(!p||!head){
    return false;
  }
  if(p->next!=NULL){
    p->value = p->next->value;
    p->next = p->next->next;
    delete (p->next);
    q=null;
  }else if(p==head){
    delete p;
    head=NULL;
  }else{
    Node*pre=head;
    while(pre->next !=p){
      pre=pre->next;
    }
    delete p;
    p=NULL;
    pre->next = NULL;
  }
  return true;
}

void findTwoNum(int*arr,int n){
  int result =0 ;
  int a = 0;
  int b = 0;
  int num = 0;
  for(int i=0;i<n;i++){
    result ^= arr[i];
  }
  while(result!=0){
    if(result & 0x1 ==0){
      result = result>>1;
      num++;
    }else{
      break;
    }
  }
  int cmp = 1 << num;
  for(int i=0;i<n;i++){
    if(arr[i] & cmp){
      a ^= arr[i];
    }else{
      b ^= arr[i];
    }
  }
  cout<< a <<" "<<b<<endl;
}

public Node findFirstCommonNode(Node head1,Node head2){
  int length1 = getLength(head1);
  int length2 = getLength(head2);
  int diff =length1- length2;
  Node longNode = head1;
  Node shortNode = head2;
  if(diff < 0){
    longNode = head2;
    shortNode = head1;
    diff = length2-length1;
  }
  for(int i=0;i<diff;i++){
    longNode =longNode.next;
  }
  while(longNode != shortNode && longNode!=null && shortNode!=null){
    longNode = longNode.next;
    shortNode = shortNode.next;
  }
  Node commonNode=longNode;
  return commonNode;
}

public int getLength(Node head){
  int length=0;
  Node p = head;
  while(p!= null){
    p = p->next;
    length++;
  }
  return length;
}
vector<string>result;
void permutate(string&str,int depth,int n){
  if(depth==n){
    result.push_back(str);
    return ;
  }
  for(int i=depth;i<n;i++){
    swap(str[depth],str[i]);
    permutate(str,depth+1,n);
    swap(str[depth],str[i]);
  }
}

void swap(char c1, char c2){
  char temp = c1;
  c1 = c2;
  c2 = temp;
}

void permutate(char[]str,int i){
  if(i>str.length){
    return ;
  }
  if(i==str.length-1){
    System.out.println(String.valueOf(str));
  }else{
    for(int j=i;j<str.length;j++){
      swap(str[i],str[j]);
      permutate(str,i+1);
      swap(str[i],str[j]);
    }
  }
}

void permutate(char[]str,int depth){
  if(depth>str.length-1){
    return ;
  }
  if(depth==str.length-1){
    System.out.println(String.valueOf(str));
  }else{
    for(int i=depth;i<arr.length;i++){
      swap(str[depth],str[i]);
      permutate(str,depth+1);
      swap(str[depth],str[i]);
    }
  }
}

public int lcs(String str1,String str2){
  int len1 = str1.length;
  int len2 = str2.length;
  int c[][]=new int[len1+1][len2+1];
  for(int i=0;i<=len1;i++){
    for(int j=0;j<=len2;j++){
      if(i==0||j==0){
        c[i][j]=0;
      }else if(str1.charAt(i)==str2.charAt(j)){
        c[i][j]=c[i-1][j-1]+1;
      }else{
        c[i][j]=max(c[i-1][j],c[i][j-1]);
      }
    }
  }
  return c[len1][len2];
}

public int lcs(String str1,String str2){
  int len1 = str1.length;
  int len2 = str2.length;
  int c[][]=new int[len1+1][len2+1];
  for(int i=0;i<=len1;i++){
    for(int j=0;j<=len2;j++){
      if(i==0 || j==0){
        c[i][j]=0;
      }else if(str1.charAt(i)==str2.charAt(j)){
        c[i][j]=a[i-1][j-1]+1;
      }else{
        c[i][j]=max(c[i-1][j],c[i][j-1]);
      }
    }
  }
  return c[len1][len2];
}


public int lcs(String str1,String str2){
  int len1 = str1.length;
  int len2 = str2.length;
  int c[][] = new int[len1+1][len2+1];
  int result = 0;
  for(int i=0;i<=len1;i++){
    for(int j=0;j<=len2;i++){
      if(i==0||j==0){
        c[i][j]=0;
      }else if(str1.charAt(i)==str2.charAt(j)){
        c[i][j]=max(c[i][j]+1,result);
        result =c[i][j];
      }else{
        c[i][j]=0;
      }
    }
  }
  return result;
}

public void deleteNode(ListNode head,ListNode delNode){
  if(head==null||delNode==null){
    return;
  }
  if(head==delNode){
    head=null;
  }else if(delNode.next==null){
    p=head;
    while(p.next.next!=null){
      p=p.next;
    }
    p.next = null;
  }else{
    delNode.value = delNode.next.value;
    delNode.next = delNode.next.next;
  }
}

public void deleteNode(ListNode head,ListNode delNode){
  if(head==null||delNode==null){
    return ;
  }
  if(head==delNode){
    head=null;
  }else if(delNode.next==null){
    ListNode p=head;
    while(p.next.next!=null){
      p=p.next;
    }
    p.next = null;
  }else{
    delNode.value = delNode.next.value;
    delNode.next =delNode.next.next;
  }
}

bool deleteNode(Node*&head,Node*p){
  if(!p||!head){
    return false;
  }
  if(p->next!=NULL){
    p->value = p->next->value;
    p->next = p->next->next;
    delete (p->next);
    p->next = NULL;
  }else{
    Node*q = head;
    while(q->next->next!=NULL){
      q = q->next;
    }
    delete p;
    p=NULL;
    q->next = NULL;
  }
  return true;
}

bool deleteNode(Node*&head,Node*p){
  if(!head||!p){
    return false;
  }
  if(p->next!=NULL){
    p->value=p->next->value;
    p->next = p->next->next;
    delete (p->next);
    p->next = NULL;
  }else{
    Node*q=head;
    while(q->next->next!=NULL){
      q=q->next;
    }
    delete p;
    p=NULL;
    q->next=NULL;
  }
  return true;
}

void findTwoNum(int*arr,int n){
  int result=0;
  int a=0;
  int b=0;
  int num=0;
  for(int i=0;i<n;i++){
    result^=arr[i];
  }
  while(result!=0){
    if(result & 0x1 ==0){
      result = result >>1;
      num++;
    }else{
      break;
    }
  }
  int cmp = 1<<num;
  for(int i=0;i<n;i++){
    if(arr[i] & cmp){
      a ^= arr[i];
    }else{
      b ^= arr[i];
    }
  }
  cout<<a<<"  "<<b<<endl;
}

void findTwoNum(int *arr, int n){
  int result=0;
  int a=0;
  int b=0;
  int num=0;
  for(int i=0;i<n;i++){
    result^=arr[i];
  }
  while(result!=0){
    if(result & 0x1==0){
      result = result>>1;
      num++;
    }else{
      break;
    }
  }
  int cmp =1 << num;
  for(int i=0;i<n;i++){
    if(arr[i] & cmp){
       a^=arr[i];
    }else{
      b^=arr[i];
    }
  }
  cout<<a<<" "<<endl;
}

public Node findFirstCommonNode(Node head1, Node head2){
  int length1 = getLength(head1);
  int length2 = getLength(head2);
  Node longNode = head1;
  Node shortNode = head2;
  int diff = length1-length2;
  if(diff<0){
    longNode = head2;
    shortNode = head1;
    diff = length2-length2;
  }
  for(int i=0;i<diff;i++){
    longNode=longNode.next;
  }
  while(longNode!=null && shortNode!=null && longNode!=shortNode){
    longNode = longNode.next;
    shortNode = shortNode.next;
  }
  Node commonNode = longNode;
  return commonNode;
}

public int getLength(Node head){
  Node p =head;
  int length=0;
  while(p!=null){
    p=p.next;
    length++;
  }
  return length;
}

public Node findFirstCommonNode(ListNode head1,ListNode head2){
  int len1 = getLength(head1);
  int len2 = getLength(head2);
  ListNode longNode = head1;
  ListNode shortNode = head2;
  int diff =len1-len2;
  if(diff<0){
    longNode = head2;
    shortNode = head1;
    diff = len2-len1;
  }
  for(int i=0;i<diff;i++){
    longNode = longNode.next;
  }
  while(longNode != shortNode && longNode!=null && shortNode != null){
    longNode = longNode.next;
    shortNode  =shortNode.next;
  }
  LisyNode commonNode = longNode;
  return commonNode;
}

public int getLength(ListNode head){
  ListNode p=head;
  int len=0;
  while(p!=null){
    p=p.next;
    len++;
  }
  return len;
}

public class Singleton {
  private volatile static Singleton instance;
  private Singleton(){}
  public static Singleton getInstance(){
    if(instance ==null){
      synchronized(Singleton.class){
        if(instance==null){
          instance = new Singleton();
        }
      }
    }
    return instance;
  }
}

public class Singleton{
  private volatile static Singleton instance;
  private Singleton(){}
  public static Singleton getInstance(){
    if(instance == null){
      synchronized(Singleton.class){
        if(instance==null){
          instance = new Singleton();
        }
      }
    }
    return instance;
  }
}

public class Singleton{
  private static class SingletonHolder{
    public static Singleton instance = new Singleton();
  }
  private Singleton(){}
  public static Singleton getInstance(){
    return SingletonHolder.instance;
  }
}

public class Singleton(){
  private static class SingletonHolder(){
    public static Singleton instance = new Singleton();
  }
  private Singleton(){}
  public static Singleton getInstance(){
    return SingletonHolder.instance;
  }
}

public class Singleton {
  private static class SingletonHolder{
    public static Singleton instance = new Singleton();
  }
  private Singleton(){}
  public static Singleton getInstance(){
    return SingletonHolder.instance;
  }
}

public enum Singleton{
  instance;
  public void getInstance(){}
}

public enum Singleton {
  INSTANCE;
  public void getInstance(){}
}

int getLongestSymmetricLength(char*str){
  if(str==NULL){
    return 0;
  }
  int symLen = 1;
  char *pchar = str;
  while(*pchar!='\0'){
    char *first = pchar;
    char *last = pchar+1;
    wile( (first>=str) && (last!='\0') && (*first==*last)){
      last++;
      first--;
    }
    int newLen = last-first+1;
    if(newLen>symLen){
      symLen = newLen;
    }
    first = pcahr-1;
    last = pchar+1;
    while((first>=str) && (*last!='\0') &&(*first == *last)){
      first--;
      last++;
    }
    newLen = last-first+1;
    if(newLen>symLen){
      symLen = newLen;
    }
    pchar++;
  }
  return symLen;
}

int getMajor(int arr[],int n){
  int x=0;
  int cnt=0;
  for(int i=0;i<n;i++){
    if(cnt==0){
      x=arr[i];
      cnt++;
    }else if(arr[i]==x){
      cnt++;
    }else{
      cnt--;
    }
  }
  return x;
}

Node*linkedListMergeSort(Node*head){
  int len = getLen(head);
  return mergeSort(head,len);
}

Node*mergeSort(Node*p,int len){
  if(len==1){
    p->next=NULL;
    return p;
  }
  Node*mid=p;
  for(int i=0;i<len/2;i++){
    mid =mid->next;
  }
  Node*p1=mergeSort(p,len/2);
  Node*p2=mergeSort(mid,len-len/2);
  return merge(p1,p2);
}

Node*merge(Node*p1,Node*p2){
  Node*p=NULL;
  Node*ph=NULL;
  while(p1!=NULL&&p2!=NULL){
    if(p1->value<p2->value){
      if(ph==NULL){
        ph=p=p1;
      }else{
        p->next = p1;
        p1->next;
        p = p->next;
      }
    }else{
      if(ph==NULL){
        ph=p=p2;
      }else{
        p=p2;
        p2=p2->next;
        p=p->next;
      }
    }
  }
  p->next = (p1==NULL)?p2:p1;
  return ph;
}

Node* Array2Tree(int arr[],int n){
  return helper(arr,0,n-1);
}

Node*helper(int arr[],int start,int end){
  if(start>end){
    return NULL;
  }
  int mid = start+(end-start)/2;
  Node*root=new Node(arr[mid]);
  root->left=helper(arr,start,mid-1);
  root->right=helper(arr,mid+1,end);
  return root;
}

int partition(int []arr){
  int i=arr.length-1;
  int j=arr.length-1;
  int coun=0;
  while(i>=0){
    if(arr[i]!='*'){
      swap(arr,i--,j--);
    }else{
      i--;
      count++;
    }
  }
  return count;
}

int atoi(const char* a){
  if(*a=='+'){
    return atoi(a+1);
  }else if(*a=='-'){
    return -atoi(a+1);
  }else{
    char*p=a;
    int c=0;
    while(*p>='0'&&*p<='9'){
      c=c*10+(*p-10);
      p++;
    }
    return c;
  }
}

int partition(const char*str){
  char*i=str;
  char*j=str;
  while(*i!='\0'){
    if(*i>'9'||*i<'0'){
      *j++=*i++;
    }else{
      *i++;
    }
  }
  *j='\0';
  return str;
}

boolean isAscending(int a[]){
  return isAscending(a,0);
}

boolean isAscending(int a[],int start){
  return start ==a.length-1 ||  isAscending(a,start+1);
}

char* strcpy(char*strDest,const char *strSrc){
  if(strSrc==NULL){
    return NULL;
  }
  char*i=strSrc;
  char*j=strDest;
  while(*i!='\0'){
    *j++=*i++;
  }
  *j='\0';
  return strDest;
}

Node lowestAncestor(Node root, Node n1,Node n2){
  if(root==null){
    return root;
  }
  Node left=lowestAncestor(root.left,n1,n2);
  Node right=lowestAncestor(root.right,n1,n2);
  if(left!=null && right!=null){
    return root;
  }
  return left!=null?left:right;
}
