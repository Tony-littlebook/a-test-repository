#include "StaticSearchTable.h"
#include <iostream>
#include <stdlib.h>
#include <string.h>
bool SSTable::InitSSTable(const char* file){
    if((fp = fopen(file,"r" )) == NULL){
        cout <<"cannot open this file\n";
        return false;
    }
    this->elem = new ElemType[LIST_INIT_SIZE];
    for(int i = 0; i < LIST_INIT_SIZE; ++i)
        this->elem[i] = new ElemType();
    char ch;
    char* word = new char[WORD_LEN];
    strcpy(word, "");
    ch = fgetc(fp);
    int i = 1, j = 0,line = 1;
    while(ch != EOF){
        while(isalpha(ch)){
            if(ch >= 'A' && ch <= 'Z')
                ch = ch + 'a' - 'A';
            word[j++] = ch;
            ch = fgetc(fp);
        }
        if(strlen(word) != 0){
            word[j] = '\0';
            int k = Search_Seq(word);
            if(!k){
                this->elem[k].nums++;
                data* p = elem[k].data;
                while(p != NULL)
                    p = p->next;
                p = new Data(line/30 + 1, (line - 1)%30 + 1);
                  //此处统计行页数；
            }
            else{
                strncpy(this->elem[i].key, word)
                this->length++;
                this->elem[i].nums++;
                elem[i].data = new Data(line/30 + 1, (line - 1)%30 + 1);
                //此处统计行页数；
            }
            j = 0;
            i++;
            if(i >= LIST_INIT_SIZE){
                cout<<"超出最大统计数量限定！\n";
                break;
            }
        }
        while(ch != EOF && !isalpha(ch)){
            if(ch = '\n')
                line++;
            ch = fgetc(fp);
        }
    }
    delete word;
    word = NULL;
    fclose(fp);
    return true;


};

bool SSTable::TraverseSSTable(){
    for(int i = 1; i <this->length; ++i){
        int nums = this->elem[i].nums;
        cout<<"单词： "<<this->elem[i].key<<"  出现的次数为： "<<nums<<"\n";
        cout<<"分别出现在以下位置：\n"<<"\n";
        data* p = this->elem[i].data;
        for(int j = 0; j < nums && p != NULL; ++j){
            cout<<"第 "<<p->page<<"页，第 "<<p->line<<"行\n";
            p = p->next;
        }
    }
    return true;
};

int SSTable::Search_Seq(KeyType key){
    this->elem[0].key = key;
    for(int i = this->length; !EQ(this->elem[i].key, key); --i);
    return i;
}

int SSTable::Search_Bin(KeyType key){
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
