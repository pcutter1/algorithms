package arrays;

public class Rotation {

  /**
   * This is a JUGGLING ALGORITHM - it works by splitting the array into sets of elements to be
   * rotated, rather than simply rotating the array one element at a time. It utilizes a helper
   * method to get the greatest common denominator and also controls for the number of rotations
   * being greater than the size of the array. This method rotates an array of integers size n to
   * the LEFT by d elements.
   *
   * @param arr - an array of integers
   * @param d   - rotate by d elements
   * @param n   - size of the array
   */
  void leftRotate(int arr[], int d, int n) {

    /** Handles if d >= n */
    d = d % n;
    /** Setting up placeholders */
    int i, j, k, temp;
    /** separates the sections of the array elements */
    int denom = gdc(d, n);

    /** the for loop only goes up to the gcd for rotations */
    for (i = 0; i < denom; i++) {
      temp = arr[i];
      j = i;
      while (true) {
        k = j + d;
        if (k >= n) {
          k = k - n;
        }
        if (k == i) {
          break;
        }
        arr[j] = arr[k];
        j = k;
      }
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

}
