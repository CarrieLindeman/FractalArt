
public class flowerChanging {
	/**
	 * prints flower pattern
	 * @param amp double amplitude of flower
	 * @param x0 double center x  coord
	 * @param y0 double center y coord
	 * @param T double time step
	 */
	public static void printFlower(double amp,double x0, double y0,double T){
		double x = 0;
		double y =0;
		//random color generator
		int r =(int) (Math.random()*255)+1;
		int g = (int) (Math.random()*255)+1;
		int b = (int) (Math.random()*255)+1;		
		StdDraw.setPenColor(r, g, b);
		
		for(double t = 0;t<=(2*Math.PI);t+=T){//goes through period of the flower graph
		x=(amp*Math.cos(4*t)*Math.sin(t))+x0;//calculates x coordinate with center point x0,y0 @ time t
		y=(amp*Math.cos(4*t)*Math.cos(t))+y0;//calculates y coordinate with center point x0,y0 @ time t
		StdDraw.line(x0, y0, x, y);
		}
	}
	/**
	 * calls print flower and recursively calls itself in 8 different positions
	 * @param level integer level of recursion
	 * @param x double x coord of center point of flower
	 * @param y double y coord of center point of flower
	 * @param amp double amplitude or diameter of flower
	 * @param T double time step of flower printer
	 */
	public static void fFlower(int level, double x, double y, double amp,double T){
		if (level == 0) return;
		printFlower(amp,x, y,T);
		
		//these are the same number but I separated them so I 
		//would not get confused.
		double cosNum=Math.cos(Math.PI/4);
		double sinNum=Math.cos(Math.PI/4);
		//view comp flower.jpg
		fFlower(level-1,(x+amp)+(amp/3), y, amp/3,T);//petal a
		fFlower(level-1,x+((amp*cosNum)+((amp/3)*cosNum)),y+((amp*sinNum)+((amp/3)*sinNum)),amp/3,T);//petal e
		fFlower(level-1,x, (y+amp)+(amp/3), amp/3,T);//petal b
		fFlower(level-1,x-((amp*cosNum)+((amp/3)*cosNum)),y+((amp*sinNum)+((amp/3)*sinNum)),amp/3,T);//petal f
		fFlower(level-1,(x-amp)-(amp/3), y, amp/3,T);//petal c
		fFlower(level-1,x-((amp*cosNum)+((amp/3)*cosNum)),y-((amp*sinNum)+((amp/3)*sinNum)),amp/3,T);//petal g
		fFlower(level-1,x, (y-amp)-(amp/3), amp/3,T);//petal d
		fFlower(level-1,x+((amp*cosNum)+((amp/3)*cosNum)),y-((amp*sinNum)+((amp/3)*sinNum)),amp/3,T);//petal h
		
		
		
		
	}
	
	public static void main(String[] args) {
		StdDraw.setXscale(-13,13);
		StdDraw.setYscale(-13,13);
		double[] x = {-18,18,18,-18,-18};
		double[] y = {18,18,-18,-18,18};
		StdDraw.filledPolygon(x, y);
		double penRad=.0004;
		int N= Integer.parseInt(args[0]);//suggested: 4
		double timeStep = .04;//the smaller the more full the flower
		double amplitude = 7;

		StdDraw.setPenRadius(penRad);
		fFlower(N,0,0,amplitude,timeStep);
		
	}

}
