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
