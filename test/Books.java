package test;

public class Books {
    String title;
    String author;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Books [] myBooks = new Books[3];
        myBooks[0] = new Books();
        myBooks[1] = new Books();
        myBooks[2] = new Books();
        int x = 0;
        myBooks[0].title = "��Ұ�ĺ���";
        myBooks[1].title = "ŷ������ƪС˵ѡ";
        myBooks[2].title = "����Ϧʰ";
        myBooks[0].author ="�ܿ��׶�";
        myBooks[1].author ="ŷ����";
        myBooks[2].author ="³Ѹ";
        
        while(x < 3) {
        	System.out.println(myBooks[x].title);
        	System.out.println("by");
        	System.out.println(myBooks[x].author );
        	System.out.println("");
        	x = x + 1;
        }
	}

}
