class Date {
  private int month, day, year;

  public Date(int month, int day, int year) {
    this.month = month;
    this.day = day;
    this.year = year;
  }

  public int getMonth() {return month;}
  public int getDay() {return day;}
  public int getYear() {return year;}
}

class Employee {
  protected Date birthDate;
  protected int salary;

  public Employee(int month, int day, int year, int salary) {
    birthDate = new Date(month, day, year);
    this.salary = salary;
  }
  public int getMoney(){
    return salary;
  }
  public int getBonus(int month) {
    return (month == birthDate.getMonth()) ? getMoney() + 100 : getMoney();
  }
}

class CommissionEmployee extends Employee {
  protected int commission;

  public CommissionEmployee(int month, int day, int year, int salary, int commission) {
    super(month, day, year, salary);
    this.commission = commission;
  }
  public int getMoney(){
    return super.getMoney() + commission;
  }
}

public class BonusPolymorphism{
  public static void main (String[] args) {
    int curMonth = 10;
    Employee[] E = new Employee[2];
    E[0] = new CommissionEmployee(11, 1, 1, 200, 50);
    E[1] = new Employee(10,0,0, 100);

    for (Employee emp : E) {
      System.out.println(emp.getBonus(curMonth));
    }
  }
}
