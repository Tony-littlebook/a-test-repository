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
        myBooks[0].title = "¿õÒ°µÄºô»½";
        myBooks[1].title = "Å·ºàÀû¶ÌÆªÐ¡ËµÑ¡";
        myBooks[2].title = "³¯»¨Ï¦Ê°";
        myBooks[0].author ="½Ü¿ËÂ×¶Ø";
        myBooks[1].author ="Å·ºàÀû";
        myBooks[2].author ="Â³Ñ¸";
        
        while(x < 3) {
        	System.out.println(myBooks[x].title);
        	System.out.println("by");
        	System.out.println(myBooks[x].author );
        	System.out.println("");
        	x = x + 1;
        }
	}

}
