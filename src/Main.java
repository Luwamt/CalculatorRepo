import rewardcal.RewardCalculator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    /**
     * Lwam purase= {month =1/1/22,{120,200}, sum}
     *
     * @param args
     */

    public static void main(String[] args) {

       //Luwam Data
        List<Double> purchases = Arrays.asList(120.0, 100.0, 10.0);
        List<LocalDate> dates= Arrays.asList(LocalDate.of(2022, 01, 01)
                ,LocalDate.of(2022, 01, 21) ,LocalDate.of(2022, 01, 29));
        RewardCalculator January = new RewardCalculator("Lily Fish", purchases,  dates);
        RewardCalculator February = new RewardCalculator("Lily Fish", Arrays.asList(100.0),
                Arrays.asList(LocalDate.of(2022, 02, 01)));
        RewardCalculator March = new RewardCalculator("Lily Fish", Arrays.asList(200.0,150.0),
                Arrays.asList(LocalDate.of(2022, 03, 01)));

        List<RewardCalculator>  Luwam =Arrays.asList( January,February,March);
        print(Luwam);


        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
//Teddy Data
        List<Double> TeddyPurchases = Arrays.asList(120.0, 60.0, 120.0);
        RewardCalculator januaryPurchase = new RewardCalculator("Teddy Hanes", TeddyPurchases, Arrays.asList(LocalDate.of(2022, 01, 01)));
        RewardCalculator FebruaryPurchase = new RewardCalculator("Teddy Hanes", Arrays.asList(180.0),dates);
        RewardCalculator MarchPurchase = new RewardCalculator("Teddy Hanes", Arrays.asList(250.0,130.0),dates);

        List<RewardCalculator>  Teddy =Arrays.asList( januaryPurchase,FebruaryPurchase,MarchPurchase);
        print(Teddy);



        List<RewardCalculator> totalMonth= new ArrayList<>();
        totalMonth.add(januaryPurchase);


        }
    //I add all the monthly total to the total point list
public  static void print(List<RewardCalculator> arr){
        int total=0;
    for (int i=0 ; i < arr.size(); i++) {
        System.out.println(arr.get(i));
        System.out.println("Total-"+(i+1)+"-Month-Points: " +  (total+=arr.get(i).getMonthlyTotal()));
    }

}

}

