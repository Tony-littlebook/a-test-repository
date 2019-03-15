#include "SelemType.h"
#include <malloc.h>
#ifndef BITREE_H_INCLUDED
#define BITREE_H_INCLUDED
public class BiTree{
    Elemtype elem;
    BiTree* left;
    BiTree* right;
    BiTree(){};
    public bool SearchBST(KeyType key, BiTree* f, BiTree* &p);

    public bool insertBST(BiTree* &T, KeyType key);

    public bool DeleteBST(BiTree* &T, );
    ~BiTree();
};
#endif //
