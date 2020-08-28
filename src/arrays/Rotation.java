package arrays;

public class Rotation {

  /**
   * LeftRotate is a JUGGLING ALGORITHM - it works by splitting the array into sets of elements to be
   * rotated, rather than simply rotating the array one element at a time. It utilizes a helper
   * method to get the greatest common denominator and also controls for the number of rotations
   * being greater than the size of the array. This method rotates an array of integers size n to
   * the LEFT by rotes elements.
   *
   * @param arr - an array of integers
   * @param rotes   - rotate by rotes elements
   * @param size   - size of the array
   */
  void leftRotate(int arr[], int rotes, int size) {

    // Handles if rotes >= size */
    rotes = rotes % size;
    // Setting up placeholders
    int i, j, k, temp;
    // separates the sections of the array elements
    int denom = gdc(rotes, size);

    // the for loop only goes up to the gcd for rotations
    for (i = 0; i < denom; i++) {
      //store first element in temp
      temp = arr[i];
      // set j to index position i to set up next code block
      j = i;

      while (true) {
        // k to the index position of i + number of places to move
        k = j + rotes;
        /* control for arrayoutofbounds and wraps around to beginning
        If index position + number of rotations is or exceeds the array length, then
        new index position of k is k - array length.
         */
        if (k >= size) {
          k = k - size;
        }
        // if k (j + rotations, which is i + rotations) equals i, do nothing
        if (k == i) {
          break;
        }
        /* set array element k (i + rotations) to array element j (i)
        remember, element at index i is currently being stored in temp
         */
        arr[j] = arr[k];
        /* set index j to k. this moves the while loop forward as the next iteration k will now become
        k + rotations. This loop repeats until k == i.
         */
        j = k;
      }
      // set element at index j (which is now k) - to the temp value
      arr[j] = temp;
    }

  }

  /**
   * Helper method to get the greatest common denominator.
   *
   * @param a - an integer
   * @param b - the second integer
   * @return - the greatest common denominator of a and b
   */
  int gdc(int a, int b) {

    if (b == 0) {
      return a;
    } else {
      return gdc(b, a % b);
    }
  }


  /**
   * rightRotate utilizes reversal to rotate the array to the right. It works by splitting the array
   * into two separate parts, individually reversing those two parts, then reversing the whole array
   * after that.
   * It utilizes a helper method to do the reversing and also controls for the number of rotations being
   * greater than the array size.
   * It should also be noted that this method does have the potential to throw an IllegalArgumentException
   * if the array is null, length 0, or there are fewer than 0 right rotations.
   * @param arr - the array to be rotated
   * @param rotes - the number of right rotations
   */


  public static void rightRotate(int[] arr, int rotes) {
    // conditions to throw the exception
    if (arr == null || arr.length==0 || rotes < 0) {
      throw new IllegalArgumentException("Illegal argument!");
    }
    // controlling for rotation being greater than array length
    if(rotes > arr.length){
      rotes = rotes %arr.length;
    }

    // get the length of first segment to be reversed
    int a = arr.length - rotes;

    // reverse the first segment
    reverse(arr, 0, a-1);
    // reverse the second segment
    reverse(arr, a, arr.length-1);
    // reverse the whole array
    reverse(arr, 0, arr.length-1);

  }

  /**
   * Helper method for reversing a SORTED array.
   * Takes an array and int index points for the leftmost and rightmost elements inclusive to be reversed
   * @param arr
   * @param left
   * @param right
   */
  public static void reverse(int[] arr, int left, int right){
    // if array is null or one element, do nothing
    if(arr == null || arr.length == 1)
      return;

    while(left < right){
      int temp = arr[left];
      arr[left] = arr[right];
      arr[right] = temp;
      left++;
      right--;
    }
  }

}
