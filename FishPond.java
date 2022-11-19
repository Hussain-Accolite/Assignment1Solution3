package Solution3;
import java.util.*;
class func extends Thread{
	List<String> fish = new ArrayList<String>();
	int rnd,rnd2;
	int k = 0;
	String [] fi = {"M","F"};
	Random rand = new Random();
	public void run() {
		try {
			while(fish.size()>1) {
				//k = k+1;
			 activity();
			 Thread.sleep(100);
			 //stopping the infinite pond
			 //if(k>100) {
				// break;
			//}
		}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}
	func(List<String> fish){
		this.fish = fish;
	}
	public void activity() {
			synchronized(this) {
			rnd = new Random().nextInt(fish.size());
			rnd2 = new Random().nextInt(fish.size());
			for(int i =0;i>=0;i++) {
				if(rnd != rnd2) {
					break;
				}
				else {
					rnd2 = new Random().nextInt(fish.size());
				}
			}
			System.out.println(fish.get(rnd) +" " + rnd);
			System.out.println(fish.get(rnd2) +" " + rnd2);
			
			if(fish.get(rnd)=="M" && fish.get(rnd2)=="M") {
				fish.remove("M");
				fish.remove("M");
				
			}
			
			else if(fish.get(rnd)=="M" && fish.get(rnd2)=="F" ) {
				fish.add(fi[rand.nextInt(fi.length)]);
				fish.add(fi[rand.nextInt(fi.length)]);
				
			}
			else if(fish.get(rnd)=="F" && fish.get(rnd2)=="M" ) {
				fish.add(fi[rand.nextInt(fi.length)]);
				fish.add(fi[rand.nextInt(fi.length)]);
			}
			
			else if(fish.get(rnd)=="F" && fish.get(rnd2)=="F") {
				fish.remove("F");
			}
			System.out.println(fish+"   "+fish.size());
			}
			
		
	}
}

public class FishPond {
	static List<String> fish = new ArrayList<String>();

	public static void main(String[] args) {
		
		for(int i=0;i<10;i++) {
			fish.add("M");
		}
		for(int i=0;i<10;i++) {
			fish.add("F");
		}
		
		System.out.println(fish+"   "+fish.size());
		func f1 = new func(fish);
		func f2 = new func(fish);
		func f3 = new func(fish);
		func f4 = new func(fish);
		func f5 = new func(fish);
		f1.start();
		f2.start();
		f3.start();
		f4.start();
		f5.start();
	}
}


