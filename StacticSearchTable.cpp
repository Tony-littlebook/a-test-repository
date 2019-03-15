#include "StaticSearchTable.h"
#include <iostream>
#include <stdlib.h>
public bool InitSSTable(const char* file){
    if((fp = fopen(file,"r" )) == NULL){
        cout <<"cannot open this file\n";
        return false;
    }
    this->elem = new ElemType[LIST_INIT_SIZE];
    for(int i = 0; i < LIST_INIT_SIZE; ++i)
        this->elem[i] = new ElemType();
    this->length = 0;
    char ch;
    char* word = new char[WORD_LEN];
    ch = fgetc(fp);
    int i = 1, j = 0;
    while(ch != EOF){
        while(isalpha(ch)){
            if(ch >= 'A' && ch <= 'Z')
            word[j++] = ch + 'a' - 'A';
            ch = fgetc(fp);
        }
        if(strlen(word) != 0){
            word[j] = '\0';
            int k = Search_Seq(word);
            if(!k){
                this->elem[k].nums++;      
                  
                  //此处统计行页数；
            }
            else{
                strncpy(this->elem[i].key, word)
                this->elem[i].nums++;
                this->length++;
            }
            j = 0;
            i++;
            if(i >= LIST_INIT_SIZE){
                cout<<"超出最大统计数量限定！\n";
                break;
            }
        }
        while(ch != EOF && !isalpha(ch))
            ch = fgetc(fp);
    }
    fclose(fp);
    return true;
    
    
};

public int SSTable::Search_Seq(KeyType key){
    this->elem[0].key = key;
    for(int i = this->length; !EQ(this->elem[i].key, key); --i);
    return i;
}

public int SSTable::Search_Bin(KeyType key){
    int high = this->length;
    int low = 1;
    int mid = (high + low) / 2;
    while(high >= low){
        if(EQ(this->elem[mid].key, key))
            return mid;
        else if(LQ(this->elem[mid].key, key))
            low = mid + 1;
        else
            high = mid;
    }
    return 0;
}
