#ifndef STKPAS_H_INCLUDED
#define STKPAS_H_INCLUDED
#include "base.h"
typedef struct{
    int step;
    PosType seat;
    int di;
}ElemType;
typedef struct NodeType{
    ElemType data;
    struct NodeType* next;
}NodeType,*LinkType;
typedef struct{
    LinkType top;
    int length;
}Stack;
void InitStack(Stack* S);
void DestoryStack(Stack* S);
void ClearStack(Stack* S);
int StackLength(Stack S);
int StackEmpty(Stack S);
int GetTop(Stack S, ElemType* e);
int Push(Stack* S, ElemType e);
int Pop(Stack* S, ElemType* e);
void StackTraverse(Stack S);

#endif // STKPAS_H_INCLUDED
