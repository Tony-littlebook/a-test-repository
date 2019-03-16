#ifndef STATICSEARCHTABLE_H_INCLUDED
#define STATICSEARCHTABLE_H_INCLUDED

#include "SelemType.h"
#define LIST_INIT_SIZE 5500
class SSTable{
    ElemType* elem;
    int length;
public:
        SSTable(){
        elem = NULL;
        length = 0;
    };
    bool InitSSTable(const char* file);
    bool TraverseSSTable();
    int Search_Seq(KeyType key);
    int Search_Bin(KeyType key);
    ~SSTable(){
        if(this->elem){
            delete elem;
            elem = NULL;
        }
    };
};

#endif // STATICSEARCHTABLE_H_INCLUDED
