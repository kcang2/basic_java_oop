class PieceWorker extends Employee {
  private final double wage;
  private final double pieces;
  // constructor
  public PieceWorker(String firstName, String lastName,
    String socialSecurityNumber, double wage, int pieces) {
    super(firstName, lastName, socialSecurityNumber);
    if (wage < 0.0) // validate wage
      throw new IllegalArgumentException("Wage must be >= 0.0");
    if (pieces < 0) // validate pieces
      throw new IllegalArgumentException("Pieces must be >= 0");
    this.wage = wage;
    this.pieces = pieces;
  }
  // return wage
  public double getWage(){return this.wage;}
  // return pieces
  public double getPieces(){return this.pieces;}
  // return String representation of PieceWorker object
  @Override
  public String toString() {
    return String.format("Piece worker: %s%n%s: $%,.2f; %s: %,.2f",
    super.toString(), "hourly wage", getWage(),
    "Pieces worked", getPieces());
  }
  // calculate earnings; override abstract method earnings in Employee
  @Override
  public double earnings() {
    return getWage()*getPieces();
  }
} // end class PieceWorker