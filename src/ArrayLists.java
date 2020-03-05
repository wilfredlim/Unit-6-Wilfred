import java.util.ArrayList;
import java.util.Arrays;

public class ArrayLists {

    public static void main(String[] args) {
        System.out.println("Test Remove Zeros");
        ArrayList<Integer> nums = new ArrayList<Integer>(Arrays.asList(3, 4, 0, 0, 1, 4, 0, 6, 0));
        System.out.println("Starting List: " + nums);
        removeZeros(nums);
        System.out.println("Expected: [3, 4, 1, 4, 6] \n Actual: " + nums);

        System.out.println();


        ArrayList<String> words = new ArrayList<>(Arrays.asList("this", "is", "a", "list", "of", "words"));
        System.out.println("Test Letter Counter:");
        System.out.println(words);
        System.out.println("Expected: 18 \n Actual: " + countLetters(words));

        System.out.println();

        System.out.println("Test keyPosition: find a 1");
        System.out.println(nums);
        System.out.println("Expected: 2 \n Actual: " + findPosition(1, nums));

        System.out.println();

        System.out.println("Test parse into array");
        System.out.println("Expected: [W, e, s, t, , L, i, n, n] \n Actual: " + parseIntoArrayList("West Linn"));

        System.out.println();

        System.out.println("Test FindMin for PersonObjects");
        ArrayList<Person> people = new ArrayList<>(Arrays.asList(new Person(32, "Abe"),
                new Person(14, "Betty"), new Person(18, "Cris")));
        System.out.println(people);
        System.out.println("Expected: BETTY \n Actual: " + findMin(people));

        System.out.println();

        System.out.println("Purse Test:");
        Purse myPurse = new Purse();
        myPurse.add(new Coin(.25, "quarter"));
        myPurse.add(new Coin(.05, "nickel"));
        myPurse.add(new Coin(.01, "penny"));
        myPurse.add(new Coin(.25, "quarter"));

        System.out.println(myPurse);
        System.out.println("# of Quarters = " + myPurse.count(new Coin(.25, "quarter")));
        System.out.println("Smallest Coin = " + myPurse.findSmallest());
        System.out.println("Total of Purse = $" + myPurse.getTotal());


    }

    public static class Person {
        private int myAge;
        private String myName;

        public Person(int age, String name) {
            myAge = age;
            myName = name;
        }

        public int getMyAge() {
            return myAge;
        }

        public String getMyName() {
            return myName;
        }

    }

    public static class Coin {

        private double myValue;
        private String myName;

        public Coin(double value, String name) {
            myValue = value;
            myName = name;
        }

        public double getValue() {
            return myValue;
        }

        public String getName() {
            return myName;
        }

        public boolean equals(Coin aCoin) {
            if(aCoin.getName().compareTo(myName) == 0 && aCoin.getValue() == myValue){
                return true;
            }
            else
                return false;
        }

    }

    public static class Purse {
        private ArrayList<Coin> coins;

        public Purse() {
            coins = new ArrayList();
        }

        public void add(Coin aCoin) {
            coins.add(aCoin);
        }

        public double getTotal() {
            double total = 0.0;
            for (int i = 0; i < coins.size(); i++) {
                total = total+coins.get(i).getValue();
            }
            return total;
        }
        public int count(Coin aCoin) {
            int count = 0;
            for (int i = 0; i < coins.size(); i++) {
                if(coins.get(i).equals(aCoin)){
                    count++;
                }
            }
            return count;
        }

        public String findSmallest(){
            double smallest = coins.get(0).getValue();
            int smallestIndex = 0;
            for (int i = 1; i < coins.size(); i++) {
                if(coins.get(i).getValue()<smallest){
                    smallest = coins.get(i).getValue();
                    smallestIndex = i;
                }
            }
            return coins.get(smallestIndex).getName();
        }
    }


    private static void removeZeros(ArrayList<Integer> nums) {
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) == 0) {
                nums.remove(i);
                i--;
            }
        }
    }

    private static int countLetters(ArrayList<String> words) {
        int count = 0;
        String current = "";
        for (int i = 0; i < words.size(); i++) {
            current = words.get(i);
            count += current.length();
        }
        return count;
    }

    private static int findPosition(int i, ArrayList<Integer> nums) {
        int pos = 0;
        for (int j = 0; j < nums.size(); j++) {
            if (nums.get(j) == i) {
                pos = j;
            }
        }
        return pos;
    }

    private static ArrayList parseIntoArrayList(String west_linn) {
        ArrayList<String> word = new ArrayList<String>();
        for (int i = 0; i < west_linn.length(); i++) {
            word.add(west_linn.substring(i, i + 1));
        }
        return word;
    }

    private static String findMin(ArrayList<Person> people) {
        int young = people.get(0).getMyAge();
        int youngIndex = 0;
        for (int i = 1; i < people.size(); i++) {
            if (people.get(i).getMyAge() < young) {
                young = people.get(i).getMyAge();
                youngIndex = i;
            }
        }
        return people.get(youngIndex).getMyName();
    }
}
