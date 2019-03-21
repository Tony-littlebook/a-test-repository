
#ifndef SELEMTYPE_H_INCLUDED
#define SELEMTYPE_H_INCLUDED

#include <cstring>
#include <iostream>
#define EQ(a, b) (!strcmp((a),(b)))
#define LT(a, b) (strcmp((a),(b)) < 0)
#define LQ(a, b) (strcmp((a),(b)) <= 0)
#define WORD_LEN 32
using namespace std;
typedef char* KeyType;

class Data{
public:
   int page;
   int line;
   Data* next;
   Data(int i, int j){
       page = i;
       line = j;
       next = NULL;
   }
   ~Data(){
       if(next){
        //cout<<"调用data的析构函数\n";
        delete next;
        next = NULL;
       }
   }
};
class ElemType{
public:
    KeyType key;
    int nums;
    Data* data;
    ElemType(){
        key = new char[WORD_LEN];
        strcpy(key, "");
        nums = 0;
        data = NULL;
    }
    ~ElemType(){
        if(key){
            cout<<"调用elemtype的析构函数\n";
            delete key;
            key = NULL;
        }
        if(data){
            delete data;
            data = NULL;
        }
    }

};



#endif // SELEMTYPE_H_INCLUDED
