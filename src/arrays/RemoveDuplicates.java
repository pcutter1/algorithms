package arrays;

public class RemoveDuplicates {

  /**
  Removing duplicates from a SORTED array.
  This method returns the length of the new array once the duplicates are removed.
   */

  public static int removeDuplicates(int[] A) {
    // If length is less than 2, there are no duplicates.
    if (A.length < 2)
      return A.length;

    // Starting the while loop
    int j = 0;
    int i = 1;

    while (i < A.length) {
    /* compare first element (left placeholder) and second element (right placeholder)

      If they're equal, increment the right placeholder e.g. compare 1 & 2, now compare 1 & 3.

      If those elements are NOT equal - then increment the left placeholder by 1 and after that
      assign the right placeholder value to the new left placeholder element.

     */
      if (A[i] != A[j]) {
        j++;
        A[j] = A[i];
      }
      i++;
    }
    // Once the right placeholder exceeds the length of array, the left placeholder + 1 is the length
    return j + 1;
  }


  /**
  This method removes duplicates but allows for them to repeat a limited amount of times - in this case
   2 times. E.g. 1, 1, 2, 2, 2, 2, 3, 4 would be 1, 1, 2, 2, 3, 4...
   */
  public int removeDuplicatesII(int[] nums) {
    // If the array contains null or has zero elements
    if(nums==null || nums.length == 0){
      return 0;
    }
  // If the array is 2 or fewer elements
    if (nums.length <= 2){
      return nums.length;
    }


    // The indices are bumped up by 1.
    int i = 1; // left index
    int j = 2; // right index

    while (j < nums.length) {
      // Check needs to be done for two elements now - left index and left index - 1
      if (nums[j] == nums[i] && nums[j] == nums[i - 1]) {
        j++;
      } else {
        i++;
        nums[i] = nums[j];
        j++;
      }
    }

    return i + 1;
  }

}
