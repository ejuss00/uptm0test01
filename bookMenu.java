import java.util.*;
import javax.swing.*;


public class bookMenu{

    static int binarySearch(double [] arr, int target)
    {
        int left = 0;
        int right = arr.length - 1;
        
        while(left <= right)
        {
            int mid = left + (right - left) / 2;
            
            //check if searched value (target) is at the middle
            if (arr [mid] == target) 
            {
                return mid;
            }

            // If the target is greater, ignore the left half
            if (arr[mid] < target) {
                left = mid + 1;
            }
            // If the target is smaller, ignore the right half
            else {
                right = mid - 1;
            }
        }
        
        // If we reach here, the target element is not present in the array
        return -1;
    }

    public static void main(String[] main){
        int menu = 0; // set initial value of menu to 0
        double[] bsArray = {}; //array for book sales


        do {
            // Display menu using JOptionPane
            String menuChoice = JOptionPane.showInputDialog(
                    "Menu:\n" +
                            "1. Store 30 days book sales data\n" +
                            "2. Display data in ascending order\n" +
                            "3. Search for a value using binary search\n" +
                            "4. Exit\n" +
                            "Enter your choice:");

            try {
                menu = Integer.parseInt(menuChoice);
            } catch (NumberFormatException e) {
                // Handle non-integer input
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid menu option.");
                continue;
            }

            switch (menu) {
                case 1:
                    // -- MENU 1 : Store 30 days book sales data in an array of type double --
                    bsArray = new double[]{200.00, 100.00,  300.00, 8000.76, 7890.32, 234.50, 654.00, 139,99, 863.00, 1000.32, 
                        541.20, 2345.89, 800.00, 987.45, 987.23, 1230.50, 3089.90, 567.87, 1300.00, 3450.80,
                        5400.90, 3201.00 ,322.78, 501.10, 230.40, 780.60, 543.05, 1200.20, 5450.32, 300.00};
                    JOptionPane.showMessageDialog(null, "Store 30 days of book sales:\n" + Arrays.toString(bsArray));
                    System.out.println("\nArray of book sales:");
                    for (Double dbl : bsArray) 
                    {
                        System.out.println(dbl);
                    }
                    break;//menu 1 end

                case 2:
                    // -- MENU 2 : Display the data in ascending order by using insertion sort method --
                    // Implement insertion sort and display the sorted array
                    if(bsArray.length == 0){
                        JOptionPane.showMessageDialog(null, 
                        "This month's sale is empty. Please try again and insert the data first at Menu 1.");
                    } else {
                        insertionSort(bsArray);
                        //sort so the menu will show vertically
                        StringBuilder formattedArray = new StringBuilder("Sorted array in ascending order:\n");
                        for (double value : bsArray) {
                            formattedArray.append(value).append("\n");
                        }
                        JOptionPane.showMessageDialog(null, formattedArray.toString());
                    }
                    System.out.println("\nSorted array in ascending order: " + Arrays.toString(bsArray));//debug
                    break;//menu 2 end

                case 3:
                    // -- MENU 3 : Provide a searching method to allow the user to search any value. The search method should use a binary search algorithm. --
                    int bsValue = Integer.parseInt(JOptionPane.showInputDialog("Enter book sales value to search for"));
                    //produce result after searching
                    int result = binarySearch(bsArray, bsValue);

                    if (result == -1)
                    {
                        System.out.println("Element not present in the array");
                    }

                    else
                    {
                        System.out.println("Element found at index" +result);
                    }
                    break;//menu 3 end
            }
        } while (menu != 4);
    }


    private static void insertionSort(double[] arr) { //for case 2
        int n = arr.length;

        for (int i = 1; i < n; ++i) {
            double key = arr[i];
            int j = i - 1;

            // move elements of arr[0, i-1], that are greater than key, to one position ahead of their current position
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }

            arr[j + 1] = key;
        }

        System.out.println("\nData in bsArray in ascending order:");

        //print out content in bsArray
        for (Double dbl : arr) {
            System.out.println(dbl);
        }
    }
}