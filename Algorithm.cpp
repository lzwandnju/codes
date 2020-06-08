#include <iostream>
using namespace std;
#define N 3900
#define K 39
double Arr[N];
double heap[K+1];
void heapJust(double*arr,int r, int m){
  for(int j=2*r;j<=m;j*=2){
    if(j+1<=m && arr[j]>arr[j+1]){
      j++;
    }
    if(arr[r]<arr[j]){
      break;
    }
    double temp=arr[j];
    arr[j]=arr[r];
    arr[r]=temp;
    r=j;
  }
}

void Swap(double*p, double*q){
  double temp=*p;
  *p=*q;
  *q=temp;
}
double middle5(double*Arr,int i){
  if(Arr[i]>Arr[i+1]) Swap(&Arr[i],&Arr[i+1]);
  if(Arr[i+2]>Arr[i+3]) Swap(&Arr[i+2],&Arr[i+3]);
  if(Arr[i+1]>Arr[i+3]){
    Swap(&Arr[i+1],&Arr[i+3]);
    Swap(&Arr[i],&Arr[i+2]);
  }
  if(Arr[i+2]>Arr[i+4])Swap(&Arr[i+2],&Arr[i+4]);
  if(Arr[i+1]>Arr[i+4]){
    Swap(&Arr[i+1],&Arr[i+4]);
    Swap(&Arr[i],&Arr[i+2]);
  }
  if(Arr[i+1]>Arr[i+2]) return Arr[i+1];
  else return Arr[i+2];
}

#include <stdio.h>
#define MAXLEN 123456
#define K 100
void HeadAdjust(int array[],int i ,int length){
  int child,temp;
  for(temp=array[i];2*i+1<length;i=child){
    child=2*i+1;
    if(child<length-1 && array[child+1] < array[child]){
      child++;
    }
    if(temp>array[child]){
      array[i]==array[child];
    }else{
      break;
    }
    array[child]=temp;
  }
}

void Swap(int*a, int*b){
  *a=*a^*b;
  *b=*a^*b;
  *a=*a^*b;
}

int GetMin(int array[],int length,int k){
  int min=arrya[0];
  Swap(&array[0],&array[length-1]);
  int child,temp;
  int i=0,j=k-1;
  for(temp=array[0];j>0&&2*i+1<length;--j,i=child){
    child=2*i+1;
    if(child<length-1 && array[child+1]<array[child]){
      child++;
    }
    if(temp>array[child]){
      array[i]=array[child];
    }else{
      break;
    }
    array[child]=temp;
  }
  return min;
}
void Kmin(int array[],int length,int k){
  HeapAdjust(array,i,length);
  int j=length;
  for(i=k;i>0;--i,--j){
    int min=GetMin(array,j,i);
    cout<<min<<endl;
  }
}

void quickSelect(int arr[],int k, int left,int right){
  int i,j;
  int pivot;
  if(left+CUTOFF<=right){
    pivot = median3(a,left,right);
    i=left,j=right-1;
    for(;;){
      while(a[++i]<pivot);
      while(a[--j]>pivot);
      if(i<j){
        swap(&a[i],&a[j]);
      }else{
        break;
      }
      swap(&a[i],&a[right-1]);
      if(k<i){
        quickSelect(a,k,left,i-1);
      }else if(k>i){
        quickSelect(a,k,i+1,right);
      }else{
        insertSort(a,left,right);
      }
    }
  }
}

void siftup(int a[],int i ,int n){
  while(i>0){
    int j=(i&1==0?i-1:i+1);
    int p=(i-1)>>1;
    if(j<n&&a[i]<a[j])i==j;
    if(a[i]<a[p])swap(a,i,p);
    i=p;
  }
}
void siftdown(int a[],int i,int n){
  while(2*i+1<n){
    int i=2*i+1;
    if(l+1<n && a[l+1]<a[l])l++;
    if(a[l]<a[i]) swap(a,i,l);
    i=l;
  }
}

void accumulate(int a[],int n,int acc[]){
  int i=0;
  acc[i]=a[i];
  for(int i=1;i<n;i++){
    acc[i]=acc[i-1]+a[i];
  }
  for(i=1;i<nli++){
    for(int j=i;j<n;j++){
      acc[i*n+j]=acc[j]-acc[i-1];
    }
  }
}

