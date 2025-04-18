public class Arrays {
    public static void main(String[] args) {
        //2. Declaring and Initializing Arrays
        int[] myNums = {7, 14, 21, 28, 35};
        System.out.println("myNums[0] = " + myNums[0]);
        System.out.println("myNums[1] = " + myNums[1]);
        System.out.println("myNums[2] = " + myNums[2]);
        System.out.println("myNums[3] = " + myNums[3]);
        System.out.println("myNums[4] = " + myNums[4]);

        //3. Traversing and Updating Arrays
        int[] integerArray = { 1, 10, 100, 1000, 10000};
        integerArray[2] = 0;

        for (int i = 0; i < 5 ; i++) {
            System.out.println(integerArray[i]);
        }

        //4. Common Array Operations
        int[] multiplesOf3 = {3 , 6, 9, 12, 15, 18, 21, 24, 27, 30};
        System.out.println("The length of the array is: " + multiplesOf3.length);
        for (int i = 0 ; i < 10; i++) {
            System.out.println(multiplesOf3[i]);
        }
    }
}
