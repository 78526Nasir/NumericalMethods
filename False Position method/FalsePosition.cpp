/**
    @Author: Nasir Islam Sujan
    @Github: https://github.com/78526Nasir

*/

/*
    * False Position Method
    * This solution is for the following equation
    * f(x)=(x-4)^2(x+2)=0
    * given initial guesses xL=-2.5, xU=-1.0
    * and pre specified error tolerance Et=0.1%

    sample input:
    xL=-2.5
    xU=-1.0

    sample output:

    Enter the value of xl: -2.5

    Enter the value of xu: -1.0

    Iteration 1:     Root: -1.813008         Appx. Error: 0.000000
    Iteration 2:     Root: -1.971182         Appx. Error: 8.024307
    Iteration 3:     Root: -1.995710         Appx. Error: 1.229055
    Iteration 4:     Root: -1.999365         Appx. Error: 0.182788
    Iteration 5:     Root: -1.999906         Appx. Error: 0.027062


*/


#include<stdio.h>
#include<stdlib.h>
#include<math.h>
#include<limits.h>

#define ET 0.1 /// Error Tolerance
#define F(x) pow((x-4), 2)*(x+2)  ///defining the function

main()
{
    int i=1;
    float xl, xu, xr, f1, f2, total;
    float approxError=INT_MAX;
    float prevRoot=INT_MAX;

    printf("\nEnter the value of xl: ");
    scanf("%f", &xl);
    printf("\nEnter the value of xu: ");
    scanf("%f", &xu);

    f1=F(xl);
    f2=F(xu);

    total=f1*f2;

    if(total > 0)
    {
        printf("Invalid initial guesses!!!");
        return 0;
    }

    do
    {
        if(i != 1)
            prevRoot = xr;

        xr = ((xu*F(xl))-(xl*F(xu)))/(F(xl)-F(xu));

        approxError = fabs((xr - prevRoot) / xr) * 100;

        printf("\nIteration %d: \t Root: %f \t Appx. Error: %f", i, xr, (i==1) ? 0 : approxError);

        f1=F(xl);
        f2=F(xr);
        total=f1*f2;

        if(total < 0)
            xu = xr;
        else if(total > 0)
            xl = xr;
        else
            exit(0);

        i++;
    }
    while(approxError >= ET);

    return 0;

}
