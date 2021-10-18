package j1.s.p0050;

/**
 *
 * @author Quang - HE140675
 */
public class EquationHandler { 
    // Solve function ax + b = 0, find number is odd, enven or perfect square
    void superlativeEquation() {
        double a = Validation.getDoubleInput("Enter A: ");
        double b = Validation.getDoubleInput("Enter B: ");
        double x = 0;
        
        if(a==0 && b!=0){
            System.out.println("No solution!!!"); 
            x = -1;
        }

        if(a==0 && b==0){
            System.out.println("Infinite solution!!!");
            x = -1;
        }

        if(a!=0 && b!=0){
            x = -b / a;  
            System.out.println("Solution: x = " + x); 
        }
        
        System.out.print("Number is odd: ");
        if (Validation.checkOdd(a)) {
            System.out.print(a + " ");
        }
        if (Validation.checkOdd(b)) {
            System.out.print(b + " ");
        }
        if (Validation.checkOdd(x)) {
            System.out.print(x + " ");
        }
        
        System.out.println();
        
        System.out.print("Number is even: ");
        if (Validation.checkEven(a)) {
            System.out.print(a + " ");
        }
        if (Validation.checkEven(b)) {
            System.out.print(b + " ");
        }
        if (Validation.checkEven(x)) {
            System.out.print(x + " ");
        }
        
        System.out.println();
        
        System.out.print("Number is perfect square: ");
        if (Validation.checkSquareNumber(a)) {
            System.out.print(a + " ");
        }
        if (Validation.checkSquareNumber(b)) {
            System.out.print(b + " ");
        }
        if (Validation.checkSquareNumber(x)) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
    
    // Solve function ax^2 + bx + c = 0, find number is odd, even or perfect square
    void quadraticEquation() {
        double a = Validation.getDoubleInput("Enter A: ");
        double b = Validation.getDoubleInput("Enter B: ");
        double c = Validation.getDoubleInput("Enter C: ");
        double delta = b * b - 4 * a * c;
        double x1 = 0, x2 = 0;
        
        if(delta < 0){
            System.out.println("No solution");
            x1 = -1; x2 = -1;
        }
        
        if(delta == 0){
            x1 = (-b) / (2 * a);
            x2 = -1;
            System.out.println("Solution x1 = x2 = " + x1);
        }
        
        if(delta >0 ){
            x1 = (-b + Math.sqrt(delta)) / (2 * a);
            x2 = (-b - Math.sqrt(delta)) / (2 * a);
            System.out.println("Solution: x1 = " + x1 + " and x2 = " + x2);
        }
        
        System.out.print("Number is odd: ");
        if (Validation.checkOdd(a)) {
            System.out.print(a + " ");
        }
        if (Validation.checkOdd(b)) {
            System.out.print(b + " ");
        }
        if (Validation.checkOdd(c)) {
            System.out.print(c + " ");
        }
        if (Validation.checkOdd(x1)) {
            System.out.print(x1 + " ");
        }
        if (Validation.checkOdd(x2)) {
            System.out.print(x2 + " ");
        }
        
        System.out.println();
        
        System.out.print("Number is even: ");
        if (Validation.checkEven(a)) {
            System.out.print(a + " ");
        }
        if (Validation.checkEven(b)) {
            System.out.print(b + " ");
        }
        if (Validation.checkEven(c)) {
            System.out.print(b + " ");
        }
        if (Validation.checkEven(x1)) {
            System.out.print(x1 + " ");
        }
        if (Validation.checkEven(x2)) {
            System.out.print(x2 + " ");
        }
        
        System.out.println();
                
        System.out.print("Number is perfect square: ");
        if (Validation.checkSquareNumber(a)) {
            System.out.print(a + " ");
        }
        if (Validation.checkSquareNumber(b)) {
            System.out.print(b + " ");
        }
        if (Validation.checkSquareNumber(c)) {
            System.out.print(c + " ");
        }
        if (Validation.checkSquareNumber(x1)) {
            System.out.print(x1 + " ");
        }
        if (Validation.checkSquareNumber(x2)) {
            System.out.print(x2 + " ");
        }
        System.out.println();
    }
}
