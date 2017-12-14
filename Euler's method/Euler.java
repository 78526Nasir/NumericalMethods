/*
    @ Author: Nasir Islam Sujan
    @ GitHub: https://github.com/78526Nasir
*/

/*
    * This solution is written for the follwing equation
    * dy/dx=x+2y, where y(x0)=y(0)=0
    
    * we need to use Euler's method to find a value for the 
    * solution at x=1, and use steps of size h=0.25

    * given true value of y(1) is 2.60143
    * we need to find the absolute eror 

    sample input:
    x0=0
    y0=0
    
    sample output:
    Enter value for x0: 0
    Enter value for y0: 0
    For the solution at X = 1.0, the value of Y is = 0.515625
    True Eror Et: 2.085805
    The absolute error: 80.17917068689144

    
*/

package euler;

import java.util.Scanner;

public class Euler {
    public static void main(String[] args) {
        double root, h = 0.25, x0, y0, X = 1, Y=0.0, trueValueOfY_1=2.60143, trueError, absoluteError;
        boolean flag = true;
        
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter value for x0: ");
        x0 = sc.nextDouble();
        
        System.out.print("Enter value for y0: ");
        y0=sc.nextDouble();
        
        while(flag){
            root=x0+h;
            Y=y0+h*f_xy(x0, y0);
            
            if(root>=X)
            {
                flag=false;
            }
            x0=root;
            y0=Y;
        }
        
        System.out.println("For the solution at X = "+X +", the value of Y is = "+Y);
        
        trueError = trueValueOfY_1 - Y;
        
        System.out.println("True Eror Et: "+trueError);
        
        absoluteError = Math.abs(trueError/trueValueOfY_1)*100;
        
        System.out.println("The absolute error: "+absoluteError);
        
    }
    
    public static double f_xy(double x, double y){
        return x+2*y;
    }

}
