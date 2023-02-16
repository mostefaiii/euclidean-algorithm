public class GcdCalc {

	//iterative
	public static int findGCD(int x, int y){
		//euclidean algorithm
		//a = bq + r
		//a%b
		//if a%b==0 break and return b
		//stick a%b in a var (that's r) (this is to do the switcharoo)
		//do the same but "a" = b and "b" = r
		//proceed!
		int a = x;
		int b = y;
		while(true){
			int r = a%b;
			if(r==0){
				break;
			}else{
				a = b;
				b = r;
			}
		}
		return b;
		
	}

	//recursive
	public static int findGCDrecurs(int x, int y){
		if(x%y==0){
			return y;
		}else{
			return findGCDrecurs(y, x%y);
		}
	}

	//recursive with prints!
	public static void findEuclidTrace(int x, int y){
		//AAAAA
		System.out.println(x + " = " + y + "(" + x/y + ") + " + x%y);
		if(x%y==0){
			System.out.println("The GCD is " + y);
			return;
		}else{
			findEuclidTrace(y, x%y);
		}
	}


	//i wanna try to do bezout here but i'm unsure how
	//i believe this is possible in go with two goroutines, 
	//one of bezout and one of euclid going at the same time
	//idk how to implement it tho

	public static void main(String[] args){
		int x = Integer.parseInt(args[0]);
		int y = Integer.parseInt(args[1]);
		long tbf = System.currentTimeMillis();
		findGCDrecurs(x,y);
		long time = (System.currentTimeMillis()-tbf);
		System.out.println("recursively this took " + time + " milliseconds.");
		tbf = System.currentTimeMillis();
		findGCD(x, y);
		time = (System.currentTimeMillis()-tbf);
		System.out.println("iteratively this took " + time + " milliseconds.");
		System.out.println("The trace for this is: ");
		findEuclidTrace(x, y);
	}
}