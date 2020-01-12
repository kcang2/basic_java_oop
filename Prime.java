import java.util.*;

class Prime {
  HashSet<Integer> set;

  public Prime(){set = new HashSet<Integer>();}

  public boolean isPrime(int n) {
    set.clear();
    if (n < 1)  // 0 & 1 are not primes
      return false;

    if (n % 2 == 0)  // if divisible by 2, add 2 to set
      set.add(2);
    while (n % 2 == 0)  // repeated division by 2 until odd
      n /= 2;
    
    // n must be odd at this point.  So we can 
    // skip one element (Note i = i + 2) 
    for (int i = 3; i <= Math.sqrt(n); i += 2) { 
      // While i divides n, print i and divide n
      if (n % i == 0)  // add the prime factor to set
        set.add(i);
      while (n % i == 0)
        n /= i; 
    }

    // This condition is to handle the case whien 
    // n is a prime number greater than 2
    if (n > 2)  // large prime factor
      set.add(n);

    System.out.println(set);
    return (set.size() < 2);
  }
}

class Main {
  public static void main(String[] args) {
    Prime p = new Prime();
    System.out.println(p.isPrime(54));
    System.out.println(p.isPrime(7));
  }
}
