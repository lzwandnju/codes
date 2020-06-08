//冒泡排序，n-1轮比较
public void bubbleSort(int[]arr){
  if(arr==null || arr.length==0)
    return ;
  for(int i=0;i<arr.length-1;i++){
    for(int j=0;j<arr.length-i-1;j++){
      if(arr[j+1]<arr[j]){
        int temp = arr[j+1];
        arr[j+1]=arr[j];
        arr[j]=temp;
      }
    }
  }
}
//选择排序
public void selectSort(int []arr){
  if(arr==null ||arr.length==0)
    return ;
  for(int i=0;i<arr.length-1;i++){
    for(int j=i+1;j<arr.length;j++){
      if(arr[j]<arr[i]){
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
      }
    }
  }
}

//插入排序
public void insertSort(int[]arr){
  if(arr==null||arr.length==0){
    return;
  }
  for(int i=1;i<arr.length;i++){
    int value =arr[i];
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
//快排
public void quickSort(int[]arr,int low,int high){
  int l=low;
  int h=high;
  int povit = arr[low];
  while(l < h){
    while(povit < arr[h] && l<h){
      h--;
  }
  if(l<h){
    int temp = arr[h];
    arr[h]=arr[l];
    arr[l]=temp;
    l++;
  }
  while(povit>arr[l] && l<h){
    l++;
  }
  if(l<h){
    int temp = arr[l];
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

//非递归二分查找
public int binarySearch(int []arr,int data){
  int low = 0;
  int high = arr.length-1;
  while(low<=high){
    int middle = (low+high)/2;
    if(arr[middle]<data){
      low=middle+1;
    }else if(arr[middle]>data]){
      high=middle-1;
    }else{
      return middle;
    }
  }
  return -1;
}
//递归二分查找
public int binarySearch(arr[]int, int data, int low,int high){
  if(data<arr[low] || data>arr[high] || low>high)
    return -1;
  int middle = (low+high)/2;
  if(arr[middle]>data){
    binarySearch(arr,data,low,middle-1);
  }else if(arr[middle]<data){
    binarySearch(arr,data,middle+1,high);
  }else{
    return middle;
  }
}

//单词字母全排列
void permutate(string&str,int depth,int n){
  if(depth==n){
    result.push_back(str);
    return;
  }
  for(int i=depth;i<n;i++){
    swap(str[depth],str[i]);
    permutate(str,depth+1,n);
    swap(str[depth],str[i]);
  }
}
//交换字符
void swap(char c1,char c2){
  char temp=c1;
  c1=c2;
  c2=temp;
}
//单词全排列，java
public void permutate(char[]str,int i){
  if(i>str.length){
    return;
  }
  if(i==str.length-1)}{
    System.out.println(String.valueOf(str));
  }else{
    for(int j=i;j<str.length;j++){
      swap(str[i],str[j]);
      permutate(str,i+1);
      swap(str[j],str[i]);
    }
  }
}
//最长公共子序列，动态规划解决
public int lcs(String str1,String str2){
  int len1=str1.length;
  int len2=str2.length;
  int c[][]=new int[len1+1][len2+1];
  for(int i=0;i<=len1;i++){
    for(int j=0;j<=len2;j++){
      if(i==0||j==0){
        c[i][j]=0;
      }else if(str1.charAt(i-1)==str2.charAt(j-1)){
        c[i][j]=c[i-1][j-1]+1;
      }else{
        c[i][j]=Math.max(c[i-1][j],c[i][j-1]);
      }
    }
  }
  return c[len1][len2];
}

//最长公共子串，要求子序列是连续的
public int lcs(String str1,String str2){
  int len1=str1.length;
  int len2=str2.length;
  int c[][]=new int[len1+1][len2+1];
  int result=0;
  for(int i=0;i<=len1;i++){
    for(int j=0;j<=len2;j++){
      if(i==0||j==0){
        c[i][j]=0;
      }else if(str1.charAt(i-1)==str2.charAt(j-1)){
        c[i][j]=Math.max(c[i-1][j-1]+1,result);
        result=c[i][j];
      }else{
        c[i][j]=0;
      }
    }
  }
  return result;
}

//给出链表头结点和待删除节点，删除这个节点，java
public void deleteNode(ListNode head,ListNode delNode){
  if(delNode==null||head==null){
    return;
  }
  if(delNode==head){
    head=null;
  }else{
    if(delNode.next==null){
      ListNode p=head;
      while(p.next.next!=null){
        p=p.next;
      }
      p.next=null;
    }else{
      delNode.next  = delNode.next.next;
      delNdoe.value = delNdoe.next.value;
    }
  }
}
//给出链表头结点和待删除节点，删除这个节点，c++
bool delNode(Node*&head,Node*del){
  if(!head||!del){
    return false;
  }
  if(del->next!=NULL){
    Node*p=del->next;
    del->next=p->next;
    del->value=p->value;
    delete p;
    p=NULL;
  }else if(del==head){
    head=NULL;
    delete del;
    del=NULL;
  }else{
    Node*p=head;
    while(p->next!=del){
      p=p->next;
    }
    p->next=NULL;
    delete del;
    del=NULL;
  }
  return true;
}
//xor应用，找出只出现一次的唯一两个数字
void findTwoNum(int*arr,int n){
  int a=0;
  int b=0;
  int num=0;
  int result=0;
  for(int i=0;i<n;i++){
    result^=arr[i];
  }
  while(result!=0){
    if(result & 0x1==0){
      num++;
      result=result>>1;
    }else{
      break;
    }
  }
  int cmp = 1<<num;
  for(int i=0;i<n;i++){
    if（arr[i] & cmp){
      a^=arr[i];
    }else{
      b^=arr[i];
    }
  }
  cout<<a<<" "<<b<<endl;
}
//链表找到第一个公共节点
public Node findFirstCommonNode(Node n1, Node n2){
  int len1 = getLength(n1);
  int len2 = getLength(n2);
  Node longNode  = n1;
  Node shortNode = n2;
  int diff = len1-len2;
  if(diff<0){
    longNode = n2;
    shortNode = n1;
    diff=len2-len1;
  }
  for(int i=0;i<diff;i++){
    longNode = longNode.next;
  }
  while(longNode!=shortNode && longNode!=null && shortNode!=null){
    longNode=longNode.next;
    shortNode=shortNode.next;
  }
  Node commonNode = longNode;
  return commonNode;
}
//获取链表的长度
public int getLength(Node head){
  int length=0;
  Node p = head;
  while(p!= null){
    p = p->next;
    length++;
  }
  return length;
}
//单例模式
public class Singleton{
  private volatile static Singleton instance;
  private Singleton(){}
  public static Singleton getInstance(){
    if(instance == null){
      synchronized(Singleton.class){
        if(instance == null){
          instance = new Singleton();
        }
      }
    }
    return instance;
  }
}

public class Singleton{
  private static class SingletonHolder{
    private static final Singleton INSTANCE = new Singleton();
  }
  private Singleton(){}
  public static final Singleton getInstance(){
    return SingletonHolder.INSTANCE;
  }
}

public enum Singleton{
  INSTANCE;
  public void method()
}
//单例模式
public enum Singleton{
  INSTANCE;
  public void method(){
  }
}
//获取最长的对称子串长度
int getLongestSymmetricLength(char*str){
  if(str==null){
    return 0;
  }
  int max=1;
  char*pchar=str;
  while(pchar!='\0'){
    char*first=pchar;
    char*second=pchar+1;
    while((first>=str) && (*second!='0') && (*first==*second)){
      first--;
      second++;
    }
    int newLen = second-first+1;
    if(newLen>max){
      max = newLen;
    }
    first=pchar-1;
    second=pchar+1;
    while((first>=pchar) && (*second!='\0') && (*first==*second)){
      first--;
      second++;
    }
    newLen = second-first+1;
    if(newLen>max){
      max=newLen;
    }
    ++pchar;
  }
  return max;
}
//查找出现次数超过一半的数字
int getMoreThanHalfNum(int arr[], int n){
  int cnt=0;
  int num=0;
  for(int i=0;i<n;i++){
    if(cnt==0){
      num=arr[i];
      cnt++;
    }else if(num==arr[i]){
      cnt++;
    }else{
      cnt--;
    }
  }
  return num;
}
//两个单链表的merge排序
void linkedListMergeSort(Node*head){
  int len=getLength(head);
  return mergeSort(head,len);
}

void mergeSort(Node*head,int n){
  if(n==1){
    head->next=NULL;
    return head;
  }
  Node*mid=head;
  for(int i=0;i<n/2;i++){
    mid=mid->next;
  }
  Node*p1=mergeSort(head,n/2);
  Node*p2=mergeSort(mid,n-n/2);
  return merge(p1,p2);
}
void merge(Node*p1,Node* p2){
  Node*head=NULL;
  Node*current=NULL;
  while(p1!=NULL && p2!=NULL){
    if(p1->value<p2->value){
      if(head==NULL){
        head=p1;
        current=p1;
      }else{
        current->next=p1;
        p1=p1->next;
        current=current->next;
      }
    }else{
      if(head==NULL){
        head=p2;
        current=p2;
      }else{
        current->next=p2;
        p2=p2->next;
        current=current->next;
      }
    }
  }
  current->next=(p1==NULL)?p2:p1;
  return head;
}

int getLength(Node*head){
  Node*p=head;
  int length=0;
  while(p!=NULL){
    p=p->next;
  }
  return length;
}
//排好序的数组转换成树
Node* array2Tree(int arr[],int n){
  return helper(arr,0,n-1);
}

Node* helper(int arr[],int start, int end){
  if(start >end){
    return NULL;
  }
  int mid=start+(end-start)/2;
  Node*root=new Node(arr[mid]);
  root->left=helper(arr,start,mid-1);
  root->right=helper(arr,mid+1,end);
  return root;
}
//将所有的*移动到最左边，并且连续排在一起
int partition(char []arr){
  int i=arr.length-1;
  int j=arr.length-1;
  int count=0;
  while(i>=0 && j>=0){
    if(arr[i]!='*'){
      swap(arr,i--,j--);
    }else{
      i--;
      count++;
    }
  }
  return count;
}
//字符串转换成数字
int atoi(const char*arr){
  if(*arr=='+'){
    return atoi(arr+1);
  }else if(*arr=='-'){
    return -atoi(arr+1);
  }else{
    int c=0;
    char*p=arr;
    while(*p>='0'&&*p<='9'){
      c = c*10+(*p-'0');
      p++;
    }
    return c;
  }
}
//删除串中的所有的数字
char* deleteNumInStr(const char*arr){
  char*i=arr;
  char*j=arr;
  while(*i!='\0'){
    if(*i>'9'||*i<'0'){
      *j++=*i++;
    }else{
      i++;
    }
  }
  *j='\0';
  return arr;
}
//递归判断int数组是升序数组
boolean isAscending(int []a){
  return isAscending(a,0);
}

boolean isAscending(int a[],int start){
  return start ==a.length-1 || isAscending(a,start+1);
}
//内存拷贝
char* copy(char*dest,char *src){
  if(src==NULL){
    return NULL;
  }
  char* i=src;
  char* j=dest;
  while(*i!='\0'){
    *j++=*i++;
  }
  *j='\0';
  return dest;
}
//寻找最近祖先节点
Node getLowestAncestor(Node root, Node n1,Node n2){
  if(root==null){
    return null;
  }
  Node left=getLowestAncestor(root.left,n1,n2);
  Node right=getLowestAncestor(root.right,n1,n2);
  if(left!=null &&  right!=null){
    return root;
  }
  return left!=null? left:right;
}

//1.把二元查找树变成排序的双向链表
TreeNode* tree2LinkedList(TreeNode*root){
  TreeNode*head;
  TreeNode*tail;
  helper(head,tail,root);
  return head;
}

TreeNode* helper(TreeNode*&head,TreeNode*&tail,TreeNode*root){
  if(root==NULL){
    head=NULL;
    tail=NULL;
    return NULL;
  }
  TreeNode*leftTail,*rightHead;
  helper(head,leftTail,root->left);
  helper(rightHead,tail,root->right);
  if(leftTail!=NULL){
    leftTail->right=root;
    root->left=leftTail;
  }else{
    head=root;
  }
  if(rightHead!=NULL){
    rightHead->left=root;
    root->right=rightHead;
  }else{
    tail=head;
  }
}

//3.求子数组的最大和，java实现
int getArrayMaxSum(int[]arr){
  if(arr==null||arr.length==0){
    return 0;
  }
  int max=-(1<<31);
  int sum=0;
  for(int i=0;i<arr.length;i++){
    if(sum<0){
      sum=0;
    }
    sum+=arr[i];
    if(sum>max){
      max=sum;
    }
  }
  return max;
}
//c++实现
int getArrayMaxSum(int arr[],int n){
  if(arr==NULL||n==0){
    return 0;
  }
  int max=-(1<<31);
  int sum=0;
  for(int i=0;i<n;i++){
    if(sum<0){
      sum=0;
    }
    sum+=arr[i];
    if(sum>max){
      max=sum;
    }
  }
  return sum;
}

//4.在二叉树中找出和委某一值的所有路径
#define MAX_LEN 9999999

void printpaths(Node*root,int sum){
  int path[MAX_LEN];
  helper(root,sum,path,0);
}

void helper(Node*&root,int sum, int path[],int top){
  path[top++]=root->value;
  sum-=root->value;
  if(root->left!=NULL && root->right!=NULL){
    if(sum==0){
      printPath(path,top);
    }
  }else{
    if(root->left!=NULL){
      helper(root->left,sum,path,top);
    }else if(root->right!=NULL){
      helper(root->right,sum,path,top);
    }
  }
  top--;
  sum+=root->value;
}

//7.判断两个链表是否相交
//两个链表都没有环
bool isJoinedNoCycle(Node*h1,Node*h2){
  Node*p1=h1;
  Node*p2=h2;
  while(p1->next!=NULL){
    p1=p1->next;
  }
  while(p2->next!=NULL){
    p2=p2->next;
  }
  return p1==p2;
}

bool isJoinedCycle(Node*h1,Node*h2){
  Node*c1=findLoop(h1);
  Node*c2=findLoop(h2);
  if(c1+c2==0){
    return isJoinedNoCycle(h1,h2);
  }
  if((c1==0&&c2!=0) ||(c1!=0 &&c2==0)){
    return false;
  }
  Node*p=c1;
  while(1){
    if(p==c2||p->next==c2){
      return true;
    }
    p=p->next->next;
    c2=c2->next;
    if(p==c2){
      return true;
    }
  }
}


//判断单链表是否存在环
LinkedList *findLoop(LinkedList*head){
  LinkedList*fast=head;
  LinkedList*slow=head;
  while(fast && fast->next){
    slow=slow->next;
    fast=fast->next->next;
    if(slow==fast){
      return fast;
    }
  }
  return NULL;
}

//寻找带环单链表的环入口节点的方法
LinkedList * findLoopPort(LinkedList*head){
  LinkedList*slow=head;
  LinkedList*fast=head;
  while(fast && fast->next){
    slow=slow->next;
    fast=fast->next->next;
    if(slow==fast){
      break;
    }
  }
  if(fast==NULL && fast->next==NULL){
    return NULL;
  }
  slow=head;
  while(slow!=fast){
    slow=slow->next;
    fast=fast->next;
  }
  return slow;
}

//计算带环链表中环的长度
int loopLength(LinkedList*head){
  LinkedList*fast=head;
  LinkedList*slow=head;
  while(fast&&fast->next){
    slow=slow->next;
    fast=fast->next->next;
    if(slow==fast){
      break;
    }
  }
  if(fast==NULL||fast->next==NULL){
    return 0;
  }
  int length=0;
  slow=head;
  while(slow!=fast){
    slow=slow->next;
    fast=fast->next;
    length++;
  }
  return length;
}

//递归来颠倒一个单链表的顺序
LinkedList * reverse(LinkedList*head){
  if(head==NULL||head->next==NULL){
    return head;
  }
  LinkedList *newHead=reverse(head->next);
  head->next->next=head;
  head->next=NULL;
  return newHead;
}
//非递归颠倒单链表
LinkedList*reverseNonRecursive(LinkedList *head){
  if(head==NULL||head->next==NULL){
    return head;
  }
  LinkedList*p=head;
  LinkedList*pre=NULL;
  LinkedList*temp=NULL;
  while(p->next!=NULL){
    temp=p->next;
    p->next=pre;
    pre=p;
    p=temp;
  }
  p->next=pre;
  return p;
}

//使用通用字符串相匹配
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
//颠倒一个字符串
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
//颠倒一个句子中单词的顺序
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

//判断整数序列是不是二元查找树的后序遍历结果
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

//求二叉树中节点的最大距离.
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

//13.输入一个单向链表，输出该链表中倒数第k 个结点
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

//14.输入一个已经按升序排序过的数组和一个数字，
//在数组中查找两个数，使得它们的和正好是输入的那个数字。
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

//15.输入一颗二元查找树，将该树转换为它的镜像
void swap(Node**left,Node**right){
  Node*temp=*left;
  *left=*right;
  *right=*temp;
}
//递归
void mirror(Node*root){
  if(root==NULL){
    return;
  }
  swap(&(root->left),&(root->right));
  mirror(root->left);
  mirror(root->right);
}
//非递归
void mirrorIteratively(Node*root){
  if(root==NULL){
    return ;
  }
  stack<Node*>s;
  s.push(root);
  while(!s.empty()){
    Node*p=s.pop();
    swap(&(p->left),&(p->right));
    if(p->left!=NULL){
      s.push(p->left);
    }
    if(p->right!=NULL){
      s.push(p->right);
    }
  }
}

//输入一颗二元树，从上往下按层打印树的每个结点，同一层中按照从左往右的顺序打印。
void printByLevel(Node root){
  if(root==NULL){
    return ;
  }
  LinkedList list = new LinkedList<Node>();
  list.addFirst(root);
  Node s = new Node();
  list.addFirst(s);
  while(!list.isEmpty()){
    Node p = list.removeLast();
    if(p==s){
      System.out.println("\n");
      list.addFirst(s);
    }else{
      System.out.println(p.value);
      if(p.left!=null){
        list.addFirst(p.left);
      }
      if(p.right!=null){
        list.addFirst(p.right);
      }
    }
  }
}
//从数组中寻找和委m的所有的组合
void findCombination(int n,int m){
  if(n>m){
    findCombination(m,m);
  }
  int aux[n];
  memset(aux,0,n*sizeof(int));
  helper(m,0,aux,n);
}
void helper(int dest, int index,int aux[],int n){
  if(dest=0){
    dump(aux,n);
  }
  if(dest<=0 || index==n){
    return ;
  }
  helper(dest,index+1,aux,n);
  aux[index]=1;
  helper(dest-index-1,index+1,aux,n);
  aux[index]=0;
}
void dump(int aux[],int n){
  for(int i=0;i<n;i++){
    if(aux[i]){
      cout<<i+1;
    }
  }
  cout<<endl;
}

//合并两个链表
LinkedList *mergeLinkedList(LinkedList*h1,LinkedList* h2){
  if(h1==NULL){
    return h2;
  }
  if(h2==NULL){
    return h1;
  }
  LinkedList *head=NULL;
  if(h1->value<h2->value){
    head=h1;
    h1=h1->next;
  }else{
    head=h2;
    h2=h2->next;
  }
  LinkedList current=head;
  while(h1!=NULL && h2!=NULL){
    if(h2==NULL || (h1!=NULL && h1->value<h2->value){
      current->next=h1;
      h1=h1->next;
      current=current->next;
    }else{
      current->next=h2;
      h2=h2->next;
      current=current->next;
    }
  }
  current->next=NULL;
  return head;
}
//获取最长非数字连续字符串
int getMaxNonNumStr(char*str,char*ch){
  if(str==NULL){
    return 0;
  }
  char *p=str;
  char *q=NULL;
  int len=0;
  int max=0;
  while(1){
    if(*p>'9'||*p<'0'){
      len++;
    }else{
      if(len>max){
        max=len;
        q=str-p;
      }
      len=0;
    }
    p++;
    if(*p=='\0'){
      break;
    }
  }
  for(int i=0;i<max;i++){
    *ch=*q;
  }
  return max;
}
