#include "BiTree.h"
#include <malloc.h>
//#include <iostream>
//#include <stdlib.h>
//#include <string.h>
bool BiTree::InitSearchBST(const char* file){
    FILE* fp;
    if((fp = fopen(file, "r")) == NULL){
        cout<<"cannot open this file!\n";
        return false;
    }
    char ch;
    char* word = new char[WORD_LEN];
    ch = fgetc(fp);
    int j = 0,i = 0,line = 1;
    BiTree* T = NULL;
    while(ch != EOF){
        strcpy(word, "");
        while(isalpha(ch)){
            if(ch >= 'A' && ch <= 'Z')
                ch = ch + 'a' - 'A';
            word[j++] = ch;
            ch = fgetc(fp);
        }
        if(strlen(word) != 0){
            word[j] = '\0';
            j = 0;
            //cout<<word<<"\n";
            InsertBST(T, word, line/30 + 1, (line - 1)%30 + 1);
            i++;
            if(i >= LIST_INIT_SIZE){
                cout<<"超出最大统计数量限定！\n";
                break;
            }
        }
        while(ch != EOF && !isalpha(ch)){
            if(ch == '\n') line++;
            ch = fgetc(fp);
        }

    }
    this->elem = T->elem;
    this->left = T->left;
    this->right = T->right;
    free(T);   //T的left和right指针指向的内存不会被释放；
    return true;

}

bool BiTree::TraverseBST(){
    return Traverse(this);
}
bool Traverse(BiTree* T){
    if(!T)
        return false;
    Traverse(T->left);
    int nums = T->elem.nums;
    cout<<"\t单词"<<T->elem.key<<"出现的次数为 "<<nums<<"\n";
    cout<<"\t分别出现在以下位置：\n";
    Data* p = T->elem.data;
    for(int j = 0; (j < nums) && (p != NULL); ++j){
        cout<<"\t第"<<p->page<<"页，第"<<p->line<<"行\n";
        p = p->next;
    }
    Traverse(T->right);
    return true;
}

bool BiTree::DestroyBST(){
    if(left){
        delete left;
        left = NULL;
    }
    if(right){
        delete right;
        right = NULL;
    }
    return true;

};

bool SearchBST(BiTree* T, KeyType key, BiTree* f, BiTree* &p){
    //cout<<"调用SearchBST\n";
    if(!T){
        //cout<<"!T\n";
        p = f;
        return false;
    }
    else if(EQ(T->elem.key, key)){
        //cout<<"成功\n";
        p = T;
        return true;
    }
    else if(LQ(T->elem.key, key))
        return SearchBST(T->right, key, T, p);
    else
        return SearchBST(T->left, key, T, p);
}

bool BiTree::InsertBST(BiTree* &T, KeyType key, int page, int line){
    BiTree* p;
    if(!SearchBST(T, key, NULL, p)){
        //cout<<"failed\n";
        ElemType* e = new ElemType();
        e->key = key;
        e->nums = 1;
        e->data = new Data(page, line);
        BiTree* s = new BiTree();
        s->elem = *e;
        if(!p) T = s;
        else if(LQ(p->elem.key, key))
            p->right = s;
        else
            p->left = s;
        return true;
    }
    else {
        (p->elem.nums)++;
        Data* cur = p->elem.data;
        while(cur->next != NULL )
            cur = cur->next;
        cur->next = new Data(page, line);
        return false;
    }
}


bool BiTree::SearchintheBST(KeyType key, BiTree* &p){
    return SearchBST(this, key, NULL, p);
}

bool BiTree::DeletetheBST(KeyType key){
    return DeleteBST(this, NULL, key);
}


bool DeleteBST(BiTree* T, BiTree* f, KeyType key){
    if(!T)
        return false;
    else{
        if(EQ(key, T->elem.key))
            return DeleteTreeNode(T, f);
        if(LQ(key, T->elem.key))
            return DeleteBST(T->left, T, key);
        else
            return DeleteBST(T->right, T, key);
    }

}

bool DeleteTreeNode(BiTree* p, BiTree* f){
    if(f == NULL)
        delete p;
    else if(!p->left){
        if(f->left == p)
            f->left = p->right;
        else
            f->right = p->right;
        delete p;
    }
    else if(!p->right){
        if(f->left == p)
            f->left = p->left;
        else
            f->right = p->left;
        delete p;
    }
    else{
        BiTree* s = p->right;
        BiTree* q = p->left;
        if(f->left == p)
            f->left = p->left;
        else
            f->right = p->left;
        delete p;
        while(q->right != NULL) q = q->right;
        q->right = s;
    }
    return true;
}




























