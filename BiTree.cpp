#include <malloc.h>
#inluce <BiTree.h>
bool BiTree::SearchBST(BiTree* T, KeyType key, BiTree* f, BiTree* &p){
    if(!T ){
        p = f;
        return false;
    }
    else if(EQ(T->elem.key, key)){
        p = T;
        return true;
    }
    else if(LQ(T->elem.key, key))
        return SearchBST(T->right, key, T, p);
    else
        return SearchBST(T->left, key, T, p);
}

bool BiTree::insertBST(BiTree* &T, KeyType key, int page， int line){
    //BiTree tree;
    BiTree* p;//= &tree;
    if(!SearchBST(T, key, NULL, p)){
        e = ElemType();
        e->key = key;
        e->nums = 1;
        e->data = new Data(page, line);  
        s = new BiTree();
        s->elem = *e;
        s->left = s->right = NULL;
        if(!p) T = s;
        else if(LQ(p->elem.key, key))
            p->right = s;
        else
            p->left = s;
        return true;
    }
    else {
        (p->elem.nums)++;
        data* cur = p->elem.data;
        while(cur->next != NULL )
            cur = cur->next;
        cur->next = new Data(page, line);
        return false;
    }
}
