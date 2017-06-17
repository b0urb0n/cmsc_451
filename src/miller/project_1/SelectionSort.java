package miller.project_1;

public class SelectionSort implements SortInterface {
  private int count = 0;
  private long time = 0;
  
  @Override
  public void recursiveSort(int[] arr) throws UnsortedException {
    long startTime = System.currentTimeMillis();

    recursiveSort(arr, 0);
    
    time = System.currentTimeMillis() - startTime;
  }
  
  public void recursiveSort(int[] arr, int index) {
    if (index >= arr.length - 1){
      return;
    }
    int minIndex = index;
    
    for (int i=index+1; i<arr.length; i++) {
      if (arr[i] < arr[minIndex]) {
        count++; // critical op is finding the smallest
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
    long startTime = System.currentTimeMillis();

    for (int i=0; i<arr.length-1; i++) {
      int currentMin = arr[i];
      int currentMinI = i;
      
      for (int j=i+1; j<arr.length; j++) { 
        if (currentMin > arr[j]){
          count++; // critical op is finding the smallest
          currentMin = arr[j];
          currentMinI = j;
        }
      } 
      if (currentMinI != i) {
        arr[currentMinI] = arr[i]; 
        arr[i] = currentMin;
      }
    }

    time = System.currentTimeMillis() - startTime;
  } 

  @Override
  public int getCount() {
    return this.count;
  }

  @Override
  public long getTime() {
    return this.time;
  }
  
  public void resetTimeAndCount() {
    this.time = 0;
    this.count = 0;
  }
}
