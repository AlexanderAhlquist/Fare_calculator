public class TransitCalculator{
  int daysTransitUsed;
  int individualRides;
  double payPerRide = 2.75;
  double unlimitedSeven = 33.00;
  double unlimitedThirty = 127.00;

  public TransitCalculator(int days, int rides){
    daysTransitUsed = days;
    individualRides = rides;
  }

  public double unlimited7Price(){
    double rideCosts = (Math.ceil(daysTransitUsed/7)*unlimitedSeven);
    double totalCost = (rideCosts/individualRides);
    return totalCost;
  }

  public double[] getRidePrices(){
    double payPerRideCost =  payPerRide;
    double unlimitedRides = (unlimitedThirty/individualRides);
    double[] ridePrices = {payPerRideCost, unlimited7Price(), unlimitedRides};
    return ridePrices;
  }

  public String getBestFare(){
    double[] ridePrices = getRidePrices();
    int bestDeal = 0;
    String[] rideChoice = {"Pay-per-ride", "Unlimited Seven-day pass", "Unlimited Thirty-day pass"};
    for (int i = 0; i < ridePrices.length;i++){
      if (ridePrices[i] < ridePrices[bestDeal]){
        bestDeal = i;
        }
    }
    return "You should utilize the "+rideChoice[bestDeal]+ " option at " + ridePrices[bestDeal]+" per ride!";
  }


  public static void main(String[] args){
    TransitCalculator first = new TransitCalculator(30,31);
    TransitCalculator second = new TransitCalculator(12, 400);
    System.out.println(second.getBestFare());
    System.out.println(first.getBestFare());
  }
}
