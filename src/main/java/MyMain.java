public class MyMain {
    // Returns the String that shows up latest alphabetically
    // in a normal 1D String array
    // You can assume that the array will not be empty
    // and that all Strings are lowercase
    // Hint: recall how the compareTo() method works:
    //      int x = "apple".compareTo("banana"); // x is negative
    //      int y = "banana".compareTo("apple"); // y is positive
    public static String findLastWord(String[] arr) {
        String string_holder = arr[0];
        for (int i = 0; i < arr.length - 1; i++){
            if (string_holder.compareTo(arr[i+1]) > 0){
               //string_holder = arr[i];
            }
            else if (string_holder.compareTo(arr[i+1]) < 0){
                string_holder = arr[i+1];
            }
        }
        return string_holder;
    }

    // Given a 2D array, return an 1D array of the last word
    // in each row in the array
    // You can assume that the matrix will not be empty
    // Hint: use the previous method to help yourself!
    public static String[] findLastWord2D(String[][] mat) {
        int x = mat[0].length;
        String[] oneD = new String[x];
        for (int row = 0; row < mat.length; row++){
            oneD[row] = findLastWord(mat[row]);


        }
        return oneD;
    }

    // Given a 2D array and some column index col
    // finds the number of Strings in the specified column
    // of the 2D array that contain the word "apple"
    // For example, if col = 0, you should only look through
    // the values in column 0 of the array; likewise, if
    // col = 2, you should only look through the values in column 2

    // Hint: remember how the indexOf() method works?
    // alternatively, consider the contains() method
    public static int appleCounter(String[][] mat, int col) {
        int counter = 0;
        for (int row = 0; row < mat.length; row++){
            for (int col2 = 0; col2 < mat[0].length; col2++){
                if (col2 == col){
                    if (mat[row][col].equals("apple") || mat[row][col].contains("apple")){
                        counter++;
                    }
                }
            }
        }
        return counter;
    }

    // Given a 2D array, return the column number corresponding
    // to the column that contains the most Strings containing
    // the word "apple"

    // Hint: use your previous method!
    // Hint 2: you might need to loop through the columns!
    public static int findMostAppleColumn(String[][] mat) {
        int mostapple = 0;
        int mostappleholder = 0;
        int col_holder = 0;
        for (int i = 0; i < mat[0].length; i++){ // set most apple back to zero each run through
            mostapple = appleCounter(mat, i);
            if (mostapple > mostappleholder) {
                col_holder = i;
                mostappleholder = mostapple;
            }
        }

        return col_holder;
    }


    // Creates Pascal's Triangle, with a height of n
    // The first row of numbers has a single number, 1
    // Each subsequent row has one more number than the previous row
    // The first and last numbers of every row are 1
    // All other numbers’ values are calculated by adding together the two numbers above that number

    // Here are some examples:
    // pascalTriangle(2) =>
    // 1  0
    // 1  1

    // pascalTriangle(6) =>
    // 1  0  0  0  0  0
    // 1  1  0  0  0  0
    // 1  2  1  0  0  0
    // 1  3  3  1  0  0
    // 1  4  6  4  1  0
    // 1  5  10 10 5  1

    // Hint: fill in the first column and first diagonal with 1's
    //       and then go through and calculate the rest of the values
    //       from top to bottom

    public static int[][] pascal(int height) {
        int[][] mat = new int[height][height];

        for (int col1 = 0; col1 < height; col1++){ // sets first column to 1's
            mat[col1][0] = 1;
        }
        for (int i = 0; i < height; i++){ // sets diagonals to 1's
            mat[i][i] = 1;
        }

// math loop that checks the row above and one to the left and gets sum
        for (int row = 0; row < height; row++){
            for (int col = 0; col < height; col++){
                if (col > 0 && row > 0){
                    mat[row][col] = mat[row - 1][col] + mat[row - 1][col - 1];

                }
                else {
                    mat[row][col] = 0; // call the next 2 loops again to make sure they aren't 0's
                    for (int col1 = 0; col1 < height; col1++){ // sets first column to 1's
                        mat[col1][0] = 1;
                    }
                    for (int i = 0; i < height; i++){ // sets diagonals to 1's
                        mat[i][i] = 1;
                    }
                }
            }
        }




        return mat;
    }










    // Methods for the homework:

    // Checks if a 2D array is a magic square or not
    // You can assume that the 2D array mat will be square
    // A 2D array is a magic square if:
    // There is some set value x such that:
    // * all rows sum to x
    // * all columns sum to x
    // * both diagonals sum to x

    // Hint 1: you might first want to add up the values in the
    // first row/col and save that value to compare with later.
    // Then, you should check each rows, check each column, and
    // check each diagonal

    // Hint 2: you problably want to break this down into many parts.
    // You should have two loops to check the row sums. Then two more
    // loops to chekc the column sums. Finally, it might help to have
    // one for loop for each diagonal

    // Hint 3: when thinking the diagonals, consider the following
    // * do you see any pattern for the row and col indexes for a diagonal?
    // * can you use a for loop that goes through that pattern?
    public static boolean isMagic(int[][] mat) {
        int firstnumcheck = 0;
        int num = 0;

        // finds initial number of sum of first column to check against all other ones
        for (int row1 = 0; row1 < mat.length; row1++){
            firstnumcheck = firstnumcheck + mat[row1][0];
        }

        // loops through all rows and checks if equal to firstnumcheck
        for (int row = 0; row < mat.length; row++) {
            num = 0;
            for (int col = 0; col < mat[0].length; col++) {
                num = num + mat[row][col];
            }

            if (firstnumcheck != num) {
                return false;
            }
        }

        // check columns

        for (int col = 0; col < mat[0].length; col++) {
            num = 0;
            for (int row = 0; row < mat.length; row++) {
                num = num + mat[row][col];
            }

            if (firstnumcheck != num) {
                return false;
            }
        }

        // checks the diagonals
        num = 0;
        for (int i = 0; i < mat.length; i++){
            num = num + mat[i][i];
        }
        if (firstnumcheck != num){
            return false;
        }


        num = 0;
        int colholder = 0;
        for (int j = mat.length - 1; j >= 0; j--){
            num = num + mat[j][colholder];
            colholder++;
        }

        if (firstnumcheck != num){
            return false;
        }


        return true;
    }


    public static void main(String[] args) {
        // Write some code here to test your methods!
    }
}
