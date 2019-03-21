#include "SelemType.h"
#ifndef BITREE_H_INCLUDED
#define BITREE_H_INCLUDED
class BiTree{
public:
    ElemType elem;
    BiTree* left;
    BiTree* right;

    BiTree(){
        left = NULL;
        right = NULL;
    };

    bool InitSearchBST(const char* file);

    bool TraverseBST();

    bool DestroyBST();

    bool SearchintheBST(KeyType key, BiTree* &p);

    bool InsertBST(BiTree* &T, KeyType key, int page, int line);

    bool DeletetheBST(KeyType key);

    ~BiTree(){
        if(left){
            delete left;
            left = NULL;
        }
        if(right){
            delete right;
            right = NULL;
        }
    };
};
bool SearchBST(BiTree* T, KeyType key, BiTree* f, BiTree* &p);
bool DeleteBST(BiTree* T, BiTree* f, KeyType key);
bool DeleteTreeNode(BiTree* p, BiTree* f);
bool Traverse(BiTree* T);
#endif // BITREE_H_INCLUDED
