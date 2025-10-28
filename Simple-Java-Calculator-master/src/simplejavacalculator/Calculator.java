/**
 * @name        Simple Java Calculator
 * @package     ph.calculator
 * @file        Main.java
 * @author      SORIA Pierre-Henry
 * @email       pierrehs@hotmail.com
 * @link        http://github.com/pH-7
 * @copyright   Copyright Pierre-Henry SORIA, All Rights Reserved.
 * @license     Apache (http://www.apache.org/licenses/LICENSE-2.0)
 */

package simplejavacalculator;

import jdk.dynalink.Operation;

import static java.lang.Double.NaN;
import static java.lang.Math.log;
import static java.lang.Math.log10;
import static java.lang.Math.pow;

public class Calculator {


    /// COMMENTED THIS AS IT WAS A CODE SMELL.

//    public enum BiOperatorModes {
//        normal, add, minus, multiply, divide , xpowerofy
//    }


    public enum MonoOperatorModes {
        square, squareRoot, oneDividedBy, cos, sin, tan, log, rate, abs, ln,
    }

    private Double num1, num2;
    private BiOperatorModes mode = BiOperatorModes.normal;


    // THE BELOW COMMENTED METHOD IS A CODE SMELL OF LONG CLASS FOR THE CLACULATOR CLASS.
    private Double calculateBiImpl() {
        BiOperations biOperations ;
//
//        throw new Error();
    }

    public Double calculateBi(BiOperatorModes newMode, Double num) {
        if (mode.equals(BiOperatorModes.normal)) {
            num2 = 0.0;
            num1 = num;
            mode = newMode;
            return NaN;
        } else {
            num2 = num;
            num1 = calculateBiImpl();
            mode = newMode;
            return num1;
        }
    }

    public Double calculateEqual(Double num) {
        return calculateBi(BiOperatorModes.normal, num);
    }

    public Double reset() {
        num2 = 0.0;
        num1 = 0.0;
        mode = BiOperatorModes.normal;

        return NaN;
    }


    /// This is to identify another code smell of divergent change commented out below:
    
//    public Double calculateMono(MonoOperatorModes newMode, Double num) {
//        if (newMode.equals(MonoOperatorModes.square)) {
//            return num * num;
//        }
//        if (newMode.equals(MonoOperatorModes.squareRoot)) {
//            return Math.sqrt(num);
//        }
//        if (newMode.equals(MonoOperatorModes.oneDividedBy)) {
//            return 1 / num;
//        }
//        if (newMode.equals(MonoOperatorModes.cos)) {
//            return Math.cos(Math.toRadians(num));
//        }
//        if (newMode.equals(MonoOperatorModes.sin)) {
//            return Math.sin(Math.toRadians(num));
//        }
//        if (newMode.equals(MonoOperatorModes.tan)) {
//            if (num == 0 || num % 180 == 0 ) {
//                return 0.0;
//            }
//            if (num % 90 == 0.0 && num % 180 != 0.0) {
//                return NaN;
//            }
//
//            return Math.tan(Math.toRadians(num));
//        }
//        if (newMode.equals(MonoOperatorModes.log)) {
//            return log10(num);
//        }
//        if (newMode.equals(MonoOperatorModes.ln)) {
//            return log(num);
//        }
//        if (newMode.equals(MonoOperatorModes.rate) ) {
//            return num / 100;
//        }
//        if (newMode.equals(MonoOperatorModes.abs)){
//            return Math.abs(num);
//        }
//
//        // never reach
//        throw new Error();
    }

}
// This is a extracting a new class because the calculator class is a long class code smell as it contains many operators, methods etc. So the BiOperations handles the operations now seperately .
class BiOperations{

