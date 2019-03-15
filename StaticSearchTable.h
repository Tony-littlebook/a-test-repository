#ifndef STATICSEARCHTABLE_H_INCLUDED
#define STATICSEARCHTABLE_H_INCLUDED

#include "SelemType.h"

#define LIST_INIT_SIZE 5500
public class SSTable{
    ElemType* elem;
    public int length;
    SSTable(){};
    public bool InitSSTable(const char* file); 
    public int Search_Seq(KeyType key);
    public int Search_Bin(KeyType key);
    ~SSTable();
};

#endif // STATICSEARCHTABLE_H_INCLUDE



#endif // SELEMTYPE_H_INCLUDED
