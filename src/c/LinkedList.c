#include <stdio.h>
#include <stdlib.h>

struct ListNode
{
    int val;
    struct ListNode *next;
};
struct ListNode* createNode(int data){
    struct  ListNode *newNode = (struct ListNode*)malloc(sizeof(struct ListNode));
    if(!newNode){printf("Mem Alloc failed \n");}
    newNode->val = data;
    newNode->next = NULL;
    return newNode;
}

//1. Traverse List and Print
void traverse(struct ListNode *head){
    struct ListNode* curNode = head;
    while(curNode != NULL){
        printf("%d \t", curNode->val);
        curNode = curNode->next;
    }
    printf("\n");
}

//free the memory
void freeMem(struct ListNode *node){
    if(!node) {return;}
    freeMem(node->next);
    free(node);
    return;
}

int main()
{
    struct ListNode *head = createNode(0);
    int n = 10;
    struct ListNode *temp = head;
    
    for(int i = 1; i<n; i++){
        struct ListNode *t = createNode(i);
        temp->next = t;
        temp = t;
    }

    //1. traverse
    traverse(head);

    freeMem(head);
    return 0;
}