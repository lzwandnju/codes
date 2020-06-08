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
//交换字符
void swap(char c1,char c2){
  char temp=c1;
  c1=c2;
  c2=temp;
}
//单词全排列，java
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
//最长公共子序列，动态规划解决
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

//最长公共子串，要求子序列是连续的
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
        result = c[i][j];
      }else{
        c[i][j]=0;
      }
    }
  }
  return result;
}

//给出链表头结点和待删除节点，删除这个节点，java
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
//给出链表头结点和待删除节点，删除这个节点，c++
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
//xor应用，找出只出现一次的唯一两个数字
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
//链表找到第一个公共节点
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
  private volatile static Singleton singleton;
  private Singleton(){}
  public static Singleton getSingleton(){
    if(singleton==null){
      synchronized(Singleton.class){
        if(singleton == null){
          singleton = new Singleton();
        }
      }
    }
  return singleton;
  }
}
//单例模式
public class Singleton{
  private static class SingletonHolder{
    private static final Singleton INSTANCE = new Singleton();
  }
  private Singleton(){}
  public static final Singleton getInstance(){
    return SingletonHolder.INSTANCE;
  }
}
//单例模式
public enum Singleton{
  INSTANCE;
  public void method(){
  }
}
//获取最长的对称子串长度
int getLongestSymmetricLength(char*str){
if(str==NULL){
    return 0;
}
int symLen=1;
char *pchar=str;
while(*pchar!='\0'){
    char *first=pchar;
    char *end=pchar+1;
    while((first>=str) && (*last!='\0') &&(*first == *last)){
        last++;
        first--;
    }
    int newLen = last-first+1;
    if(newLen>symLen){
        symLen = newLen;
     }
    first=pchar-1;
    last=pchar+1;
    while((first>=str) && (*last!='\0')&&(*first==*last)){
        last++;
        first--;
    }
    newLen = last-first+1;
    if(newLen>symLen){
        symLen = newLen;
    }
    pchar++;
    }
    return symLen;
}
//查找出现次数超过一半的数字
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
//两个单链表的merge排序
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
    mid=mid->next;
  }
  Node*p1=mergeSort(p,len/2);
  Node*p2=mergeSort(mid,len-len/2);
  return merge(p1,p2);
}

Node*merge(Node*p1,Node*p2){
  Node*p=NULL;
  Node*ph=NULL;
  while(p1!=NULL && p2 !=NULL){
    if(p1->value<p2->value){
      if(ph==NULL){
        ph=p=p1;
      }else{
        p->next=p1;
        p1=p1->next;
        p=p->next;
      }
    }else{
      if(ph==NULL){
        ph=p=p2;
      }else{
        p->next=p2;
        p=p->next;
        p2=p2->next;
      }
    }
  }
  p->next = (p1==NULL)?p2:p1;
  return ph;
}
//排好序的数组转换成树
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
//将所有的*移动到最左边，并且连续排在一起
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
//字符串转换成数字
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
//删除串中的所有的数字
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
//递归判断int数组是升序数组
boolean isAscending(int a[]){
  return isAscending(a,0);
}

boolean isAscending(int a[],int start){
  return start ==a.length-1 || isAscending(a,start+1);
}
//内存拷贝
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
//寻找最近祖先节点
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

//1.把二元查找树变成排序的双向链表
TreeNode *tree2LinkedList(TreeNode*root){
  TreeNode * head,*tail;
  helper(head,tail,root);
  return head;
}

void helper(TreeNode*&head,TreeNdoe*&tail,TreeNode*root){
  TreeNode*lt,*rh;
  if(root==NULL){
    head=NULL;
    tail=NULL;
    return NULL;
  }
  helper(head,lt,root->left);
  helper(rh,tail,root->right);
  if(lt!=NULL){
    lt->right=root;
    root->left=lt;
  }else{
    head=root;
  }
  if(rh!=NULL){
    root->right=rh;
    rh->left=root;
  }else{
    tail=root;
  }
}

//3.求子数组的最大和
int maxSumArray(int a[],int size){
  if(size<0){
    error('error array size');
  }
  int sum=0;
  int max=-(1<<31);
  for(int i=0;i<size;i++){
    if(sum<0){
      sum=0;
    }
    sum+=a[i];
    if(sum>max){
      max=sum;
    }
  }
  return max;
}

