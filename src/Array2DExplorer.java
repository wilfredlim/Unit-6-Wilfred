public class Array2DExplorer {

    public static void main(String[] args) {
    int array [][] = {  {4,1,8,5},
            {0,2,3,4},
            {6,6,2,2} };
    Array2DExplorer exp = new Array2DExplorer();

    System.out.println("Test evenRow: \n Row w/ odd, Expecting: false \n Actual: " + exp.evenRow(array,0));
    System.out.println("Test evenRow: \n Row w/o odd, Expecting: true \n Actual: " + exp.evenRow(array,2));

    System.out.println();

    System.out.println("Test oddColSum: \n Col w/ odd Sum, Expecting: true \n Actual: " + exp.oddColSum(array,1));
    System.out.println("Test oddColSum: \n Col w/ even, Expecting: false \n Actual: " + exp.oddColSum(array,0));

    System.out.println();


    System.out.print("Test minRow: \n Expecting: {0 2 3 4} \n Actual: {");
    int [] row = exp.minRow(array);
    for(int i = 0; i < row.length; i++){
        System.out.print(row[i] + " ");
    }
    System.out.print("]");

    System.out.println();

    System.out.print("Test minRowAssignment: \n Expecting: 2 \n Actual: ");
    System.out.println(exp.minRowAssignment(array, 2));

    System.out.println();

    System.out.print("Test colMax: \n Expecting: {6 6 8 5} \n Actual: {");
    int [] colMaxs = exp.colMaxs(array);
    for(int i = 0; i < colMaxs.length; i++){
        System.out.print(colMaxs[i] + " ");
    }
    System.out.print("}");

    System.out.println();
    System.out.println();


    System.out.print("Test allRowSum: \n Expecting: {18 9 16} \n Actual: {");
    int [] sum = exp.allRowSums(array);
    for(int i = 0; i < sum.length; i++){
        System.out.print(sum[i] + " ");
    }
    System.out.print("}");

    System.out.println();
    System.out.println();

    System.out.print("Test averageCol: \n Expecting: {3.333333 3.0 4.333333 3.6666667} \n Actual: {");
    double [] avg = exp.averageCol(array);
    for(int i = 0; i < avg.length; i++){
        System.out.print(avg[i] + " ");
    }
    System.out.print("}");


    System.out.println();
    System.out.println();

    System.out.print("Test smallEven: \n Expecting: 0 \n Actual: ");
    System.out.println(exp.smallEven(array));

    System.out.println();
    System.out.println();

    System.out.print("Test biggestRow: \n Expecting: 0 \n Actual: ");
    System.out.println(exp.biggestRow(array));

    System.out.println();
}

    public boolean evenRow(int [][] mat, int row){
        boolean answer = true;
        for(int i = 0; i< mat[row].length; i++){
            if(mat[row][i]%2==0)
                answer = true;
            else
                answer = false;
        }
        return answer;
        //returns true if the sum of the numbers the given col is odd.
    }
    public boolean oddColSum(int [][] nums, int col){
        boolean answer = true;
        int total = 0;
        for(int i = 0; i<nums.length; i++){
            total = total + nums[i][col];
        }
        if(total%2!=0)
            answer = true;
        else
            answer = false;
        return answer;
    }

    public int[] minRow(int [][] mat){
        int min = mat[0][0];
        int minI = 0;
        for(int i=1; i<mat.length; i++){
            for(int j=1; j<mat[i].length; j++){
                if(mat[i][j]<min) {
                    min = mat[i][j];
                    minI = i;
                }
            }
        }
        return mat[minI];
    }

//1. Write a method that looks through each element of the chosen row and returns the smallest integer from that row.

    public int minRowAssignment(int[][] nums, int row){
        int min = nums[row][0];
        for(int i = 0; i < nums.length; i++){
            if(nums[row][i]<min){
                min = nums[row][i];
            }
        }
        return min;
    }

//2. Write a method that searches through each column of an array and returns an array with the largest integer from
//   each column.

    public int[] colMaxs(int[][] matrix){
        int[] colsMax = new int[matrix[0].length];
        for(int col = 0; col<matrix[0].length;col++){
            int max = matrix[0][col];
            for(int row = 0; row<matrix.length; row++){
                if(matrix[row][col]>max){
                    max=matrix[row][col];
                }
            }
            colsMax[col] = max;
        }
        return colsMax;
    }

//3. Write a method that calculates the row sum for every row and returns each of the values in an array.
//   Index i of the return array contains the sum of elements in row i.

        public int[] allRowSums(int[][] data){
        int total = 0;
        int[] rowSum = new int[data.length];
            for(int i = 0; i<data.length;i++){
                for(int j = 0; j<data[i].length; j++){
                    total = data[i][j] + total;
                }
                rowSum[i] = total;
                total = 0;
            }
            return rowSum;
        }

//4. Write a method that calculates the average of each column in the array nums, and returns those values in an array
//   of doubles.

       public double[] averageCol(int[][] nums){
        double[] colAvg = new double[nums[0].length];
        double avg = 0;
        double total = 0;
            for(int col = 0; col<nums[0].length; col++){
                for(int row=0; row<nums.length; row++){
                    total = nums[row][col] + total;
                }
                avg = (double)total/nums.length;
                colAvg[col]=avg;
                total = 0;
            }

            return colAvg;
        }

//5. Write a method that finds and returns the smallest even number in the array matrix. Assume that the array is filled
//   with only positive ints.

        public int smallEven(int[][] matrix){
            int min = 99999999;
            for(int i = 0; i<matrix.length; i++){
                for(int j = 0; j<matrix[i].length; j++){
                    if(matrix[i][j]%2==0){
                        if(matrix[i][j]<min){
                            min = matrix[i][j];
                        }
                    }
                }
            }
            return min;
        }

// 6. Write a method that returns the row index number that has the greatest sum of its elements.

        public static int biggestRow(int[][] nums){
            int total = 0;
            int bigTotal = 0;
            int bigIndex = 0;
            int[] rowSum = new int[nums.length];
            for(int i = 0; i<nums.length;i++){
                for(int j = 0; j<nums[i].length; j++){
                    total = nums[i][j] + total;
                }
                if(total>bigTotal){
                    bigTotal = total;
                    bigIndex = i;
                }
                total = 0;
            }
            return bigIndex;
        }

}