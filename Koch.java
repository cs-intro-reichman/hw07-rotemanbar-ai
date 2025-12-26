/** Draws the Koch curve and the Koch snowflake fractal. */
public class Koch {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java Koch <depth> OR java Koch <n> <x1> <y1> <x2> <y2>");
            return;
        }

        if (args.length == 1) {
            snowFlake(Integer.parseInt(args[0]));
        } 
        else if (args.length == 5) {
            curve(Integer.parseInt(args[0]),
                  Double.parseDouble(args[1]), Double.parseDouble(args[2]), 
                  Double.parseDouble(args[3]), Double.parseDouble(args[4]));
        }
    }

    /** Draws a Koch curve of depth n from (x1,y1) to (x2,y2). */
    public static void curve(int n, double x1, double y1, double x2, double y2) {
        if (n == 0) {
            StdDraw.line(x1, y1, x2, y2);
            return;
        }

        double x_p1 = x1 + (x2 - x1) / 3.0;
        double y_p1 = y1 + (y2 - y1) / 3.0;

        double x_p3 = x1 + 2.0 * (x2 - x1) / 3.0;
        double y_p3 = y1 + 2.0 * (y2 - y1) / 3.0;

        double x_p2 = (0.5 * (x1 + x2)) - ((Math.sqrt(3) / 6.0) * (y2 - y1));
        double y_p2 = (0.5 * (y1 + y2)) + ((Math.sqrt(3) / 6.0) * (x2 - x1));

        curve(n - 1, x1, y1, x_p1, y_p1);     
        curve(n - 1, x_p1, y_p1, x_p2, y_p2); 
        curve(n - 1, x_p2, y_p2, x_p3, y_p3); 
        curve(n - 1, x_p3, y_p3, x2, y2);     
    }

    /** Draws a Koch snowflake of n edges in the standard canvass. */
    public static void snowFlake(int n) {
        StdDraw.setYscale(0, 1.1);
        StdDraw.setXscale(0, 1.1);
  
        double x1 = 0.2, y1 = 0.7;
        double x2 = 0.8, y2 = 0.7;
        double x3 = 0.5, y3 = 0.7 - (Math.sqrt(3) / 2.0) * 0.6;
 
        curve(n, x1, y1, x2, y2); 
        curve(n, x2, y2, x3, y3); 
        curve(n, x3, y3, x1, y1); 
    }
}