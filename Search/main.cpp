#include <iostream>
#include "StaticSearchTable.h"
#include "StaticSearchTable.cpp"
#include "BiTree.h"
#include "BiTree.cpp"
//using namespace std;
void menu(void);
int main()
{
    /*SSTable a = SSTable();
    const char* file = "test.txt";
    a.InitSSTable(file);
    a.TraverseSSTable();
    a.DestroySSTable();
    BiTree b = BiTree();
    b.InitSearchBST(file);
    b.TraverseBST();
    b.DestroyBST();
    return 0;*/
    int op = 0;
    BiTree myBST;
    SSTable mySSTable;
    bool isBSTinit = false;
    bool isSSTableinit = false;
    char word[WORD_LEN];
    char file[50];
    do{
        system("cls");
        menu();
        cout<<"          ����������ѡ��[0-18]:\t";
        cin>>op;
        switch(op){
        case 0:
            break;
        case 1:
            if(isSSTableinit){
                cout<<"\n\t��������֮ǰ�����ľ�̬���ұ�\n";
                break;
            }
            mySSTable = SSTable();
            cout<<"\n     ---������̬���ұ�---\n";
            cout<<"\n\t������������txt�ļ�����";
            cin>>file;
            strcat(file,".txt");
            if(!mySSTable.InitSSTable(file)){
                cout<<"\n\t������̬���ұ�ʧ�ܣ�\n";
            }
            else{
                isSSTableinit = true;
                cout<<"\n\t������̬���ұ�ɹ���\n";
            }
            getchar();getchar();
            break;
        case 2:
            break;
        case 3:
            break;
        case 4:{
            if(!isSSTableinit){
                cout<<"\n\t���ȴ�����̬���ұ�\n";
                getchar();getchar();
                break;
            }
            cout<<"\n\t������Ҫ��ѯ�ĵ�������";
            cin>>word;
            int i = mySSTable.Search_Seq(word);
            if(!i)
                cout<<"\n\t�õ���δ�����ڵ����ļ��У�\n";
            else
                mySSTable.WordInfor(i);
            getchar();getchar();
            break;
        }
        case 5:
            break;
        case 6:
            if(!isSSTableinit){
                cout<<"\n\t���ȴ�����̬���ұ�\n";
                getchar();getchar();
                break;
            }
            mySSTable.TraverseSSTable();
            getchar();getchar();
            break;
        case 7:
            if(!isSSTableinit){
                cout<<"\n\t���ȴ�����̬���ұ�\n";
                getchar();getchar();
                break;
            }
            mySSTable.DestroySSTable();
            cout<<"\n\t���پ�̬���ұ�ɹ���\n";
            isSSTableinit = false;
            getchar();getchar();
            break;
        case 8:
            break;
        case 9:
            break;
        case 10:
            break;
        case 11:
            if(isBSTinit){
                cout<<"\n\t��������֮ǰ�����Ķ�����������\n";
                getchar();getchar();
                break;
            }
            myBST = BiTree();
            cout<<"\n     ---��������������---\n";
            cout<<"\n\t������������txt�ļ�����";
            cin>>file;
            strcat(file,".txt");
            if(!myBST.InitSearchBST(file)){
                cout<<"\n\t��������������ʧ�ܣ�\n";
            }
            else{
                isBSTinit = true;
                cout<<"\n\t���������������ɹ���\n";
            }
            getchar();getchar();
            break;
        case 12:
            break;
        case 13:
            break;
        case 14:{
            if(!isBSTinit){
                cout<<"\n\t���ȴ���������������\n";
                getchar();getchar();
                break;
            }
            cout<<"\n\t������Ҫ��ѯ�ĵ�������";
            cin>>word;
            BiTree* T;
            bool isSearch = myBST.SearchintheBST(word, T);
            if(!isSearch)
                cout<<"\n\t�����������в����ڸõ��ʣ�\n";
            else{
                int nums = T->elem.nums;
                cout<<"\t����"<<T->elem.key<<"���ֵĴ���Ϊ "<<nums<<"\n";
                cout<<"\t�ֱ����������λ�ã�\n";
                Data* p = T->elem.data;
                for(int j = 0; (j < nums) && (p != NULL); ++j){
                    cout<<"\t��"<<p->page<<"ҳ����"<<p->line<<"��\n";
                    p = p->next;
                }
            }
            getchar();getchar();
            break;
        }
        case 15:
            break;
        case 16:
            break;
        case 17:
            if(!isBSTinit){
                cout<<"\n\t���ȴ���������������\n";
                getchar();getchar();
                break;
            }
            myBST.TraverseBST();
            //Traverse(&myBST);
            getchar();getchar();
            break;
        case 18:
            if(!isBSTinit){
                cout<<"\n\t���ȴ���������������\n";
                getchar();getchar();
                break;
            }
            myBST.DestroyBST();
            cout<<"\n\t���ٶ����������ɹ���\n";
            getchar();getchar();
            break;

        default: ;
        }
    }while(op);
    cout<<"\n--------------------Welcome again!--------------------\n";
	getchar();getchar();
	return 0;
}
void menu(void){
	cout<<"\n\n";
	cout<<"                   ���ڲ��ұ�ĵ��ʼ������ \n";
	cout<<"***********************************************************\n";
    cout<<"    	  1.  ������̬���ұ� \n";
    cout<<"    	  2.  ���澲̬���ұ� \n";
    cout<<"    	  3.  �ָ���̬���ұ� \n";
	cout<<"    	  4.  ��̬����       \n";
	cout<<"    	  5.  ���ֲ���       \n";
	cout<<"    	  6.  ������̬���ұ� \n";
	cout<<"    	  7.  ���پ�̬���ұ� \n";
	cout<<"          8.  �Ӵ�����       \n";
	cout<<"          9.  �����滻       \n";
	cout<<"          10. ���ʳ��ִ���ͳ��\n";
	cout<<"----------------------------------------------------------\n";
    cout<<"    	  11. ��ʼ������������\n";
    cout<<"    	  12. �������������  \n";
    cout<<"    	  13. �ָ�����������  \n";
	cout<<"    	  14. ��������������  \n";
	cout<<"    	  15. �������������  \n";
	cout<<"    	  16. ɾ������������  \n";
	cout<<"          17. ��������������  \n";
	cout<<"    	  18. ���ٶ���������  \n";
	cout<<"    	  0.  �˳�ϵͳ     \n\n";
	cout<<"**********************************************************\n";
}
