package miller.project_1;

public class SelectionSort implements SortInterface {
  private int count = 0;
  private long time = 0;
  
  @Override
  public void recursiveSort(int[] arr) throws UnsortedException {
    long startTime = System.nanoTime();

    recursiveSort(arr, 0);
    
    time = System.nanoTime() - startTime;
  }
  
  public void recursiveSort(int[] arr, int index) {
    if (index >= arr.length - 1) {
      return;
    }
    
    int minIndex = index;
    for (int i=index+1; i<arr.length; i++) {
      count++; // critical op is finding the smallest
      if (arr[i] < arr[minIndex]) {
        minIndex = i;
      }
    }
    
    int temp = arr[index];
    arr[index] = arr[minIndex];
    arr[minIndex] = temp;
    
    recursiveSort(arr, index + 1);
  }

  @Override
  public void iterativeSort(int[] arr) throws UnsortedException {
    long startTime = System.nanoTime();

    for (int i=0; i<arr.length-1; i++) {
      int currentMin = arr[i];
      int currentMinIndex = i;
      
      for (int j=i+1; j<arr.length; j++) {
        count++; // critical op is finding the smallest
        if (currentMin > arr[j]) {
          currentMin = arr[j];
          currentMinIndex = j;
        }
      }
      
      if (currentMinIndex != i) {
        arr[currentMinIndex] = arr[i]; 
        arr[i] = currentMin;
      }
    }

    time = System.nanoTime() - startTime;
  } 

  @Override
  public int getCount() {
    return count;
  }

  @Override
  public long getTime() {
    return time;
  }
  
  public void resetTimeAndCount() {
    time = 0;
    count = 0;
  }
}
