
/**
 * SWC4133 - GROUP PROJECT
 * 
 * menu's will be display where user can manipulate the details of book sales for a month
 *
 * @authors: 
 * (EIREEN SELINA BT ZULKIFLI - AM2304013221)
 * 
 * 
 * 
 * 
 * 
 * @version (11 NOVEMBER 2023)
 */

//packages
import java.io.*;
import java.util.*;
import javax.swing.*;

public class testBookSales
{
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
    
    public static void main (String args[])
    {
        // -- MENU 1 : Store 30 days book sales data in an array of type double --
        //store data in arraylist into an array instead
        double [] bsArray = {100.00, 200.00, 300.00, 8000.76, 7890.32, 234.50, 654.00, 139,99, 863.00, 1000.32};
               
        System.out.println("\nArray of book sales:");
            
        //print out content in bsArray
        for (Double dbl : bsArray) 
        {
            System.out.println(dbl);
        }
        // -- END OF MENU 1 --
            
        // -- MENU 2 : Display the data in ascending order by using insertion sort method --
        int n = bsArray.length;
        
        for (int i = 1; i < n; ++i)
        {
            double key = bsArray[i];
            int j = i - 1;
            
            //move lement of bsArray[0,,i-1], that are greater than key, to one position ahead of their current position
            while (j >= 0 && bsArray[j] > key)
            {
                bsArray[j + 1] = bsArray[j];
                j = j - 1;
            }
            
            bsArray[j + 1] = key;
            
        }
        
        System.out.println("\nData in bsArray in ascending order:");
        
        //print out content in bsArray
        for (Double dbl : bsArray) {
            System.out.println(dbl);
        }
        // -- END OF MENU 2 --
        
        // -- MENU 3 : Provide a searching method to allow user to search any value --         
        System.out.println("\nMenu 3 - Search book sales value");//display menu to let user search
        
        int menu = 0; // set initial value of menu to 0
        //user select options to manipulate data
        menu = Integer.parseInt(JOptionPane.showInputDialog("Select Menu 3 to search for book sales value"));
        
        //search for wanted value
        int bsValue = Integer.parseInt(JOptionPane.showInputDialog("Enter book sales value to search for"));
        //produce result after searching
        int result = binarySearch(bsArray, bsValue);
        
        if (result == -1) 
        {
            System.out.println("Element not present in the array");
        } 
            
        else 
        {
            System.out.println("Element found at index " + result);
        }
        // -- END OF MENU 3 --
    }
}