void knockOut(int**w,int order[],int result[],int n){
  int round=n;
  memecpy(result,order,n*sizeof(int));
  while(round>1){
    int i,j;
    for(int i=0,j=0;i<round;i+=2){
      int win=(i==round-1)? i : w[i][i+1];
      swap(result,j,win);
      j++;
    }
  }
}

#define MAX_NUM 201
int inDegree[MAX_NUM];
int longestConcat(char**str,int m,int n){
  int graph[MAX_NUM][MAX_NUM];
  int prefixHash[MAX_NUM];
  int suffixHash[MAX_NUM];
  int i,j;
  for(i=0;i<n;i++){
    calcHash(strs[i],prefixHash[i],suffixHash[i]);
    graph[i][0]=0;
  }
  memset(inDegree,0,sizeof(int)*n);
  for(i=0;i<n;i++){
    for(j=0;j<n;j++){
      if(suffixHash[i]==prefixHash[j]&&stmcmp(strs[i]+1,strs[j],m)==0){
        if(i==j)return 0;
        graph[i][0]++;
        graph[i][graph[i*n]]=j;
        inDegree[j]++;
      }
    }
  }
  return longestPath(graph,n);
}

int visit[MAX_NUM];
int parent[MAX_NUM];
#define MAX_PATH 0
int d[MAX_NUM];
int longestPath(int graph[],int n){
  memset(visit,0,sizeof(int));
  if(topSort(graph)==0)
    return -1;
  int min=0;
  for(int i=0;i<n;i++){
    if(inDegree[i]!=0)
      continue;
    memset(parent,-1,n*sizeof(int));
    memset(d,MAX_PATH,n*sizeof(int));
    d[i]=0;
    for(int j=0;j<n;j++){
      for(int k=1;k<=graph[top[j]][0];k++){
        if(d[top[j]]-1<d[graph[top[j]][k]]){
          d[graph[top[j]][k]]=d[top[j]]-1;
          parent[graph[top[j]][k]]=top[j];
          if(d[graph[top[j]][k]]<min){
            min=d[graph[top[j]][k]];
          }
        }
      }
    }
  }
  return -min;
}

int top[MAX_NUM];
int finished[MAX_NUM];
int cnt=0;
int topSort(int graph[]){
  memset(visit,n,n*sizeof(int));
  memset(finished,0,n*sizeof(int));
  for(int i=0;i<n;i++){
    if(topdfs(graph,i)==0)
      return 0;
  }
  return 1;
}

int topdfs(int graph[],int s){
  if(visited[s]!=0)
    return 1;
  for(int i=1;i<=graph[s][0];i++){
    if(visited[graph[s][i]]!=0 && finished[graph[s][i]]==0){
      return 0;
    }
    if(visited[graph[s][i]]==0){
      visited[graph[s][i]]=1;
      dfs(graph,graph[s][i]);
    }
  }
  finished[s]=1;
  top[cnt++]=1;
  return 1;
}

int cnt=0;
int visited[MAX_NUM];
int lowest[MAX_NUM];
void getCutPoints(int *g[], int cuts[], int n){
  memset(cuts,0,sizeof(int)*n);
  memset(visited,0,sizeof(int)*n);
  memset(lowest,0,sizeof(int)*n);
  for(int i=0;i<n;i++){
    if(visited[i]==0){
      visited[i]=++cnt;
      dfs(g,cuts,n,i,j);
    }
  }
}

int dfs(int*g[],int cuts[],int n,int s,int root){
  int out=0;
  int low=visit[s];
  for(int i=1;i<=g[s][0];i++){
    if(visited[g[s][i]]==0){
    out++;
    visited[g[s][i]]=++cnt;
    int clow=dfs(g,cuts,n,g[s][i],root);
    if(clow<low)
      low=clow;
    }else{
      if(low>visit[g[s][i]]){
        low=visit[g[s][i]];
      }
    }
  }
  lowest[s]=low;
  if(s==root && out>1){
    cuts[s]=1;
  }
  return low;
}

int shortestFullColor(int a[],int n,int m){
  int c[m],ctr=m;
  int h=0,t=0;
  int min=n;
  while(1){
    while(ctr>0 && h<n){
      if(c[a[h]]==0){
        ctr--;
      }
      c[a[h]]++;
      h++;
    }
    if(h>=n)
      return min;
    while(1){
      c[a[t]]--;
      if(c[a[t]]==0){
        break;
      }
      t++;
    }
    if(min>h-t){
      min=h-t;
    }
    t++;
    ctr++;
  }
}

