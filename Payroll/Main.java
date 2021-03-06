// Fig. 10.15: PayableInterfaceTest.java
// Payable interface test program processing Invoices and
// Employees polymorphically.
public class Main {
  public static void main(String[] args){
    // create four-element Payable array
    Payable[] payableObjects = new Payable[6];

    // populate array with objects that implement Payable
    payableObjects[0] = new Invoice("01234", "seat", 2, 375.00);
    payableObjects[1] = new Invoice("56789", "tire", 4, 79.95);
    payableObjects[2] = new SalariedEmployee("John", "Smith", "111-11-1111", 800.00);
    payableObjects[3] = new HourlyEmployee("C", "D", "77", 800.00, 40.0);
    payableObjects[4] = new CommissionEmployee("Lisa", "Barnes", "888-88-8888", 1200.00, 0.1);
    payableObjects[5] = new BasePlusCommissionEmployee("A", "B", "99", 1200.00, 0.1, 1000.0);

    System.out.println("Invoices and Employees processed polymorphically:");
    // generically process each element in array payableObjects
    for (Payable currentPayable : payableObjects) {
      // output currentPayable and its appropriate payment amount
      System.out.printf("%n%s", currentPayable.toString()); // could invoke implicitly
      if (currentPayable instanceof BasePlusCommissionEmployee) {
        BasePlusCommissionEmployee BCE = (BasePlusCommissionEmployee) currentPayable;
        BCE.incrementBaseSalary(0.1);
      }
      System.out.printf("%n%s: $%,.2f%n","payment due",currentPayable.getPaymentAmount());
    }
  } // end main
} // end class PayableInterfaceTest