#include <stdio.h>
#include <stdlib.h>
#include <malloc.h>
#include "stkpas.h"
#include "myMaze.h"
#define TRUE 1
#define FALSE 0
void Initialization();
void ReadCommand(char* cmd);
void Interpret(char cmd, MazeType* maze, int* isCreate);
int main()
{
    Initialization();
    char cmd;
    int isCreate = FALSE;
    MazeType maze;
    do{
        ReadCommand(&cmd);
        Interpret(cmd, &maze, &isCreate);
    } while(cmd != 'q');
    printf("\n--------------------Welcome again!--------------------\n");
    getchar();
    getchar();
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

/*Stack test
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

/*MazePath test
int a[] = {
               0,0,1,0,0,0,1,0,
               0,0,1,0,0,0,1,0,
               0,0,0,0,1,1,0,1,
               0,1,1,1,0,0,1,0,
               0,0,0,1,0,0,0,0,
               0,1,0,0,0,1,0,1,
               0,1,1,1,1,0,0,1,
               1,1,0,0,0,1,0,1,
               1,1,0,0,0,0,0,0
               };
    MazeType maze;
    InitMaze(&maze, a, 9, 8);
    PosType startPos = {1, 1};
    PosType endPos = {9, 8};
    int found = MazePath(&maze, startPos, endPos);
    printf("%d\n",found);
    PrintMaze(maze);
    printf("Hello world!\n");
*/

void StackTraverse(Stack S){

}
void InitMaze(MazeType* maze, int* a, int row,int col){
    maze->m = row + 2;
    maze->n = col + 2;
    maze->arr = (char*)malloc((row+2)*(col+2)*sizeof(char));
    int i;
    for(i = 0; i < col+2; ++i){
        maze->arr[i] = maze->arr[(row + 1)*(col + 2) + i] = '1',
        maze->arr[i*(col+2)] = maze->arr[i*(col+2) + col + 1] = '1';
    }
    int j,k;
    /*test
    for(j = 0; j < row; ++j){
        for(k = 0; k < col; ++k){
             maze->arr[(j + 1)*(col + 2) + k + 1] = 1;
             printf("%d ", (j + 1)*(col + 2) + k + 1);
        }
        printf("\n");
    }
    */

    for(j = 0; j < row; ++j)
        for(k = 0; k < col; ++k){
            if(a[j*(col) + k] == 1)
                maze->arr[(j + 1)*(col + 2) + k + 1] = '1';
            else
                maze->arr[(j + 1)*(col + 2) + k + 1] = '0';
        }
}
int MazePath(MazeType* maze, PosType startPos, PosType endPos){
    Stack* S = (Stack*)malloc(sizeof(Stack));
    InitStack(S);
    PosType curpos = startPos;
    int curstep = 1;
    int found = FALSE;
    do{
        if(Pass(*maze, curpos)== TRUE){
            FootPrint(maze, curpos);
            ElemType e = {curstep, curpos, 1};
            Push(S, e);
            //printf("(%d, %d)\n",e.seat.c, e.seat.r);
            if(Same(curpos, endPos)== TRUE) found = TRUE;
            else{
                curpos = NextPos(curpos, 1);
                curstep++;
            }
        }
        else{
            if(!StackEmpty(*S)){
                ElemType e;
                Pop(S, &e);
                while(e.di == 4 && !StackEmpty(*S)){
                    MarkPrint(maze, e.seat);
                    Pop(S, &e);
                    curstep--;
                }
                if(e.di < 4){
                   e.di++;
                   Push(S, e);
                   curpos = NextPos(e.seat, e.di);
                }
            }
        }
    }while(StackEmpty(*S) == FALSE && found == FALSE);
    DestoryStack(S);
    return found;

}
void PrintMaze(MazeType maze){
    int i,j;
    for(i = 1; i < maze.m - 1; ++i){
        for(j = 1; j < maze.n -1; ++j){
            printf("%c ", maze.arr[i*maze.n + j]);
        }
        printf("\n");
    }
}

int Same(PosType pos1, PosType pos2){
    if(pos1.c == pos2.c && pos1.r == pos2.r)
        return TRUE;
    else
        return FALSE;
}

PosType NextPos(PosType pos, int di){
    switch(di){
        case 1:pos.r++;break;
        case 2:pos.c--;break;
        case 3:pos.r--;break;
        case 4:pos.c++;break;
        default:;
    }
    return pos;
}

int Pass(MazeType maze, PosType curpos){
    if(maze.arr[curpos.c*maze.n + curpos.r] == '0')
        return TRUE;
    else
        return FALSE;
}

void FootPrint(MazeType* maze, PosType curpos){
    maze->arr[curpos.c*maze->n + curpos.r] = '*';
}

void MarkPrint(MazeType* maze, PosType curpos){
    maze->arr[curpos.c*maze->n + curpos.r] = '@';
}

void Initialization(){
    system("cls");
    printf("\n\n");
    printf("                     Maze Program\n");
    printf("***********************************************************\n");
    printf("*CreateMaze-c       MazePath-m     PrintMaze-p       Quit-q*\n");
    printf("***********************************************************\n");
    printf("*Enter a operation code : c, m, p OR q                    *\n");
}

void ReadCommand(char* cmd){
    do{
        printf("please input correct operation t-");
        scanf("%c", cmd);
        printf("\n");
        getchar();
    }while(!(*cmd == 'c' || *cmd == 'm' || *cmd == 'p' || *cmd == 'q'));
}

void Interpret(char cmd, MazeType* maze, int* isCreate){
    char fileName[10];
    FILE* fp = NULL;
    int* a;
    int rnum, cnum;
    switch(cmd){
        case 'c':{
            do{
                printf("please input file name:");
                scanf("%s", fileName);
            }while((fp=fopen(fileName,"r"))==NULL);
            fscanf(fp, "%d,%d", &rnum, &cnum);
            a = malloc(rnum*cnum*sizeof(int));
            int i;
            int* temp = a;
            for(i = 0; i < rnum*cnum; ++i){
                fscanf(fp, "%d,", temp);
                temp++;
            }
            fclose(fp);
            InitMaze(maze, a, rnum, cnum);
            printf("\nmaze create successful!\n");
            *isCreate = TRUE;
            getchar();
            break;
        }
        case 'm':{
            if(*isCreate == TRUE){
                int c1,r1,c2,r2;
                c1=r1=c2=r2=1;
                printf("please input entrance coordinates:");
                scanf("%d,%d", &c1, &r1);
                printf("\nplease input exit coordinates:");
                scanf("%d,%d", &c2, &r2);
                PosType startPos = {c1, r1};
                PosType endPos = {c2, r2};
                if(MazePath(maze, startPos, endPos) == TRUE)
                    printf("\nPath exists!You can print maze.\n");
                else
                    printf("Path doesn't exists!\n");
            }
            else
                printf("You must create maze firstly!\n");
            getchar();
            break;
        }
        case 'p':{
            if(*isCreate == TRUE){
                PrintMaze(*maze);
            }
            else
                printf("You must create maze firstly!\n");
            getchar();
            break;
        }
        default:;
    }
}
