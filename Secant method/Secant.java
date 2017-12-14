/*
    @ Author: Nasir Islam Sujan
    @ GitHub: https://github.com/78526Nasir
*/



/*
    * This solution was written for
    * the following equation
    * f(x) = x^3 - 0.165x^2 + 3.993 * 10^-4

    You need an absolute relative approximate error of 5% or less.

    sample imput: 
    x_1 = 0.02 
    x0 = 0.05

    sample output:
    Iteration : 1
    Root:0.06461437908496731
    Error:22.61784341493019
    Iteration : 2
    Root:0.06241444855629439
    Error:3.5247135552094235

*/


package secant;
import java.util.*;

public class Secant {
    public static void main(String[] args) {
        
        double x_1,x0,root,given=5,error;
        boolean flag=true;
        int i=1;
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter value for x_1 : ");
        x_1 = sc.nextDouble();

        System.out.print("Enter value for x0 : ");
        x0 = sc.nextDouble();

        while(flag){
            root = x0 - ((F(x0)*(x0-x_1))/(F(x0)-F(x_1)));
            error = Math.abs((root-x0)/root)*100;

            System.out.println("Iteration : "+ i++);
            System.out.println("Root:"+root);
            System.out.println("Error:"+error);

            x_1 = x0;
            x0 = root;

            if(given>error)
            {
                    flag=false;
            }
        }
    }
            
    public static double F(double x){
        return Math.pow(x,3)-(0.165*Math.pow(x,2))+(3.993*Math.pow(10,-4));
    }
    
}




