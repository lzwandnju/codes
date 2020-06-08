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
int is_backsort(int*a,itn start, int end){
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

int helper(Node*root,intn &depth){
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
  int *a=a+n-1;
  int sum=*f+*e;
  while(sum!=dest && f<e){
    if(sum<dest){
      sum=*(++f);
    }else{
      sum=*(--e);
    }
  }
  if(sum==dest){
    cout<<*f<<" "<<*a<<endl;
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















































































































































































































































































































































line
