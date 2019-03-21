package test;

public class abstractClassDrive {
    void giveShot(animal [] a) {
    	int x = a.length;
    	for(int i = 0; i < x; i++)
    	   a[i].makeNoise();
    }
    void showRunning(animal [] a) {
    	int x = a.length;
    	for(int i = 0; i < x; i++)
    	   a[i].running();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        abstractClassDrive v = new abstractClassDrive();
        animal [] a = new animal[2];
        a[0] = new cat("mimi");
        a[1] = new dog();
        v.giveShot(a);
        v.showRunning(a);
        tiger s = new tiger();
        s.makeNoise();
        //animal acat = new cat();
        //acat.catchRat();
        //animal aAnimal = animal();
        /*cat mycat = new cat();
        dog mydog = new dog();
        v.giveShot(mycat);
        v.giveShot(mydog);
        animal aAnimal = new cat();
        aAnimal.eat();*/
        //if(aAnimal instanceof cat)
        	//cat newcat =  (cat) aAnimal;
        //aAnimal.catchRat();
	}

}
