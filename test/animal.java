package test;

abstract public class animal {
	boolean life;
	private String name;
	abstract void eat();
	abstract void sleep();
	abstract void makeNoise();
	public animal(String theName){
		name = theName;
		life = true;
		eat();
		sleep();
		running();
		getName();
		System.out.println("the animal class construction");
	}
	public animal() {
		System.out.println("the animal class construction");
	}
	public void running() {
		System.out.println("do not known speed");
	}
	public boolean isAlive() {
		return life;
	}
	public boolean setLife(boolean x) {
		life = x;
		return true;
	}
	public void getName() {
		System.out.println("the name is " + name);
	}
}
