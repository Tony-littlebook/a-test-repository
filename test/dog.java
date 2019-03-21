package test;

public final class dog extends animal implements Pet{
	public dog(String name){
		super(name);
		eat();
		System.out.println("the dog class construction");
	}
	public dog() {
		this("wancai");
	}
	public void eat() {
    	System.out.println("rice and meat");
    }
	public void sleep() {
    	System.out.println("sleep at night");
    }
	public void makeNoise() {
    	System.out.println("wowo!");
    }
	public void running() {
    	System.out.println("very fast");
    }
	public void wagTail() {
    	System.out.println("feel nice");
    }
    public void beFriendly() {
    	System.out.println("wag its tail");
    }
    public void play() {
    	System.out.println("play  with kids");
    }
}
