
public class SerpinskiTriangle {
	/**
	 * takes side length and top left point and makes an equal triangle
	 * @param sL double side length
	 * @param x double x coord of top left point
	 * @param y double y coord of top left point
	 */
	public static void triangle(double sL, double x, double y){
		double[] xS = {x,x+sL,(sL/2)+x,x};//makes x array based on TL point
		double[] yS = {y,y,y-(sL*Math.sin(Math.PI/3)),y};//makes y array based on TL point
		StdDraw.filledPolygon(xS, yS);//draws triangle
	}
	/**
	 * recursive function that calculates the spaces for three corresponding triangles
	 * @param level int level of recurse
	 * @param sL double side length
	 * @param x double x coord of top left point
	 * @param y double y coord of top left point
	 */
	public static void serpinski(int level,double sL, double x, double y){
		if (level==0) return;
		
		triangle(sL,x,y);
		/*
		 *calculations to find the TL point for three corresponding triangles 
		 */
		serpinski(level-1,sL/2,x-(sL/4),y-((sL/2)*Math.sin(Math.PI/3)));
		serpinski(level-1,sL/2,x+(sL/4),y+((sL/2)*Math.sin(Math.PI/3)));
		serpinski(level-1,sL/2,(x+sL)-(sL/4),y-((sL/2)*Math.sin(Math.PI/3)));
	}
	public static void main(String[] args) {//main function 
		StdDraw.setXscale(0,10);//set x scale
		StdDraw.setYscale(0,10);//set y scale
		
		double[] oX={0.0,5.0,10.0,0.0}; //makes array for original triangle x
		double[] oY={0.0,5*Math.sqrt(3),0.0,0.0};//makes array for original triangle y
		StdDraw.polygon(oX,oY);//draw orig triangle
		
		int N = Integer.parseInt(args[0]);//sets level for recurse
		serpinski(N,5,2.5,(5*Math.sin(Math.PI/3)));//calls serpinski for first triangle

	}

}
