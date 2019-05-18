#ifndef MYMAZE_H_INCLUDED
#define MYMAZE_H_INCLUDED
#include "base.h"
typedef struct{
    int m;
    int n;
    char* arr;
}MazeType;

void InitMaze(MazeType* maze, int* a, int row,int col);
int MazePath(MazeType* maze, PosType startPos, PosType endPos);
void PrintMaze(MazeType maze);
int Pass(MazeType maze, PosType curpos);
void FootPrint(MazeType* maze, PosType curpos);
void MarkPrint(MazeType* maze, PosType curpos);
#endif // MYMAZE_H_INCLUDED
