package myedit;
//多线程同步，以简单的一个售票系统为例
public class TicketSale implements Runnable {
    private int numberOfSale;
    public TicketSale(){
    	this.numberOfSale = 0;
    }
    public void sale() {
    	this.numberOfSale++;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
     TicketSale myTicketSale = new TicketSale();
     Thread thread1 = new Thread(myTicketSale, "售票点1");
     Thread thread2 = new Thread(myTicketSale, "售票点2");
     Thread thread3 = new Thread(myTicketSale, "售票点3");
     thread1.start();
     thread2.start();
     thread3.start(); 
	}
	
	public void run() {
		for(int i = 0; i < 10; ++i) {
			synchronized(this) {//同步代码块，类似于锁
			    sale();
		        String name = Thread.currentThread().getName();
		        System.out.println(name + "售出一张票，目前一共售出" 
		        + this.numberOfSale + "张票。");
		        try {
		            Thread.sleep(1000);
		        }catch(InterruptedException e) {
		    	    e.printStackTrace();
		        }
		   }
		}
	}

}