Node* head(Node*h1,Node*h2){
  if(h1==NULL) return h2;
  if(h2==NULL) return h1;
  Node*head;
  if(h1->data < h2->data){
    head=h1;
    h1=h1->next;
  }else{
    head=h2;
    h2=h2->next;
  }
  Node*p=head;
  while(h1!=NULL || h2!=NULL){
    Node*candi;
    if(h1!=NULL && h2!=NULL && h1->data<h2->data || h2==NULL){
      candi=h1;
      h1=h1->next;
    }else{
      candi=h2;
      h2=h2->next;
    }
  if(candi->data==p->data){
    delete(candi);
  }else{
    p->next=candi;
    p=candi;
  }
 }
 return head;
}

void preorderRecursive(TreeNode*node){
  if(node==nulll)
    return;
  visited(node);
  preorderRecursive(node->left);
  preorderRecursive(node->right);
}

void preorderNonrecursive(TreeNode*node){
  stack<TreeNode*>s;
  s.push(node);
  while(!s.empty()){
    TreeNode*n=s.pop();
    visit(n);
    if(n->right!=NULL){
      s.push(n->right);
    }
    if(n->left!=NULL){
      s.push(n->left);
    }
  }
}

void inorderNonrecursive(TreeNode*node){
  stack<TreeNode*>s;
  TreeNode*current=node;
  while (!s.empty() || current!=NULL) {
    if(current!=NULL){
      s.push(current);
      current=current->left;
    }else{
      current=s.top();
      visit(current);
      current=current->right;
    }
  }
}

void postorderNonrecursice(TreeNode*node){
  stack<TreeNode*>traverse,visit;
  traverse.push(node);
  while(!traverse.empty()){
    TreeNode*p=traverse.pop();
    visit.push(p);
    if(p->left!=NULL) {
      traverse.push(p->left);
    }
    if(p->right!=NULL){
      traverse.push(p->right);
    }
  }
  while(!visit.empty()){
    visitNode(visit.pop());
  }
}

void preorder(TreeNode*node){
  if(node==null){
    return;
  }
  cout<<node->value;
  preorder(node->left);
  preorder(node->right);
}

void preOrder(TreeNode*node){
  if(node!=NULL){
    cout<<node->value<<endl;
    preOrder(node->left);
    preOrder(node->right);
  }
}

void inOrder(TreeNode*node){
  if(node!=NULL){
    inOrder(node->left);
    cout<<node->value<<endl;;
    inOrder(node->right);
  }
}

void postOrder(TreeNode*node){
  if(node!=NULL){
    postOrder(node->left);
    postOrder(node->right);
    cout<<node->value<<endl;
  }
}

void preOrder(TreeNode*node){
  stack<TreeNode*>s;
  s.push(node);
  while(!s.empty()){
    TreeNode*n=s.pop();
    cout<<n->value<<end;
    if(n->left!=NULL){
      s.push(n->left);
    }
    if(n->right!=NULL){
      s.push(n->right);
    }
  }
}

void inOrder(TreeNode*node){
  stack<TreeNode*>s;
  TreeNode*current=node;
  while(!s.empty()||current!=NULL){
    if(current!=NULL){
      s.push(current);
      current=current->left;
    }else{
      current=s.pop();
      cout<<current->value<<endl;
      current=current->right;
    }
  }
}

void postOrder(TreeNode*node){
  stack<TreeNode*>s,vist;
  s.push(node);
  while(!s.empty()){
    TreeNode*p=s.pop();
    visit.push(p);
    if(p->left!=NULL){
      s.push(p->left);
    }
    if(p->right!=NULL){
      s.push(p->right);
    }
  }
  while(!visi.empty()){
    cout<<(visit.pop())->value<<end;
  }
}

int maxShares(inta[],int n){
  int sum=0;
  int i,m;
  for(i=0.;i<n;i++){
    sum+=a[i];
  }
  for(m=n;m>=2;m--){
    if(sum % 2!=0){
      continue;
    }
    int aux[n];
    for(i=0;i<n;i++){
      aux[i]=0;
    }
    if(testShares(a,n,m,sum,sum/m,aux,sum/m,1)){
      return m;
    }
  }
  return 1;
}

itn testShares(int a[],int n,int m, int sum, int groupsum, int[] aux,int goal, int groupId){
  if(goal==0){
    groupId++;
    if(groupId==m+1){
      return 1;
    }
    for(int i=0;i<n;i++){
      if(aux[i]!=0){
        continue;
      }
      aux[i]=groupId;
      if(testShares(a,n,m,sum,groupsum,aux,goal-a[i],groupId)){
        return 1;
      }
      aux[i]=0;
    }
  }
}

