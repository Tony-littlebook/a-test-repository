#ifndef BASE_H_INCLUDED
#define BASE_H_INCLUDED
typedef struct{
    int c;
    int r;
}PosType;
int Same(PosType pos1, PosType pos2);
PosType NextPos(PosType pos, int di);

#endif // BASE_H_INCLUDED
