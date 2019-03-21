package test;

public final class cat extends animal implements Pet{
    public cat(String name){
    	super(name);
    	eat();
    	System.out.println("the cat class construction");
    }
    public void eat() {
    	System.out.println("fish and meat");
    }
    public void sleep() {
    	System.out.println("sleep at day");
    }
    public void makeNoise() {
    	System.out.println("miao!");
    }
    /*void running() {
    	System.out.println("fast");
    }*/
    public void catchRat() {
    	System.out.println("good at catching rats");
    }
    public void beFriendly() {
    	System.out.println("help people catch rats");
    }
    public void play() {
    	System.out.println("play  with kids");
    }
}