int[] findDecreasing(int[]a){
  int[]ds=new int[a.length];
  Arrays.fill(ds,0);
  int dsl=0;
  int lastdsl=0;
  for(int i=0;i<a.length;i++){
    int s=0,t=dsl-1;
    while(s<=t){
      int m=s+(t-s)/2;
      if(ds[m]<a[i]){
        t=m-1;
      }else{
        s=m+1;
      }
    }
    ds[s]=a[i];
    if(s>dsl){
      dsl=s;
      latestdsl=i;
    }
  }
  for(int i=lastdsl-1,j=dsl-1;i>=0;&&j>=0;i--){
    if(a[i]==ds[j]){
      j--;
    }else if(a[i]<ds[j]){
      ds[j--]=a[i];
    }
  }
  return Arrays.copyOfRange(ds,0,dsl+1);
}

int shiftedBinarySearch(int a[],int k){
  return helper(a,k,0,n-1);
}
int helper(int a[],int k,int s,int t){
  if(s>t) return -1;
  int m=s+(t-s)/2;
  if(a[m]==k)return m;
  else if(a[s]>=k && k>a[m])return helper(a,k,s,m-1);
  else return helper(a,k,m+1,t);
}

int findConsecutiveSequence(int n){
  count =0 ;
  for(int i=0;i<=n/2;i++){
    int sqroot=calcSqrt(4*i*i+8*n-4*i+1);
    if(sqroot==-1)continue;
    if((sqroot&1)==1){
      System.out.println(i+'-'+((sqroot-1)/2));
      count++;
    }
  }
  return count;
}

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

void partition(int a[],int n){
  int i=j=0;
  while(i<n && (a[i]&1)==0) i++;
  if(i==n) return ;
  swap(a,i++,j++);
  while(i<n){
    if((a[i]&1)==1){
      swap(a,i,j++);
    }
    i++;
  }
}

int lcs(char*p1,char*p2){
  int l1=strlen(p1)+1;
  int l2=strlen(p2)+1;
  int a[l1*l2];
  for(int i=0;i<l1;i++)a[i*l2]=0;
  for(int i=0;i<l2;i++)a[i]=0;
  for(int i=1;i<l1;i++){
    for(int j=1;j<l2;j++){
      int max=MAX(a[(i-1)*l2+l1],a[i*l2+l1-1]);
      if(p1[i-1]==p2[j-1]){
        max=(max>1+a[(i-1)*l2+j-1])?max:1+a[(i-1)*l2+j-1];
      }
    }
  }
  return a[l1*l2-1];
}

public int lcs(String str1, String str2){
  int len1 = str1.length;
  int len2 = str2.length;
  int c[][] = new int[len1+1][len2+1];
  for(int i=0;i<=len1;i++){
    for(int j=0;j<=len2;j++){
      if(i==0||j==0){
        c[i][j]=0;
      }else if(str1.charAt(i)==str2.charAt(j)){
        c[i][j] = c[i-1][j-1]+1;
      }else{
        c[i][j] = max(c[i-1][j],c[i][j-1]);
      }
    }
  }
  return c[len1][len2];
}


public int lcs(String str1, String str2){
  int len1 = str1.length;
  int len2 = str2.length;
  int result = 0 ;
  int c[][] = new int[len1+1][len2+1];
  for(int i=0;i<=len1;i++){
    for(int j=0;j<=len2;j++){
      if(i==0||j==0){
        c[i][j]=0;
      }else if(str1.charAt(i) == str2.charAt(j)){
        c[i][j] = max(c[i-1][j-1]+1,result);
        result = c[i][j];
      }else{
        c[i][j] = 0;
      }
    }
  }
  return result;
}

void appendTail(const T &node){
  m_stack1.push(node);
}

