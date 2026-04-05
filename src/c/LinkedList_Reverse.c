#include<stdio.h>
#include<stdlib.h>

struct ListNode{
    int val;
    struct ListNode *next;
};

void traverse(struct ListNode *head){
    if(!head){return;}
    struct ListNode *temp = head;
    while(temp != NULL){
        printf("%d\t", temp->val);
        temp = temp->next;
    }
    printf("\n");
    return;
}

struct ListNode* reverse(struct ListNode *head){
    if(!head){return NULL;}
    struct ListNode *curr = head;
    struct ListNode *tNext = NULL, *prev = NULL;
    
    while(curr != NULL){
        tNext = curr->next;
        curr->next = prev;
        prev = curr;
        curr = tNext;
    }
    return prev;
}

 int main(){
    struct ListNode *head = (struct ListNode*)malloc(sizeof(struct ListNode));
    head->val = 0;
    head->next = NULL;
    struct ListNode *t = head;
    for(int i =1; i<10; i++){
        struct ListNode *temp = (struct ListNode*)malloc(sizeof(struct ListNode));
        temp->val = i;
        temp->next = NULL;
        t->next = temp;
        t = t->next;
    }
    traverse(head);
    head = reverse(head);
    traverse(head);
    return 0;
 }