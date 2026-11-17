class Solution {

  public int findPages(int[] arr, int k) {
    if (k > arr.length) {
      return -1;
    }

    int low = 0;
    long high = 0; // Use long for high to prevent overflow during sum

    for (int pages : arr) {
      low = Math.max(low, pages);
      high += pages;
    }

    int result = -1;
    long lowLong = low;
    long highLong = high;

    while (lowLong <= highLong) {
      long mid = lowLong + (highLong - lowLong) / 2;

      if (isAllocationPossible(arr, k, mid)) {
        result = (int) mid;
        highLong = mid - 1;
      } else {
        lowLong = mid + 1;
      }
    }

    return result;
  }

  private boolean isAllocationPossible(int[] arr, int k, long maxPages) {
    int studentsRequired = 1;
    long currentPages = 0;

    for (int pages : arr) {
      if (currentPages + pages > maxPages) {
        studentsRequired++;
        currentPages = pages;
        if (studentsRequired > k) {
          return false;
        }
      } else {
        currentPages += pages;
      }
    }

    return true;
  }
}