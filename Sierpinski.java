public class Sierpinski {
    
    public static void main(String[] args) {
        if (args.length > 0) {
            sierpinski(Integer.parseInt(args[0]));
        } else {
            System.out.println("Usage: java Sierpinski <depth>");
        }
    }
    
    public static void sierpinski(int n) {
        double x1 = 0.0, y1 = 0.0;
        double x2 = 1.0, y2 = 0.0;
        double x3 = 0.5, y3 = Math.sqrt(3) / 2; 
        
    
        StdDraw.setPenColor(StdDraw.BLACK);
        drawTriangle(x1, y1, x2, y2, x3, y3);
        
        
        sierpinski(n, x1, y1, x2, y2, x3, y3);
    }
    
    private static void sierpinski(int n, double x1, double y1, double x2, double y2, double x3, double y3) {
        if (n == 0) return; 

        // חישוב נקודות האמצע
        double midX12 = (x1 + x2) / 2;
        double midY12 = (y1 + y2) / 2;
        double midX23 = (x2 + x3) / 2;
        double midY23 = (y2 + y3) / 2;
        double midX31 = (x3 + x1) / 2;
        double midY31 = (y3 + y1) / 2;

        drawTriangle(midX12, midY12, midX23, midY23, midX31, midY31);
        
        sierpinski(n - 1, x1, y1, midX12, midY12, midX31, midY31); 
        sierpinski(n - 1, midX12, midY12, x2, y2, midX23, midY23);  
        sierpinski(n - 1, midX31, midY31, midX23, midY23, x3, y3); 
    }

    private static void drawTriangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        StdDraw.line(x1, y1, x2, y2);
        StdDraw.line(x2, y2, x3, y3);
        StdDraw.line(x3, y3, x1, y1);
    }
}