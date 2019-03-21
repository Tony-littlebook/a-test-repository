#include "StaticSearchTable.h"
//#include <iostream>
#include <cstdio>
//#include <cstring>
//using namespace std;
bool SSTable::InitSSTable(const char* file){
    FILE* fp;
    if((fp = fopen(file,"r" )) == NULL){
        cout <<"cannot open this file!\n";
        return false;
    }
    this->elem = new ElemType[LIST_INIT_SIZE];
    for(int i = 0; i < LIST_INIT_SIZE; ++i){
        this->elem[i] = ElemType();
    }
    char ch;
    char* word = new char[WORD_LEN];
    ch = fgetc(fp);
    int i = 1, j = 0,line = 1;
    while(ch != EOF){
        strcpy(word, "");
        //char word[WORD_LEN] = "";
        while(isalpha(ch)){
            if(ch >= 'A' && ch <= 'Z')
                ch = ch + 'a' - 'A';
            word[j++] = ch;
            ch = fgetc(fp);
        }
        if(strlen(word) != 0){
            word[j] = '\0';
            int k = Search_Seq(word);
            if(k != 0){
                this->elem[k].nums++;
                //cout<<k<<"һ���ϵ���"<<word<<" "<<this->elem[k].key<<"����Ϊ��"<<line<<"\n";
                Data* p = elem[k].data;
                while(p->next != NULL)
                    p = p->next;
                p -> next = new Data(line/30 + 1, (line - 1)%30 + 1);
            }
            else{
                strcpy(this->elem[i].key, word);
                this->length++;
                this->elem[i].nums = 1;
                elem[i].data = new Data(line/30 + 1, (line - 1)%30 + 1);
                //cout<<"һ���µ���"<<i<<" "<<word<<" "<<this->elem[i].key<<length<<"\n";
                i++;
                if(i >= LIST_INIT_SIZE){
                    cout<<"�������ͳ�������޶���\n";
                    break;
                }
            }
            j = 0;
        }
        while(ch != EOF && !isalpha(ch)){
            if(ch == '\n'){
                //cout<<"����\n";
                line++;
            }
            ch = fgetc(fp);
        }
    }
    delete word;
    word = NULL;
    fclose(fp);
    return true;


};

bool SSTable::TraverseSSTable(){
    for(int i = 1; i <=this->length; ++i){
        int nums = this->elem[i].nums;
        cout<<"\t���ʣ�"<<this->elem[i].key<<"���ֵĴ���Ϊ��"<<nums<<"\n";
        cout<<"\t�ֱ����������λ�ã�\n";
        Data* p = this->elem[i].data;
        for(int j = 0; j < nums; ++j){
            cout<<"\t��"<<p->page<<"ҳ����"<<p->line<<"��\n";
            p = p->next;
        }
    }
    return true;
};

bool SSTable::DestroySSTable(){
    if(this->elem){
        delete [] elem;
        elem = NULL;
    }
    return true;
}

int SSTable::Search_Seq(KeyType key){
    this->elem[0].key = key;
    cout<<this->elem[this->length].key<<"\n";
    int i;
    for(i = this->length; !EQ(this->elem[i].key, key); --i){
        cout<<i<<"\n";
    }
    return i;
}

void SSTable::WordInfor(int i){
    if(i > this->length)
        return;
    else{
        int nums = this->elem[i].nums;
        cout<<"\t���ʣ�"<<this->elem[i].key<<"���ֵĴ���Ϊ��"<<nums<<"\n";
        cout<<"\t�ֱ����������λ�ã�\n";
        Data* p = this->elem[i].data;
        for(int j = 0; j < nums; ++j){
            cout<<"\t��"<<p->page<<"ҳ����"<<p->line<<"��\n";
            p = p->next;
        }
    }
}

int SSTable::Search_Bin(KeyType key){
    int high = this->length;
    int low = 1;
    int mid = (high + low) / 2;
    while(high >= low){
        if(EQ(this->elem[mid].key, key))
            return mid;
        else if(LT(this->elem[mid].key, key))
            low = mid + 1;
        else
            high = mid;
    }
    return 0;
}
/*int EQ(char* s1, char* s2){
    int i = 0;
    while(s1[i] != '\0' && s2[i] != '\0'){
        if(s1[i] > s2[i])
            return 1;
        if(s1[i] < s2[i])
            return -1;
        i++;
    }
    if(s1[i] == '\0' && s2[i] == '\0')
        return 0;
    else if(s1[i] == '\0')
        return -1;
    else
        return 1;
}*/
