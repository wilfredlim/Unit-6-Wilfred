import java.util.Scanner;

public class FrequencyChart {
    //The class stuff
        //instance variable
    private int[] list;

        //constructor
    public FrequencyChart(int[] list){
        this.list = list;
    }

        //methods
    public String makeChart(){
        System.out.print("1-10|");
        for(int i=0; i<counter(1,11); i++){
            System.out.print("*");
        }
        System.out.print("\n");
        System.out.print("11-20|");
        for(int i=0; i<counter(11,21); i++){
            System.out.print("*");
        }
        System.out.print("\n");
        System.out.print("21-30|");
        for(int i=0; i<counter(21,31); i++){
            System.out.print("*");
        }
        System.out.print("\n");
        System.out.print("31-40|");
        for(int i=0; i<counter(31,41); i++){
            System.out.print("*");
        }
        System.out.print("\n");
        System.out.print("41-50|");
        for(int i=0; i<counter(41,51); i++){
            System.out.print("*");
        }
        System.out.print("\n");
        System.out.print("51-60|");
        for(int i=0; i<counter(51,61); i++){
            System.out.print("*");
        }
        System.out.print("\n");
        System.out.print("61-70|");
        for(int i=0; i<counter(61,71); i++){
            System.out.print("*");
        }
        System.out.print("\n");
        System.out.print("71-80|");
        for(int i=0; i<counter(71,81); i++){
            System.out.print("*");
        }
        System.out.print("\n");
        System.out.print("81-90|");
        for(int i=0; i<counter(81,91); i++){
            System.out.print("*");
        }
        System.out.print("\n");
        System.out.print("91-100|");
        for(int i=0; i<counter(91,101); i++){
            System.out.print("*");
        }
        return "";
    }

        //helper methods
    public int counter(int low, int high){
        int count = 0;
        for (int num : list) {
            if (num>=low && num<high)
                count++;
        }
        return count;
    }
    //end class stuff

    //main method to make the chart
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("How many values in your data set?");
        int size = scan.nextInt();

        int[] data = new int[size];

        System.out.println("Enter data values one at a time followed by enter!");
        int val = 0;
        for(int i=0; i<data.length; i++){
            val = scan.nextInt();
            data[i] = val;
        }

        FrequencyChart chart = new FrequencyChart(data);

        System.out.println(chart.makeChart());
    }
}
