#ifndef SELEMTYPE_H_INCLUDED
#define SELEMTYPE_H_INCLUDED

#include <cstring>
#define EQ(a, b) (strcmp((a),(b)) == 0)
#define LT(a, b) (strcmp((a),(b)) < 0)
#define LQ(a, b) (strcmp((a),(b)) <= 0)
#define WORD_LEN 36
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
};
class ElemType{
public:
    KeyType key;
    int nums;
    Data* data;
    ElemType(){
        key = new char[WORD_LEN];
        strcpy(key, "");
        int nums = 0;
        data = NULL;
    }

};



#endif // SELEMTYPE_H_INCLUDED

