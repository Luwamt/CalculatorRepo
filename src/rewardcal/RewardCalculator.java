package rewardcal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RewardCalculator {

    private String fullName;
    private List<Double> purchase;
    private List<LocalDate> date;
    private double monthlyTotal;
    private List<Integer> totalPoint;

    public RewardCalculator(String fullName, List<Double> purchase, List<LocalDate> date) {
        this.fullName = fullName;
        this.purchase = purchase;
        this.date = date;
        totalPoint = new ArrayList<>();
        monthlyTotal=0;
    }

    public double getMonthlyTotal() {
        return monthlyTotal;
    }

    public void setMonthlyTotal(double monthlyTotal) {
        this.monthlyTotal = monthlyTotal;
    }

    public List<Integer> getTotalPoint() {
        return totalPoint;
    }

    public void setTotalPoint(List<Integer> totalPoint) {
        this.totalPoint = totalPoint;
    }

    public RewardCalculator() {
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public List<Double> getPurchase() {
        return purchase;
    }

    public void setPurchase(List<Double> purchase) {
        this.purchase = purchase;
    }

    public List<LocalDate> getDate() {
        return date;
    }

    public void setDate(List<LocalDate> date) {
        this.date = date;
    }

    private double calculatePoints(double purchase) {

        if (purchase <= 50) {
            return 0;
        } else if (purchase <= 100) {
            return (purchase - 50);
        } else {
            return (purchase - 100) * 2 + 50;
        }
    }

    public String print(List<Double> purchases) {
        String add = "";   double points =0;
        for (int i = 0; i < purchases.size(); i++) {
            //we get every transaction
            points= calculatePoints(purchases.get(i));

            add += "\nPoints for $"+ (purchases.get(i)) +" is: " + points;// +"sum monthlu"+ ;
            //I sum all per transaction
            monthlyTotal+=points;
        }
        return add;
    }

    @Override
    public String toString() {
       return "[CustomerName: "+fullName+
               "\nPurchase: "+purchase+
               "\nDate: "+date +
              "\n[Points: "+ print(purchase)+"]" + "\nMonthlyTotal: " +monthlyTotal+"]" ;

    }
}