    private Double calculateBiImpl()
    {
        Calculator.BiOperatorModes mode = null;
        double num1 = 0;
        if (mode.equals(Calculator.BiOperatorModes.normal)) {
            double num1 = num1;
            return  Calculator num1;
        }
        double num2 = 0;
        if (mode.equals(Calculator.BiOperatorModes.add)) {
            if (num2 != 0) {
                return num1 + num2;
            }


            return num1;
        }
        if (mode.equals(Calculator.BiOperatorModes.minus)) {
            return num1 - num2;
        }
        if (mode.equals(Calculator.BiOperatorModes.multiply)) {
            return num1 * num2;
        }
        if (mode.equals(Calculator.BiOperatorModes.divide)) {
            return num1 / num2;
        }
        if (mode.equals(Calculator.BiOperatorModes.xpowerofy)) {
            return pow(num1,num2);
        }

        // never reach
        throw new Error();
    
}


// This is extracting a subclass WHICH IS TO SOLVE THE 2ND CODE SMELL OF DIVERGENT CHANGE (REFACTORING)
class MonoOperations extends Calculator {

    public Double calculateMono(MonoOperatorModes newMode, Double num) {
        if (newMode.equals(MonoOperatorModes.square)) {
            return num * num;
        }
        if (newMode.equals(MonoOperatorModes.squareRoot)) {
            return Math.sqrt(num);
        }
        if (newMode.equals(MonoOperatorModes.oneDividedBy)) {
            return 1 / num;
        }
        if (newMode.equals(MonoOperatorModes.cos)) {
            return Math.cos(Math.toRadians(num));
        }
        if (newMode.equals(MonoOperatorModes.sin)) {
            return Math.sin(Math.toRadians(num));
        }
        if (newMode.equals(MonoOperatorModes.tan)) {
            if (num == 0 || num % 180 == 0 ) {
                return 0.0;
            }
            if (num % 90 == 0.0 && num % 180 != 0.0) {
                return NaN;
            }

            return Math.tan(Math.toRadians(num));
        }
        if (newMode.equals(MonoOperatorModes.log)) {
            return log10(num);
        }
        if (newMode.equals(MonoOperatorModes.ln)) {
            return log(num);
        }
        if (newMode.equals(MonoOperatorModes.rate) ) {
            return num / 100;
        }
        if (newMode.equals(MonoOperatorModes.abs)){
            return Math.abs(num);
        }

        // never reach
        throw new Error();

}
///// This is the 3rd code smell of replacing the variables with a new class. This BiOperatorModes is the new class which is relacing the variables
    class BiOperatorModes  {
        enum normal, add, minus, multiply, divide , xpowerofy;
    }


    //////       THIS IS TO IMPLEMENT THE STATE DESIGN PATTERN FOR THE IF ELSE CONDITION OF BI OPERATIONS  ///////
    interface Operations {
        double calculateBiimpl();
    }

    class addOperation implements Operations{
        @Override
        public double calculateBiimpl() {
            double num1=0;
            double num2=0;
            Calculator.BiOperatorModes mode = null;
            if (num2 != 0) {
                return num1 + num2;
            }

            return num1;

        }
    }

    class minusOperation implements Operations{
        double num1=0;
        double num2=0;

        @Override
        public double calculateBiimpl() {
            return num1-num2;
        }
    }

    class multiplyOperation implements Operations{
        double num1=0;
        double num2=0;

        @Override
        public double calculateBiimpl() {
            return num1*num2;
        }
    }

    class divideOperations implements Operations{
        double num1=0;
        double num2=0;

        @Override
        public double calculateBiimpl() {
            return num1/num2;
        }
    }

    class powerOperation implements Operations{
        double num1=0;
        double num2=0;

        @Override
        public double calculateBiimpl() {
            return pow(num1,num2);
        }
    }

    class stateHandler{
        private Operations operations;
        stateHandler(Operations operations){
            this.operations=operations;


        }
        void setOperations(Operations operations){
            this.operations=operations;
        }

        void chooseOperations(){
            operations.calculateBiimpl();
        }




    }

    public static void main(String[] args) {
        stateHandler handler = new stateHandler(new addOperation());
        handler.chooseOperations();// Addition operation
    }
    }

   //// FOr implemeting feature as decorated pattern:


    interface Calc{
        void addFeature();
    }

    /// Now the
    class Features implements Calc{
        @Override
        public void addFeature() {
            System.out.println("Adding new features");
        }
    }

    class decorator implements Calc{
        protected Calc calc;
        decorator(Calc calc){
            this.calc=calc;
        }

        @Override
        public void addFeature() {
            calc.addFeature();
        }
    }






}