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
        cout<<"          请输入您的选择[0-18]:\t";
        cin>>op;
        switch(op){
        case 0:
            break;
        case 1:
            if(isSSTableinit){
                cout<<"\n\t请先销毁之前创建的静态查找表！\n";
                break;
            }
            mySSTable = SSTable();
            cout<<"\n     ---创建静态查找表---\n";
            cout<<"\n\t请输入待导入的txt文件名：";
            cin>>file;
            strcat(file,".txt");
            if(!mySSTable.InitSSTable(file)){
                cout<<"\n\t创建静态查找表失败！\n";
            }
            else{
                isSSTableinit = true;
                cout<<"\n\t创建静态查找表成功！\n";
            }
            getchar();getchar();
            break;
        case 2:
            break;
        case 3:
            break;
        case 4:{
            if(!isSSTableinit){
                cout<<"\n\t请先创建静态查找表！\n";
                getchar();getchar();
                break;
            }
            cout<<"\n\t请输入要查询的单词名：";
            cin>>word;
            int i = mySSTable.Search_Seq(word);
            if(!i)
                cout<<"\n\t该单词未出现在导入文件中！\n";
            else
                mySSTable.WordInfor(i);
            getchar();getchar();
            break;
        }
        case 5:
            break;
        case 6:
            if(!isSSTableinit){
                cout<<"\n\t请先创建静态查找表！\n";
                getchar();getchar();
                break;
            }
            mySSTable.TraverseSSTable();
            getchar();getchar();
            break;
        case 7:
            if(!isSSTableinit){
                cout<<"\n\t请先创建静态查找表！\n";
                getchar();getchar();
                break;
            }
            mySSTable.DestroySSTable();
            cout<<"\n\t销毁静态查找表成功！\n";
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
                cout<<"\n\t请先销毁之前创建的二叉搜索树！\n";
                getchar();getchar();
                break;
            }
            myBST = BiTree();
            cout<<"\n     ---创建二叉搜索树---\n";
            cout<<"\n\t请输入待导入的txt文件名：";
            cin>>file;
            strcat(file,".txt");
            if(!myBST.InitSearchBST(file)){
                cout<<"\n\t创建二叉搜索树失败！\n";
            }
            else{
                isBSTinit = true;
                cout<<"\n\t创建二叉搜索树成功！\n";
            }
            getchar();getchar();
            break;
        case 12:
            break;
        case 13:
            break;
        case 14:
            break;
        case 15:
            break;
        case 16:
            break;
        case 17:
            if(!isBSTinit){
                cout<<"\n\t请先创建二叉搜索树！\n";
                getchar();getchar();
                break;
            }
            myBST.TraverseBST();
            getchar();getchar();
            break;
        case 18:
            if(!isBSTinit){
                cout<<"\n\t请先创建二叉搜索树！\n";
                getchar();getchar();
                break;
            }
            myBST.DestroyBST();
            cout<<"\n\t销毁二叉搜索树成功！\n";
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
	cout<<"                   基于查找表的单词检索软件 \n";
	cout<<"***********************************************************\n";
    cout<<"    	  1.  创建静态查找表 \n";
    cout<<"    	  2.  保存静态查找表 \n";
    cout<<"    	  3.  恢复静态查找表 \n";
	cout<<"    	  4.  静态查找       \n";
	cout<<"    	  5.  二分查找       \n";
	cout<<"    	  6.  遍历静态查找表 \n";
	cout<<"    	  7.  销毁静态查找表 \n";
	cout<<"          8.  子串查找       \n";
	cout<<"          9.  单词替换       \n";
	cout<<"          10. 单词出现次数统计\n";
	cout<<"----------------------------------------------------------\n";
    cout<<"    	  11. 初始化二叉搜索树\n";
    cout<<"    	  12. 保存二叉搜索树  \n";
    cout<<"    	  13. 恢复二叉搜索树  \n";
	cout<<"    	  14. 二叉搜索树查找  \n";
	cout<<"    	  15. 插入二叉搜索树  \n";
	cout<<"    	  16. 删除二叉搜索树  \n";
	cout<<"          17. 遍历二叉搜索树  \n";
	cout<<"    	  18. 销毁二叉搜索树  \n";
	cout<<"    	  0.  退出系统     \n\n";
	cout<<"**********************************************************\n";
}
