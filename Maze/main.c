#include <stdio.h>
#include <stdlib.h>
#include <malloc.h>
#include "stkpas.h"
#include "myMaze.h"
#define TRUE 1
#define FALSE 0
int main()
{
    printf("Hello world!\n");
    return 0;
}

void InitStack(Stack* S){
    S->top = NULL;
    S->length = 0;
}
void DestoryStack(Stack* S){
    if(S->top != NULL){
        LinkType p = S->top;
        LinkType q;
        while(p != NULL){
            q = p->next;
            free(p);
            p = q;
        }
    }
    S->length = 0;
}
void ClearStack(Stack* S){
    S->length = 0;
}
int StackLength(Stack S){
    return S.length;
}
int StackEmpty(Stack S){
    if(S.length == 0)
        return TRUE;
    else
        return FALSE;
}
int GetTop(Stack S, ElemType* e){
    if(S.length == 0)
        return FALSE;
    else{
        *e = S.top->data;
        return TRUE;
    }
}
int Push(Stack* S, ElemType e){
    LinkType temp = (LinkType)malloc(sizeof(NodeType));
    temp->data = e;
    temp->next = S->top;
    S->top = temp;
    S->length++;
    return TRUE;
}
int Pop(Stack* S, ElemType* e){
    if(!StackEmpty(*S)){
        *e = S->top->data;
        LinkType temp = S->top;
        S->top = S->top->next;
        free(temp);
        S->length--;
        return TRUE;
    }
    else
        return FALSE;
}

/*≤‚ ‘
PosType pos = {3, 4};
    ElemType e = {1, pos, 3};
    Stack* S = (Stack*)malloc(sizeof(Stack));
    InitStack(S);
    int i;
    for(i = 0; i < 10; ++i)
        Push(S, e);
    for(i = 0; i < 10; ++i){
        ElemType s,k;
        Pop(S, &s);
        GetTop(*S, &k);
        printf("%d\n",S->length);
        printf("%d\n",s.step);
        printf("%d\n",k.step);
    }
    DestoryStack(S);
*/

void StackTraverse(Stack S){

}
void InitMaze(MazeType* maze, int* a, int row,int col){
    maze->arr = (char*)malloc((row+1)*(col+1)*sizeof(char));
    int i;
    for(i = 0; i < col+1; i++){
        arr[i] = arr[row*(col+1) + i] = '0',
        arr[i*(col+1)] = arr[i*(col+1) + col] = '0';
    }
    int j,k;
    for(j = 0; j < row; j++)
        for(k = 0; k < col; k++){
            arr[(j+1)*(row) + k + 1] = a[j*(row) + k];
        }

}
int MazePath(MazeType* maze, PosType startPos, PosType endPos){

}
void PrintMaze(MazeType maze){

}