T getHead(){
  if(!m_stack2.isEmpty()){
    return m_stack2.pop();
  }
  if(m_stack1.isEmpty()){
    error("Delete from empty queue");
  }
  while(!m_stack1.isEmpty()){
    m_stack2.push(m_stack1.pop());
  }
  return m_stack2.pop();
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

int calc(int*arr,int n){
  int result=0;
  int a=0,b=0,index=0;
  for(int i=0;i<n;i++){
    result^=arr[i];
  }
  while(result){
    if(result & 0x1 ==0){
      index++;
      result=result>>1;
    }else{
      break;
    }
  }
  int cmp = 1<<index;
  for(int i=0;i<n;i++){
    if(arr[i] & cmp){
      a=a^arr[i];
    }else{
      b=b^arr[i];
    }
  }
  cout<<a<<" "<<b<<endl;
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

int getMajor(int a[],int n){
  int x,cnt=0;
  for(int i=0;i<n;i++){
    if(cnt==0){
      x=a[i];
      cnt++;
    }else if(a[i]==x){
      cnt++;
    }else{
      cnt--;
    }
  }
  return x;
}

TreeNode* getLCA(TreeNode*root,TreeNode*x,TreeNode*y){
  if(root==NULL){
    return NULL;
  }
  if(x==root||y==root){
    return root;
  }
  TreeNode*left = getLCA(root->left,x,y);
  TreeNode*right = getLCA(root->right,x,y);
  if(left==NULL){
    return right;
  }else if(right==NULL){
    return left;
  }else{
    return root;
  }
}

ComplexNode*clone(ComplexNode*pHead){
  if(pHead==NULL){
    return NULL;
  }
  preClone(pHead);
  inClone(pHead);
  return postClone(pHead);
}
void preClone(ComplexNode*pHead){
  ComplexNode*p=new ComplexNode();
  p->next = pHead->sibling;
  pHead->sibling = p;
  if(pHead->next!=NULL){
    preClone(pHead->next);
  }
}
void inClone(ComplexNode*pHead){
  ComplexNode*psib = pnew->next;
  if(psib==NULL){
    pnew->sibling = NULL;
  }else{
    pnew->sibling = psib->sibling;
  }
  if(pHead->next!=NULL){
    inClone(pHead->next);
  }
}
ComplexNode*postClone(ComplexNode*pHead){
  ComplexNode*pnew=pHead->psibling;
  ComplexNode*psib = pnew->next;
  if(pHead->next!=NULL){
    pnew->next = pHead->next->sibling;
    pHead->sibling=psib;
    postClone(pHead->next);
  }else{
    pnew->next=NULL;
    pHead->sibling=NULL;
  }
  return pnew;
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

void * memmove(void*dest,const void*src,size_t n){
  if(dest==NULL || src==NULL){
    error("NULL points");
  }
  byte *psrc=(byte*)src;
  byte*pdest = (byte*)dest;
  int step=1;
  if(dest<src+n){
    psrc=(byte*)(src+n-1);
    pdest=(byte*)(dest+n-1);
    step=-1;
  }
  for(int i=0;i<n;i++){
    pdest=psrc;
    pdest+=step;
    psrc +=step;
  }
}

int countSubstr(constchar*str,const char*sub){
  int count=0;
  char*p=str;
  int n=strlen(sub);
  while(*p!='\0'){
    if(stmcmp(p,sub,n)==0){
      count++;
    }
    p++;
  }
  return count;
}

Node*array2Tree(int[]array,int n){
  return helper(array,0,n-1);
}

Node*helper(int[]array,int start,int end){
  if(start>end){
    return NULL;
  }
  int m=start+(end-start)/2;
  Node*root=new Node(array[m]);
  root->left = helper(array,start,m-1);
  root->right =helper(array,m+1,end);
  return root;
}

final static long mask=(1<<31)-1;
ArrayList<Integer>multiply(ArrayList<Integer>a, ArrayList<Integer>b){
  ArrayList<Integer>result=new ArrayList<Integer>(a.size()*b.size()+1);
  for(int i=0;i<a.size();i++){
      multiply(b,a.get(i),i,result);
  }
  return result;
}

void multiply(ArrayList<Integer>x,int a,int base,ArrayList<Integer>result){
  if(a==0){
    return;
  }
  long overflow=0;
  int i;
  for(int i=0;i<x.size();i++){
    long tmp = x.get(i)*a+result.get(base+i)+overflow;
    result.set(base+i,(int)(mask&tmp));
    overflow=(tmp>>31);
  }
  while(overflow!=0){
    long tmp=result.get(base+i)+overflow;
    result.set(base+i,(int)(mask&tmp));
    overflow=(tmp>>31)
  }
}

int partition(char []a){
  int count=0;
  int i=a.length-1;
  int j=a.length-1;
  wile(i>=0){
    if(a[i]!='*'){
      swap(a,i--,j--);
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

char* partition(const char*str){
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

public TreeNode lowestAncestor(TreeNode head,TreeNode n1,TreeNode n2){
  if(root==null){
    return root;
  }
  TreeNode left = lowestAncestor(head->left,n1,n2);
  TreeNdoe right = lowestAncestor(head->right,n1,n2);
  if(left!=null && right!=null){
    return head;
  }
  return left!=null ? left:right;
}

public TreeNode lowestAncestor(TreeNode root, TreeNode n1,TreeNode n2){
  if(root==null){
    return root;
  }
  TreeNode left = lowestAncestor(root.left,n1,n2);
  TreeNode right = lowestAncestor(root.right,n1,n2);
  if(left!=null && right != null){
    return root;
  }
  return left!=null ? left:right;
}

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

Node* merge(Node*p1,Node*p2){
  Node*p=NULL;
  Node*ph=NULL;
  while(p1!=NULL && p2!=NULL){
    if(p1->value<p2->value){
      if(ph==NULL){
        ph=p=p1;
      }else{
        p->next=p1;
        p=p->next;
        p1=p1->next;
      }
    }else{
      if(ph==NULL){
        ph=p=head;
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

int getLen(Node*head){
  Node*p=head;
  int len=0;
  while(p!=NULL){
    len++;
    p=p->next;
  }
  return len;
}

Node* arrar2Tree(int arr[],int n){
  return helper(arr,0,n-1);
}

Node*helper(int arr[],int start, int end){
  if(start>end){
    return NULL;
  }
  int mid = start+(end-start)/2;
  Node*root=new Node(arr[mid]);
  root->left = helper(arr,start,mid-1);
  root->right = helper(arr,mid+1,end);
  return root;
}

Node*array2Tree(int arr[],int n){
  return helper(arr,0,n-1);
}

Node* helper(int arr[],int low, int high){
  if(low>high){
    return NULL;
  }
  int mid=low+(high-low)/2;
  Node*root=new Node(arr[mid]);
  root->left=helper(arr,low,mid-1);
  root->right=helper(arr,mid+1,high);
  return root;
}

int partition(int []arr){
  int count=0;
  int i=arr.length-1;
  int j=arr.length-1;
  while(i>=0){
    if(arr[i]!='*'){
      swap(arr,i++,j++);
    }else{
      i--;
      cnt++;
    }
  }
  return count;
}

int partition(int []arr){
  int i=arr.length-1;
  int j=arr.length-1;
  int count=0;
  while(i>=0){
    if(arr[i]!='*'){
      swap(arr,i--,j--);
    }else{
      count++;
      i--;
    }
  }
  return count;
}

int atoi(const char*a){
  if(*a=='+'){
    return atoi(a+1);
  }else if(*a=='-'){
    retun -atoi(a+1);
  }else{
    char*p=a;
    int c=0;
    while(*p>'0' && *p<='9'){
      c = c*10+(*p-'0');
      p++;
    }
    return c;
  }
}

int atoi(const char*a){
  if(*a=='+'){
    return atoi(a+1);
  }else if(*a=='-'){
    return -atoi(a+1);
  }else{
    char*p=a;
    int result=0;
    while(*p>='0'&&*p<='9'){
      result=result*10+(*p-'0');
      p++;
    }
    return result;
  }
}

int partition(const char*str){
  char*i=str;
  char*j=str;
  while(*i!='\0'){
    if(*i>'9'||*i<'0'){
      *j++=*i++;
    }else{
      i++;
    }
    *j='\0';
    return str;
}

boolean isAscending(int []a){
  return isAscending(a,0);
}

boolean isAscending(int []a,int start){
  return start == a.length-1 || isAscending(a,start+1);
}

char*strcpy(char *dest,const char*src){
  if(src==NULL){
    return NULL;
  }
  char*i=src;
  char*j=dest;
  while(*i!='\0'){
    *j++=*i++;
  }
  *j='\0';
  return dest;
}

Node lowestAncestor(Node root, Node n1,Node n2){
  if(root==null){
    return root;
  }
  Node left=lowestAncestor(root.left,n1,n2);
  Node right=lowestAncestor(root.right,n1,n2);
  if(left!=null && right1=null){
    return root;
  }
  return left!=null left:right;
}

public static boolean isValidDate(String str){
  boolean convertSuccess=true;
  SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm");
  try{
    format.setLenient(false);
    format.parse(str);
  }catch (ParseException e){
    convertSuccess =false;
  }
  return convertSuccess;
}
