class Employee {
  protected final String first, last, ssn;
  public Employee(String first, String last, String ssn){
    this.first = first;
    this.last = last;
    this.ssn = ssn;
  }

  public String get_first() {return first;}
  public String get_last() {return last;}
  public String get_ssn() {return ssn;}

  public String toString() {
    return String.format(first + ", " + last + ", "  + ssn);
  }
}

class CommissionEmployee extends Employee {
  protected double commission_rate, sales;

  public CommissionEmployee(String first, String last, String ssn, double commission_rate, double sales){
    super(first, last, ssn);
    this.commission_rate = commission_rate;
    this.sales = sales;
  }

  public double get_commission() {return commission_rate;}
  public double get_sales() {return sales;}

  public double get_earnings() {
    return sales*commission_rate;
  }

  public String toString() {
    String supes = super.toString();
    return String.format(supes + ", " + commission_rate + ", "+ sales);
  }
}

class BasePlusCommissionEmployee extends CommissionEmployee {
  protected double base;

  public BasePlusCommissionEmployee(String first, String last, String ssn, double commission_rate, double sales, double base){
    super(first, last, ssn, commission_rate, sales);
    this.base = base;
  }

  public double get_base() {return base;}

  public double get_earnings() {
    return base + super.get_earnings();
  }

  public String toString() {
    String supes = super.toString();
    return String.format(supes + ", " + base);
  }
}

class HourlyEmployee extends Employee {
  protected double wage, hours;

  public HourlyEmployee(String first, String last, String ssn, double wage, double hours){
    super(first, last, ssn);
    this.wage = wage;
    this.hours = hours;
  }

  public double get_wage() {return wage;}
  public double get_hours() {return hours;}

  public double get_earnings() {
    return wage*hours;
  }

  public String toString() {
    String supes = super.toString();
    return String.format(supes + ", " + wage + ", " + hours);
  }
}

public class TestEmployee {
  public static void main (String[] args) {
    BasePlusCommissionEmployee BCE = new BasePlusCommissionEmployee("A", "B", "C", 1.0, 2.0, 400.0);
    System.out.println(BCE.toString());
    System.out.println(BCE.get_earnings());

    HourlyEmployee HE = new HourlyEmployee("A", "B", "C", 16.0, 2.0);
    System.out.println(HE.toString());
    System.out.println(HE.get_earnings());
  }
}
