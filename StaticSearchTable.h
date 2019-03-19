#ifndef STATICSEARCHTABLE_H_INCLUDED
#define STATICSEARCHTABLE_H_INCLUDED

#include "SelemType.h"
#define LIST_INIT_SIZE 5500
class SSTable{
    ElemType* elem;
    int length;
public:
    STable(){
        elem = NULL;
        length = 0;
    };
    bool InitSSTable(const char* file);
    bool TraverseSSTable();
    int Search_Seq(KeyType key);
    int Search_Bin(KeyType key);
    void WordInfor(int i);
    bool DestroySSTable();
    ~SSTable(){
        if(this->elem){
            cout<<"调用sstable的析构函数\n";
            delete [] elem;
            elem = NULL;
        }
    };
};
//int EQ(char* s1, char* s2);

#endif /
