#ifndef SELEMTYPE_H_INCLUDED
#define SELEMTYPE_H_INCLUDED

#include <string>
#define EQ(a, b) ((a) == (b))
#define LT(a, b) ((a) <= (b))
#define LQ(a, b) ((a) < (b))
typedef char* KeyType;
#define WORD_LEN 32

public class Data{
   public int page;
   public int line;
   public Data* next;
   Data(int i, int j){
       page = i;
       line = j;
   }
};
public class ElemType{
    public KeyType key;
    public int nums;
    public Data* data;
    ElemType(){
        key = new char[WORD_LEN 32];
        int nums = 0;
    }
};