int getArrayMaxSum(int[]arr){
  if(arr==null || arr.length==0){
    return -1;
  }
  int sum=0;
  int max=-(1<<31);
  for(int i=0;i<arr.length;i++){
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
# define MAX_HEIGHT 99999
void printPaths(TreeNode*root,int sum){
  int path[MAX_HEIGHT];
  helper(root,sum,path,0);
}

void helper(TreeNode*root,int sum,int path[],int top){
  path[top++]=root->value;
  sum-=root->value;
  if(root->left==NULL && root->right==NULL){
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
  sum-=root->value;
}

//7.判断两个链表是否相交
//两个链表都没有环
int isJoinedNoCycle(Node*h1,Node*h2){
  while(h1->next!=NULL){
    h1=h1->next;
  }
  while(h2->next!=NULL){
    h2=h2->next;
  }
  return h1==h2;
}

int isJoinedCycle(Node*h1,Node*h2){
  Node*c1 = existCycle(h1);
  Ndoe*c2 = existCycle(h2);
  if(c1+c2==0){
    return isJoinedCycle(h1,h2);
  }
  if(c1==0&&c2!=0 || c1!=0 && c2==0){
    return 0;
  }
  Node*p=c1;
  while(1){
    if(p==c2||p->next==c2){
      return 1;
    }
    p=p->next->next;
    c1=c1->next;
    if(p==c1){
      return 0;
    }
  }
}

Node*existCycle(Node*head){
  Node*p1=head;
  Node*p2=head;
  while(p2!=NULL && p2->next!=NULL){
    p1=p1->next;
    p2=p2->next->next;
    if(p1==p2){
      return p1;
    }
  }
  return NULL;
}

//是否存在环
LinkList* isExistLoop(LinkList*head){
  LinkList*slow=head;
  LinkList*fast=head;
  while(fast && fast->next){
    slow=slow->next;
    fast=fast->next->next;
    if(slow==fast){
      return slow;
    }
  }
  return NULL;
}

//寻找带环单链表的环入口节点的方法
LinkList *findLoopPort(LinkList*head){
  LinkList*slow=head;
  LinkList*fast=head;
  while(fast && fast->next){
    slow=slow->next;
    fast=fast->next->next;
    if(slow==fast){
      break;
    }
  }
  if(fast==NULL||fast->next==NULL){
    return NULL;
  }
  slow=head;
  while(slow!=fast){
    slow=slow->next;
    fast=fast->next;
  }
  return slow;
}

//求环的长度
int loopLength(LinkList *head){
  LinkList *slow=head;
  LinkList *fast=head;
  LinkList *p;
  int length=0;
  while(fast && fast->next){
    slow=slow->next;
    fast=fast->next->next;
    if(slow==fast){
      break;
    }
  }
  if(fast==NULL ||fast->next==NULL){
    return 0;
  }
  while(true){
    slow=slow->next;
    fast=fast->next->next;
    length++;
    if(slow==fast){
      break;
    }
  }
  return length;
}

//递归来颠倒一个单链表的顺序
Node* reverse(Node*head){
  if(head==NULL || head->next==NULL){
    return head;
  }
  Node*ph=reverse(head->next);
  head->next->next=head;
  head->next=NULL;
  return ph;
}

Node* reverseNonRecursive(Node*head){
  if(head==NULL){
    return head;
  }
  Node*p=head;
  Node*previous=NULL;
  while(p->next!=NULL){
    p->next=previous;
    previous=p;
    p=p->next;
  }
  p->next=previous;
  return p;
}

//使用通用字符串相匹配
int match(char *str,char*ptn){
  if(*ptn=='\0'){
    return 1;
  }
  if(*ptn=='*'){
    do{
      if(match(str++,ptn++)){
        retun 1;
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
void reverse(char*str){
  reverseFixlen(str+1,strlen(str));
}

void reverseFixlen(char*str,int n){
  char*p=str+n-1;
  while(str<p){
    char c=*str;
    *str=*p;
    *p=c;
  }
}

//颠倒一个句子中单词的顺序
void reverseWordsInSentence(char*sen){
  int len =strlen(sen);
  reverseFixlen(sen,len);
  char*p=str;
  while(*p!='\0'){
    while(*p=='' && *p!='\0'){
      p++;
    }
    str=p;
    while(p!=''&&*p!='\0'){
      p++;
    }
    reverseFixlen(str,p-str);
  }
}

//判断整数序列是不是二元查找树的后序遍历结果
int is_backsort(int*a,int start, int end){
  if(start>=end){
    return 0;
  }
  int root=a[end];
  int i=start;
  int j=end-1;
  if(i<j){
    while(a[i]<root && i<j){
      i++;
    }
    while(a[j]>root && i<j){
      j--;
    }
  }
  if(i<j){
    return -1;
  }
  is_backsort(a,start,i-1);
  is_backsort(a,i+1,end);
}

//求二叉树中节点的最大距离.
int maxDistance(Node*root){
  int depth;
  return helper(root,depth);
}

int helper(Node*root,int &depth){
  if(root==NULL){
    depth=0;
    return 0;
  }
  int ld;
  int rd;
  int maxleft=helper(root->left,ld);
  int rightleft=helper(root->rigth,rd);
  depth=max(ld,rd)+1;
  return max(maxleft,max(maxright,ld+rd))
}

//13.输入一个单向链表，输出该链表中倒数第k 个结点
Node*lastK(Node*head, int k){
  if(k<0){
    error(k<0);
  }
  Node*p=head;
  Node*pk=head;
  for(;k>0;k--){
    if(pk->next!=NULL){
      pk=pk->next;
    }else{
      return NULL;
    }
  }
  while(pk->next!=NULL){
    p=p->next;
    pk=pk->next;
  }
  return p;
}

//14.输入一个已经按升序排序过的数组和一个数字，
//在数组中查找两个数，使得它们的和正好是输入的那个数字。
void find2Number(int a[],int n,int dest){
  int *f=a;
  int *e=a+n-1;
  int sum=*f+*e;
  while(sum!=dest && f<e){
    if(sum<dest){
      sum=*(++f);
    }else{
      sum=*(--e);
    }
  }
  if(sum==dest){
    cout<<*f<<" "<<*e<<endl;
  }
}

//15.输入一颗二元查找树，将该树转换为它的镜像
void swap(Node**l,Node**r){
  Node*p=*l;
  *l=*r;
  *r=*p;
}

void mirror(Node*root){
  if(root==NULL){
    return ;
  }
  swap(&(root->left),&(root->right));
  mirror(root->left);
  mirror(root->right);
}

void mirrorIteratively(Node*root){
  if(root==NULL){
    return ;
  }
  stack<Node*>buff;
  buff.push(root);
  while(!stack.empty()){
    Node*n=stack.pop();
    swap(&(root->left),&(root->right));
    if(root->left!=NULL){
      buff.push(root->left);
    }
    if(root->right!=NULL){
      buff.push(root->right);
    }
  }
}

//输入一颗二元树，从上往下按层打印树的每个结点，同一层中按照从左往右的顺序打印。
void printByLevel(Node root){
  Node s = new Node();
  LinkedList<Node>q=new LinkedList<Node>();
  q.addFirst(first);
  q.addFirst(s);
  while(!q.isEmpty()){
    Node n = q.removeLast();
    if(n==s){
      System.out.println("\n");
      q.addFirst(s);
    }else{
      System.out.println(n);
      if(n.left()!=NULL){
        q.addFirst(n.left());
      }
      if(n.right()!=null){
        q.addFirst(n.right());
      }
    }
  }
}

void findCombination(int n,int m){
  if(n>m){
    findCombination(m,m);
  }
  int aux[n];
  memset(aux,0,n*sizeof(int));
  helper(m,0,aux);
}

void helper(int dest,int idx,int aux[],int n){
  if(dest==0){
    dump(aux,n);
  }
  if(dest<=0 || idx==n){
    return ;
  }
  helper(dest,idx+1,aux,n);
  aux[idx]=1;
  helper(dest-idx-1,idx+1,aux,n);
  aux[idx]=0;
}
void dump(int aux[],int n){
  for(int i=0;i<n;i++){
    if(aux[i]){
      cout<<i+1<<endl;
    }
  }
  cout<<endl;
}

//合并链表
Node*merge(Node*h1,Node*h2){
  if(h1==NULL){
    return h2;
  }
  if(h2==NULL){
    return h1;
  }
  Node*head;
  if(h1->value>h2->value){
    head=h2;
    h2=h2->next;
  }else{
    head=h1;
    h1=h1->next;
  }
  Node*current=head;
  while(h1!=NULL && h2!=NULL){
    if(h1==NULL||(h2!=NULL && h1->value>h2->value)){
      current->next=h2;
      h2=h2->next;
      current = current->next;
    }else{
      current->next=h1;
      h1=h1->next;
      current=current->next;
    }
  }
  current->next=NULL;
  return head;
}

int continueMax(char*str,char*ch){
  int len=0;
  char*p=NULL;
  int max=0;
  while(1){
    if(*str>='0' && *str<='9'){
      len++;
    }else{
      if(len>max){
        max=len;
        p=str-len;
      }
      len=0;
    }
    if(*str++=='\0'){
      break;
    }
  }
  for(int i=0;i<len;i++){
    *ch++=p++;
  }
  *ch='\0';
  return max;
}
